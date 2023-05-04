/*
 Navicat Premium Data Transfer

 Source Server         : mysql_3306
 Source Server Type    : MySQL
 Source Server Version : 80031
 Source Host           : localhost:3306
 Source Schema         : logistics

 Target Server Type    : MySQL
 Target Server Version : 80031
 File Encoding         : 65001

 Date: 04/05/2023 18:34:53
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for complaints
-- ----------------------------
DROP TABLE IF EXISTS `complaints`;
CREATE TABLE `complaints`  (
  `id` int UNSIGNED NOT NULL AUTO_INCREMENT,
  `user_id` int NULL DEFAULT NULL,
  `logistics_id` int NULL DEFAULT NULL,
  `content` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `status` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `create_time` datetime NULL DEFAULT NULL,
  `update_time` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `user_id`(`user_id` ASC) USING BTREE,
  INDEX `logistics_id`(`logistics_id` ASC) USING BTREE,
  CONSTRAINT `complaints_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `complaints_ibfk_2` FOREIGN KEY (`logistics_id`) REFERENCES `logistics` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of complaints
-- ----------------------------
INSERT INTO `complaints` VALUES (1, 2, 1, '测试题屠苏', '2', '2023-04-13 16:30:37', '2023-04-13 16:30:40');

-- ----------------------------
-- Table structure for house
-- ----------------------------
DROP TABLE IF EXISTS `house`;
CREATE TABLE `house`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `location` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `company` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `is_open` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `phone` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `work_time` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `create_time` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of house
-- ----------------------------
INSERT INTO `house` VALUES (1, '顺丰湖北武汉仓库', '武汉市洪山区', '顺丰集团', '1', '1231251231', '10-20', '2023-03-30 22:12:15');

-- ----------------------------
-- Table structure for logistics
-- ----------------------------
DROP TABLE IF EXISTS `logistics`;
CREATE TABLE `logistics`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_id` int NOT NULL COMMENT '用户ID',
  `logistics_company` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '物流公司名称',
  `logistics_status` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '物流状态',
  `logistics_time` datetime NOT NULL COMMENT '更新的日期和时间',
  `order_id` int NOT NULL COMMENT '订单ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of logistics
-- ----------------------------
INSERT INTO `logistics` VALUES (1, 2, '顺丰速递', '3', '2023-03-29 20:33:58', 1);
INSERT INTO `logistics` VALUES (2, 2, '德邦快递', '2', '2023-04-01 13:37:09', 1);

-- ----------------------------
-- Table structure for order_info
-- ----------------------------
DROP TABLE IF EXISTS `order_info`;
CREATE TABLE `order_info`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `trade_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '商品名称',
  `trade_total` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '商品总价',
  `trade_per` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '商品单价',
  `trade_num` int NULL DEFAULT NULL COMMENT '商品数量',
  `order_total` int NULL DEFAULT NULL COMMENT '订单总价',
  `customer_id` int NULL DEFAULT NULL COMMENT '用户ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of order_info
-- ----------------------------
INSERT INTO `order_info` VALUES (1, '测试货物名称', '1000', '10', 100, 1000, 2);
INSERT INTO `order_info` VALUES (2, '测试第二个货物', '1000', '20', 50, 1000, 2);

-- ----------------------------
-- Table structure for orders
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `customer_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '客户ID',
  `order_date` date NOT NULL COMMENT '订单日期',
  `total` decimal(10, 2) NOT NULL DEFAULT 1.00 COMMENT '订单总数',
  `amount` decimal(10, 2) NOT NULL DEFAULT 0.00 COMMENT '订单总额',
  `order_info_id` int NULL DEFAULT NULL COMMENT '订单ID',
  `order_desc` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `order_status` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `finish_date` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `from_location` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `to_location` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of orders
-- ----------------------------
INSERT INTO `orders` VALUES (1, '2', '2023-03-29', 10.00, 100.00, 1, '无', '2', '2023-04-05T16:06:41.900418', '湖北省武汉市欢乐大道', '武汉城市学院');
INSERT INTO `orders` VALUES (2, '2', '2023-04-01', 20.00, 200.00, 2, '无', '0', '2023-04-07', '湖北省武汉市欢乐大道', '武汉城市学院');
INSERT INTO `orders` VALUES (3, '2', '2023-04-05', 10.00, 100.00, 3, '无', '2', '2023-04-10', '湖北省武汉市欢乐大道', '武汉城市学院');

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `phone_number` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `email` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `permissions` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `create_time` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES (1, '超级管理员', '超级管理员', '123124512', '123124@qq.com', '12346123', '5', '2023-03-26 07:39:45');
INSERT INTO `users` VALUES (2, '普通用户', '测试地址i123', '123124512', '1231245@qq.com', '123456', '2', '2023-03-29 20:30:52');
INSERT INTO `users` VALUES (3, '物流人员A', '测试地址11', '12312412312', '24281320908@qq.com', '123456', '2', '2023-04-06 21:32:57');
INSERT INTO `users` VALUES (6, NULL, NULL, NULL, '123@qq.com', '123', NULL, '2023-04-13 18:21:34');
INSERT INTO `users` VALUES (7, NULL, NULL, NULL, '1234@qq.com', '123', NULL, '2023-04-13 18:23:02');
INSERT INTO `users` VALUES (8, NULL, NULL, NULL, '12322@qq.com', '123', NULL, '2023-04-13 18:26:45');

-- ----------------------------
-- Table structure for warehouse
-- ----------------------------
DROP TABLE IF EXISTS `warehouse`;
CREATE TABLE `warehouse`  (
  `id` int NOT NULL,
  `house_id` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '仓库名称',
  `address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '仓库地址',
  `in_time` datetime NULL DEFAULT NULL COMMENT '入库时间',
  `out_time` datetime NULL DEFAULT NULL COMMENT '出库时间',
  `order_id` int NULL DEFAULT NULL COMMENT '订单ID',
  `oper_id` int NULL DEFAULT NULL COMMENT '操作者',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of warehouse
-- ----------------------------
INSERT INTO `warehouse` VALUES (1, '1', '测试地址1', '2023-03-29 20:31:35', '2023-04-13 21:29:37', 1, 3);
INSERT INTO `warehouse` VALUES (2, '1', '测试地址2', '2023-03-29 20:32:18', '2023-03-29 20:32:20', 1, 3);

SET FOREIGN_KEY_CHECKS = 1;
