import threading
import requests
import random
import time
import socket
import cx_Oracle
from lxml import etree
import xlwt
import os
import math

def db_open():
    return cx_Oracle.connect('gdcreditbase/gdcreditbase@19.16.30.192:1521/orcl', threaded=True)

def cursor_open(db):
    return db.cursor()

def get_content(url, data=None):
    header = {
        'Accept': 'text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8',
        'Accept-Encoding': 'gzip, deflate, sdch',
        'Accept-Language': 'zh-CN,zh;q=0.8',
        'Connection': 'keep-alive',
        'User-Agent': 'Mozilla/5.0 (Windows NT 6.3; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/43.0.235'
    }
    timeout = random.choice(range(80, 180))
    while True:
        try:
            # rep = requests.get(url, headers=header, proxies={'http': random.choice(proxy)}, timeout=timeout)
            rep = requests.get(url, headers=header, timeout=timeout)
            rep.encoding = 'utf-8'
            break

        except socket.timeout as e:
            print('timeout:', e)
            time.sleep(random.choice(range(8, 15)))

        except socket.error as e:
            print('error:', e)
            time.sleep(random.choice(range(20, 60)))

        

    return rep.text



def getShopAllBooks_list(url):
    html = etree.HTML(get_content(url))
    result_box = html.xpath('//div[starts-with(@class,"result_box")]')

#传入url，爬取查询数据量
def getSearchCount(url):
    html = etree.HTML(get_content(url))
    result = html.xpath('//div[starts-with(@class,"nums")]')
    text = result[0].xpath('string(.)')
    count =  int(text[15:][:-1].replace(',',''))
    return count

#从数据库中获取企业名称
def get_entname(cursor):
    cursor.execute("select UNISCID,sxqy_name from sxqy_info where search_count is null and sxqy_name !='#'  and rownum<10000")
    rows = cursor.fetchall()
    return rows

#使用企业名称拼接url，爬取查询数据量
def get_count(entname):
    url = 'https://www.baidu.com/s?q1=%s&q2=%s&tn=baiduadv'%(entname,entname)
    return getSearchCount(url)

#把获取的数据量更新到数据库中
def update(rows,cursor,db):
    for i in range(len(rows)):
        try:
            
            row = rows[i]
            count = get_count(row[1])
            cursor.execute('update sxqy_info set SEARCH_COUNT = :count where UNISCID = :id ', count=count, id=row[0])
            
            if i > 0 and i % 100 == 0:
                db.commit()
                print("commit 100")
        except Exception as e:
            print(e)
            continue
    db.commit()
    print("commit")

#调用多线程进行查询数据量爬取更新
def run():
    for k in range(100):
        print(k)
        db = db_open()
        cursor = cursor_open(db)
        rows = get_entname(cursor)

        thread_list = []
        for i in range(math.ceil(len(rows) / 1000)):
            t = threading.Thread(target=update, args=(rows[i * 1000:i * 1000 + 1000], cursor, db))
            t.setDaemon(True)  # 设置线程为后台线程
            thread_list.append(t)

        for t in thread_list:
            t.start()

        for t in thread_list:
            t.join()

    
if __name__ == '__main__':
#    count = getSearchCount('https://www.baidu.com/s?q1=深圳大中时代物流贸易有限公司&q2=深圳大中时代物流贸易有限公司&tn=baiduadv')
#    print (get_count('深圳大中时代物流贸易有限公司'))
    #get_entname()
    run()