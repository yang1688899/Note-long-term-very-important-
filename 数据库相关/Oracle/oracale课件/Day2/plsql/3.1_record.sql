/*record*/
SET VERIFY OFF;
SET serveroutput ON;
DECLARE
    --����һ���������� dept_record_type����������3���������
    TYPE dept_record_type IS RECORD(
         deptno dept.deptno%TYPE,
         dname dept.dname%TYPE,
         loc dept.loc%TYPE
    );
    --����һ��dept_record_type���ͱ���
    dept_record dept_record_type;
BEGIN
  SELECT * INTO dept_record FROM dept WHERE deptno=&deptno;
  dbms_output.put_line('���ű��'||dept_record.deptno);
  dbms_output.put_line('��������'||dept_record.dname);
  dbms_output.put_line('���ŵص�'||dept_record.loc);
END;
/
