/*synonymͬ���*/
--��Ҫ��Ȩ
--����ͬ���
CREATE PUBLIC SYNONYM public_emp FOR emp; --����ͬ��ʣ���ͬ���ΪPUBLIC����
CREATE SYNONYM private_emp FOR emp;       --˽��ͬ��ʣ���ͬ���Ϊִ�е�ǰ�����û�����

--ɾ��ͬ���
DROP PUBLIC SYNONYM public_emp;
DROP SYNONYM private_emp;
