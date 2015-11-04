/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50621
Source Host           : localhost:3306
Source Database       : shiro

Target Server Type    : MYSQL
Target Server Version : 50621
File Encoding         : 65001

Date: 2015-11-04 14:37:11
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `set_user`
-- ----------------------------
DROP TABLE IF EXISTS `set_user`;
CREATE TABLE `set_user` (
  `USER_ID` int(11) NOT NULL DEFAULT '0',
  `USERNAME` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL,
  `PASSWORD` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL,
  `DESCRIPTION` varchar(256) COLLATE utf8_unicode_ci DEFAULT NULL,
  `STATUS` char(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `LAST_UPDATOR` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL,
  `LAST_UPDATE_TIME` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`USER_ID`),
  UNIQUE KEY `SET_USER_IX1` (`USERNAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of set_user
-- ----------------------------
