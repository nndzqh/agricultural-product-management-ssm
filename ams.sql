/*
 Navicat Premium Data Transfer

 Source Server         : MyAliyun
 Source Server Type    : MySQL
 Source Server Version : 80025
 Source Host           : rm-hp3owu27a3g071f408o.mysql.huhehaote.rds.aliyuncs.com:3306
 Source Schema         : ams

 Target Server Type    : MySQL
 Target Server Version : 80025
 File Encoding         : 65001

 Date: 27/06/2022 04:30:33
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '种类id',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '名称',
  `sort` int NULL DEFAULT NULL COMMENT '排序',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '分类表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of category
-- ----------------------------
INSERT INTO `category` VALUES (1, '蔬菜', 1, '2022-06-25 16:20:09', '2022-06-25 16:20:09');
INSERT INTO `category` VALUES (2, '水果', 2, '2022-06-26 18:00:06', '2022-06-26 18:00:08');
INSERT INTO `category` VALUES (3, '粮食', 3, '2022-06-26 19:23:36', '2022-06-26 19:23:39');
INSERT INTO `category` VALUES (11, '肉类', 4, '2022-06-27 01:37:42', '2022-06-27 01:37:42');
INSERT INTO `category` VALUES (12, '粗粮类', 5, '2022-06-27 01:38:17', '2022-06-27 01:38:17');
INSERT INTO `category` VALUES (13, '蛋类', 8, '2022-06-27 01:38:44', '2022-06-27 01:38:44');
INSERT INTO `category` VALUES (14, '王五', 7, '2022-06-27 04:28:54', '2022-06-27 04:28:54');

-- ----------------------------
-- Table structure for orders
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '订单id',
  `number` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '订单号',
  `products_id` int NULL DEFAULT NULL COMMENT '产品id',
  `num` int NULL DEFAULT NULL COMMENT '数量',
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '地址',
  `contact` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '联系人',
  `phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '手机号',
  `state` int NULL DEFAULT NULL COMMENT '状态 0-已支付，1-未支付，2-已发货，3-未发货，4-已签收，5-未签收',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime NULL DEFAULT NULL COMMENT '修改时间',
  `end_time` datetime NULL DEFAULT NULL COMMENT '订单完成时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of orders
-- ----------------------------
INSERT INTO `orders` VALUES (1, '1', 2, 1, '1', '1', '1', 1, '2022-06-26 20:55:45', '2022-06-26 20:55:48', '2022-06-26 20:55:50');
INSERT INTO `orders` VALUES (2, '22', 3, 22, '22', '11', '11111', 1, '2022-06-27 02:58:28', '2022-06-27 02:58:36', '2022-06-27 02:58:39');
INSERT INTO `orders` VALUES (5, 'dfafdasfda', 2, 1, '内蒙古自治区呼和浩特市玉泉区实施华庭', '张三', '123123456123', 3, '2022-06-27 03:19:37', '2022-06-27 03:19:40', '2022-06-27 03:19:46');
INSERT INTO `orders` VALUES (6, '12345436543111', 3, 22, '内蒙古自治区呼和浩特市玉泉区实施华庭', '王五', '12345567887654', 1, '2022-06-27 03:22:32', '2022-06-27 03:22:38', '2022-06-27 03:22:44');
INSERT INTO `orders` VALUES (7, '1234567890', 30, 33, '内蒙古自治区呼和浩特市玉泉区实施华庭', '赵六', '123456789098', 2, '2022-06-27 03:24:14', '2022-06-27 03:24:19', '2022-06-27 03:24:24');

-- ----------------------------
-- Table structure for products
-- ----------------------------
DROP TABLE IF EXISTS `products`;
CREATE TABLE `products`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '农产品id',
  `category_id` int NULL DEFAULT NULL COMMENT '分类id',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '名称',
  `img` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图片路径',
  `state` int NULL DEFAULT 0 COMMENT '状态 0-起售，1-停售',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '农产品表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of products
-- ----------------------------
INSERT INTO `products` VALUES (2, 2, '香蕉', 'img/wallhaven-q2kmw5_3840x2160.png', 1, '2022-06-26 18:02:10', '2022-06-26 14:01:29');
INSERT INTO `products` VALUES (3, 2, '苹果', 'img/wallhaven-q2kmw5_3840x2160.png', 0, '2022-06-26 18:02:13', '2022-06-26 21:07:57');
INSERT INTO `products` VALUES (4, 2, '猕猴桃', 'img/wallhaven-q2kmw5_3840x2160.png', 0, '2022-06-26 18:02:15', '2022-06-26 21:07:59');
INSERT INTO `products` VALUES (6, 1, '黄瓜', 'img/wallhaven-q2kmw5_3840x2160.png', 0, '2022-06-26 18:02:19', '2022-06-26 21:08:03');
INSERT INTO `products` VALUES (7, 1, '茄子', 'img/wallhaven-q2kmw5_3840x2160.png', 0, '2022-06-26 18:02:22', '2022-06-26 21:08:07');
INSERT INTO `products` VALUES (8, 1, '西红柿', 'img/wallhaven-q2kmw5_3840x2160.png', 0, '2022-06-26 18:02:24', '2022-06-26 21:08:09');
INSERT INTO `products` VALUES (9, 1, '豆芽', 'img/wallhaven-q2kmw5_3840x2160.png', 0, '2022-06-26 18:02:27', '2022-06-26 21:08:11');
INSERT INTO `products` VALUES (14, 2, '油桃', 'img/wallhaven-q2kmw5_3840x2160.png', 0, '2022-06-26 12:30:08', '2022-06-26 21:08:13');
INSERT INTO `products` VALUES (25, 1, '娃娃菜', 'img/wallhaven-q2kmw5_3840x2160.png', 0, '2022-06-26 18:08:01', '2022-06-26 18:08:01');
INSERT INTO `products` VALUES (26, 1, '大黄瓜', 'img/wallhaven-q2kmw5_3840x2160.png', 0, '2022-06-26 18:27:21', '2022-06-26 18:27:21');
INSERT INTO `products` VALUES (30, 1, '大白菜', 'img/wallhaven-q2kmw5_3840x2160.png', 0, '2022-06-26 18:38:30', '2022-06-26 18:38:30');
INSERT INTO `products` VALUES (31, 3, '绿豆', 'img\\wallhaven-q2kmw5_3840x2160.png.png', 0, '2022-06-26 18:51:27', '2022-06-26 18:51:27');

-- ----------------------------
-- Table structure for stock
-- ----------------------------
DROP TABLE IF EXISTS `stock`;
CREATE TABLE `stock`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '库存id',
  `products_id` int NULL DEFAULT NULL COMMENT '产品id',
  `sum` int NULL DEFAULT NULL COMMENT '数量',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '库存表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of stock
-- ----------------------------
INSERT INTO `stock` VALUES (1, 2, 10, '2022-06-26 19:35:55', '2022-06-26 19:36:46');
INSERT INTO `stock` VALUES (2, 3, 22, '2022-06-26 19:36:02', '2022-06-26 19:37:16');
INSERT INTO `stock` VALUES (3, 4, 12, '2022-06-26 19:36:04', NULL);
INSERT INTO `stock` VALUES (13, 25, 34, '2022-06-26 19:54:27', '2022-06-26 19:54:27');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',
  `state` int NULL DEFAULT 0 COMMENT '状态 0-正常，1-禁用',
  `is_power` int NULL DEFAULT 0 COMMENT '是否为管理员 0-非，1-管理员',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'admin', 'admin', 0, 1, '2022-06-22 15:52:16', '2022-06-22 15:52:19');
INSERT INTO `user` VALUES (2, 'zhangsan', '1', 0, 0, '2022-06-22 15:52:33', '2022-06-22 15:52:35');

SET FOREIGN_KEY_CHECKS = 1;
