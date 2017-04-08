/*synonym同义词*/
--需要授权
--创建同义词
CREATE PUBLIC SYNONYM public_emp FOR emp; --公有同义词，该同义词为PUBLIC所有
CREATE SYNONYM private_emp FOR emp;       --私有同义词，该同义词为执行当前语句的用户所有

--删除同义词
DROP PUBLIC SYNONYM public_emp;
DROP SYNONYM private_emp;
