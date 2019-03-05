CREATE DATABASE IF NOT EXISTS m_Proyecto;
USE m_Proyecto;

CREATE TABLE Elementos (
   `CodigoE` INTEGER(10) NOT NULL,
    `Nombre` VARCHAR(100) DEFAULT NULL,
    `Descripcion` VARCHAR(100) DEFAULT NULL,
    `Stock` VARCHAR(100) DEFAULT NULL,
    `Precio` NUMERIC(15) DEFAULT NULL,
`Categoria` NUMERIC(15) DEFAULT NULL,

    PRIMARY KEY (`CodigoE`)
);

CREATE TABLE Hardware (
`CodigoHW` INTEGER(10) NOT NULL,
    `Nombre` VARCHAR(100) DEFAULT NULL,
    `Descripcion` VARCHAR(100) DEFAULT NULL,
    `Unidades` VARCHAR(100) DEFAULT NULL,
    `Año` NUMERIC(15) DEFAULT NULL,
`Precio` NUMERIC(15) DEFAULT NULL,

    PRIMARY KEY (`CodigoHW`)
    
);
 
CREATE TABLE Software (
    `CodigoSW` INTEGER(10) NOT NULL,
    `Nombre` VARCHAR(100) DEFAULT NULL,
    `Descripcion` VARCHAR(100) DEFAULT NULL,
    `Version` VARCHAR(100) DEFAULT NULL,
    `Licencia` NUMERIC(15) DEFAULT NULL,
`Caducidad` NUMERIC(15) DEFAULT NULL,
`Unidades` NUMERIC(15) DEFAULT NULL,
`Precio` NUMERIC(15) DEFAULT NULL,

    PRIMARY KEY (`CodigoSW`)
    
);

CREATE TABLE Equipo (
`CodigoEIO` INTEGER(10) NOT NULL,
    `CodigoCHW` VARCHAR(100) DEFAULT NULL,
    `CodigoSW` VARCHAR(100) DEFAULT NULL,
    `Observaciones` VARCHAR(100) DEFAULT NULL,
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

CREATE TABLE CHardware (
    `CodigoCHW` INTEGER(10) NOT NULL,
    `Nombre` VARCHAR(100) DEFAULT NULL,
    `Tamaño` VARCHAR(100) DEFAULT NULL,
    `Tipo` VARCHAR(100) DEFAULT NULL,
    `Descripcion` NUMERIC(15) DEFAULT NULL,

    PRIMARY KEY (`CodigoCHW`)
    
);
         
CREATE TABLE Proveedores (
    `CodigoP` INTEGER(10) NOT NULL,
    `Nombre` VARCHAR(100) DEFAULT NULL,
    `Direccion` VARCHAR(100) DEFAULT NULL,
    `Poblacion` VARCHAR(100) DEFAULT NULL,
    `Telefono` NUMERIC(15) DEFAULT NULL,
`Contacto` NUMERIC(15) DEFAULT NULL,
`PaginaWeb` NUMERIC(15) DEFAULT NULL,
`CorreoElectronico` NUMERIC(15) DEFAULT NULL,

    PRIMARY KEY (`CodigoP`)
); 
       
CREATE TABLE Registro (
    `CodigoP` INTEGER(10) NOT NULL,
    `CodigoE` VARCHAR(100) DEFAULT NULL,
    `IdentificadorE` VARCHAR(100) DEFAULT NULL,
    `Fecha` VARCHAR(100) DEFAULT NULL,
    `Lista` NUMERIC(15) DEFAULT NULL,


    PRIMARY KEY (`CodigoP`,`CodigoE`,`IdentificadorE`),
INDEX Registro_FKIndex4 (`CodigoP`),
    FOREIGN KEY (`CodigoP`)
        REFERENCES Proovedores (`CodigoP`)
        ON UPDATE CASCADE ON DELETE RESTRICT,
INDEX Registro_FKIndex5 (`CodigoE`),
    FOREIGN KEY (`CodigoE`)
        REFERENCES Elementos (`CodigoE`)
        ON UPDATE CASCADE ON DELETE RESTRICT
);

CREATE TABLE Empleado (
    `IdentificadorE` INTEGER(10) NOT NULL,
    `Contraseña` VARCHAR(100) DEFAULT NULL,

    PRIMARY KEY (`IdentificadorE`)
);

CREATE TABLE Tiene (
    `IdentificadorE` INTEGER(10) NOT NULL,
    `RolR` VARCHAR(100) DEFAULT NULL,
    
    PRIMARY KEY (`IdentificadorE`,`RolR`),
INDEX Tiene_FKIndex6 (`RolR`),
    FOREIGN KEY (`RolR`)
        REFERENCES Roles (`RolR`)
        ON UPDATE CASCADE ON DELETE SET NULL
);

CREATE TABLE Roles (
    `RolR` INTEGER(10) NOT NULL,
    `Descripcion` VARCHAR(100) DEFAULT NULL,
    
    PRIMARY KEY (`RolR`)
);

CREATE TABLE Usuario (
    `IdentificadorU` INTEGER(10) NOT NULL,
    PRIMARY KEY (`IdentificadorU`)
);

CREATE TABLE Solicitud (
     `IdentificadorU` INTEGER(10) NOT NULL,
    `IdentificadorJ` VARCHAR(100) DEFAULT NULL,
`Articulo` VARCHAR(100) DEFAULT NULL,
`Motivo` VARCHAR(100) DEFAULT NULL,
    
    PRIMARY KEY (`IdentificadorU`,`IdentificadorJ`),
INDEX Solicitud_FKIndex7 (`IdentificadorJ`),
    FOREIGN KEY (`IdentificadorJ`)
        REFERENCES JefeDepartamento (`IdentificadorJ`)
        ON UPDATE CASCADE ON DELETE SET NULL
);

CREATE TABLE JefeDepartamento (
   `IdentificadorJ` INTEGER(10) NOT NULL,
    `IdentificadorE` VARCHAR(100) DEFAULT NULL,
    PRIMARY KEY (`IdentificadorJ`),
INDEX JefeDepartamento_FKIndex8 (`IdentificadorE`),
    FOREIGN KEY (`IdentificadorE`)
        REFERENCES Empleado (`IdentificadorE`)
        ON UPDATE CASCADE ON DELETE SET NULL
);

CREATE TABLE Profesor (
    `IdentificadorP` INTEGER(10) NOT NULL,
    `IdentificadorE` VARCHAR(100) DEFAULT NULL,
    PRIMARY KEY (`IdentificadorP`),
INDEX Profesor_FKIndex9 (`IdentificadorE`),
    FOREIGN KEY (`IdentificadorE`)
        REFERENCES Empleado (`IdentificadorE`)
        ON UPDATE CASCADE ON DELETE SET NULL
);
CREATE TABLE TicketIncidencia (
    `CodigoT` INTEGER(10) NOT NULL,
    `Fecha` VARCHAR(100) DEFAULT NULL,
 `Descripcion` VARCHAR(100) DEFAULT NULL,
 `Elemento` VARCHAR(100) DEFAULT NULL,
 `Material` VARCHAR(100) DEFAULT NULL,
 `NivelUrgencia` VARCHAR(100) DEFAULT NULL,
 `Categoria` VARCHAR(100) DEFAULT NULL,
 `IdentificadorP` VARCHAR(100) DEFAULT NULL,
 `CodigoUbicacion` VARCHAR(100) DEFAULT NULL,
 `CodigoEstado` VARCHAR(100) DEFAULT NULL,
 `CodigoResolucion` VARCHAR(100) DEFAULT NULL,
 `IdentificadorU` VARCHAR(100) DEFAULT NULL,

    PRIMARY KEY (`CodigoT`),
INDEX TicketIncidencia_FKIndex10 (`IdentificadorP`),
    FOREIGN KEY (`IdentificadorP`)
        REFERENCES Profesor (`IdentificadorP`)
        ON UPDATE CASCADE ON DELETE SET RESTRICT,
INDEX TicketIncidencia_FKIndex11 (`CodigoUbicacion`),
    FOREIGN KEY (`CodigoUbicacion`)
        REFERENCES Ubicacion (`CodigoUbicacion`)
        ON UPDATE CASCADE ON DELETE SET RESTRICT,
INDEX TicketIncidencia_FKIndex12 (`CodigoEstado`),
    FOREIGN KEY (`CodigoEstado`)
        REFERENCES Estado (`CodigoEstado`)
        ON UPDATE CASCADE ON DELETE SET RESTRICT,
INDEX TicketIncidencia_FKIndex13 (`CodigoResolucion`),
    FOREIGN KEY (`CodigoResolucion`)
        REFERENCES Resolucion (`CodigoResolucion`)
        ON UPDATE CASCADE ON DELETE SET RESTRICT,
INDEX TicketIncidencia_FKIndex14 (`IdentificadorU`),
    FOREIGN KEY (`IdentificadorU`)
        REFERENCES Usuario (`IdentificadorU`)
        ON UPDATE CASCADE ON DELETE SET RESTRICT

);
CREATE TABLE Ubicacion (
    `CodigoUbicacion` INTEGER(10) NOT NULL,
    `Nombre` VARCHAR(100) DEFAULT NULL,
 `Descripcion` VARCHAR(100) DEFAULT NULL,
 `Ubicacion` VARCHAR(100) DEFAULT NULL,
 `Planta` VARCHAR(100) DEFAULT NULL,
    
    PRIMARY KEY (`CodigoUbicacion`)
);
CREATE TABLE Estado (
    `CodigoEstado` INTEGER(10) NOT NULL,
    `Estado` VARCHAR(100) DEFAULT NULL,
    PRIMARY KEY (`CodigoEstado`)
);
CREATE TABLE Resolucion (
    `CodigoResolucion` INTEGER(10) NOT NULL,
    `FechaResolucion` VARCHAR(100) DEFAULT NULL,
 `Observaciones` VARCHAR(100) DEFAULT NULL,
    PRIMARY KEY (`CodigoResolucion`)
);
CREATE TABLE Tecnico (
      `IdentificadorT` INTEGER(10) NOT NULL,
    `IdentificadorE` VARCHAR(100) DEFAULT NULL,
    PRIMARY KEY (`IdentificadorT`),
INDEX Tecnico_FKIndex15 (`IdentificadorE`),
    FOREIGN KEY (`IdentificadorE`)
        REFERENCES Empleado (`IdentificadorE`)
        ON UPDATE CASCADE ON DELETE SET NULL
);
CREATE TABLE Mensaje (
     `CodigoMensaje` INTEGER(10) NOT NULL,
    `Asunto` VARCHAR(100) DEFAULT NULL,
`Cuerpo` VARCHAR(100) DEFAULT NULL,
`Fecha` VARCHAR(100) DEFAULT NULL,
`EnviadoPor` VARCHAR(100) DEFAULT NULL,
`RecibidoPor` VARCHAR(100) DEFAULT NULL,
    PRIMARY KEY (`CodigoMensaje`),
INDEX Mensaje_FKIndex16 (`EnviadoPor`),
    FOREIGN KEY (`EnviadoPor`)
        REFERENCES Tecnico (`IdentificadorT`)
        ON UPDATE CASCADE ON DELETE RESTRICT,
INDEX Mensaje_FKIndex17 (`RecibidoPor`),
    FOREIGN KEY (`RecibidoPor`)
        REFERENCES Profesor (`IdentificadorP`)
        ON UPDATE CASCADE ON DELETE RESTRICT,
);
CREATE TABLE Recibir (
    
);
CREATE TABLE Enviar (
    
);
   
   
   
   
   
   
