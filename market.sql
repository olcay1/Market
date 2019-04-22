CREATE DATABASE  IF NOT EXISTS `market` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */;
USE `market`;
-- MySQL dump 10.13  Distrib 8.0.15, for Win64 (x86_64)
--
-- Host: localhost    Database: market
-- ------------------------------------------------------
-- Server version	8.0.15

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `musteri_urun`
--

DROP TABLE IF EXISTS `musteri_urun`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `musteri_urun` (
  `musteri_urun_id` int(11) NOT NULL AUTO_INCREMENT,
  `musteri_id` int(11) DEFAULT NULL,
  `urun_id` int(11) DEFAULT NULL,
  `urun_fiyat` decimal(4,2) DEFAULT NULL,
  `fis_no` int(11) DEFAULT NULL,
  PRIMARY KEY (`musteri_urun_id`),
  KEY `fk_musteri_urun` (`urun_id`),
  KEY `fk_musteri_urun_musteri` (`musteri_id`),
  CONSTRAINT `fk_musteri_urun` FOREIGN KEY (`urun_id`) REFERENCES `urunler` (`urun_id`),
  CONSTRAINT `fk_musteri_urun_musteri` FOREIGN KEY (`musteri_id`) REFERENCES `musteriler` (`musteri_id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `musteri_urun`
--

LOCK TABLES `musteri_urun` WRITE;
/*!40000 ALTER TABLE `musteri_urun` DISABLE KEYS */;
INSERT INTO `musteri_urun` VALUES (1,1,1,2.00,1),(2,1,2,2.00,2),(3,1,3,2.00,3),(4,2,1,3.00,1),(5,2,2,2.00,2),(6,3,4,1.00,1),(7,2,3,5.59,2000),(8,3,5,5.00,2000),(9,3,4,1.00,2000),(10,2,6,8.00,2000),(11,3,4,1.00,2000),(12,3,4,1.00,2000),(13,5,10,4.00,2000),(14,3,4,1.00,2000),(15,2,2,2.34,2000),(16,3,3,5.59,2000),(17,3,4,1.00,3),(18,2,1,2.00,1544),(19,2,3,5.59,1684);
/*!40000 ALTER TABLE `musteri_urun` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `musteriler`
--

DROP TABLE IF EXISTS `musteriler`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `musteriler` (
  `musteri_id` int(11) NOT NULL AUTO_INCREMENT,
  `isim` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`musteri_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `musteriler`
--

LOCK TABLES `musteriler` WRITE;
/*!40000 ALTER TABLE `musteriler` DISABLE KEYS */;
INSERT INTO `musteriler` VALUES (1,'Ali'),(2,'VELİ'),(3,'ahmet'),(4,'mehmet'),(5,'mahmut');
/*!40000 ALTER TABLE `musteriler` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `urunler`
--

DROP TABLE IF EXISTS `urunler`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `urunler` (
  `urun_id` int(11) NOT NULL AUTO_INCREMENT,
  `urun_ad` varchar(45) DEFAULT NULL,
  `urun_fiyat` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`urun_id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `urunler`
--

LOCK TABLES `urunler` WRITE;
/*!40000 ALTER TABLE `urunler` DISABLE KEYS */;
INSERT INTO `urunler` VALUES (1,'cola',2.00),(2,'ekmek',2.34),(3,'fanta',5.59),(4,'gofret',1.00),(5,'cikolata',5.00),(6,'cay',8.00),(7,'salca',10.55),(8,'alo',4.00),(9,'omo',2.00),(10,'pril',4.00),(11,'kahve',12.00),(12,'şeker',333.00);
/*!40000 ALTER TABLE `urunler` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-04-22 17:01:47
