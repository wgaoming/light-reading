-- MySQL dump 10.13  Distrib 5.7.18, for macos10.12 (x86_64)
--
-- Host: rm-m5e52b35wx8shto17mo.mysql.rds.aliyuncs.com    Database: reading_cloud_account
-- ------------------------------------------------------
-- Server version	8.0.16

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
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uuid` varchar(36) NOT NULL COMMENT '唯一ID',
  `user_pwd` varchar(100) NOT NULL COMMENT '密码',
  `login_name` varchar(20) NOT NULL COMMENT '登录名',
  `nick_name` varchar(20) NOT NULL COMMENT '中文名',
  `phone_number` varchar(20) DEFAULT NULL COMMENT '联系电话',
  `head_img_url` varchar(300) DEFAULT NULL,
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `index_login_name` (`login_name`),
  UNIQUE KEY `index_uuid` (`uuid`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'d67cab870dbc44ad9040888cbd015a24','1fc295bc42b8b218dd8e1218211b11dc','admin','admin','13800138000','http://reading.zealon.cn/default.jpg','2020-04-11 16:45:20','2020-04-11 16:45:20'),(2,'0c2ad57c6e0546f997eb190e952fd309','a10806ccad7e60dc071736b1eb0c2b19','123','123',NULL,'http://reading.zealon.cn/default.jpg','2020-04-21 17:25:44','2020-04-21 17:25:44'),(3,'2294c0b6c6cf4225adf54a716c3f43be','69ba74e59501695ece996853e8914cde','00','00',NULL,'http://reading.zealon.cn/default.jpg','2020-04-21 17:34:25','2020-04-21 17:34:25'),(4,'7fd29bd0067e4826952af9b7219edb67','c877bd7ab10b028c0c05b977d7805bd8','000','00',NULL,'http://reading.zealon.cn/default.jpg','2020-04-21 17:36:33','2020-04-21 17:36:33'),(5,'6952af9b7219edb7fd29bd0067e48267','c877bd7ab10b028c0c05b977d7805bd8','90','00',NULL,'http://reading.zealon.cn/default.jpg','2020-04-21 17:36:33','2020-04-21 17:36:33'),(6,'7fd29bd0067e4826952af9b7219edb61','c877bd7ab10b028c0c05b977d7805bd8','111','00',NULL,'http://reading.zealon.cn/default.jpg','2020-04-21 17:36:33','2020-04-21 17:36:33'),(7,'7fd29bd0067e4826952af9b7219edb62','c877bd7ab10b028c0c05b977d7805bd8','222','00',NULL,'http://reading.zealon.cn/default.jpg','2020-04-21 17:36:33','2020-04-21 17:36:33'),(8,'7fd29bd0067e4826952af9b7219edb63','c877bd7ab10b028c0c05b977d7805bd8','333','00',NULL,'http://reading.zealon.cn/default.jpg','2020-04-21 17:36:33','2020-04-21 17:36:33'),(9,'7fd29bd0067e4826952af9b7219edb64','c877bd7ab10b028c0c05b977d7805bd8','444','00',NULL,'http://reading.zealon.cn/default.jpg','2020-04-21 17:36:33','2020-04-21 17:36:33'),(10,'7fd29bd0067e4826952af9b7219edb66','c877bd7ab10b028c0c05b977d7805bd8','555','00',NULL,'http://reading.zealon.cn/default.jpg','2020-04-21 17:36:33','2020-04-21 17:36:33'),(11,'b677fd29bd0067e4826952af9b7219ed','c877bd7ab10b028c0c05b977d7805bd8','666','00',NULL,'http://reading.zealon.cn/default.jpg','2020-04-21 17:36:33','2020-04-21 17:36:33'),(12,'f7fd29bd0067e4826952a9b7219edb67','c877bd7ab10b028c0c05b977d7805bd8','777','00',NULL,'http://reading.zealon.cn/default.jpg','2020-04-21 17:36:33','2020-04-21 17:36:33'),(13,'e7fd29bd00674826952af9b7219edb67','c877bd7ab10b028c0c05b977d7805bd8','888','00',NULL,'http://reading.zealon.cn/default.jpg','2020-04-21 17:36:33','2020-04-21 17:36:33'),(14,'57fd29bd0067e482692af9b7219edb67','c877bd7ab10b028c0c05b977d7805bd8','999','00',NULL,'http://reading.zealon.cn/default.jpg','2020-04-21 17:36:33','2020-04-21 17:36:33'),(15,'7fd29bd0067e482952af9b7219edb676','c877bd7ab10b028c0c05b977d7805bd8','121','00',NULL,'http://reading.zealon.cn/default.jpg','2020-04-21 17:36:33','2020-04-21 17:36:33'),(16,'d7fd29b0067e4826952af9b7219edb67','c877bd7ab10b028c0c05b977d7805bd8','131','00',NULL,'http://reading.zealon.cn/default.jpg','2020-04-21 17:36:33','2020-04-21 17:36:33'),(17,'07fd29bd067e4826952af9b7219edb67','c877bd7ab10b028c0c05b977d7805bd8','141','00',NULL,'http://reading.zealon.cn/default.jpg','2020-04-21 17:36:33','2020-04-21 17:36:33'),(18,'67fd29bd0067e482952af9b7219edb67','c877bd7ab10b028c0c05b977d7805bd8','151','00',NULL,'http://reading.zealon.cn/default.jpg','2020-04-21 17:36:33','2020-04-21 17:36:33'),(19,'e67fd29bd0067e482952af9b7219db67','c877bd7ab10b028c0c05b977d7805bd8','161','00',NULL,'http://reading.zealon.cn/default.jpg','2020-04-21 17:36:33','2020-04-21 17:36:33'),(20,'97fd29bd0067e4826952afb7219edb67','c877bd7ab10b028c0c05b977d7805bd8','171','00',NULL,'http://reading.zealon.cn/default.jpg','2020-04-21 17:36:33','2020-04-21 17:36:33'),(22,'714ca9432c664b039177e45bbdd3bb3e','161853a6a397a3d33f2f1458d5f030fd','melody','melody',NULL,'http://reading.zealon.cn/default.jpg','2020-05-24 22:53:27','2020-05-24 22:53:27'),(23,'933b91bc9ef941199c328c0247c58533','161853a6a397a3d33f2f1458d5f030fd','summer','夏天',NULL,'http://reading.zealon.cn/default.jpg','2020-05-26 13:12:41','2020-05-26 13:12:41');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_bookshelf`
--

DROP TABLE IF EXISTS `user_bookshelf`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_bookshelf` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL COMMENT '用户',
  `book_id` varchar(20) NOT NULL COMMENT '图书ID',
  `last_chapter_id` int(11) DEFAULT NULL COMMENT '图书最后章节ID',
  `last_read_time` bigint(20) NOT NULL COMMENT '最后阅读时间',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_index_01` (`user_id`,`book_id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8 COMMENT='用户书架';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_bookshelf`
--

LOCK TABLES `user_bookshelf` WRITE;
/*!40000 ALTER TABLE `user_bookshelf` DISABLE KEYS */;
INSERT INTO `user_bookshelf` VALUES (12,3,'10043456',0,1589207767488,'2020-05-11 22:36:07'),(13,3,'88043024',0,1589380151793,'2020-05-13 22:29:11'),(14,3,'3001815938',2253,1590244087399,'2020-05-16 23:24:06'),(15,3,'160473',1608,1590244074140,'2020-05-23 22:27:28'),(16,23,'3001815938',0,1590469995025,'2020-05-26 13:13:15'),(17,23,'60924085',0,1590470046660,'2020-05-26 13:14:06'),(18,23,'804700011',0,1590470061740,'2020-05-26 13:14:21'),(19,23,'322538',0,1590470086193,'2020-05-26 13:14:46');
/*!40000 ALTER TABLE `user_bookshelf` ENABLE KEYS */;
UNLOCK TABLES;
