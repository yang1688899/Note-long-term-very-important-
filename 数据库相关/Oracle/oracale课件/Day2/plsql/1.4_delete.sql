/*É¾³ýÊý¾Ý*/
SET VERIFY OFF;
SET serveroutput ON;
BEGIN
  DELETE FROM emp WHERE empno=&empno;
  COMMIT;
END;
/
