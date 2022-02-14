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
-- Table structure for table `dang_ky_hoc`
--

DROP TABLE IF EXISTS `dang_ky_hoc`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `dang_ky_hoc` (
  `dang_ky_hoc_id` int NOT NULL AUTO_INCREMENT,
  `ngay_bat_dau` date DEFAULT NULL,
  `ngay_dang_ky` date DEFAULT NULL,
  `ngay_ket_thuc` date DEFAULT NULL,
  `hoc_vien_id` int DEFAULT NULL,
  `khoa_hoc_id` int DEFAULT NULL,
  `tai_khoan_id` int DEFAULT NULL,
  `tinh_trang_hoc_id` int DEFAULT NULL,
  PRIMARY KEY (`dang_ky_hoc_id`),
  KEY `FKksb2koib7asnphftr3w6kdi5p` (`hoc_vien_id`),
  KEY `FK1h6nhohjcida8jyop7aep0cjx` (`khoa_hoc_id`),
  KEY `FK43wa2kw4m70bc6i9gq2alcuw2` (`tai_khoan_id`),
  KEY `FKlidyj2sk04f5xx6562na901q0` (`tinh_trang_hoc_id`),
  CONSTRAINT `FK1h6nhohjcida8jyop7aep0cjx` FOREIGN KEY (`khoa_hoc_id`) REFERENCES `khoa_hoc` (`khoa_hoc_id`),
  CONSTRAINT `FK43wa2kw4m70bc6i9gq2alcuw2` FOREIGN KEY (`tai_khoan_id`) REFERENCES `tai_khoan` (`tai_khoan_id`),
  CONSTRAINT `FKksb2koib7asnphftr3w6kdi5p` FOREIGN KEY (`hoc_vien_id`) REFERENCES `hoc_vien` (`hoc_vien_id`),
  CONSTRAINT `FKlidyj2sk04f5xx6562na901q0` FOREIGN KEY (`tinh_trang_hoc_id`) REFERENCES `tinh_trang_hoc` (`tinh_trang_hoc_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dang_ky_hoc`
--

LOCK TABLES `dang_ky_hoc` WRITE;
/*!40000 ALTER TABLE `dang_ky_hoc` DISABLE KEYS */;
INSERT INTO `dang_ky_hoc` VALUES (1,'2018-01-02','2018-01-01','2018-03-02',1,1,1,1),(2,'2018-01-02','2018-01-01','2018-03-02',2,2,2,2),(3,NULL,'2018-01-01',NULL,3,3,NULL,NULL),(4,'2018-01-02','2018-01-01','2018-03-02',4,4,2,NULL);
/*!40000 ALTER TABLE `dang_ky_hoc` ENABLE KEYS */;
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
