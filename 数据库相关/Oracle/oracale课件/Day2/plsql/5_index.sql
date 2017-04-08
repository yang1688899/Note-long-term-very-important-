/*index����*/
--�鿴����
SELECT a.INDEX_NAME, a.TABLE_NAME, b.COLUMN_NAME, a.TABLE_OWNER
FROM user_indexes a, user_ind_columns b
WHERE a.INDEX_NAME = b.INDEX_NAME;

--������������
CREATE INDEX i_emp_ename ON emp(ename);

--������������
CREATE INDEX i_emp_job_sal ON emp(job,sal);

--����Ψһ����
CREATE UNIQUE INDEX I_SALGRADE_GRADE ON SALGRADE(GRADE);

--�ؽ�����
ALTER INDEX i_emp_ename REBUILD;

--�ؽ���������
ALTER INDEX i_emp_ename REBUILD ONLINE;

--ɾ������
DROP INDEX i_emp_ename;
DROP INDEX i_emp_job_sal;
DROP INDEX I_SALGRADE_GRADE;
