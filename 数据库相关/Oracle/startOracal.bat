::设置数据库实例
set ORACLE_SID=ORCL

::启动监听
Isnerctl start

::启动数据库
net start  OracleServiceORCL

::启动OEM
::net start OracleDBConsoleorcl