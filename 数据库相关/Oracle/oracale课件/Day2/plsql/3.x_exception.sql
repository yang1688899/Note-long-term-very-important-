/*�����쳣*/
SET VERIFY OFF;
SET serveroutput ON;
DECLARE
    v_rslt NUMBER(10):=0;
BEGIN
  v_rslt := 100/0;              --ִ�д������׳�zero_divide�쳣
  dbms_output.put_line('��仰�ǲ�����ʾ�ġ�');
  EXCEPTION
    WHEN zero_divide THEN       --����zero_divide�쳣ʱִ����������
      dbms_output.put_line('����̡�');
END;
/
