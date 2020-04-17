CREATE USER your_user IDENTIFIED BY your_password;

GRANT CREATE TABLE TO your_user;
GRANT CREATE SESSION TO your_user;
GRANT UNLIMITED TABLESPACE TO your_user;
GRANT CONNECT TO your_user;
alter user your_user quota unlimited on users;
GRANT CREATE SEQUENCE to your_user;