CREATE DATABASE  IF NOT EXISTS `demo`;
USE `demo`;

--
-- Table structure for table `bidlist`
--

DROP TABLE IF EXISTS `bidlist`;
CREATE TABLE `bidlist` (
  `bid_list_id` int NOT NULL,
  `account` varchar(255) DEFAULT NULL,
  `ask` double NOT NULL,
  `ask_quantity` double DEFAULT NULL,
  `benchmark` varchar(255) DEFAULT NULL,
  `bid` double NOT NULL,
  `bid_list_date` datetime(6) DEFAULT NULL,
  `bid_quantity` double DEFAULT NULL,
  `book` varchar(255) DEFAULT NULL,
  `commentary` varchar(255) DEFAULT NULL,
  `creation_date` datetime(6) DEFAULT NULL,
  `creation_name` varchar(255) DEFAULT NULL,
  `deal_name` varchar(255) DEFAULT NULL,
  `deal_type` varchar(255) DEFAULT NULL,
  `revision_date` datetime(6) DEFAULT NULL,
  `revision_name` varchar(255) DEFAULT NULL,
  `security` varchar(255) DEFAULT NULL,
  `side` varchar(255) DEFAULT NULL,
  `source_list_id` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `trader` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `bid_list_datetoto` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`bid_list_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


--
-- Dumping data for table `bidlist`
--

LOCK TABLES `bidlist` WRITE;
INSERT INTO `bidlist` VALUES (1,'A1',0,0,NULL,0,NULL,101,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'T1',NULL);
UNLOCK TABLES;

--
-- Table structure for table `curvepoint`
--

DROP TABLE IF EXISTS `curvepoint`;
CREATE TABLE `curvepoint` (
  `id` int NOT NULL,
  `as_of_date` datetime(6) DEFAULT NULL,
  `creation_date` datetime(6) DEFAULT NULL,
  `curve_id` int DEFAULT NULL,
  `term` double NOT NULL,
  `value` double NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `curvepoint`
--

LOCK TABLES `curvepoint` WRITE;
INSERT INTO `curvepoint` VALUES (2,'2023-09-12 17:24:09.503636','2023-09-05 10:56:46.182097',0,10,102),(14,'2023-09-05 12:57:17.970574','2023-09-05 12:57:17.970574',0,12,12);
UNLOCK TABLES;

--
-- Table structure for table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `hibernate_sequence`
--

LOCK TABLES `hibernate_sequence` WRITE;
INSERT INTO `hibernate_sequence` VALUES (18);
UNLOCK TABLES;

--
-- Table structure for table `rating`
--

DROP TABLE IF EXISTS `rating`;
CREATE TABLE `rating` (
  `id` int NOT NULL,
  `fitch_rating` varchar(255) DEFAULT NULL,
  `moodys_rating` varchar(255) DEFAULT NULL,
  `order_number` int NOT NULL,
  `sandprating` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `rating`
--

LOCK TABLES `rating` WRITE;
INSERT INTO `rating` VALUES (3,'3','1',16,'4'),(4,'3','1',15,'4'),(5,'2','2',90,'3'),(6,'dgqf','fgd',3,'dfg'),(7,'dgqf','fgd',3,'dfg'),(9,'dgqfppp','fgd',4,'dfg'),(10,'dgqf','fgd',3,'dfg');
UNLOCK TABLES;

--
-- Table structure for table `rulename`
--

DROP TABLE IF EXISTS `rulename`;
CREATE TABLE `rulename` (
  `id` int NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `json` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `sql_part` varchar(255) DEFAULT NULL,
  `sql_str` varchar(255) DEFAULT NULL,
  `template` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `rulename`
--

LOCK TABLES `rulename` WRITE;
INSERT INTO `rulename` VALUES (16,'hs','hs','gfh','shf','sfhd','hsfd');
UNLOCK TABLES;

--
-- Table structure for table `trade`
--

DROP TABLE IF EXISTS `trade`;
CREATE TABLE `trade` (
  `trade_id` int NOT NULL,
  `account` varchar(255) DEFAULT NULL,
  `benchmark` varchar(255) DEFAULT NULL,
  `book` varchar(255) DEFAULT NULL,
  `buy_price` double NOT NULL,
  `buy_quantity` double NOT NULL,
  `creation_date` datetime(6) DEFAULT NULL,
  `creation_name` varchar(255) DEFAULT NULL,
  `deal_name` varchar(255) DEFAULT NULL,
  `deal_type` varchar(255) DEFAULT NULL,
  `revision_date` datetime(6) DEFAULT NULL,
  `revision_name` varchar(255) DEFAULT NULL,
  `security` varchar(255) DEFAULT NULL,
  `sell_price` double NOT NULL,
  `sell_quantity` double NOT NULL,
  `side` varchar(255) DEFAULT NULL,
  `source_list_id` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `trade_date` datetime(6) DEFAULT NULL,
  `trader` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`trade_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `trade`
--

LOCK TABLES `trade` WRITE;
INSERT INTO `trade` VALUES (13,'hkhj',NULL,NULL,0,4,NULL,NULL,NULL,NULL,'2023-09-12 17:58:48.025226',NULL,NULL,0,0,NULL,NULL,NULL,NULL,NULL,'hjkh');
UNLOCK TABLES;

--
-- Table structure for table `user_sequence`
--

DROP TABLE IF EXISTS `user_sequence`;
CREATE TABLE `user_sequence` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `user_sequence`
--

LOCK TABLES `user_sequence` WRITE;
INSERT INTO `user_sequence` VALUES (3);
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `id` int NOT NULL,
  `fullname` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
UNLOCK TABLES;

