/*rowtype*/
SET VERIFY OFF;
SET serveroutput ON;
DECLARE
    --声明dept_record变量，它的类型和dept表中的单条记录一致
    dept_record dept%ROWTYPE;
BEGIN
  SELECT * INTO dept_record FROM dept WHERE deptno=&detpno; --select时不能缺任意字段
  dbms_output.put_line('部门编号'||dept_record.deptno);
  dbms_output.put_line('部门名称'||dept_record.dname);
  dbms_output.put_line('部门地点'||dept_record.loc);
END;
/
