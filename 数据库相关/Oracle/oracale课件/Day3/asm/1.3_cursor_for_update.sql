/*���α��������*/
DECLARE
  CURSOR emp_cursor IS SELECT * FROM emp FOR UPDATE;
BEGIN
  FOR emp_record IN emp_cursor LOOP
    IF emp_record.sal < 1000 THEN
      UPDATE emp SET sal = sal+1 WHERE CURRENT OF emp_cursor;
      dbms_output.put_line(emp_record.ENAME||'���¹���Ϊ:'||(emp_record.sal+1));
    END IF;
  END LOOP;
END;
/
