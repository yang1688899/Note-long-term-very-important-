/*��ѯemp������*/
set verify off;
set serveroutput on;			                    --������������
declare
  v_ename emp.ename%type;                     --����v_ename�������������ͺ�emp.enameһ��
  v_sal emp.sal%type;		                      --����v_sal�������������ͺ�emp.salһ��
begin
  select ename,sal into v_ename, v_sal	      --����ѯ����е�ename�к�sal�����ݷֱ�ֵ��v_ename��v_sal����
  from emp where empno=&no;							      --&no���ȴ��û�����
  dbms_output.put_line('��Ա����'||v_ename);	--���һ��
  dbms_output.put_line('��Ա����'||v_sal);
END;
/
