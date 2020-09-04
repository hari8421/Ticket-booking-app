-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: train_db
-- ------------------------------------------------------
-- Server version	5.7.28-log

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
-- Table structure for table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hibernate_sequence`
--

LOCK TABLES `hibernate_sequence` WRITE;
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` VALUES (55),(55),(55),(55);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `route_dtl`
--

DROP TABLE IF EXISTS `route_dtl`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `route_dtl` (
  `route_dtl_id` bigint(20) NOT NULL,
  `route_id` varchar(5) DEFAULT NULL,
  `train_id` bigint(20) DEFAULT NULL,
  `fare` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`route_dtl_id`),
  KEY `FK4840lk8a8ado5c67g9iebqpio` (`route_id`),
  KEY `FK2gbgjq1mvoys2ppeg9tdv4doc` (`train_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `route_dtl`
--

LOCK TABLES `route_dtl` WRITE;
/*!40000 ALTER TABLE `route_dtl` DISABLE KEYS */;
INSERT INTO `route_dtl` VALUES (50,'103',14,'290'),(49,'103',13,'280'),(51,'103',14,'290'),(52,'103',13,'290'),(54,'104',13,'200');
/*!40000 ALTER TABLE `route_dtl` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `route_hdr`
--

DROP TABLE IF EXISTS `route_hdr`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `route_hdr` (
  `route_id` varchar(5) NOT NULL,
  `end_station` varchar(255) DEFAULT NULL,
  `start_station` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`route_id`),
  KEY `FKdalw9c4yawv9fr2h8673pejyq` (`end_station`),
  KEY `FKtla6kq8u389ggr8l7p11tdj8h` (`start_station`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `route_hdr`
--

LOCK TABLES `route_hdr` WRITE;
/*!40000 ALTER TABLE `route_hdr` DISABLE KEYS */;
INSERT INTO `route_hdr` VALUES ('102','ALP','EKP'),('103','EKM','TVM'),('104','EKM','TVM');
/*!40000 ALTER TABLE `route_hdr` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `route_seq`
--

DROP TABLE IF EXISTS `route_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `route_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `route_seq`
--

LOCK TABLES `route_seq` WRITE;
/*!40000 ALTER TABLE `route_seq` DISABLE KEYS */;
INSERT INTO `route_seq` VALUES (54);
/*!40000 ALTER TABLE `route_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `route_sequence`
--

DROP TABLE IF EXISTS `route_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `route_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `route_sequence`
--

LOCK TABLES `route_sequence` WRITE;
/*!40000 ALTER TABLE `route_sequence` DISABLE KEYS */;
INSERT INTO `route_sequence` VALUES (105);
/*!40000 ALTER TABLE `route_sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `station_dtl`
--

DROP TABLE IF EXISTS `station_dtl`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `station_dtl` (
  `station_id` bigint(20) NOT NULL,
  `station_code` varchar(255) DEFAULT NULL,
  `station_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`station_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `station_dtl`
--

LOCK TABLES `station_dtl` WRITE;
/*!40000 ALTER TABLE `station_dtl` DISABLE KEYS */;
INSERT INTO `station_dtl` VALUES (3,'101','TVM'),(4,'102','EKM');
/*!40000 ALTER TABLE `station_dtl` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `train_dtl`
--

DROP TABLE IF EXISTS `train_dtl`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `train_dtl` (
  `train_id` bigint(20) NOT NULL,
  `arrival` varchar(255) DEFAULT NULL,
  `departure` varchar(255) DEFAULT NULL,
  `train_code` varchar(255) DEFAULT NULL,
  `train_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`train_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `train_dtl`
--

LOCK TABLES `train_dtl` WRITE;
/*!40000 ALTER TABLE `train_dtl` DISABLE KEYS */;
INSERT INTO `train_dtl` VALUES (1,'10:30','12:00','1234','Jan Shathabdi'),(2,'10:30','12:00','1234','Jan Shathabdi2'),(13,'10:30','12:00','101','Jana'),(53,'10:30','12:30','101','Jana shathabdi');
/*!40000 ALTER TABLE `train_dtl` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-09-04 22:17:50
