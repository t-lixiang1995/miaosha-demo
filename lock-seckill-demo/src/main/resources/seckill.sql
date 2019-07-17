/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 80011
Source Host           : localhost:3306
Source Database       : seckill

Target Server Type    : MYSQL
Target Server Version : 80011
File Encoding         : 65001

Date: 2019-07-17 15:09:50
*/
create database seckill;
SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `seckill_goods`
-- ----------------------------
DROP TABLE IF EXISTS `seckill_goods`;
CREATE TABLE `seckill_goods` (
  `id` int(20) NOT NULL COMMENT '序号',
  `name` varchar(50) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '名称',
  `count` int(20) DEFAULT NULL COMMENT '数量（库存）',
  `sale` int(20) DEFAULT NULL COMMENT '已售数量',
  `version` int(20) DEFAULT NULL COMMENT '版本',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
-- Records of seckill_goods
-- ----------------------------
INSERT INTO `seckill_goods` VALUES ('1', '娃娃', '102', '148', '99');

-- ----------------------------
-- Table structure for `seckill_order`
-- ----------------------------
DROP TABLE IF EXISTS `seckill_order`;
CREATE TABLE `seckill_order` (
  `id` int(20) NOT NULL AUTO_INCREMENT COMMENT '搴忓彿',
  `custname` varchar(50) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '商品名',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=105 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

