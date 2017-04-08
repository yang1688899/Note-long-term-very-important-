/* where
 * 使用where实现等差数列求和
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
  dbms_output.put_line('结果为'||v_result);
END;
/
