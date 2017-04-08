/*sequence序列*/
--查看序列
SELECT * FROM seq;

--创建序列
CREATE SEQUENCE seq_deptno
       INCREMENT BY 1     --步长
       START WITH 1       --种子
       MAXVALUE 1000      --最大值
       CACHE 10           --内存中预分配的序列号个数
       NOCYCLE            --不循环
       
--使用序列
/*新建一个数据表用于测试序列
CREATE TABLE test4seq(
       ID INT
);
*/
INSERT INTO test4seq VALUES(seq_deptno.nextval);
COMMIT;
/*
DROP TABLE test4seq;
*/

--修改序列
ALTER SEQUENCE seq_deptno
--START WITH 3            --不能修改种子值
INCREMENT BY 2
MAXVALUE 10000
NOCACHE;

--删除序列
DROP SEQUENCE seq_deptno;
