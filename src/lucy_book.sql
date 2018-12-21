/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50173
Source Host           : localhost:3306
Source Database       : lucy_book

Target Server Type    : MYSQL
Target Server Version : 50173
File Encoding         : 65001

Date: 2018-12-21 20:19:41
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `admin`
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `admid` int(11) NOT NULL AUTO_INCREMENT COMMENT '管理员ID',
  `admName` varchar(35) DEFAULT NULL COMMENT '管理员姓名',
  `admPassword` varchar(35) DEFAULT NULL COMMENT '登录密码',
  `admPor` varchar(50) DEFAULT NULL COMMENT '管理员头像',
  PRIMARY KEY (`admid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admin
-- ----------------------------

-- ----------------------------
-- Table structure for `author`
-- ----------------------------
DROP TABLE IF EXISTS `author`;
CREATE TABLE `author` (
  `autid` int(11) NOT NULL AUTO_INCREMENT COMMENT '作者ID',
  `autName` varchar(35) DEFAULT NULL COMMENT '作者姓名',
  `autSex` varchar(10) DEFAULT NULL COMMENT '性别',
  `autPlace` varchar(10) DEFAULT NULL COMMENT '作者籍贯',
  `autdate` date DEFAULT NULL COMMENT '出生日期',
  `autPor` varchar(35) DEFAULT NULL COMMENT '作者图片',
  `autdetail` varchar(225) DEFAULT NULL COMMENT '作者的相关描述',
  PRIMARY KEY (`autid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of author
-- ----------------------------

-- ----------------------------
-- Table structure for `book`
-- ----------------------------
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book` (
  `bid` int(11) NOT NULL AUTO_INCREMENT COMMENT '书本ID',
  `bName` varchar(35) DEFAULT NULL COMMENT '书名',
  `bPrice` double DEFAULT NULL COMMENT '单价',
  `bStore` int(11) DEFAULT NULL COMMENT '库存',
  `bPhoto` varchar(35) DEFAULT NULL COMMENT '图片',
  `bdetail` varchar(225) DEFAULT NULL COMMENT '书本描述',
  `isRem` varchar(8) DEFAULT NULL COMMENT '是否加入推荐',
  `stid` int(11) NOT NULL COMMENT '书本类型',
  `autid` int(11) NOT NULL COMMENT '作者',
  PRIMARY KEY (`bid`),
  KEY `stid` (`stid`),
  KEY `autid` (`autid`),
  CONSTRAINT `autid` FOREIGN KEY (`autid`) REFERENCES `author` (`autid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `stid` FOREIGN KEY (`stid`) REFERENCES `stort` (`stid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of book
-- ----------------------------

-- ----------------------------
-- Table structure for `consigness`
-- ----------------------------
DROP TABLE IF EXISTS `consigness`;
CREATE TABLE `consigness` (
  `consid` int(11) NOT NULL AUTO_INCREMENT COMMENT '收货人ID',
  `consName` varchar(35) DEFAULT NULL COMMENT '收货人姓名',
  `consTel` varchar(35) DEFAULT NULL COMMENT '收货人电话',
  `consAddre` varchar(225) DEFAULT NULL COMMENT '收货人地址',
  `isDef` varchar(8) DEFAULT NULL COMMENT '是否设置为默认',
  `uid` int(11) DEFAULT NULL COMMENT '创建人',
  PRIMARY KEY (`consid`),
  KEY `uid` (`uid`),
  CONSTRAINT `uid` FOREIGN KEY (`uid`) REFERENCES `user` (`uid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of consigness
-- ----------------------------

-- ----------------------------
-- Table structure for `detail`
-- ----------------------------
DROP TABLE IF EXISTS `detail`;
CREATE TABLE `detail` (
  `detid` int(11) NOT NULL AUTO_INCREMENT COMMENT '订单细明ID',
  `bid` int(11) DEFAULT NULL COMMENT '书本信息',
  `number` int(11) DEFAULT NULL COMMENT '购买数量',
  `consid` int(11) DEFAULT NULL COMMENT '收货人',
  `userdetail` varchar(225) DEFAULT NULL COMMENT '用户备注信息',
  PRIMARY KEY (`detid`),
  KEY `b_id` (`bid`),
  KEY `cons_id` (`consid`),
  CONSTRAINT `b_id` FOREIGN KEY (`bid`) REFERENCES `book` (`bid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `cons_id` FOREIGN KEY (`consid`) REFERENCES `consigness` (`consid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of detail
-- ----------------------------

-- ----------------------------
-- Table structure for `notes`
-- ----------------------------
DROP TABLE IF EXISTS `notes`;
CREATE TABLE `notes` (
  `bufid` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `
content` varchar(225) NOT NULL COMMENT '内容',
  PRIMARY KEY (`bufid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of notes
-- ----------------------------

-- ----------------------------
-- Table structure for `orders`
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders` (
  `ordid` int(11) NOT NULL AUTO_INCREMENT COMMENT '订单ID',
  `uid` int(11) DEFAULT NULL COMMENT '创建该订单的用户',
  `ordTime` date DEFAULT NULL COMMENT '订单创建时间',
  `ordstate` varchar(255) DEFAULT NULL COMMENT '订单状态',
  `detid` int(11) DEFAULT NULL COMMENT '明细',
  PRIMARY KEY (`ordid`),
  KEY `u_id` (`uid`),
  KEY `det_id` (`detid`),
  CONSTRAINT `det_id` FOREIGN KEY (`detid`) REFERENCES `detail` (`detid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `u_id` FOREIGN KEY (`uid`) REFERENCES `user` (`uid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of orders
-- ----------------------------

-- ----------------------------
-- Table structure for `shoppcart`
-- ----------------------------
DROP TABLE IF EXISTS `shoppcart`;
CREATE TABLE `shoppcart` (
  `shopid` int(11) NOT NULL AUTO_INCREMENT COMMENT '购物车ID',
  `shopTime` date DEFAULT NULL COMMENT '创建时间',
  `uid` int(11) DEFAULT NULL COMMENT '创建用户',
  `detid` int(11) DEFAULT NULL COMMENT '明细',
  PRIMARY KEY (`shopid`),
  KEY `userid` (`uid`),
  KEY `orddid` (`detid`),
  CONSTRAINT `userid` FOREIGN KEY (`uid`) REFERENCES `user` (`uid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `orddid` FOREIGN KEY (`detid`) REFERENCES `detail` (`detid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of shoppcart
-- ----------------------------

-- ----------------------------
-- Table structure for `stort`
-- ----------------------------
DROP TABLE IF EXISTS `stort`;
CREATE TABLE `stort` (
  `stid` int(11) NOT NULL AUTO_INCREMENT COMMENT '类型ID',
  `stName` varchar(35) DEFAULT NULL COMMENT '类型名',
  PRIMARY KEY (`stid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of stort
-- ----------------------------

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `uid` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `uName` varchar(35) DEFAULT NULL COMMENT '用户名',
  `uSex` varchar(8) DEFAULT NULL COMMENT '性别',
  `uPassword` varchar(35) DEFAULT NULL COMMENT '登录密码',
  `uPor` varchar(35) DEFAULT NULL COMMENT '头像',
  `uTel` varchar(35) DEFAULT NULL COMMENT '用户电话',
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
