/* where
 * ʹ��whereʵ�ֵȲ��������
 */
SET VERIFY OFF;
SET serveroutput ON;
DECLARE
    v_i INT := 1;
    v_target INT := &target;
    v_result INT := 0;
BEGIN
  WHILE v_i <= v_target LOOP
    v_result := v_i + v_result;
    v_i := v_i + 1;
  END LOOP;
  dbms_output.put_line('���Ϊ'||v_result);
END;
/
