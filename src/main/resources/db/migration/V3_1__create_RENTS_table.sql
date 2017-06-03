--------------------------------------------------------
--  DDL for Table RENTS
--------------------------------------------------------

CREATE TABLE RENTS
(
  RNT_ID                   NUMBER(10) 			CONSTRAINT PK_RENTS PRIMARY KEY,
  RNT_USR_ID               NUMBER(10) 			CONSTRAINT NN_RNT_USR_ID NOT NULL,
  RNT_MTO_ID               NUMBER(10) 			CONSTRAINT NN_RNT_MTO_ID NOT NULL,
  RNT_DATE_START           DATE             DEFAULT SYSDATE CONSTRAINT NN_RNT_DATE_START NOT NULL,
  RNT_DATE_END             DATE             CONSTRAINT NN_RNT_DATE_END NOT NULL,
  CONSTRAINT FK_RNT_USR_ID FOREIGN KEY (RNT_USR_ID) REFERENCES USERS (USR_ID),
  CONSTRAINT FK_RNT_MTO_ID FOREIGN KEY (RNT_MTO_ID) REFERENCES MOTORCYCLES (MTO_ID)
);

--------------------------------------------------------
--  Sequence for Table RENTS
--------------------------------------------------------

CREATE SEQUENCE SEQ_RNT_ID
START WITH 1
INCREMENT BY 1;