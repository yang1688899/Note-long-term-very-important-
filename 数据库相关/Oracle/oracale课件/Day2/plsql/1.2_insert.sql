/*��������*/
SET VERIFY OFF;
SET serveroutput ON;
DECLARE
    v_ename emp.ename%TYPE;
    v_empno emp.empno%TYPE;
BEGIN
  --Ϊ�˱���emp���е����ݸ�ʽһ�£��˴�����������ת��Ϊ��д�����ҽ�ǰ�����˵Ŀո�ȥ��
  v_ename := UPPER(TRIM('&ename'));
  v_empno := &empno;
  --��������ֵ����emp���ж�Ӧ���ֶ���
  INSERT INTO emp(ENAME, EMPNO) VALUES(v_ename, v_empno);
  COMMIT;
--  SELECT * FROM emp;
END;
/
