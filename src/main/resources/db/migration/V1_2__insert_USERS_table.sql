--------------------------------------------------------
--  Example data for Table USERS
--------------------------------------------------------

INSERT INTO USERS (USR_ID,USR_LOGIN,USR_PASSWORD,USR_FIRST_NAME,USR_LAST_NAME,USR_EMAIL,USR_ADMIN)
VALUES (SEQ_USR_ID.NEXTVAL,'jdoe','abc','John','Doe','A@gmail.com',1);

INSERT INTO USERS (USR_ID,USR_LOGIN,USR_PASSWORD,USR_FIRST_NAME,USR_LAST_NAME,USR_EMAIL,USR_ADMIN)
VALUES (SEQ_USR_ID.NEXTVAL,'jdoe2','$2a$10$ebyC4Z5WtCXXc.HGDc1Yoe6CLFzcntFmfse6/pTj7CeDY5I05w16C','John','Doe','demo@localhost',1);
COMMIT;