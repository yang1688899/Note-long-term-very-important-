create table T_USER(id integer primary key, 
      name varchar(30) ,
      birthday date,
      money float);
      
insert into T_USER values(2,'zhangsan',to_date('2010-01-01','YYYY-MM-DD'),15000);
insert into T_USER values(1,'wangwenjun',to_date('1984-06-09','YYYY-MM-DD'),8500.00);

SELECT * FROM t_user;

--现在的大多数数据库都支持了CLOB的类型用于满足我们存放文本信息
create table clob_test(id integer primary key ,info clob);

--BLOB类型是专门针对二进制文件进行的存取，比如图片，音频，等信息，
--当然了现在主流的数据库均会对其进行支持的，jdbc API同样也对其进行了支持。
Create table blob_test(id integer primary key ,info blob);