/*����һ�����������ڲ鿴��������(�������쳣)*/
CREATE OR REPLACE FUNCTION emp_count(
       v_deptno emp.deptno%TYPE
)
RETURN NUMBER
IS
       v_count NUMBER(3);
BEGIN
  SELECT COUNT(*) INTO v_count FROM emp WHERE deptno=v_deptno;
  RETURN v_count;
END;
