--------------------------------------------------------
--  DDL for Table USERS
--------------------------------------------------------

CREATE TABLE USERS
(
  USR_ID                   NUMBER(10) 		  CONSTRAINT PK_USERS PRIMARY KEY,
  USR_LOGIN                NVARCHAR2(20) 		CONSTRAINT NN_USR_LOGIN NOT NULL,
  USR_PASSWORD             NVARCHAR2(60)    CONSTRAINT NN_USR_PASSWORD NOT NULL,
  USR_FIRST_NAME           NVARCHAR2(20) 		CONSTRAINT NN_USR_FIRST_NAME NOT NULL,
  USR_LAST_NAME            NVARCHAR2(30) 		CONSTRAINT NN_USR_LAST_NAME NOT NULL,
  USR_EMAIL                NVARCHAR2(40)    CONSTRAINT NN_USR_EMAIL NOT NULL,
  USR_ADMIN                NUMBER(1)        DEFAULT 0 CONSTRAINT NN_USR_ADMIN NOT NULL,
  USR_AVATAR			         BLOB
);

--------------------------------------------------------
--  Sequence for Table USERS
--------------------------------------------------------

CREATE SEQUENCE SEQ_USR_ID
START WITH 1
INCREMENT BY 1;