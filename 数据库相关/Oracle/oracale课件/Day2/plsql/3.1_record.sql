/*record*/
SET VERIFY OFF;
SET serveroutput ON;
DECLARE
    --定义一个数据类型 dept_record_type，该类型由3个变量组成
    TYPE dept_record_type IS RECORD(
         deptno dept.deptno%TYPE,
         dname dept.dname%TYPE,
         loc dept.loc%TYPE
    );
    --定义一个dept_record_type类型变量
    dept_record dept_record_type;
BEGIN
  SELECT * INTO dept_record FROM dept WHERE deptno=&deptno;
  dbms_output.put_line('部门编号'||dept_record.deptno);
  dbms_output.put_line('部门名称'||dept_record.dname);
  dbms_output.put_line('部门地点'||dept_record.loc);
END;
/
