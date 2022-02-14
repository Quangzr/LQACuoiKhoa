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
-- Table structure for table `khoa_hoc`
--

DROP TABLE IF EXISTS `khoa_hoc`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `khoa_hoc` (
  `khoa_hoc_id` int NOT NULL AUTO_INCREMENT,
  `gioi_thieu` varchar(255) NOT NULL,
  `hinh_anh` varchar(255) NOT NULL,
  `hoc_phi` double NOT NULL,
  `noi_dung` varchar(255) NOT NULL,
  `so_hoc_vien` int NOT NULL,
  `so_luong_mon` int NOT NULL,
  `ten_khoa_hoc` varchar(50) NOT NULL,
  `thoi_gian_hoc` int NOT NULL,
  `loai_khoa_hoc_id` int NOT NULL,
  PRIMARY KEY (`khoa_hoc_id`),
  KEY `FK2gcgk8bu05i8jayjdf9724adf` (`loai_khoa_hoc_id`),
  CONSTRAINT `FK2gcgk8bu05i8jayjdf9724adf` FOREIGN KEY (`loai_khoa_hoc_id`) REFERENCES `loai_khoa_hoc` (`loai_khoa_hoc_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `khoa_hoc`
--

LOCK TABLES `khoa_hoc` WRITE;
/*!40000 ALTER TABLE `khoa_hoc` DISABLE KEYS */;
INSERT INTO `khoa_hoc` VALUES (1,'Giới Thiệu','img/net.jpg',2000000,'Nội Dung',20,3,'.NET',2,1),(2,'Giới Thiệu','img/react.jpg',2000000,'Nội Dung',20,4,'ReactJS',2,2),(3,'Giới Thiệu','img/java.jpg',2000000,'Nội Dung',20,4,'JAVA',2,1),(4,'Giới Thiệu','img/vue.jpg',2000000,'Nội Dung',20,4,'VueJS',2,2);
/*!40000 ALTER TABLE `khoa_hoc` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-02-14 13:19:48
