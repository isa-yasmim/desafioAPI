DROP USER desafio CASCADE;

CREATE USER desafio IDENTIFIED BY desafio;

ALTER USER desafio DEFAULT TABLESPACE users
              QUOTA UNLIMITED ON users;

ALTER USER desafio TEMPORARY TABLESPACE temp;

GRANT create session
     , create table
     , create procedure 
     , create sequence
     , create trigger
     , create view
     , create synonym
     , alter session
TO desafio;

ALTER SESSION SET NLS_DATE_FORMAT = 'DD/MM/YYYY';