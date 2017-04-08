/*感受异常*/
SET VERIFY OFF;
SET serveroutput ON;
DECLARE
    v_rslt NUMBER(10):=0;
BEGIN
  v_rslt := 100/0;              --执行此语句会抛出zero_divide异常
  dbms_output.put_line('这句话是不会显示的。');
  EXCEPTION
    WHEN zero_divide THEN       --出现zero_divide异常时执行下面的语句
      dbms_output.put_line('数体教。');
END;
/
