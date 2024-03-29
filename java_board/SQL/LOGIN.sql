--------------------------------------------------------
--  파일이 생성됨 - 금요일-3월-29-2024   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table LOGIN
--------------------------------------------------------

  CREATE TABLE "HR"."LOGIN" 
   (	"NO" NUMBER(20,0), 
	"TPW" VARCHAR2(100 BYTE), 
	"TID" VARCHAR2(100 BYTE), 
	"NAME" VARCHAR2(255 BYTE), 
	"AGE" NUMBER(20,0)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
REM INSERTING into HR.LOGIN
SET DEFINE OFF;
Insert into HR.LOGIN (NO,TPW,TID,NAME,AGE) values (1,'12345','ID','ex',20);
Insert into HR.LOGIN (NO,TPW,TID,NAME,AGE) values (2,'JavaFx','hello','DB',null);
Insert into HR.LOGIN (NO,TPW,TID,NAME,AGE) values (null,'javaFx','Hello','dB',null);
--------------------------------------------------------
--  DDL for Index LOGIN_PK1
--------------------------------------------------------

  CREATE UNIQUE INDEX "HR"."LOGIN_PK1" ON "HR"."LOGIN" ("TID", "TPW") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  Constraints for Table LOGIN
--------------------------------------------------------

  ALTER TABLE "HR"."LOGIN" MODIFY ("TID" NOT NULL ENABLE);
  ALTER TABLE "HR"."LOGIN" ADD CONSTRAINT "LOGIN_PK" PRIMARY KEY ("TID", "TPW")
  USING INDEX (CREATE UNIQUE INDEX "HR"."LOGIN_PK1" ON "HR"."LOGIN" ("TID", "TPW") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" )  ENABLE;
  ALTER TABLE "HR"."LOGIN" MODIFY ("TPW" NOT NULL ENABLE);