/*�α�+for*/
DECLARE
  CURSOR emp_cursor(NO NUMBER) IS SELECT * FROM emp WHERE deptno=NO;
  v_ename emp.ename%TYPE;
  v_sal emp.sal%TYPE;
BEGIN
  --for ���Զ������α겢����ѭ������ʱ�ر��α�
  FOR emp_record IN emp_cursor(10) LOOP
    dbms_output.put_line(emp_record.EMPNO||'  '||emp_record.ENAME);
  END LOOP;
END;
/
