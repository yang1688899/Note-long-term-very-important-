/*rowtype*/
SET VERIFY OFF;
SET serveroutput ON;
DECLARE
    --����dept_record�������������ͺ�dept���еĵ�����¼һ��
    dept_record dept%ROWTYPE;
BEGIN
  SELECT * INTO dept_record FROM dept WHERE deptno=&detpno; --selectʱ����ȱ�����ֶ�
  dbms_output.put_line('���ű��'||dept_record.deptno);
  dbms_output.put_line('��������'||dept_record.dname);
  dbms_output.put_line('���ŵص�'||dept_record.loc);
END;
/
