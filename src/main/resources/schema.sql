CREATE TABLE IF NOT EXISTS Organizations (
    id         INTEGER              COMMENT 'Уникальный идентификатор' PRIMARY KEY AUTO_INCREMENT ,
    name VARCHAR(25) NOT NULL COMMENT 'Имя',
    fullName VARCHAR(25),
    inn INTEGER(12),
    kpp INTEGER(20),
    address VARCHAR(50),
    phone CHAR(20),
    isActive INTEGER(1)
);
COMMENT ON TABLE Organizations IS 'Organizations';


CREATE TABLE IF NOT EXISTS Offices (
    id         INTEGER              COMMENT 'Уникальный идентификатор' PRIMARY KEY AUTO_INCREMENT ,
    orgId INTEGER(25),
    name VARCHAR(25),
    phone CHAR(20),
    isActive INTEGER(1),
    address    VARCHAR(50) NOT NULL COMMENT 'Адрес'
);
COMMENT ON TABLE Offices IS 'Offices';

CREATE TABLE IF NOT EXISTS User (
    officeId INTEGER(25)PRIMARY KEY AUTO_INCREMENT,
    firstName VARCHAR(25),
    lastName VARCHAR(25),
    middleName VARCHAR(25),
    position VARCHAR(25),
    docCode INTEGER(15),
    citizenshipCode INTEGER(5),
    isIdentified INTEGER(1),
    docName VARCHAR(25),
    docNumber INTEGER(20),
    docDate DATE
);

CREATE TABLE IF NOT EXISTS Docs (
    name VARCHAR(25),
    code INTEGER(10)
);

CREATE TABLE IF NOT EXISTS Countries (
    name VARCHAR(25),
    code INTEGER(10)
);

CREATE INDEX Org_Id ON Offices (orgId);
ALTER TABLE Offices ADD FOREIGN KEY (orgId) REFERENCES Organizations(id);

CREATE INDEX Offices_Id ON User (officeId);
ALTER TABLE User ADD FOREIGN KEY (officeId) REFERENCES Offices(id);

CREATE INDEX DocName_Id ON User (docName);
ALTER TABLE User ADD FOREIGN KEY (docName) REFERENCES Docs(name);

CREATE INDEX CitizenshipCode_Id ON User (citizenshipCode);
ALTER TABLE User ADD FOREIGN KEY (citizenshipCode) REFERENCES Countries(code);