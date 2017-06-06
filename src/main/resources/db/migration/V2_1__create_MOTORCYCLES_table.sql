--------------------------------------------------------
--  DDL for Table MOTORCYCLES
--------------------------------------------------------

CREATE TABLE MOTORCYCLES
(
  MTO_ID                    NUMBER(10) 		    CONSTRAINT PK_MOTORCYCLES PRIMARY KEY,
  MTO_MANUFACTURER          NVARCHAR2(20) 		CONSTRAINT NN_MTO_MANUFACTURER NOT NULL,
  MTO_MODEL                 NVARCHAR2(20)     CONSTRAINT NN_MTO_MODEL NOT NULL,
  MTO_YEAR                  NUMBER(6)         CONSTRAINT NN_MTO_YEAR NOT NULL,
  MTO_CAPACITY              NUMBER(6)         CONSTRAINT NN_MTO_CAPACITY NOT NULL,
  MTO_POWER                 NUMBER(6)         CONSTRAINT NN_MTO_POWER NOT NULL,
  MTO_WEIGHT			          NUMBER(6)         CONSTRAINT NN_MTO_WEIGHT NOT NULL,
  MTO_CONSUMPTION           NUMBER(6,1)       CONSTRAINT NN_MTO_CONSUMPTION NOT NULL,
  MTO_TOP_SPEED             NUMBER(6)         CONSTRAINT NN_MTO_TOP_SPEED NOT NULL,
  MTO_COLOUR                NVARCHAR2(20)     CONSTRAINT NN_MTO_COLOUR NOT NULL,
  MTO_PRICE                 NUMBER(6)         CONSTRAINT NN_MTO_PRICE NOT NULL,
  MTO_PHOTO                 BLOB,
  MTO_PHOTO_BASE64          CLOB
);

--------------------------------------------------------
--  Sequence for Table MOTORCYCLES
--------------------------------------------------------

CREATE SEQUENCE SEQ_MTO_ID
START WITH 1
INCREMENT BY 1;