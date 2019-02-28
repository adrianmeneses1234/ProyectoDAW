CREATE TABLE `m_ENTIDAD` (
    `cod` INT(11) NOT NULL,
    `domicilio` VARCHAR(45) DEFAULT NULL,
    PRIMARY KEY (`cod`)
    
);

CREATE TABLE `m_VIGILANTES` (
    `cod` INT(11) NOT NULL,
    `nombre` VARCHAR(45) DEFAULT NULL,
    `fecnac` DATE DEFAULT NULL,
    PRIMARY KEY (`cod`)
    
);

CREATE TABLE `m_SUCURSAL` (
  `cod+entidad` INT(11) NOT NULL,
  `domicilio` VARCHAR(45) DEFAULT NULL,
  `cod` INT(11) NOT NULL,
  `cod_vigilantes` INT(11) NOT NULL,
  PRIMARY KEY (`cod+entidad`),
  INDEX m_SUCURSAL_FKIndex1(`cod`),
   FOREIGN KEY(`cod`)
      REFERENCES m_ENTIDAD(`cod`)
         ON UPDATE CASCADE
         ON DELETE CASCADE,
   INDEX m_SUCURSAL_FKIndex2(`cod_vigilantes`),
   FOREIGN KEY(`cod_vigilantes`)
      REFERENCES m_VIGILANTES(`cod`)
         ON UPDATE CASCADE
         ON DELETE CASCADE
         
);

CREATE TABLE `m_PERSONA` (
    `clave` INT(11) NOT NULL,
    `DNI` VARCHAR(9) DEFAULT NULL,
    `nombre` VARCHAR(15) DEFAULT NULL,
    `num` INT(11) NOT NULL,
    `cod` INT(11) NOT NULL,
    PRIMARY KEY (`clave`)
);

CREATE TABLE `m_ATRACO` (
    `cod` INT(11) NOT NULL,
    `dinero` DOUBLE DEFAULT NULL,
    `fecha` DATE DEFAULT NULL,
    `numvictimas` INT(11) DEFAULT NULL,
    `tipoarma` VARCHAR(100) DEFAULT NULL,
    `cod+entidad` int(11) NOT NULL,
    `clave` INT(11) NOT NULL,
    PRIMARY KEY (`cod`),
    INDEX m_ATRACO_FKIndex3(`cod+entidad`),
   FOREIGN KEY(`cod+entidad`)
      REFERENCES `m_SUCURSAL`(`cod+entidad`)
         ON UPDATE CASCADE
         ON DELETE CASCADE,
	INDEX m_ATRACO_FKIndex4(`clave`),
         FOREIGN KEY(`clave`)
      REFERENCES `m_PERSONA`(`clave`)
         ON UPDATE CASCADE
         ON DELETE CASCADE
    
    
    
);

CREATE TABLE `m_BANDAS` (
    `num` INT(11) NOT NULL AUTO_INCREMENT,
    `nombre` VARCHAR(15) DEFAULT NULL,
    PRIMARY KEY (`num`)
    
);

CREATE TABLE `m_JUECES` (
    `clave` INT(11) NOT NULL,
    `nombre` VARCHAR(45) DEFAULT NULL,
    `años_servicio` INT(11) DEFAULT NULL,
    PRIMARY KEY (`clave`)
);

CREATE TABLE `m_PRINCIPAL` (
    `director` VARCHAR(20) DEFAULT NULL,
    `numempl` INT(11) DEFAULT NULL,
    `cod+entidad` INT(11) NOT NULL,
    PRIMARY KEY (`cod+entidad`),
    INDEX m_PRINCIPAL_FKIndex5(`cod+entidad`),
    FOREIGN KEY (`cod+entidad`)
        REFERENCES `m_SUCURSAL` (`cod+entidad`)
        ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE `m_SECUNDARIA` (
    `cod+entidad` INT(11) NOT NULL,
    PRIMARY KEY (`cod+entidad`),
    INDEX m_SECUNDARIA_FKIndex6(`cod+entidad`),
    FOREIGN KEY (`cod+entidad`)
        REFERENCES `m_SUCURSAL` (`cod+entidad`)
        ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE `m_POSEER` (
    `cod+entidad` INT(11) NOT NULL,
    `cod` INT(11) NOT NULL,
    PRIMARY KEY (`cod+entidad` , `cod`),
    INDEX m_POSEER_FKIndex7(`cod+entidad`),
    FOREIGN KEY (`cod+entidad`)
        REFERENCES `m_SUCURSAL` (`cod+entidad`)
        ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE `m_CONTRATAR` (
    `cod+entidad` INT(11) NOT NULL,
    `cod` INT(11) NOT NULL,
    `fin` DATE NOT NULL,
    `Ffin` DATE NOT NULL,
    `arma` VARCHAR(30) NOT NULL,
    PRIMARY KEY (`cod+entidad` , `cod`),
    INDEX m_CONTRATAR_FKIndex8(`cod+entidad`),
    FOREIGN KEY (`cod+entidad`)
        REFERENCES `m_SUCURSAL` (`cod+entidad`)
        ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE `m_DEPENDER` (
    `cod+entidad` INT(11) NOT NULL,
    
    PRIMARY KEY (`cod+entidad`),
    INDEX m_DEPENDER_FKIndex9(`cod+entidad`),
    FOREIGN KEY (`cod+entidad`)
        REFERENCES `m_SECUNDARIA` (`cod+entidad`)
        ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE `m_SUFRIR` (
  `cod+entidad` int(11) NOT NULL,
  `cod` INT(11) NOT NULL,
  PRIMARY KEY (`cod+entidad`,`cod`),
  INDEX m_SUFRIR_FKIndex10(`cod+entidad`),
  FOREIGN KEY(`cod+entidad`)
      REFERENCES `m_SUCURSAL`(`cod+entidad`)
         ON UPDATE CASCADE
         ON DELETE CASCADE

);

CREATE TABLE `m_PARTICIPAR` (
    `cod` INT(11) NOT NULL,
    `clave` INT(11) NOT NULL,
    `clave_jueces` INT(11) NOT NULL,
    PRIMARY KEY (`cod` , `clave`),
    INDEX m_PARTICIPAR_FKIndex11(`clave_jueces`),
    FOREIGN KEY (`clave_jueces`)
        REFERENCES `m_JUECES` (`clave`)
        ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE `m_PERTENECER` (
    `clave` INT(11) NOT NULL,
    `num` INT(11) NOT NULL,
    PRIMARY KEY (`clave` , `num`),
    INDEX m_PERTENECER_FKIndex12(`clave`),
    FOREIGN KEY (`clave`)
        REFERENCES `m_PERSONA` (`clave`)
        ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE `m_CABECILLA` (
    `clave` INT(11) NOT NULL,
    `num` INT(11) NOT NULL AUTO_INCREMENT,
    PRIMARY KEY (`clave` , `num`),
    INDEX m_CABECILLA_FKIndex13(`num`),
    FOREIGN KEY (`num`)
        REFERENCES `m_BANDAS` (`num`)
        ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE `m_JUZGAR` (
    `clave` INT(11) NOT NULL,
    `condenado` VARCHAR(20) NOT NULL,
    `tiempo-carcel` TIME NOT NULL,
    PRIMARY KEY (`clave`)
);

ALTER TABLE `m_InformacionPolicial`.`m_PERSONA` 
ADD CONSTRAINT `num`
  FOREIGN KEY (`num`)
  REFERENCES `m_InformacionPolicial`.`m_BANDAS` (`num`)
  ON DELETE CASCADE
  ON UPDATE CASCADE,
ADD CONSTRAINT `cod`
  FOREIGN KEY (`cod`)
  REFERENCES `m_InformacionPolicial`.`m_ATRACO` (`cod`)
  ON DELETE CASCADE
  ON UPDATE CASCADE;
  
  
  














































