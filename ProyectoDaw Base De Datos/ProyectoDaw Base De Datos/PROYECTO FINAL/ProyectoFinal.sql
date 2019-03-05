CREATE DATABASE IF NOT EXISTS m_Proyecto;
USE m_Proyecto;

CREATE TABLE Elementos (
   `CodigoE` INTEGER(10) NOT NULL,
    `Nombre` VARCHAR(15) DEFAULT NULL,
    `Descripcion` VARCHAR(150) DEFAULT NULL,
    `Stock` NUMERIC(10) DEFAULT NULL,
    `Precio` NUMERIC(10) NOT NULL,
`Categoria` VARCHAR(20) DEFAULT NULL,

    PRIMARY KEY (`CodigoE`)
);

CREATE TABLE Hardware (
`CodigoHW` INTEGER(10) NOT NULL,
`Nombre` VARCHAR(15) NOT NULL,
`Descripcion` VARCHAR(150) DEFAULT NULL,
`Unidades` NUMERIC(10) NOT NULL,
`Año` NUMERIC(4) DEFAULT NULL,
`Precio` NUMERIC(10) NOT NULL,

    PRIMARY KEY (`CodigoHW`)
    
);
 
CREATE TABLE Software (
    `CodigoSW` INTEGER(10) NOT NULL,
    `Nombre` VARCHAR(15) DEFAULT NULL,
    `Descripcion` VARCHAR(150) DEFAULT NULL,
    `Version` NUMERIC(10) DEFAULT NULL,
    `Licencia` VARCHAR(5) DEFAULT NULL,
`Caducidad` DATE DEFAULT NULL,
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
`Nombre` VARCHAR(15) DEFAULT NULL,
`Direccion` VARCHAR(25) DEFAULT NULL,
`Poblacion` VARCHAR(25) DEFAULT NULL,
`Telefono` NUMERIC(9) DEFAULT NULL,
`Contacto` VARCHAR(15) DEFAULT NULL,
`PaginaWeb` VARCHAR(25) DEFAULT NULL,
`CorreoElectronico` VARCHAR(25) DEFAULT NULL,
    PRIMARY KEY (`CodigoP`)
); 

CREATE TABLE Empleado (
    `IdentificadorE` INTEGER(10) NOT NULL,
    `Contraseña` VARCHAR(9) DEFAULT NULL,

    PRIMARY KEY (`IdentificadorE`)
);
       
CREATE TABLE Registro (
    `CodigoP` INTEGER(10) NOT NULL,
    `CodigoE` INTEGER(10) NOT NULL,
    `IdentificadorE` INTEGER(10) NOT NULL,
    `Fecha` DATE DEFAULT NULL,
    `Lista` VARCHAR(250) DEFAULT NULL,
    PRIMARY KEY (`IdentificadorE`, `CodigoP`,`CodigoE`),
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
    `IdentificadorE` INTEGER(10) NOT NULL,
    `RolR` INTEGER(10) NOT NULL,
    
    PRIMARY KEY (`IdentificadorE`,`RolR`),
INDEX Tiene_FKIndex6 (`RolR`),
    FOREIGN KEY (`RolR`)
        REFERENCES Roles (`RolR`)
        ON UPDATE CASCADE ON DELETE RESTRICT
);

CREATE TABLE Usuario (
    `IdentificadorU` INTEGER(10) NOT NULL,
    PRIMARY KEY (`IdentificadorU`)
);

CREATE TABLE JefeDepartamento (
   `IdentificadorJ` INTEGER(10) NOT NULL,
    `IdentificadorE` INTEGER(10) NOT NULL,
    PRIMARY KEY (`IdentificadorJ`),
INDEX JefeDepartamento_FKIndex8 (`IdentificadorE`),
    FOREIGN KEY (`IdentificadorE`)
        REFERENCES Empleado (`IdentificadorE`)
        ON UPDATE CASCADE ON DELETE RESTRICT
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
INDEX Profesor_FKIndex9 (`IdentificadorE`),
    FOREIGN KEY (`IdentificadorE`)
        REFERENCES Empleado (`IdentificadorE`)
        ON UPDATE CASCADE ON DELETE RESTRICT
);

CREATE TABLE Ubicacion (
    `CodigoUbicacion` INTEGER(10) NOT NULL,
    `Nombre` VARCHAR(15) DEFAULT NULL,
 `Descripcion` VARCHAR(150) DEFAULT NULL,
 `Ubicacion` VARCHAR(15) DEFAULT NULL,
 `Planta` VARCHAR(1) DEFAULT NULL,
    
    PRIMARY KEY (`CodigoUbicacion`)
);

CREATE TABLE Estado (
    `CodigoEstado` INTEGER(10) NOT NULL,
    `Estado` VARCHAR(5) DEFAULT NULL,
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
 `Elemento` VARCHAR(15) DEFAULT NULL,
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
INDEX Tecnico_FKIndex15 (`IdentificadorE`),
    FOREIGN KEY (`IdentificadorE`)
        REFERENCES Empleado (`IdentificadorE`)
        ON UPDATE CASCADE ON DELETE RESTRICT
);

CREATE TABLE Mensaje (
     `CodigoMensaje` INTEGER(10) NOT NULL,
    `Asunto` VARCHAR(20) DEFAULT NULL,
`Cuerpo` VARCHAR(250) DEFAULT NULL,
`Fecha` DATE DEFAULT NULL,
`EnviadoPor`  INTEGER(10) NOT NULL,
`RecibidoPor`  INTEGER(10) NOT NULL,
    PRIMARY KEY (`CodigoMensaje`),
INDEX Mensaje_FKIndex16 (`EnviadoPor`),
    FOREIGN KEY (`EnviadoPor`)
        REFERENCES Tecnico (`IdentificadorT`)
        ON UPDATE CASCADE ON DELETE RESTRICT,
INDEX Mensaje_FKIndex17 (`RecibidoPor`),
    FOREIGN KEY (`RecibidoPor`)
        REFERENCES Profesor (`IdentificadorP`)
        ON UPDATE CASCADE ON DELETE RESTRICT
);

CREATE TABLE Recibir (
    `EnviadoPor` INTEGER(10) NOT NULL,
PRIMARY KEY (`EnviadoPor`)
);

CREATE TABLE Enviar (
     `RecibidoPor` INTEGER(10) NOT NULL,
PRIMARY KEY (`RecibidoPor`)
);

   
   
   
   
   
   
