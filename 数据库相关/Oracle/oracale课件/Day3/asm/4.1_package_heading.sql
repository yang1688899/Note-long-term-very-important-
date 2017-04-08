/*建立包头*/
CREATE OR REPLACE PACKAGE emp_package IS
--声明包中的公有存储过程、函数等
       PROCEDURE fire_emp(v_empno emp.empno%TYPE);
       FUNCTION get_avgSal(v_deptno emp.deptno%TYPE)RETURN emp.sal%TYPE;
--end 后面跟包名
END emp_package;
