/*查询emp表数据*/
set verify off;
set serveroutput on;			                    --激活服务器输出
declare
  v_ename emp.ename%type;                     --声明v_ename变量，它的类型和emp.ename一样
  v_sal emp.sal%type;		                      --声明v_sal变量，它的类型和emp.sal一样
begin
  select ename,sal into v_ename, v_sal	      --将查询结果中的ename列和sal列数据分别赋值给v_ename、v_sal变量
  from emp where empno=&no;							      --&no：等待用户输入
  dbms_output.put_line('雇员名：'||v_ename);	--输出一行
  dbms_output.put_line('雇员工资'||v_sal);
END;
/
