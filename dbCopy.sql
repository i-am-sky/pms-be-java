-- MySQL dump 10.13  Distrib 8.0.36, for Win64 (x86_64)
--
-- Host: localhost    Database: testdb
-- ------------------------------------------------------
-- Server version	8.0.34

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
-- Table structure for table `products`
--

DROP TABLE IF EXISTS `products`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `products` (
  `product_id` int NOT NULL,
  `product_name` varchar(45) NOT NULL,
  `price` decimal(18,2) DEFAULT '0.00',
  `description` varchar(5000) DEFAULT NULL,
  `product_code` varchar(20) NOT NULL,
  `release_date` date DEFAULT (curdate()),
  `image_url` varchar(5000) DEFAULT NULL,
  `star_rating` decimal(4,2) DEFAULT '0.00',
  PRIMARY KEY (`product_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `products`
--

LOCK TABLES `products` WRITE;
/*!40000 ALTER TABLE `products` DISABLE KEYS */;
INSERT INTO `products` VALUES (1,'iPhone 14 Pro Max',1099.00,'Apple\'s flagship smartphone with a 6.7-inch Super Retina XDR display, A16 Bionic chip, and a triple camera system.','IP14PM','2023-09-16','https://images-cdn.ubuy.co.in/633ff4156784f756b5031314-iphone-14-pro-max-256gb-gold.jpg',4.70),(2,'Samsung Galaxy S23 Ultra',1199.99,'Samsung\'s latest flagship smartphone with a 6.8-inch Dynamic AMOLED display, Snapdragon 8 Gen 2 processor, and a 200MP camera.','SG23UL','2023-02-01','https://cdn.dxomark.com/wp-content/uploads/medias/post-139011/Samsung-Galaxy-S23-Ultra_-featured-image-packshot-review-1024x691.jpg',4.60),(3,'Sony WH-1000XM5',399.99,'Sony\'s latest flagship noise-canceling headphones with improved sound quality, up to 30 hours of battery life, and multi-device connectivity.','WH1000XM5','2022-08-15','https://www.sony.co.in/image/6145c1d32e6ac8e63a46c912dc33c5bb?fmt=pjpeg&wid=330&bgcolor=FFFFFF&bgc=FFFFFF',4.80),(4,'Canon EOS R6 Mark II',2499.00,'Canon\'s latest mirrorless camera with a 24.2-megapixel full-frame sensor, 4K video recording, and dual pixel autofocus.','CR6M2','2022-11-10','https://cdn1.smartprix.com/rx-iEbCdQUsN-w420-h420/canon-eos-r6-mark-ii.jpg',4.50),(5,'Microsoft Surface Pro 9',999.99,'Microsoft\'s latest 2-in-1 tablet with a 13-inch PixelSense display, Intel Core i5 processor, and Windows 11 Pro.','SP9','2022-10-12','https://cdn-dynmedia-1.microsoft.com/is/image/microsoftcorp/MSFT-Surface-Pro-9-for-Business-desktop-Poster-RE50wFD?scl=1',4.30),(6,'Bose QuietComfort 45',329.95,'Bose\'s latest noise-canceling headphones with improved sound quality, up to 24 hours of battery life, and comfortable ear cups.','QC45','2021-09-22','https://assets.bose.com/content/dam/cloudassets/Bose_DAM/Web/consumer_electronics/global/products/headphones/qc45/product_silo_images/QC45-LE_Left-Angle_1200x1022_Midnight-Blue_RGB.png/jcr:content/renditions/cq5dam.web.320.320.png',4.60),(7,'Nikon Z7 II',2999.95,'Nikon\'s latest mirrorless camera with a 45.7-megapixel full-frame sensor, 4K video recording, and 5-axis image stabilization.','NZ7II','2020-10-14','https://cdn1.smartprix.com/rx-ivSsuH0Dj-w1200-h1200/vSsuH0Dj.jpg',4.40),(8,'Apple Watch Series 8',399.00,'Apple\'s latest smartwatch with a 41mm or 45mm display, blood oxygen sensor, and ECG app.','AW8','2022-09-16','https://iplanet.one/cdn/shop/files/Apple_Watch_Series_8_LTE_41mm_Midnight_Aluminum_Midnight_Sport_Band_PDP_Image_Position-1__en-US_4b6ccd1d-dbfc-4589-a43b-3efcbe392819_1445x.jpg?v=1698871403',4.60),(9,'Google Pixel 7 Pro',899.00,'Google\'s latest flagship smartphone with a 6.7-inch OLED display, Tensor G2 processor, and a 50-megapixel camera.','GP7P','2022-10-13','https://images-cdn.ubuy.co.in/651546e3124186167265e27b-google-pixel-7-pro-5g-android-phone.jpg',4.50),(10,'Samsung Galaxy Z Fold 4',1799.99,'Samsung\'s latest foldable smartphone with a 7.6-inch Dynamic AMOLED display, Snapdragon 8+ Gen 1 processor, and a 108MP camera.','SGZF4','2022-08-26','https://d2xamzlzrdbdbn.cloudfront.net/products/ed188986-a44c-4e97-b19e-ee6d6d50cf5122170836_416x416.jpg',4.40),(100,'sample',999.00,'this is a sample item','sam-999','2024-04-29','sample.com/1.jpg',8.00);
/*!40000 ALTER TABLE `products` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'testdb'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-05-07 11:52:49
-- MySQL dump 10.13  Distrib 8.0.36, for Win64 (x86_64)
--
-- Host: localhost    Database: sampledb
-- ------------------------------------------------------
-- Server version	8.0.34

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
-- Table structure for table `employees`
--

DROP TABLE IF EXISTS `employees`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `employees` (
  `id` int NOT NULL,
  `name` varchar(45) NOT NULL,
  `salary` decimal(18,2) NOT NULL DEFAULT '0.00',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employees`
--

LOCK TABLES `employees` WRITE;
/*!40000 ALTER TABLE `employees` DISABLE KEYS */;
INSERT INTO `employees` VALUES (1,'Gagan',15000.00),(2,'Akash',20000.00),(3,'Mallesh',18000.00),(4,'vinod kumar',25000.00),(10,'tobii',5000.00),(12,'someoneNew',20000.00);
/*!40000 ALTER TABLE `employees` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'sampledb'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-05-07 11:52:49
