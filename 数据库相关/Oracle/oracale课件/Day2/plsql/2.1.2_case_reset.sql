/*case reset*/
SET VERIFY OFF;
SET serveroutput ON;
DECLARE
    v_empno emp.empno%TYPE;
    v_deptno emp.deptno%TYPE;
BEGIN
  v_empno := &empno;
  SELECT deptno INTO v_deptno FROM emp WHERE empno=v_empno;
  CASE v_deptno
    WHEN 10 THEN
      UPDATE emp SET sal=sal-10 WHERE empno = v_empno;
    WHEN 20 THEN
      UPDATE emp SET sal=sal-20 WHERE empno = v_empno;
    WHEN 30 THEN
      UPDATE emp SET sal=sal-30 WHERE empno = v_empno;
  END CASE;
  COMMIT;
END;
/
