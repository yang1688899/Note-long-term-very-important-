/*�α�*/
DECLARE
  --����һ�����������α�
	cursor emp_cursor(no NUMBER) is select ename, sal from emp where deptno=no;
	v_ename emp.ename%type;
	v_sal emp.sal%type;
BEGIN
  --ȷ���α괦�ڴ�״̬
	if not emp_cursor%isopen then
		open emp_cursor(10);
	end if;
	loop 
    --���α���ʵ������ݸ�ֵ����������
		fetch emp_cursor into v_ename, v_sal;
    --�α���ʲ�������ʱ�˳�
    exit when emp_cursor%notfound;
    dbms_output.put_line(v_ename||':'||v_sal);
	end loop;
  --��ӡ�α�������ݵ�����
  dbms_output.put_line(emp_cursor%ROWCOUNT);
  --�ر��α�
	close emp_cursor;
end;
/

