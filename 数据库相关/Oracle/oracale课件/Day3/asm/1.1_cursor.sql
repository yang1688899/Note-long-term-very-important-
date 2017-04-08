/*游标*/
DECLARE
  --创建一个带参数的游标
	cursor emp_cursor(no NUMBER) is select ename, sal from emp where deptno=no;
	v_ename emp.ename%type;
	v_sal emp.sal%type;
BEGIN
  --确保游标处于打开状态
	if not emp_cursor%isopen then
		open emp_cursor(10);
	end if;
	loop 
    --将游标访问到得数据赋值给两个变量
		fetch emp_cursor into v_ename, v_sal;
    --游标访问不到数据时退出
    exit when emp_cursor%notfound;
    dbms_output.put_line(v_ename||':'||v_sal);
	end loop;
  --打印游标访问数据的行数
  dbms_output.put_line(emp_cursor%ROWCOUNT);
  --关闭游标
	close emp_cursor;
end;
/

