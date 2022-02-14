-- MySQL dump 10.13  Distrib 8.0.27, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: cuoikhoa
-- ------------------------------------------------------
-- Server version	8.0.27

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `hoc_vien`
--

DROP TABLE IF EXISTS `hoc_vien`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hoc_vien` (
  `hoc_vien_id` int NOT NULL AUTO_INCREMENT,
  `email` varchar(40) DEFAULT NULL,
  `hinh_anh` varchar(255) DEFAULT NULL,
  `ho_ten` varchar(50) DEFAULT NULL,
  `ngay_sinh` date DEFAULT NULL,
  `phuong_xa` varchar(50) DEFAULT NULL,
  `quan_huyen` varchar(50) DEFAULT NULL,
  `so_dien_thoai` varchar(11) DEFAULT NULL,
  `so_nha` varchar(50) DEFAULT NULL,
  `tinh_thanh` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`hoc_vien_id`),
  UNIQUE KEY `UK_fhan3nsv002ytybkqsfs0f1p1` (`email`),
  UNIQUE KEY `UK_mhavd5hbe1n7fc735ris7kxfn` (`so_dien_thoai`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hoc_vien`
--

LOCK TABLES `hoc_vien` WRITE;
/*!40000 ALTER TABLE `hoc_vien` DISABLE KEYS */;
INSERT INTO `hoc_vien` VALUES (1,'abc1@gmail.com','img/anh1','Kim','2000-11-11','Châu Khê','Từ Sơn','012345660','1','Bắc Ninh'),(2,'abc2@gmail.com','img/anh2','Lee','2000-11-11','Châu Khê','Từ Sơn','012345661','1','Bắc Ninh'),(3,'abc3@gmail.com','img/anh3','Naruto','2000-11-11','Châu Khê','Từ Sơn','012345662','1','Bắc Ninh'),(4,'abc4@gmail.com','img/anh4','Sasuke','2000-11-11','Châu Khê','Từ Sơn','012345663','1','Bắc Ninh');
/*!40000 ALTER TABLE `hoc_vien` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-02-14 13:19:49
