-- MySQL dump 10.13  Distrib 5.6.24, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: bdcine
-- ------------------------------------------------------
-- Server version	5.6.26-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `cartelera`
--

DROP TABLE IF EXISTS `cartelera`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cartelera` (
  `idCartelera` int(11) NOT NULL AUTO_INCREMENT,
  `nomCartelera` varchar(45) DEFAULT NULL,
  `idLocal` int(11) NOT NULL,
  PRIMARY KEY (`idCartelera`),
  KEY `fk_Cartelera_Local1_idx` (`idLocal`),
  CONSTRAINT `fk_Cartelera_Local1` FOREIGN KEY (`idLocal`) REFERENCES `local` (`idLocal`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cartelera`
--

LOCK TABLES `cartelera` WRITE;
/*!40000 ALTER TABLE `cartelera` DISABLE KEYS */;
INSERT INTO `cartelera` VALUES (1,'Tour de Cine Frances',1),(2,'Tour de Cine Frances',2),(3,'Tour de Cine Frances',3),(4,'Accion y Emocion',1),(5,'Accion y Emocion',2),(6,'Accion y Emocion',3),(7,'Infantil',1),(8,'Infantil',2),(9,'Infantil',3),(10,'Terror',1),(11,'Terror',2),(12,'Terror',3),(13,'Estreno',1),(14,'Estreno',2),(15,'Estreno',3),(16,'Comedia',1),(17,'Comedia',2),(18,'Comedia',3);
/*!40000 ALTER TABLE `cartelera` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cliente` (
  `idCliente` int(11) NOT NULL AUTO_INCREMENT,
  `dni` varchar(8) DEFAULT NULL,
  `nomCompleto` varchar(100) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `telFijo` varchar(7) DEFAULT NULL,
  `telMovil` varchar(9) DEFAULT NULL,
  PRIMARY KEY (`idCliente`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` VALUES (3,'46980417','Froilan Cerna','froilan1512@hotmail.com','7654321','987654321'),(4,'46980418','Gianfranco Egusquiza','eguzvia@gmail.com','7654321','987654321');
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `detallecartelera`
--

DROP TABLE IF EXISTS `detallecartelera`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `detallecartelera` (
  `idDetalle` int(11) NOT NULL AUTO_INCREMENT,
  `idCartelera` int(11) NOT NULL,
  `idPelicula` int(11) NOT NULL,
  `fecInicio` date DEFAULT NULL,
  `horaInicio` time DEFAULT NULL,
  `fecFin` date DEFAULT NULL,
  `horaFin` time DEFAULT NULL,
  `precio` double DEFAULT NULL,
  `estado` varchar(20) DEFAULT NULL,
  `idSala` int(11) NOT NULL,
  PRIMARY KEY (`idDetalle`,`idCartelera`,`idPelicula`,`idSala`),
  KEY `fk_Cartelera_has_Pelicula_Pelicula1_idx` (`idPelicula`),
  KEY `fk_Cartelera_has_Pelicula_Cartelera1_idx` (`idCartelera`),
  KEY `fk_DetalleCartelera_Sala1_idx` (`idSala`),
  CONSTRAINT `fk_Cartelera_has_Pelicula_Cartelera1` FOREIGN KEY (`idCartelera`) REFERENCES `cartelera` (`idCartelera`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Cartelera_has_Pelicula_Pelicula1` FOREIGN KEY (`idPelicula`) REFERENCES `pelicula` (`idPelicula`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_DetalleCartelera_Sala1` FOREIGN KEY (`idSala`) REFERENCES `sala` (`idSala`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=101 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `detallecartelera`
--

LOCK TABLES `detallecartelera` WRITE;
/*!40000 ALTER TABLE `detallecartelera` DISABLE KEYS */;
INSERT INTO `detallecartelera` VALUES (1,1,1,'2016-07-03','17:00:00','2016-07-10','19:00:00',13,NULL,1),(2,1,2,'2016-07-04','17:00:00','2016-07-11','19:00:00',13,NULL,2),(3,1,3,'2016-07-05','17:00:00','2016-07-12','19:00:00',13,NULL,3),(4,1,4,'2016-07-06','17:00:00','2016-07-13','19:00:00',13,NULL,4),(5,1,5,'2016-07-07','17:00:00','2016-07-14','19:00:00',13,NULL,5),(6,1,6,'2016-07-08','17:00:00','2016-07-15','19:00:00',13,NULL,6),(7,1,7,'2016-07-09','17:00:00','2016-07-16','19:00:00',13,NULL,7),(8,2,1,'2016-07-03','17:00:00','2016-07-10','19:00:00',12,NULL,1),(9,2,2,'2016-07-04','17:00:00','2016-07-11','19:00:00',12,NULL,2),(10,2,3,'2016-07-05','17:00:00','2016-07-12','19:00:00',12,NULL,3),(11,2,4,'2016-07-06','17:00:00','2016-07-13','19:00:00',12,NULL,4),(12,2,5,'2016-07-07','17:00:00','2016-07-14','19:00:00',12,NULL,5),(13,2,6,'2016-07-08','17:00:00','2016-07-15','19:00:00',12,NULL,6),(14,2,7,'2016-07-09','17:00:00','2016-07-16','19:00:00',12,NULL,7),(15,3,1,'2016-07-03','17:00:00','2016-07-10','19:00:00',15,NULL,1),(16,3,2,'2016-07-04','17:00:00','2016-07-11','19:00:00',15,NULL,2),(17,3,3,'2016-07-05','17:00:00','2016-07-12','19:00:00',15,NULL,3),(18,3,4,'2016-07-06','17:00:00','2016-07-13','19:00:00',15,NULL,4),(19,3,5,'2016-07-07','17:00:00','2016-07-14','19:00:00',15,NULL,5),(20,3,6,'2016-07-08','17:00:00','2016-07-15','19:00:00',15,NULL,6),(21,3,7,'2016-07-09','17:00:00','2016-07-16','19:00:00',15,NULL,7),(22,4,8,'2016-07-01','19:00:00','2016-07-31','21:00:00',16,NULL,1),(23,4,9,'2016-07-01','19:00:00','2016-07-31','21:00:00',16,NULL,2),(24,4,10,'2016-07-01','19:00:00','2016-07-31','21:00:00',16,NULL,3),(25,4,11,'2016-07-01','19:00:00','2016-07-31','21:00:00',16,NULL,4),(26,4,12,'2016-07-01','19:00:00','2016-07-31','21:00:00',16,NULL,5),(27,4,13,'2016-07-01','19:00:00','2016-07-31','21:00:00',16,NULL,6),(28,4,14,'2016-07-01','19:00:00','2016-07-31','21:00:00',16,NULL,7),(29,4,15,'2016-07-01','19:00:00','2016-07-31','21:00:00',16,NULL,8),(30,4,16,'2016-07-01','19:00:00','2016-07-31','21:00:00',16,NULL,9),(31,4,17,'2016-07-01','19:00:00','2016-07-31','21:00:00',16,NULL,10),(32,4,18,'2016-07-01','19:00:00','2016-07-31','21:00:00',16,NULL,11),(33,4,19,'2016-07-01','19:00:00','2016-07-31','21:00:00',16,NULL,12),(34,4,20,'2016-07-01','19:00:00','2016-07-31','21:00:00',16,NULL,13),(35,4,21,'2016-07-01','19:00:00','2016-07-31','21:00:00',16,NULL,14),(36,5,8,'2016-07-01','19:00:00','2016-07-31','21:00:00',15,NULL,1),(37,5,9,'2016-07-01','19:00:00','2016-07-31','21:00:00',15,NULL,2),(38,5,10,'2016-07-01','19:00:00','2016-07-31','21:00:00',15,NULL,3),(39,5,11,'2016-07-01','19:00:00','2016-07-31','21:00:00',15,NULL,4),(40,5,12,'2016-07-01','19:00:00','2016-07-31','21:00:00',15,NULL,5),(41,5,13,'2016-07-01','19:00:00','2016-07-31','21:00:00',15,NULL,6),(42,5,14,'2016-07-01','19:00:00','2016-07-31','21:00:00',15,NULL,7),(43,5,15,'2016-07-01','19:00:00','2016-07-31','21:00:00',15,NULL,8),(44,5,16,'2016-07-01','19:00:00','2016-07-31','21:00:00',15,NULL,9),(45,5,17,'2016-07-01','19:00:00','2016-07-31','21:00:00',15,NULL,10),(46,5,18,'2016-07-01','19:00:00','2016-07-31','21:00:00',15,NULL,11),(47,5,19,'2016-07-01','19:00:00','2016-07-31','21:00:00',15,NULL,12),(48,5,20,'2016-07-01','19:00:00','2016-07-31','21:00:00',15,NULL,13),(49,5,21,'2016-07-01','19:00:00','2016-07-31','21:00:00',15,NULL,14),(50,6,8,'2016-07-01','19:00:00','2016-07-31','21:00:00',18,NULL,1),(51,6,9,'2016-07-01','19:00:00','2016-07-31','21:00:00',18,NULL,2),(52,6,10,'2016-07-01','19:00:00','2016-07-31','21:00:00',18,NULL,3),(53,6,11,'2016-07-01','19:00:00','2016-07-31','21:00:00',18,NULL,4),(54,6,12,'2016-07-01','19:00:00','2016-07-31','21:00:00',18,NULL,5),(55,6,13,'2016-07-01','19:00:00','2016-07-31','21:00:00',18,NULL,6),(56,6,14,'2016-07-01','19:00:00','2016-07-31','21:00:00',18,NULL,7),(57,6,15,'2016-07-01','19:00:00','2016-07-31','21:00:00',18,NULL,8),(58,6,16,'2016-07-01','19:00:00','2016-07-31','21:00:00',18,NULL,9),(59,6,17,'2016-07-01','19:00:00','2016-07-31','21:00:00',18,NULL,10),(60,6,18,'2016-07-01','19:00:00','2016-07-31','21:00:00',18,NULL,11),(61,6,19,'2016-07-01','19:00:00','2016-07-31','21:00:00',18,NULL,12),(62,6,20,'2016-07-01','19:00:00','2016-07-31','21:00:00',18,NULL,13),(63,6,21,'2016-07-01','19:00:00','2016-07-31','21:00:00',18,NULL,14),(64,7,32,'2016-07-01','15:00:00','2016-07-31','17:00:00',13,NULL,1),(65,7,33,'2016-07-01','15:00:00','2016-07-31','17:00:00',13,NULL,2),(66,7,34,'2016-07-01','15:00:00','2016-07-31','17:00:00',13,NULL,3),(67,7,35,'2016-07-01','15:00:00','2016-07-31','17:00:00',13,NULL,4),(68,7,36,'2016-07-01','15:00:00','2016-07-31','17:00:00',13,NULL,5),(69,7,37,'2016-07-01','15:00:00','2016-07-31','17:00:00',13,NULL,6),(70,7,38,'2016-07-01','15:00:00','2016-07-31','17:00:00',13,NULL,7),(71,8,32,'2016-07-01','15:00:00','2016-07-31','17:00:00',12,NULL,1),(72,8,33,'2016-07-01','15:00:00','2016-07-31','17:00:00',12,NULL,2),(73,8,34,'2016-07-01','15:00:00','2016-07-31','17:00:00',12,NULL,3),(74,8,35,'2016-07-01','15:00:00','2016-07-31','17:00:00',12,NULL,4),(75,8,36,'2016-07-01','15:00:00','2016-07-31','17:00:00',12,NULL,5),(76,9,32,'2016-07-01','15:00:00','2016-07-31','17:00:00',15,NULL,1),(77,9,33,'2016-07-01','15:00:00','2016-07-31','17:00:00',15,NULL,2),(78,9,34,'2016-07-01','15:00:00','2016-07-31','17:00:00',15,NULL,3),(79,9,35,'2016-07-01','15:00:00','2016-07-31','17:00:00',15,NULL,4),(80,9,36,'2016-07-01','15:00:00','2016-07-31','17:00:00',15,NULL,5),(81,10,26,'2016-07-01','23:00:00','2016-07-31','01:00:00',14,NULL,1),(82,10,27,'2016-07-01','23:00:00','2016-07-31','01:00:00',14,NULL,2),(83,10,28,'2016-07-01','23:00:00','2016-07-31','01:00:00',14,NULL,3),(84,10,29,'2016-07-01','23:00:00','2016-07-31','01:00:00',14,NULL,4),(85,10,30,'2016-07-01','23:00:00','2016-07-31','01:00:00',14,NULL,5),(86,10,31,'2016-07-01','23:00:00','2016-07-31','01:00:00',14,NULL,6),(87,11,27,'2016-07-01','23:00:00','2016-07-31','01:00:00',13,NULL,1),(88,11,28,'2016-07-01','23:00:00','2016-07-31','01:00:00',13,NULL,2),(89,11,29,'2016-07-01','23:00:00','2016-07-31','01:00:00',13,NULL,3),(90,12,27,'2016-07-01','23:00:00','2016-07-31','01:00:00',16,NULL,1),(91,12,28,'2016-07-01','23:00:00','2016-07-31','01:00:00',16,NULL,2),(92,12,29,'2016-07-01','23:00:00','2016-07-31','01:00:00',16,NULL,3),(93,16,22,'2016-07-01','21:00:00','2016-07-31','23:00:00',15,NULL,1),(94,16,23,'2016-07-01','21:00:00','2016-07-31','23:00:00',15,NULL,2),(95,16,24,'2016-07-08','21:00:00','2016-07-31','23:00:00',15,NULL,3),(96,16,25,'2016-07-08','21:00:00','2016-07-31','23:00:00',15,NULL,4),(97,17,22,'2016-07-08','21:00:00','2016-07-31','23:00:00',14,NULL,1),(98,17,23,'2016-07-08','21:00:00','2016-07-31','23:00:00',14,NULL,2),(99,18,22,'2016-07-01','21:00:00','2016-07-31','23:00:00',17,NULL,1),(100,18,23,'2016-07-01','21:00:00','2016-07-31','23:00:00',17,NULL,2);
/*!40000 ALTER TABLE `detallecartelera` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `local`
--

DROP TABLE IF EXISTS `local`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `local` (
  `idLocal` int(11) NOT NULL AUTO_INCREMENT,
  `nomLocal` varchar(45) DEFAULT NULL,
  `dirLocal` varchar(100) DEFAULT NULL,
  `ubiLocal` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idLocal`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `local`
--

LOCK TABLES `local` WRITE;
/*!40000 ALTER TABLE `local` DISABLE KEYS */;
INSERT INTO `local` VALUES (1,'MEGAPLAZA','MEGAPLAZA','INDEPENDENCIA'),(2,'PRO','REAL PLAZA PRO','LOS OLIVOS'),(3,'PLAZA SAN MIGUEL','LA MARINA','SAN MIGUEL');
/*!40000 ALTER TABLE `local` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pelicula`
--

DROP TABLE IF EXISTS `pelicula`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pelicula` (
  `idPelicula` int(11) NOT NULL AUTO_INCREMENT,
  `nomPelicula` varchar(100) DEFAULT NULL,
  `tipo` varchar(45) DEFAULT NULL,
  `fecEstreno` date DEFAULT NULL,
  PRIMARY KEY (`idPelicula`)
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pelicula`
--

LOCK TABLES `pelicula` WRITE;
/*!40000 ALTER TABLE `pelicula` DISABLE KEYS */;
INSERT INTO `pelicula` VALUES (1,'MI HISTORIA ENTRE TUS DEDOS/EL REGRESO DEL VAMPIRO','Cine Frances','2013-09-06'),(2,'RENOIR ¿QUE ES LA GUERRA?','Cine Frances','2013-09-06'),(3,'CAMILLE REGRESA','Cine Frances','2013-09-06'),(4,'LOS SABORES DEL PALACIO','Cine Frances','2013-09-06'),(5,'PASEANDO CON MOLIERE','Cine Frances','2013-09-06'),(6,'EN LA CASA','Cine Frances','2013-09-06'),(7,'EL LOBO SEDUCTOR/TRAS DE TI','Cine Frances','2013-09-06'),(8,'LOS INDESTRUCTIBLES','Accion y Emocion','2010-09-09'),(9,'LOS INDESTRUCTIBLES II','Accion y Emocion','2012-08-23'),(10,'LOS INDESTRUCTIBLES III','Accion y Emocion','2014-08-13'),(11,'PIRATAS DEL CARIBE: LA MALDICION DE LA PERLA NEGRA','Accion y Emocion','2003-07-09'),(12,'PIRATAS DEL CARIBE: EL COFRE DEL HOMBRE MUERTO','Accion y Emocion','2006-07-07'),(13,'PIRATAS DEL CARIBE: EN EL FIN DEL MUNDO','Accion y Emocion','2008-05-25'),(14,'PIRATAS DEL CARIBE: EN MAREAS MISTERIOSAS','Accion y Emocion','2011-05-20'),(15,'TRANSFORMERS: LA PELICULA','Accion y Emocion','2007-07-19'),(16,'TRANSFORMERS: LA VENGANZA DE LOS CAIDOS','Accion y Emocion','2009-06-24'),(17,'TRANSFORMERS: EL LADO OSCURO DE LA LUNA','Accion y Emocion','2011-06-29'),(18,'TRANSFORMERS: LA ERA DE LA EXTINCION','Accion y Emocion','2014-07-10'),(19,'MACHETE','Accion y Emocion','2010-09-03'),(20,'MACHETE KILLS','Accion y Emocion','2013-09-20'),(21,'CAZADORES DE SOMBRAS: CIUDAD DE HUESO','Accion y Emocion','2013-08-22'),(22,'ESPEJITO ESPEJITO','Comedia','2013-03-23'),(23,'PEQUEÑO PERO PELIGROSO','Comedia','2004-06-23'),(24,'¿DONDE ESTAN LAS RUBIAS?','Comedia','2006-07-13'),(25,'SCARY MOVIE 3','Comedia','2003-10-20'),(26,'CHUCKY: MUÑECO DIABOLICO','Terror','1988-11-09'),(27,'EL EXORCISMO DE EMILY ROSE','Terror','2005-09-09'),(28,'EL ARO','Terror','2002-10-18'),(29,'RATAS ASESINAS','Terror','2002-10-17'),(30,'LEPRECHAUN','Terror','1993-01-08'),(31,'LEPRECHAUN 2','Terror','1994-04-08'),(32,'LILO Y STICH','Infantil','2002-06-21'),(33,'LILO Y STICH 2','Infantil','2005-08-30'),(34,'EL VIAJE DE CHIHIRO','Infantil','2003-08-13'),(35,'TIMKERBELL','Infantil','2013-08-16'),(36,'FROZEN','Infantil','2013-12-25'),(37,'6 GRANDES HEROES','Infantil','2014-12-25'),(38,'UN GRAN DINOSAURIO','Infantil','2015-11-25');
/*!40000 ALTER TABLE `pelicula` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reserva`
--

DROP TABLE IF EXISTS `reserva`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `reserva` (
  `idReserva` int(11) NOT NULL AUTO_INCREMENT,
  `idCliente` int(11) NOT NULL,
  `idDetalle` int(11) DEFAULT NULL,
  `estado` varchar(20) DEFAULT NULL,
  `fecReserva` date DEFAULT NULL,
  PRIMARY KEY (`idReserva`),
  KEY `fk_Reserva_Cliente1_idx` (`idCliente`),
  KEY `fk_Reserva_DetalleCartelera_idx` (`idDetalle`),
  CONSTRAINT `fk_Reserva_Cliente1` FOREIGN KEY (`idCliente`) REFERENCES `cliente` (`idCliente`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Reserva_DetalleCartelera` FOREIGN KEY (`idDetalle`) REFERENCES `detallecartelera` (`idDetalle`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reserva`
--

LOCK TABLES `reserva` WRITE;
/*!40000 ALTER TABLE `reserva` DISABLE KEYS */;
INSERT INTO `reserva` VALUES (3,3,1,'CONFIRMADO','2016-07-05'),(4,3,2,'CONFIRMADO','2016-07-05'),(5,3,2,'CONFIRMADO','2016-07-05'),(6,3,2,'RESERVADO','2016-07-08'),(7,4,24,'CONFIRMADO','2016-07-05');
/*!40000 ALTER TABLE `reserva` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sala`
--

DROP TABLE IF EXISTS `sala`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sala` (
  `idSala` int(11) NOT NULL AUTO_INCREMENT,
  `numSala` varchar(3) DEFAULT NULL,
  PRIMARY KEY (`idSala`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sala`
--

LOCK TABLES `sala` WRITE;
/*!40000 ALTER TABLE `sala` DISABLE KEYS */;
INSERT INTO `sala` VALUES (1,'1'),(2,'2'),(3,'3'),(4,'4'),(5,'5'),(6,'6'),(7,'7'),(8,'8'),(9,'9'),(10,'10'),(11,'11'),(12,'12'),(13,'13'),(14,'14'),(15,'15');
/*!40000 ALTER TABLE `sala` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-07-11 15:26:29
