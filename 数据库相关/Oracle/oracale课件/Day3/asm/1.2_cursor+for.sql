/*游标+for*/
DECLARE
  CURSOR emp_cursor(NO NUMBER) IS SELECT * FROM emp WHERE deptno=NO;
  v_ename emp.ename%TYPE;
  v_sal emp.sal%TYPE;
BEGIN
  --for 会自动开启游标并且在循环结束时关闭游标
  FOR emp_record IN emp_cursor(10) LOOP
    dbms_output.put_line(emp_record.EMPNO||'  '||emp_record.ENAME);
  END LOOP;
END;
/
