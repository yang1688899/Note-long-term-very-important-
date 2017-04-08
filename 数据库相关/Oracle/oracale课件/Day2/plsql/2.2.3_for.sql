/*for*/
SET VERIFY OFF;
SET serveroutput ON;
DECLARE
    v_i INT;
    v_target INT := &target;
    v_result INT := 0;
BEGIN
  FOR v_i IN 1..v_target LOOP
    v_result := v_result + v_i;
  END LOOP;
  dbms_output.put_line('½á¹ûÎª'||v_result);
END;
/
