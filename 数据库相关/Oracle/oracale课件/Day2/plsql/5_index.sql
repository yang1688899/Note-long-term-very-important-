/*index索引*/
--查看索引
SELECT a.INDEX_NAME, a.TABLE_NAME, b.COLUMN_NAME, a.TABLE_OWNER
FROM user_indexes a, user_ind_columns b
WHERE a.INDEX_NAME = b.INDEX_NAME;

--建立单列索引
CREATE INDEX i_emp_ename ON emp(ename);

--建立复合索引
CREATE INDEX i_emp_job_sal ON emp(job,sal);

--建立唯一索引
CREATE UNIQUE INDEX I_SALGRADE_GRADE ON SALGRADE(GRADE);

--重建索引
ALTER INDEX i_emp_ename REBUILD;

--重建联机索引
ALTER INDEX i_emp_ename REBUILD ONLINE;

--删除索引
DROP INDEX i_emp_ename;
DROP INDEX i_emp_job_sal;
DROP INDEX I_SALGRADE_GRADE;
