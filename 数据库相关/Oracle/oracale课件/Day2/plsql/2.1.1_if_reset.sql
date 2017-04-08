/*if reset*/
SET VERIFY OFF;
SET serveroutput ON;
DECLARE
    v_empno emp.empno%TYPE;
    v_deptno emp.deptno%TYPE;
    v_comm emp.comm%TYPE;
BEGIN
  v_empno := &empno;
  SELECT deptno, nvl(comm,0) INTO v_deptno, v_comm FROM emp WHERE empno = v_empno;
  IF v_deptno=10 THEN             --�����ж���俪ʼ
    v_comm:=v_comm - 100;
  ELSIF v_deptno=20 THEN
    v_comm:=v_comm - 200;
  ELSIF v_deptno=30 THEN
    v_comm:=v_comm - 300;
  END IF;                         --�����ж�������
  IF v_comm = 0.00 THEN
    UPDATE emp SET comm = NULL WHERE empno = v_empno;
  ELSE
    UPDATE emp SET comm = v_comm WHERE empno = v_empno;
  END IF;
  COMMIT;
END;
/
