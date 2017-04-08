/*table_type “数组”*/
SET VERIFY OFF;
SET serveroutput ON;
DECLARE
    --定义一个名叫dept_table_type的类型，它可以看作是一个“数组”，这个数组的类型是dept的rowtype
    TYPE dept_table_type IS TABLE OF dept%ROWTYPE INDEX BY BINARY_INTEGER;
    dept_table dept_table_type;                    --定义dept_table变量，类型为dept_table_type
BEGIN
  SELECT * BULK COLLECT INTO dept_table FROM dept; --将查询结果逐个放到“数组”中
  FOR i IN 1..dept_table.count LOOP                --遍历数组
    dbms_output.put_line('部门编号'||dept_table(i).deptno);
    dbms_output.put_line('部门名称'||dept_table(i).dname);
    dbms_output.put_line('部门地点'||dept_table(i).loc);
    dbms_output.put_line('*******************');
  END LOOP;
END;
/
