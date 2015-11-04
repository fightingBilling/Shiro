/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50621
Source Host           : localhost:3306
Source Database       : shiro

Target Server Type    : MYSQL
Target Server Version : 50621
File Encoding         : 65001

Date: 2015-11-04 14:37:17
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `set_user_rgroup`
-- ----------------------------
DROP TABLE IF EXISTS `set_user_rgroup`;
CREATE TABLE `set_user_rgroup` (
  `USER_ID` int(11) NOT NULL DEFAULT '0',
  `RGROUP_ID` int(11) NOT NULL DEFAULT '0',
  `LAST_UPDATOR` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL,
  `LAST_UPDATE_TIME` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`USER_ID`,`RGROUP_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of set_user_rgroup
-- ----------------------------
