CREATE FUNCTION NEXTNVL()
RETURNS INT(4)
BEGIN
	DECLARE N_NEXTVAL INT(4);
	SELECT IFNULL(MAX(EMPNO),0)+1
	INTO N_NEXTVAL
	FROM web_emp;
	RETURN N_NEXTVAL;
END;

CREATE TABLE WEB_DEPT
(
    DEPTNO                         int(2) NOT NULL,
    DNAME                          VARCHAR(20),
    LOC                            VARCHAR(50),
    CONSTRAINT WEB_PK_WEB_DEPT PRIMARY KEY (DEPTNO)
)

CREATE TABLE WEB_EMP
(
    EMPNO                          INT(4) NOT NULL,
    ENAME                          VARCHAR(20),
    JOB                            VARCHAR(50),
    MGR                            INT(4),
    HIREDATE                       DATE,
    SAL                            DOUBLE(7,2),
    COMM                           DOUBLE(7,2),
    DEPTNO                         INT(2,0),
    MEMO                           VARCHAR(4000),
    UPD_TIME                       DATE,
    CONSTRAINT FK_WEB_EMP FOREIGN KEY (DEPTNO) REFERENCES WEB_DEPT (DEPTNO),
    CONSTRAINT PK_WEB_EMP PRIMARY KEY (EMPNO)
)