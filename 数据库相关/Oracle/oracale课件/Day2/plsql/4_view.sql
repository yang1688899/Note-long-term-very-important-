/*view视图*/
--创建视图
CREATE VIEW vu_emp AS
SELECT empno, ename, job, sal, comm FROM emp WITH READ ONLY;--with read only 只读视图

--修改视图定义，修改为连接视图
CREATE OR REPLACE VIEW vu_emp AS
SELECT emp.empno, emp.ename, emp.job, emp.sal, emp.comm, dept.dname, dept.loc
FROM emp, dept
WHERE dept.deptno = emp.deptno;
alter view vu_emp compile;                --重新编译视图

--插入记录(实际上操作的是基表)
insert into vu_emp values(7777, '蛋大', 'CLERK', 1600.00, NULL);
COMMIT;

--删除记录(实际上操作的是基表)
delete from vu_emp where empno=7777;
COMMIT;

--删除视图
DROP VIEW vu_emp;
