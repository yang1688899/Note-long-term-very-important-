/*更新数据*/
SET VERIFY OFF;
SET serveroutput ON;
DECLARE
    v_ename emp.ename%TYPE;
    v_empno emp.empno%TYPE;
BEGIN
  v_empno := &targetno;
  v_ename := UPPER(TRIM('&ename'));
  UPDATE emp SET ename = v_ename WHERE empno = v_empno;
  COMMIT;
END;
/
