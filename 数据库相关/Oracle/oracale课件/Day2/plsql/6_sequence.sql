/*sequence����*/
--�鿴����
SELECT * FROM seq;

--��������
CREATE SEQUENCE seq_deptno
       INCREMENT BY 1     --����
       START WITH 1       --����
       MAXVALUE 1000      --���ֵ
       CACHE 10           --�ڴ���Ԥ��������кŸ���
       NOCYCLE            --��ѭ��
       
--ʹ������
/*�½�һ�����ݱ����ڲ�������
CREATE TABLE test4seq(
       ID INT
);
*/
INSERT INTO test4seq VALUES(seq_deptno.nextval);
COMMIT;
/*
DROP TABLE test4seq;
*/

--�޸�����
ALTER SEQUENCE seq_deptno
--START WITH 3            --�����޸�����ֵ
INCREMENT BY 2
MAXVALUE 10000
NOCACHE;

--ɾ������
DROP SEQUENCE seq_deptno;
