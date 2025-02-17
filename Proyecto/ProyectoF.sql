CREATE DATABASE IF NOT EXISTS m_ProyectoF;
USE m_ProyectoF;

CREATE TABLE Elementos (
   `CodigoE` INTEGER(10) NOT NULL,
    `Nombre` VARCHAR(25) DEFAULT NULL,
    `Descripcion` VARCHAR(150) DEFAULT NULL,
    `Stock` NUMERIC(10) DEFAULT NULL,
    `Precio` NUMERIC(10) NOT NULL,
`Categoria` VARCHAR(20) DEFAULT NULL,

    PRIMARY KEY (`CodigoE`)
);

CREATE TABLE Hardware (
`CodigoHW` INTEGER(10) NOT NULL,
`Nombre` VARCHAR(30) NOT NULL,
`Descripcion` VARCHAR(250) DEFAULT NULL,
`Unidades` INTEGER(10) NOT NULL,
`Anyo` INTEGER(4) DEFAULT NULL,
`Precio` INTEGER(10) NOT NULL,

    PRIMARY KEY (`CodigoHW`)
    
);
 
CREATE TABLE Software (
    `CodigoSW` INTEGER(10) NOT NULL,
    `Nombre` VARCHAR(30) DEFAULT NULL,
    `Descripcion` VARCHAR(250) DEFAULT NULL,
    `Version` VARCHAR(10) DEFAULT NULL,
    `Licencia` VARCHAR(5) DEFAULT NULL,
`Caducidad` VARCHAR(20) NOT NULL,
`Unidades` NUMERIC(10) DEFAULT NULL,
`Precio` NUMERIC(10) NOT NULL,

    PRIMARY KEY (`CodigoSW`)
    
);

CREATE TABLE CHardware (
    `CodigoCHW` INTEGER(10) NOT NULL,
    `Nombre` VARCHAR(15) DEFAULT NULL,
    `Tamaño` NUMERIC(10) DEFAULT NULL,
    `Tipo` VARCHAR(20) DEFAULT NULL,
    `Descripcion` VARCHAR(250) DEFAULT NULL,
    PRIMARY KEY (`CodigoCHW`)
    
);

CREATE TABLE Equipo (
`CodigoEIO` INTEGER(10) NOT NULL,
    `CodigoCHW` INTEGER(10) NOT NULL,
    `CodigoSW` INTEGER(10) NOT NULL,
    `Observaciones` VARCHAR(250) DEFAULT NULL,
    PRIMARY KEY (`CodigoEIO`),
INDEX Equipo_FKIndex2 (`CodigoCHW`),
    FOREIGN KEY (`CodigoCHW`)
        REFERENCES CHardware (`CodigoCHW`)
        ON UPDATE CASCADE ON DELETE RESTRICT,
INDEX Equipo_FKIndex3 (`CodigoSW`),
    FOREIGN KEY (`CodigoSW`)
        REFERENCES Software (`CodigoSW`)
        ON UPDATE CASCADE ON DELETE RESTRICT
    
    
);
         
CREATE TABLE Proveedores (
`CodigoP` INTEGER(10) NOT NULL,
`Nombre` VARCHAR(30) DEFAULT NULL,
`Direccion` VARCHAR(25) DEFAULT NULL,
`Poblacion` VARCHAR(25) DEFAULT NULL,
`Telefono` CHAR(9) DEFAULT NULL,
`Contacto` VARCHAR(15) DEFAULT NULL,
`PaginaWeb` VARCHAR(35) DEFAULT NULL,
`CorreoElectronico` VARCHAR(25) DEFAULT NULL,
    PRIMARY KEY (`CodigoP`)
); 

CREATE TABLE Empleado (
    `Identificador` INTEGER(10) NOT NULL,
    `Nombre` VARCHAR(30) NOT NULL,
    `Contraseña` VARCHAR(9) DEFAULT NULL,
    `Rol` VARCHAR(25) DEFAULT NULL,

    PRIMARY KEY (`IdentificadorE`)
);
       
CREATE TABLE Registro (
    `CodigoP` INTEGER(10) NOT NULL,
    `CodigoE` INTEGER(10) NOT NULL,
    `Identificador` INTEGER(10) NOT NULL,
    `Fecha` DATE DEFAULT NULL,
    `Lista` VARCHAR(250) DEFAULT NULL,
    PRIMARY KEY (`Identificador`, `CodigoP`,`CodigoE`),
    INDEX Registro_FKIndex4 (`CodigoP`),
    FOREIGN KEY (`CodigoP`)
        REFERENCES Proveedores (`CodigoP`)
        ON UPDATE CASCADE ON DELETE RESTRICT,
    INDEX Registro_FKIndex5 (`CodigoE`),
    FOREIGN KEY (`CodigoE`)
        REFERENCES Elementos (`CodigoE`)
        ON UPDATE CASCADE ON DELETE RESTRICT
);

CREATE TABLE Roles (
    `RolR` INTEGER(10) NOT NULL,
    `Descripcion` VARCHAR(250) DEFAULT NULL,   
    PRIMARY KEY (`RolR`)
);

CREATE TABLE Tiene (
    `Identificador` INTEGER(10) NOT NULL,
    `RolR` INTEGER(10) NOT NULL,   
    PRIMARY KEY (`Identificador`,`RolR`),
INDEX Tiene_FKIndex6 (`RolR`),
    FOREIGN KEY (`RolR`)
        REFERENCES Roles (`RolR`)
        ON UPDATE CASCADE ON DELETE RESTRICT
);

CREATE TABLE Usuario (
    `Identificador` INTEGER(10) NOT NULL,
    PRIMARY KEY (`Identificador`)
);

CREATE TABLE JefeDepartamento (
   `Identificador` INTEGER(10) NOT NULL,  
    PRIMARY KEY (`Identificador`),

);

CREATE TABLE Solicitud (
     `IdentificadorU` INTEGER(10) NOT NULL,
    `IdentificadorJ` INTEGER(10) NOT NULL,
`Articulo` VARCHAR(25) DEFAULT NULL,
`Motivo` VARCHAR(250) DEFAULT NULL,
    
    PRIMARY KEY (`IdentificadorU`,`IdentificadorJ`),
INDEX Solicitud_FKIndex7 (`IdentificadorJ`),
    FOREIGN KEY (`IdentificadorJ`)
        REFERENCES JefeDepartamento (`IdentificadorJ`)
        ON UPDATE CASCADE ON DELETE RESTRICT
);

CREATE TABLE Profesor (
    `IdentificadorP` INTEGER(10) NOT NULL,
    `IdentificadorE` INTEGER(10) NOT NULL,
    PRIMARY KEY (`IdentificadorP`),
);

CREATE TABLE Ubicacion (
    `CodigoUbicacion` INTEGER(10) NOT NULL,
    `Nombre` VARCHAR(15) DEFAULT NULL,
 `Descripcion` VARCHAR(150) DEFAULT NULL,
 `Ubicacion` VARCHAR(25) DEFAULT NULL,
 `Planta` CHAR(1) DEFAULT NULL,
    
    PRIMARY KEY (`CodigoUbicacion`)
);

CREATE TABLE Estado (
    `CodigoEstado` INTEGER(10) NOT NULL,
    `Estado` VARCHAR(11) DEFAULT NULL,
    PRIMARY KEY (`CodigoEstado`)
);

CREATE TABLE Resolucion (
    `CodigoResolucion` INTEGER(10) NOT NULL,
    `FechaResolucion` DATE DEFAULT NULL,
 `Observaciones` VARCHAR(250) DEFAULT NULL,
    PRIMARY KEY (`CodigoResolucion`)
);

CREATE TABLE TicketIncidencia (
    `CodigoT` INTEGER(10) NOT NULL,
    `Fecha` DATE DEFAULT NULL,
 `Descripcion` VARCHAR(150) DEFAULT NULL,
 `Elemento` VARCHAR(50) DEFAULT NULL,
 `Material` VARCHAR(15) DEFAULT NULL,
 `NivelUrgencia` VARCHAR(15) DEFAULT NULL,
 `Categoria` VARCHAR(15) DEFAULT NULL,
 `IdentificadorP` INTEGER(10) NOT NULL,
 `CodigoUbicacion` INTEGER(10) NOT NULL,
 `CodigoEstado` INTEGER(10) NOT NULL,
 `CodigoResolucion` INTEGER(10) NOT NULL,
 `IdentificadorU` INTEGER(10) NOT NULL,

    PRIMARY KEY (`CodigoT`),
INDEX TicketIncidencia_FKIndex10 (`IdentificadorP`),
    FOREIGN KEY (`IdentificadorP`)
        REFERENCES Profesor (`IdentificadorP`)
        ON UPDATE CASCADE ON DELETE  RESTRICT,
INDEX TicketIncidencia_FKIndex11 (`CodigoUbicacion`),
    FOREIGN KEY (`CodigoUbicacion`)
        REFERENCES Ubicacion (`CodigoUbicacion`)
        ON UPDATE CASCADE ON DELETE  RESTRICT,
INDEX TicketIncidencia_FKIndex12 (`CodigoEstado`),
    FOREIGN KEY (`CodigoEstado`)
        REFERENCES Estado (`CodigoEstado`)
        ON UPDATE CASCADE ON DELETE  RESTRICT,
INDEX TicketIncidencia_FKIndex13 (`CodigoResolucion`),
    FOREIGN KEY (`CodigoResolucion`)
        REFERENCES Resolucion (`CodigoResolucion`)
        ON UPDATE CASCADE ON DELETE  RESTRICT,
INDEX TicketIncidencia_FKIndex14 (`IdentificadorU`),
    FOREIGN KEY (`IdentificadorU`)
        REFERENCES Usuario (`IdentificadorU`)
        ON UPDATE CASCADE ON DELETE  RESTRICT

);

CREATE TABLE Tecnico (
      `IdentificadorT` INTEGER(10) NOT NULL,
    `IdentificadorE`  INTEGER(10) NOT NULL,
    PRIMARY KEY (`IdentificadorT`),
);

CREATE TABLE Mensaje (
     `CodigoMensaje` INTEGER(10) NOT NULL,
    `Asunto` VARCHAR(50) DEFAULT NULL,
`Cuerpo` VARCHAR(250) DEFAULT NULL,
`Fecha` DATE DEFAULT NULL,
`EnviadoPor`  INTEGER(10) NOT NULL,
`RecibidoPor`  INTEGER(10) NOT NULL,
    PRIMARY KEY (`CodigoMensaje`),
INDEX Mensaje_FKIndex16 (`EnviadoPor`),
    FOREIGN KEY (`EnviadoPor`)
        REFERENCES Empleado (`IdentificadorE`)
        ON UPDATE CASCADE ON DELETE RESTRICT,
INDEX Mensaje_FKIndex17 (`RecibidoPor`),
    FOREIGN KEY (`RecibidoPor`)
        REFERENCES Empleado (`IdentificadorE`)
        ON UPDATE CASCADE ON DELETE RESTRICT
);

INSERT INTO Elementos(`CodigoE`,`Nombre`,`Descripcion`, `Stock`,`Precio`, `Categoria`)  
VALUES (10001, 'Ordenadores Windows' ,'Ordenadores con sistema operativo Windows listos para funcionar', '15',125,'Hardware'),
	   (10002, 'Pantallas ','Pantallas que nos ayudarán a visualizar mejor el trabajo', '22',55,'Hardware');
       
       
INSERT INTO Hardware(`CodigoHW`,`Nombre`,`Descripcion`, `Unidades`,`Anyo`, `Precio`)  
VALUES (20001, 'CPU' ,'Ayuda para mejorar el rendimiento general de nuestro ordenador', 12,2008, 145),
	   (20002, 'Tarjeta Grafica ','mayor rendimiento en el ámbito gráfico para nuestras computadoras', 5,2011, 615);
       
       
INSERT INTO Software(`CodigoSW`,`Nombre`,`Descripcion`, `Version`,`Licencia`, `Caducidad`, `Unidades`, `Precio`)  
VALUES (30001, 'Windows 10 Enterprise' ,'Version de windows 10 orientada a empresas', '10.1', 'OS', '20/01/2019', 5, 300),
	   (30002, 'Skype','Software capaz de comunicarnos con otras personas mediante videollamada', '2.2','DOS', '31/8/2058', 70, 25);
       
       
INSERT INTO CHardware(`CodigoCHW`,`Nombre`,`Tamaño`, `Tipo`,`Descripcion`)  
VALUES (40001, 'PCB' ,1000, 'PCB','Conecta aquellos elementos electronicos con circuitos electronicos'),
	   (40002, 'CPU ',25, 'CPU','Ayuda para mejorar el rendimiento general de nuestro ordenador');
       
       
INSERT INTO Equipo(`CodigoEIO`,`CodigoCHW`,`CodigoSW`, `Observaciones`)  
VALUES (50001, 40001 ,30001, 'Un Ordenador con Windows 10 Enterprise funcionando a pleno rendimiento y PCB'),
	   (50002, 40002,30001, 'Un ordenador con Software Windows 10 Enterprise funcionando a pleno rendimiento con una CPU de 25TB');
       
       
INSERT INTO Proveedores(`CodigoP`,`Nombre`,`Direccion`, `Poblacion`,`Telefono`, `Contacto`, `PaginaWeb`, `CorreoElectronico`)  
VALUES (60001, 'BEEP Informática' ,'Nila', 'Monforte del Cid',968434236, 'Juan', 'www.BEEP.com', 'beepI@gmail.com'),
	   (60002, 'PCBOX ','Mira', 'Petrer',659898125,'Pepe','www.PCBOX.com','PCBOX@gmail.com' );
       
       
INSERT INTO Empleado(`Identificador`,`Nombre`,`Contrasenya`,`Rol`)  
VALUES (70001, 'Adrian', 'batoi1234', 'Administrador' ),
(70002, 'Samu', 'samu', 'Profesor' ),
(70003, '*******','*******','Tecnico' ),
(70004, '*******','*******','Tecnico' ),
(70005, '*******','*******','Tecnico' ),
(70006, '*******','*******','Tecnico' );



	   
       
       
INSERT INTO Registro(`CodigoP`,`CodigoE`,`IdentificadorE`, `Fecha`,`Lista`)  
VALUES (60001, 10001 ,70001, 31/1/2017,''),
	   (60002, 10002,70002, 2/2/2017,'');
      

INSERT INTO Roles(`RolR`,`Descripcion`)  
VALUES (80001, 'Consultar proveedores' ),
(80002, 'Consultar inventario y 
artículos no inventariable' ),
(80003, 'Consultar y crear incidencias' ),
(80004, 'Manipular proveedores' ),
(80005, 'Manipular inventario y resto 
de artículos' ),
(80006, 'Lanzar peticiones de compra'),
(80007, 'Gestionar pedidos'),
(80008, 'Gestionar uso de material'),
(80009, 'Gestionar ubicaciones'),
(80010, 'Gestión de usuario'),
(80011, 'Resolver incidencias');
       
       
       
INSERT INTO Tiene(`IdentificadorE`,`RolR`)  
VALUES (70001,80001),
(70002, 80002),
(70003,80003),
(70004, 80004),
(70005, 80005),
	   (70006, 80006);
       
       
INSERT INTO Usuario(`IdentificadorU`)  
VALUES (90001),
	   (90002);
       
       
INSERT INTO JefeDepartamento(`IdentificadorJ`, `IdentificadorE`)  
VALUES (100001, 70001),
	   (100002, 70002);
       

INSERT INTO Solicitud(`IdentificadorU`,`IdentificadorJ`,`Articulo`, `Motivo`)  
VALUES (20001, 100001 ,'Torre de Ordenador', 'El Ordenador dejó de funcionar'),
	   (20002, 100002,'Raton', 'No se encuentra el ratón');
       

 INSERT INTO Profesor(`IdentificadorP`, `IdentificadorE`)  
VALUES (110001, 70003),
	   (110002, 70004);
       
      
   INSERT INTO Ubicacion(`CodigoUbicacion`,`Nombre`,`Descripcion`, `Ubicacion`, `Planta`)  
VALUES (120001, 'Aula221' ,'En el Aula de Daw en la segunda Planta', 'Segundo Edificio',2),
	   (120002, 'Aula211','En la entrada de la clase, primer ordenador', 'Segundo Edificio',2);
       
   
   INSERT INTO Estado(`CodigoEstado`, `Estado`)  
VALUES (130001, 'Pendiente' ),
	   (130002, 'En Proceso'),
       (130003, 'Finalizado');
       
       
       
INSERT INTO Resolucion(`CodigoResolucion`, `FechaResolucion`, `Observaciones`)  
VALUES (140001, 8/8/2008,'Pendiente de evolucion'),
	   (140002, 23/12/2012, 'No se encuentra el error');
       
   
INSERT INTO TicketIncidencia(`CodigoT`,`Fecha`,`Descripcion`, `Elemento`,`Material`, `NivelUrgencia`, `Categoria`, `IdentificadorP`,`CodigoUbicacion`,`CodigoEstado`,`CodigoResolucion`, `IdentificadorU` )  
VALUES (150001,12/12/2007 ,'La caja de la torre se encontró destrozada', 'Torre de Ordenador','Hardware','Alta','Hardware',110001,120001,130002,140001,90001),
	   (150002,1/2/2013,'No se encuentra el raton de una torre de la clse 211', 'Raton','Hardware','Baja','Hardware',110002,120002,130002,140002,90002);
       
       
INSERT INTO Tecnico(`IdentificadorT`, `IdentificadorE`)  
VALUES (160001, 70005),
	   (160002, 70006);
       
       
INSERT INTO Mensaje(`CodigoMensaje`,`Asunto`,`Cuerpo`, `Fecha`,`EnviadoPor`, `RecibidoPor`)  
VALUES (170001, 'Urgencia Reparaciones' ,'Se requiere que repares la torre de inmediato', 21/12/2007,70005,70003),
	   (170002, 'Duda','¿Sabes algo sobre el material perdido en el aula 221?', 3/2/2013,70006,70002);
