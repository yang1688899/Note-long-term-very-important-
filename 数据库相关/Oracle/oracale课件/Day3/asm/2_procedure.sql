/*����һ���������Ӽ�¼�Ĵ洢����(�������쳣)*/
CREATE OR REPLACE PROCEDURE emp_procedure_add(
       v_empno emp.empno%TYPE,
       v_ename emp.ename%TYPE,
       v_sal emp.sal%TYPE
)
IS 
BEGIN
  INSERT INTO emp(empno, ename, sal) VALUES(v_empno, v_ename, v_sal);
END;
