/*table_type �����顱*/
SET VERIFY OFF;
SET serveroutput ON;
DECLARE
    --����һ������dept_table_type�����ͣ������Կ�����һ�������顱����������������dept��rowtype
    TYPE dept_table_type IS TABLE OF dept%ROWTYPE INDEX BY BINARY_INTEGER;
    dept_table dept_table_type;                    --����dept_table����������Ϊdept_table_type
BEGIN
  SELECT * BULK COLLECT INTO dept_table FROM dept; --����ѯ�������ŵ������顱��
  FOR i IN 1..dept_table.count LOOP                --��������
    dbms_output.put_line('���ű��'||dept_table(i).deptno);
    dbms_output.put_line('��������'||dept_table(i).dname);
    dbms_output.put_line('���ŵص�'||dept_table(i).loc);
    dbms_output.put_line('*******************');
  END LOOP;
END;
/
