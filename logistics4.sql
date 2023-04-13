/*
 Navicat Premium Data Transfer

 Source Server         : LocalHost_3306
 Source Server Type    : MySQL
 Source Server Version : 80026
 Source Host           : localhost:3306
 Source Schema         : logistics

 Target Server Type    : MySQL
 Target Server Version : 80026
 File Encoding         : 65001

 Date: 13/04/2023 19:10:50
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for Complaints
-- ----------------------------
DROP TABLE IF EXISTS `Complaints`;
CREATE TABLE `Complaints` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `user_id` int DEFAULT NULL,
  `logistics_id` int DEFAULT NULL,
  `content` varchar(500) DEFAULT NULL,
  `status` varchar(10) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  KEY `logistics_id` (`logistics_id`),
  CONSTRAINT `complaints_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `Users` (`id`),
  CONSTRAINT `complaints_ibfk_2` FOREIGN KEY (`logistics_id`) REFERENCES `Logistics` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of Complaints
-- ----------------------------
BEGIN;
INSERT INTO `Complaints` VALUES (1, 2, 1, '测试题屠苏', '2', '2023-04-13 16:30:37', '2023-04-13 16:30:40');
COMMIT;

-- ----------------------------
-- Table structure for house
-- ----------------------------
DROP TABLE IF EXISTS `house`;
CREATE TABLE `house` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `location` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `company` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `is_open` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `phone` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `work_time` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of house
-- ----------------------------
BEGIN;
INSERT INTO `house` VALUES (1, '顺丰湖北武汉仓库', '武汉市洪山区', '顺丰集团', '1', '1231251231', '10-20', '2023-03-30 22:12:15');
COMMIT;

-- ----------------------------
-- Table structure for logistics
-- ----------------------------
DROP TABLE IF EXISTS `logistics`;
CREATE TABLE `logistics` (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_id` int NOT NULL COMMENT '用户ID',
  `logistics_company` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '物流公司名称',
  `logistics_status` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '物流状态',
  `logistics_time` datetime NOT NULL COMMENT '更新的日期和时间',
  `order_id` int NOT NULL COMMENT '订单ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of logistics
-- ----------------------------
BEGIN;
INSERT INTO `logistics` VALUES (1, 2, '顺丰速递', '1', '2023-03-29 20:33:58', 1);
INSERT INTO `logistics` VALUES (2, 2, '德邦快递', '2', '2023-04-01 13:37:09', 1);
COMMIT;

-- ----------------------------
-- Table structure for order_info
-- ----------------------------
DROP TABLE IF EXISTS `order_info`;
CREATE TABLE `order_info` (
  `id` int NOT NULL AUTO_INCREMENT,
  `trade_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '商品名称',
  `trade_total` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '商品总价',
  `trade_per` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '商品单价',
  `trade_num` int DEFAULT NULL COMMENT '商品数量',
  `order_total` int DEFAULT NULL COMMENT '订单总价',
  `customer_id` int DEFAULT NULL COMMENT '用户ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of order_info
-- ----------------------------
BEGIN;
INSERT INTO `order_info` VALUES (1, '测试货物名称', '1000', '10', 100, 1000, 2);
INSERT INTO `order_info` VALUES (2, '测试第二个货物', '1000', '20', 50, 1000, 2);
COMMIT;

-- ----------------------------
-- Table structure for orders
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders` (
  `id` int NOT NULL AUTO_INCREMENT,
  `customer_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '客户ID',
  `order_date` date NOT NULL COMMENT '订单日期',
  `total` decimal(10,2) NOT NULL DEFAULT '1.00' COMMENT '订单总数',
  `amount` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT '订单总额',
  `order_info_id` int DEFAULT NULL COMMENT '订单ID',
  `order_desc` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `order_status` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `finish_date` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of orders
-- ----------------------------
BEGIN;
INSERT INTO `orders` VALUES (1, '2', '2023-03-29', 10.00, 100.00, 1, NULL, '2', '2023-04-05T16:06:41.900418');
INSERT INTO `orders` VALUES (2, '2', '2023-04-01', 20.00, 200.00, 2, NULL, '0', '2023-04-07');
INSERT INTO `orders` VALUES (3, '2', '2023-04-05', 10.00, 100.00, 3, NULL, '2', '2023-04-10');
COMMIT;

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `phone_number` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `email` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `permissions` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of users
-- ----------------------------
BEGIN;
INSERT INTO `users` VALUES (1, '超级管理员', '地址', '13476973442', '1347290221@qq.com', '123456', '5', '2023-03-26 07:39:45');
INSERT INTO `users` VALUES (2, '普通用户', '测试地址', '12312412312', '2428320908@qq.com', '123456', '1', '2023-03-29 20:30:52');
INSERT INTO `users` VALUES (3, '物流人员A', '测试地址11', '12312412312', '24281320908@qq.com', '123456', '2', '2023-04-06 21:32:57');
INSERT INTO `users` VALUES (6, NULL, NULL, NULL, '123@qq.com', '123', NULL, '2023-04-13 18:21:34');
INSERT INTO `users` VALUES (7, NULL, NULL, NULL, '1234@qq.com', '123', NULL, '2023-04-13 18:23:02');
INSERT INTO `users` VALUES (8, NULL, NULL, NULL, '12322@qq.com', '123', NULL, '2023-04-13 18:26:45');
COMMIT;

-- ----------------------------
-- Table structure for warehouse
-- ----------------------------
DROP TABLE IF EXISTS `warehouse`;
CREATE TABLE `warehouse` (
  `id` int NOT NULL,
  `house_id` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '仓库名称',
  `address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '仓库地址',
  `in_time` datetime DEFAULT NULL COMMENT '入库时间',
  `out_time` datetime DEFAULT NULL COMMENT '出库时间',
  `order_id` int DEFAULT NULL COMMENT '订单ID',
  `oper_id` int DEFAULT NULL COMMENT '操作者',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of warehouse
-- ----------------------------
BEGIN;
INSERT INTO `warehouse` VALUES (1, '1', '测试地址1', '2023-03-29 20:31:35', '2023-04-06 22:08:28', 1, 3);
INSERT INTO `warehouse` VALUES (2, '1', '测试地址2', '2023-03-29 20:32:18', '2023-03-29 20:32:20', 1, 3);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
