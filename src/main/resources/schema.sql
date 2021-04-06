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
    id       INTEGER              COMMENT 'Уникальный идентификатор' PRIMARY KEY AUTO_INCREMENT ,
    orgId    INTEGER(25),
    name     VARCHAR(25),
    phone    CHAR(20),
    isActive INTEGER(1),
    address  VARCHAR(50) NOT NULL COMMENT 'Адрес'
);
COMMENT ON TABLE Office IS 'Office';

CREATE TABLE IF NOT EXISTS User (
    id              INTEGER(25) PRIMARY KEY AUTO_INCREMENT,
    officeId        INTEGER(25),
    firstName       VARCHAR(25),
    lastName        VARCHAR(25),
    middleName      VARCHAR(25),
    position        VARCHAR(25),
    docCode         INTEGER(15),
    citizenshipCode INTEGER(5),
    isIdentified    INTEGER(1)
);

CREATE TABLE IF NOT EXISTS DocProperties (
    id        INTEGER(20) PRIMARY KEY AUTO_INCREMENT,
    docName   VARCHAR(25),
    docNumber INTEGER(20),
    docDate   DATE
);

CREATE TABLE IF NOT EXISTS Doc (
    id   INTEGER(20) PRIMARY KEY,
    name VARCHAR(25),
    code INTEGER(10)
);

CREATE TABLE IF NOT EXISTS Countries (
    id   INTEGER(20) PRIMARY KEY,
    name VARCHAR(25),
    code INTEGER(10)
);

CREATE INDEX Org_Id ON Office (orgId);
ALTER TABLE Office ADD FOREIGN KEY (orgId) REFERENCES Organization(id);

CREATE INDEX Office_Id ON User (officeId);
ALTER TABLE User ADD FOREIGN KEY (officeId) REFERENCES Office(id);

CREATE INDEX Doc_Id ON DocProperties(id);
ALTER TABLE DocProperties ADD FOREIGN KEY (id) REFERENCES User(docCode);

CREATE INDEX DocName_Id ON DocProperties (id);
ALTER TABLE DocProperties ADD FOREIGN KEY (id) REFERENCES Doc(id);

CREATE INDEX Country_Id ON User (citizenshipCode);
ALTER TABLE User ADD FOREIGN KEY (citizenshipCode) REFERENCES Countries(id);
