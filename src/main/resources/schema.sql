CREATE TABLE IF NOT EXISTS Organization (
    id       INTEGER              COMMENT 'Уникальный идентификатор' PRIMARY KEY AUTO_INCREMENT ,
    name     VARCHAR(25) NOT NULL COMMENT 'Имя',
    fullName VARCHAR(25),
    inn      VARCHAR(25),
    kpp      VARCHAR(25),
    address  VARCHAR(50),
    phone    CHAR(20),
    isActive INTEGER(1)
);
COMMENT ON TABLE Organization IS 'Organization';


CREATE TABLE IF NOT EXISTS Office (
    orgId    INTEGER(25)          COMMENT 'Уникальный идентификатор' PRIMARY KEY,
    name     VARCHAR(25),
    phone    CHAR(20),
    isActive INTEGER(1),
    address  VARCHAR(50) NOT NULL COMMENT 'Адрес'
);
COMMENT ON TABLE Office IS 'Office';

CREATE TABLE IF NOT EXISTS User (
    officeId        INTEGER(25)PRIMARY KEY,
    firstName       VARCHAR(25),
    lastName        VARCHAR(25),
    middleName      VARCHAR(25),
    position        VARCHAR(25),
    citizenshipCode INTEGER(5),
    isIdentified    INTEGER(1)
);

CREATE TABLE IF NOT EXISTS DocProperties (
    userId    INTEGER(20),
    docName   VARCHAR(25),
    docDate   DATE
);

CREATE TABLE IF NOT EXISTS Docs (
    id   INTEGER(20) PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(25),
    code INTEGER(10)
);

CREATE TABLE IF NOT EXISTS Countries (
    id   INTEGER(20) PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(25),
    code INTEGER(10)
);

CREATE INDEX Org_Id ON Office (orgId);
ALTER TABLE Office ADD FOREIGN KEY (orgId) REFERENCES Organization(id);

CREATE INDEX Office_Id ON User (officeId);
ALTER TABLE User ADD FOREIGN KEY (officeId) REFERENCES Office(orgId);

CREATE INDEX User_Id ON DocProperties(userId);
ALTER TABLE DocProperties ADD FOREIGN KEY (userId) REFERENCES User(officeId);

CREATE INDEX DocName_Id ON DocProperties (userId);
ALTER TABLE DocProperties ADD FOREIGN KEY (userId) REFERENCES Docs(id);

CREATE INDEX Country_Id ON User (citizenshipCode);
ALTER TABLE User ADD FOREIGN KEY (citizenshipCode) REFERENCES Countries(id);
