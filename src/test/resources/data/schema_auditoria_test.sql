DROP SEQUENCE IF EXISTS AUDITORIA_SEQ;

DROP TABLE IF EXISTS REQUEST_LOGS;

-- ******************************************************
-- 
--                    SECUENCIADORES
-- 
-- ******************************************************
CREATE SEQUENCE "AUDITORIA_SEQ"
	MINVALUE 1
	MAXVALUE 999999999
	INCREMENT BY 50
	START WITH 5000
	NOCACHE
	NOCYCLE;
 
-- ******************************************************
-- 
--                       MODEL 
-- 
-- ******************************************************

CREATE TABLE REQUEST_LOGS(
	ID								BIGINT			NOT NULL,
	TIME_STAMP						TIMESTAMP		,
	PATH							VARCHAR(250)	,
	METHOD							VARCHAR(15)		,
	IP								VARCHAR(30)		,
	ELAPSED_TIME					BIGINT			,
	STATUS_CODE						INTEGER			,
	PRIMARY KEY(ID)
);