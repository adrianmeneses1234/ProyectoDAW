CREATE DATABASE IF NOT EXISTS m_Practica3;
USE m_Practica3;

CREATE TABLE Clientes (
    `ID_Cliente` INTEGER(10) NOT NULL,
    `Nombre` VARCHAR(100) DEFAULT NULL,
    `Apellido` VARCHAR(100) DEFAULT NULL,
    `Direccion` VARCHAR(100) DEFAULT NULL,
    `Telefono` NUMERIC(15) DEFAULT NULL,
    PRIMARY KEY (`ID_Cliente`)
);

CREATE TABLE Cocineros (
    `ID_Cocinero` INTEGER(10) NOT NULL,
    `Nombre` VARCHAR(100) DEFAULT NULL,
    `Apellido` VARCHAR(100) DEFAULT NULL,
    `Direccion` VARCHAR(100) DEFAULT NULL,
    `Telefono` NUMERIC(15) DEFAULT NULL,
    PRIMARY KEY (`ID_Cocinero`)
);
 
CREATE TABLE Comandas (
    `Cod_Comandas` INTEGER(10) NOT NULL,
    `ID_Cliente` INTEGER(10) NOT NULL,
    PRIMARY KEY (`Cod_Comandas`),
    INDEX Comandas_FKIndex2 (`ID_Cliente`),
    FOREIGN KEY (`ID_Cliente`)
        REFERENCES Clientes (`ID_Cliente`)
        ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE Camareros (
    `ID_Camareros` INTEGER(10) NOT NULL,
    `Nombre` VARCHAR(100) DEFAULT NULL,
    `Apellido` VARCHAR(100) DEFAULT NULL,
    `Direccion` VARCHAR(100) DEFAULT NULL,
    `Telefono` NUMERIC(15) DEFAULT NULL,
    `Id_Comandas` INTEGER(10) NOT NULL,
    PRIMARY KEY (`ID_Camareros`),
    INDEX Camareros_FKIndex1 (`Id_Comandas`),
    FOREIGN KEY (`Id_Comandas`)
        REFERENCES Comandas (`Cod_Comandas`)
        ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE Mesa (
    `Id_NºMesa` INTEGER(10) NOT NULL,
    `NºPersona` VARCHAR(100) DEFAULT NULL,
    `ID_Cliente` INTEGER(10) NOT NULL,
    PRIMARY KEY (`Id_NºMesa`),
    INDEX Mesa_FKIndex5 (`ID_Cliente`),
    FOREIGN KEY (`ID_Cliente`)
        REFERENCES Clientes (`ID_Cliente`)
        ON UPDATE CASCADE ON DELETE CASCADE
);
         
CREATE TABLE Plato (
    `Id_Plato` INTEGER(10) NOT NULL,
    `Nombre` VARCHAR(100) DEFAULT NULL,
    `Precio` DECIMAL(65) NOT NULL,
    PRIMARY KEY (`Id_Plato`)
); 
       
CREATE TABLE Factura (
    `Id_Factura` INTEGER(10) NOT NULL,
    `Importe` DECIMAL(10) NOT NULL,
    `Fecha` DATE NOT NULL,
    `Hora` VARCHAR(20) NOT NULL,
    `Id_Comandas` INTEGER(10) NOT NULL,
    `Id_Platos` INTEGER(10) NOT NULL,
    PRIMARY KEY (`Id_Factura`),
    INDEX Factura_FKIndex3 (`Id_Comandas`),
    FOREIGN KEY (`Id_Comandas`)
        REFERENCES Comandas (`Cod_Comandas`)
        ON UPDATE CASCADE ON DELETE CASCADE,
    INDEX Factura_FKIndex4 (`Id_Platos`),
    FOREIGN KEY (`Id_Platos`)
        REFERENCES Plato (`Id_Plato`)
        ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE Reserva (
    `Id_NºMesa` INTEGER(10) NOT NULL,
    `ID_Cliente` INTEGER(10) NOT NULL,
    PRIMARY KEY (`Id_NºMesa` , `ID_Cliente`),
    INDEX Reserva_FKIndex6 (`ID_Cliente`),
    FOREIGN KEY (`ID_Cliente`)
        REFERENCES Clientes (`ID_Cliente`)
        ON UPDATE CASCADE ON DELETE NO ACTION
);

CREATE TABLE Eligen (
    `Id_NºMesa` INTEGER(10) NOT NULL,
    `ID_Cliente` INTEGER(10) NOT NULL,
    PRIMARY KEY (`Id_NºMesa` , `ID_Cliente`),
    INDEX Eligen_FKIndex7 (`ID_Cliente`),
    FOREIGN KEY (`ID_Cliente`)
        REFERENCES Clientes (`ID_Cliente`)
        ON UPDATE CASCADE ON DELETE NO ACTION
);

CREATE TABLE Realizan (
    `ID_Cliente` INTEGER(10) NOT NULL,
    `Cod_Comandas` INTEGER(10) NOT NULL,
    PRIMARY KEY (`ID_Cliente` , `Cod_Comandas`),
    INDEX Realizan_FKIndex8 (`Cod_Comandas`),
    FOREIGN KEY (`Cod_Comandas`)
        REFERENCES Comandas (`Cod_Comandas`)
        ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE Cocinan (
    `Cod_Comandas` INTEGER(10) NOT NULL,
    `ID_Cocinero` INTEGER(10) NOT NULL,
    PRIMARY KEY (`Cod_Comandas` , `ID_Cocinero`),
    INDEX Cocinan_FKIndex9 (`ID_Cocinero`),
    FOREIGN KEY (`ID_Cocinero`)
        REFERENCES Cocineros (`ID_Cocinero`)
        ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE Atiende (
    `Cod_Comandas` INTEGER(10) NOT NULL,
    `ID_Camareros` INTEGER(10) NOT NULL,
    PRIMARY KEY (`Cod_Comandas` , `ID_Camareros`),
    INDEX Atiende_FKIndex10 (`ID_Camareros`),
    FOREIGN KEY (`ID_Camareros`)
        REFERENCES Camareros (`ID_Camareros`)
        ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE Coste (
    `Cod_Comandas` INTEGER(10) NOT NULL,
    `Id_Factura` INTEGER(10) NOT NULL,
    PRIMARY KEY (`Cod_Comandas` , `Id_Factura`),
    INDEX Coste_FKIndex11 (`Id_Factura`),
    FOREIGN KEY (`Id_Factura`)
        REFERENCES Factura (`Id_Factura`)
        ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE Contiene (
    `Cod_Comandas` INTEGER(10) NOT NULL,
    `Id_Plato` INTEGER(10) NOT NULL,
    PRIMARY KEY (`Cod_Comandas` , `Id_Plato`),
    INDEX Contiene_FKIndex12 (`Id_Plato`),
    FOREIGN KEY (`Id_Plato`)
        REFERENCES Plato (`Id_Plato`)
        ON UPDATE CASCADE ON DELETE CASCADE
);
         



INSERT INTO Clientes(`ID_Cliente`,`Nombre`,`Apellido`, `Direccion`,`Telefono`)
VALUES (10001, 'Adrian' ,'Meneses', 'C/Lepanto',965421236),
	   (10002, 'Miguel' ,'Arias', 'C/Santidaz',659874125),
       (10003, 'Adan' ,'Mortal', 'C/Minar',965324578),
       (10004, 'Alvaro' ,'Minor', 'C/Jocosa',965653877);
       
INSERT INTO Cocineros(`ID_Cocinero`,`Nombre`,`Apellido`, `Direccion`,`Telefono`)  
VALUES (20001, 'Nolan' ,'Nila', 'C/Lepanto',968434236),
	   (20002, 'Ana ','Mira', 'C/Santidaz',659898125),
       (20003, 'Miro ','Monto', 'C/Minar',965632578),
       (20004, 'Lucas' ,'Lux', 'C/Jocosa',969653877);
       
INSERT INTO Comandas(`Cod_Comandas`,`ID_Cliente`)
VALUES(30001, 10001),
	  (30002, 10002),
      (30003, 10003),
      (30004, 10004);

INSERT INTO Camareros(`ID_Camareros`,`Nombre`,`Apellido`,`Direccion`,`Telefono`,`Id_Comandas`)
VALUES(40001, 'Mariano', 'Vivaz', 'C/Onil', 95645854,30001),
(40002, 'Miranda', 'Nueva', 'C/Salamanca', 965471598,30002),
(40003, 'Sofia', 'Lopez', 'C/Ibi', 965877518,30003),
(40004, 'Luis', 'Carlá',' C/Mortó', 965235614,30004);

INSERT INTO Mesa(`Id_NºMesa`,`NºPersona`,`ID_Cliente`)
VALUES(50001, 2, 10001),
(50002, 1, 10002),
(50003, 3, 10003),
(50004, 4, 10004);


INSERT INTO Plato(`Id_Plato`,`Nombre`,`Precio`)
VALUES(60001, 'La torrija de horchata', 12,25),
(60002, 'Merluza con citronella', 16,55),
(60003, 'El pulpo de roca con miel de membrillo de Atrapallada', 22,63),
(60004, 'Arroz de costilla de cerdo y ali oli de tomillo', 32,56);

INSERT INTO Reserva(`Id_NºMesa`,`ID_Cliente`)
VALUES(50001, 10001),
(50002, 10002),
(50003, 10003),
(50004, 10004);

INSERT INTO Eligen(`Id_NºMesa`,`ID_Cliente`)
VALUES(50001, 10003),
(50002, 10004),
(50003, 10001),
(50004, 10002);

INSERT INTO Realizan(`ID_Cliente`,`Cod_Comandas`)
VALUES(10001, 30001),
(10002, 30002),
(10003, 30003),
(10004, 30004);

INSERT INTO Cocinan(`Cod_Comandas`,`ID_Cocinero`)
VALUES(30001, 20001),
(30002, 20002),
(30003, 20003),
(30004, 20004);

INSERT INTO Atiende(`Cod_Comandas`,`ID_Camareros`)
VALUES(30001, 40001),
(30002, 40002),
(30003, 40003),
(30004, 40004);



UPDATE Camareros 
SET 
    `Direccion` = 'Castalla'
WHERE
    `ID_Camareros` = 10001; 







           
       
       
       




