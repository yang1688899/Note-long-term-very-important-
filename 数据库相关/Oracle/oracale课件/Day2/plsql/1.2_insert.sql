/*插入数据*/
SET VERIFY OFF;
SET serveroutput ON;
DECLARE
    v_ename emp.ename%TYPE;
    v_empno emp.empno%TYPE;
BEGIN
  --为了保持emp表中的数据格式一致，此处将输入内容转换为大写，并且将前后两端的空格都去掉
  v_ename := UPPER(TRIM('&ename'));
  v_empno := &empno;
  --将变量的值插入emp表中对应的字段中
  INSERT INTO emp(ENAME, EMPNO) VALUES(v_ename, v_empno);
  COMMIT;
--  SELECT * FROM emp;
END;
/
