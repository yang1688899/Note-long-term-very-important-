/*创建包体*/
CREATE OR REPLACE PACKAGE BODY emp_package IS
       PROCEDURE fire_emp(v_empno emp.empno%TYPE)
         IS
         BEGIN
           DELETE emp WHERE empno=v_empno;
         END;
       FUNCTION get_avgSal(v_deptno emp.deptno%TYPE)RETURN emp.sal%TYPE
         IS
         v_avgSal emp.sal%TYPE;
         BEGIN
           SELECT AVG(sal) INTO v_avgSal FROM emp WHERE deptno=v_deptno;
           RETURN v_avgSal;
         END;
END emp_package;
