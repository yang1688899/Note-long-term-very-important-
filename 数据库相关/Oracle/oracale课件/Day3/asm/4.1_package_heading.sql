/*������ͷ*/
CREATE OR REPLACE PACKAGE emp_package IS
--�������еĹ��д洢���̡�������
       PROCEDURE fire_emp(v_empno emp.empno%TYPE);
       FUNCTION get_avgSal(v_deptno emp.deptno%TYPE)RETURN emp.sal%TYPE;
--end ���������
END emp_package;
