create database demo_db;

use demo_db;
-- CREATE TABLE `authorities` (
--   `id` int NOT NULL AUTO_INCREMENT,
--   `username` varchar(255) DEFAULT NULL,
--   `roleid` varchar(255) DEFAULT NULL,
--   PRIMARY KEY (`id`)
-- )

-- CREATE TABLE `categories` (
--   `idcategories` int NOT NULL,
--   `name` varchar(45) DEFAULT NULL,
--   `id` varchar(255) NOT NULL,
--   PRIMARY KEY (`idcategories`)
-- )

-- CREATE TABLE `orders` (
--   `id` bigint NOT NULL AUTO_INCREMENT,
--   `address` varchar(255) DEFAULT NULL,
--   `createdate` date DEFAULT NULL,
--   `username` varchar(255) DEFAULT NULL,
--   PRIMARY KEY (`id`)
-- )

-- CREATE TABLE `products` (
--   `id` int NOT NULL AUTO_INCREMENT,
--   `available` bit(1) DEFAULT NULL,
--   `createdate` date DEFAULT NULL,
--   `image` varchar(255) DEFAULT NULL,
--   `name` varchar(255) DEFAULT NULL,
--   `price` double DEFAULT NULL,
--   `categoryid` varchar(255) DEFAULT NULL,
--   PRIMARY KEY (`id`)
-- )

-- CREATE TABLE `orderdetails` (
--   `id` bigint NOT NULL AUTO_INCREMENT,
--   `price` double DEFAULT NULL,
--   `quantity` int DEFAULT NULL,
--   `orderid` bigint DEFAULT NULL,
--   `productid` int DEFAULT NULL,
--   PRIMARY KEY (`id`),
--   KEY `FKj4gc2ja2otvwemf4rho2lp3s8` (`orderid`),
--   KEY `FKaltatpxipsjtcih4d1h6bn0xr` (`productid`)
-- )

-- CREATE TABLE `role` (
--   `id_role` int NOT NULL AUTO_INCREMENT,
--   `name` varchar(45) DEFAULT NULL,
--   PRIMARY KEY (`id_role`)
-- )
-- INSERT INTO `role` VALUES (1,'employee'),(2,'admin');

-- CREATE TABLE `user` (
--   `iduser` int NOT NULL AUTO_INCREMENT,
--   `id_role` int DEFAULT NULL,
--   PRIMARY KEY (`iduser`),
--   KEY `id_role_idx` (`id_role`),
--   CONSTRAINT `role_and_user` FOREIGN KEY (`id_role`) REFERENCES `role` (`id_role`)
-- )

-- INSERT INTO `user` VALUES (1,1);