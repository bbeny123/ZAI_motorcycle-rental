--------------------------------------------------------
--  Example data for Table RENTS
--------------------------------------------------------

INSERT INTO RENTS (RNT_ID,RNT_USR_ID,RNT_MTO_ID,RNT_DATE_START,RNT_DATE_END)
VALUES (SEQ_RNT_ID.NEXTVAL,1,1,to_date('21-05-2017 00:00:00','DD-MM-RRRR HH24:MI:SS'), to_date('20-06-2017 00:00:00','DD-MM-RRRR HH24:MI:SS'));

INSERT INTO RENTS (RNT_ID,RNT_USR_ID,RNT_MTO_ID,RNT_DATE_START,RNT_DATE_END)
VALUES (SEQ_RNT_ID.NEXTVAL,2,1,to_date('21-05-2017 00:00:00','DD-MM-RRRR HH24:MI:SS'), to_date('20-06-2017 00:00:00','DD-MM-RRRR HH24:MI:SS'));
COMMIT;