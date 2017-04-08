/* loop
 * 使用Loop计算阶乘
 * 发生输入错误时使用goto跳过计算过程返回结果-1
 */
SET VERIFY OFF;
SET serveroutput ON;
DECLARE
    v_i INT := &initNum;
    v_target INT := &targetNum;
    v_result INT := -1;
BEGIN
  IF v_i > v_target THEN
    dbms_output.put_line('起始值大于结束值');
    GOTO E;                     --跳到标号E
  ELSIF v_i < 1 THEN
    dbms_output.put_line('起始值必须大于0');
    GOTO E;
  END IF;
  v_result := 1;
  LOOP                          --loop循环开始
    v_result := v_result * v_i;
    v_i := v_i + 1;
    EXIT WHEN v_i > v_target;   --跳出loop循环的条件
  END LOOP;                     --loop循环结束
  <<E>>                         --标号E
  dbms_output.put_line('结果为'||v_result);
END;
/
