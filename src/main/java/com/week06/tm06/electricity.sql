/*
Navicat MySQL Data Transfer

Source Server         : 192.168.16.166
Source Server Version : 50724
Source Host           : 192.168.16.166:3306
Source Database       : electricity

Target Server Type    : MYSQL
Target Server Version : 50724
File Encoding         : 65001

Date: 2021-04-24 16:19:26
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_detail
-- ----------------------------
DROP TABLE IF EXISTS `t_detail`;
CREATE TABLE `t_detail` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `orderId` varchar(255) NOT NULL COMMENT '订单id',
  `productId` varchar(255) NOT NULL COMMENT '商品id',
  `number` int(11) NOT NULL COMMENT '数量',
  `totalPrice` decimal(10,0) NOT NULL COMMENT '总价',
  `createTime` datetime NOT NULL COMMENT '创建时间',
  `updateTime` datetime NOT NULL COMMENT '更新时间',
  `status` int(11) NOT NULL COMMENT '是否删除：1-显示，2-删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_detail
-- ----------------------------

-- ----------------------------
-- Table structure for t_order
-- ----------------------------
DROP TABLE IF EXISTS `t_order`;
CREATE TABLE `t_order` (
  `id` int(11) NOT NULL COMMENT '主键',
  `userId` varchar(255) NOT NULL COMMENT '用户id',
  `totalAmount` decimal(10,0) NOT NULL COMMENT '总额',
  `consignor` varchar(255) DEFAULT NULL COMMENT '发货人',
  `deliveryAddress` varchar(255) DEFAULT NULL COMMENT '发货地址',
  `harvestAddress` varchar(255) DEFAULT NULL COMMENT '收获地址',
  `createTime` datetime NOT NULL COMMENT '创建时间',
  `updateTime` datetime NOT NULL COMMENT '更新时间',
  `status` int(11) NOT NULL COMMENT '是否删除：1-显示，2-删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='订单表';

-- ----------------------------
-- Records of t_order
-- ----------------------------

-- ----------------------------
-- Table structure for t_product
-- ----------------------------
DROP TABLE IF EXISTS `t_product`;
CREATE TABLE `t_product` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `productId` varchar(255) NOT NULL COMMENT '商品id',
  `productName` varchar(255) NOT NULL COMMENT '商品\n名称',
  `price` decimal(10,0) NOT NULL COMMENT '价格',
  `type` varchar(255) DEFAULT NULL COMMENT '类型',
  `brand` varchar(255) DEFAULT NULL COMMENT '品牌',
  `function` varchar(255) DEFAULT NULL COMMENT '功能',
  `placeOrigin` varchar(255) DEFAULT NULL COMMENT '产地',
  `createTime` datetime NOT NULL COMMENT '创建时间',
  `updateTime` datetime NOT NULL COMMENT '更新时间',
  `status` int(11) NOT NULL COMMENT '是否删除：1-显示，2-删除',
  PRIMARY KEY (`id`),
  UNIQUE KEY `productId` (`productId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商品表';

-- ----------------------------
-- Records of t_product
-- ----------------------------

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `userId` varchar(255) NOT NULL COMMENT '用户id',
  `userName` varchar(255) NOT NULL COMMENT '用户名',
  `password` varchar(255) NOT NULL COMMENT '用户密码',
  `gender` int(11) DEFAULT NULL COMMENT '性别：1-男，2-女',
  `phoneNumber` varchar(255) NOT NULL COMMENT '手机号码',
  `email` varchar(255) DEFAULT NULL COMMENT '邮箱',
  `postcode` varchar(255) DEFAULT NULL COMMENT '邮编',
  `address` varchar(255) DEFAULT NULL COMMENT '地址',
  `createTime` datetime NOT NULL COMMENT '创建时间',
  `updateTime` datetime NOT NULL COMMENT '更新时间',
  `status` int(11) NOT NULL COMMENT '是否删除：1-显示，2-删除',
  PRIMARY KEY (`id`),
  UNIQUE KEY `userId` (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户表';

-- ----------------------------
-- Records of t_user
-- ----------------------------
