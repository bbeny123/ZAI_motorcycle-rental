--------------------------------------------------------
--  CleanUp Schema
--------------------------------------------------------
DROP TABLE "schema_version";

DROP SEQUENCE SEQ_USR_ID;
DROP SEQUENCE SEQ_MTO_ID;
DROP SEQUENCE SEQ_RNT_ID;

DROP TABLE USERS;
DROP TABLE MOTORCYCLES;
DROP TABLE RENTS;