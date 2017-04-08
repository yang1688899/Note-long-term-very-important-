/*view��ͼ*/
--������ͼ
CREATE VIEW vu_emp AS
SELECT empno, ename, job, sal, comm FROM emp WITH READ ONLY;--with read only ֻ����ͼ

--�޸���ͼ���壬�޸�Ϊ������ͼ
CREATE OR REPLACE VIEW vu_emp AS
SELECT emp.empno, emp.ename, emp.job, emp.sal, emp.comm, dept.dname, dept.loc
FROM emp, dept
WHERE dept.deptno = emp.deptno;
alter view vu_emp compile;                --���±�����ͼ

--�����¼(ʵ���ϲ������ǻ���)
insert into vu_emp values(7777, '����', 'CLERK', 1600.00, NULL);
COMMIT;

--ɾ����¼(ʵ���ϲ������ǻ���)
delete from vu_emp where empno=7777;
COMMIT;

--ɾ����ͼ
DROP VIEW vu_emp;
