/* loop
 * ʹ��Loop����׳�
 * �����������ʱʹ��goto����������̷��ؽ��-1
 */
SET VERIFY OFF;
SET serveroutput ON;
DECLARE
    v_i INT := &initNum;
    v_target INT := &targetNum;
    v_result INT := -1;
BEGIN
  IF v_i > v_target THEN
    dbms_output.put_line('��ʼֵ���ڽ���ֵ');
    GOTO E;                     --�������E
  ELSIF v_i < 1 THEN
    dbms_output.put_line('��ʼֵ�������0');
    GOTO E;
  END IF;
  v_result := 1;
  LOOP                          --loopѭ����ʼ
    v_result := v_result * v_i;
    v_i := v_i + 1;
    EXIT WHEN v_i > v_target;   --����loopѭ��������
  END LOOP;                     --loopѭ������
  <<E>>                         --���E
  dbms_output.put_line('���Ϊ'||v_result);
END;
/
