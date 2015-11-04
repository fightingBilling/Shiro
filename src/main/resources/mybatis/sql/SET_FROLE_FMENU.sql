/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50621
Source Host           : localhost:3306
Source Database       : shiro

Target Server Type    : MYSQL
Target Server Version : 50621
File Encoding         : 65001

Date: 2015-11-04 14:36:25
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `set_frole_fmenu`
-- ----------------------------
DROP TABLE IF EXISTS `set_frole_fmenu`;
CREATE TABLE `set_frole_fmenu` (
  `FUNC_ROLE_ID` int(11) NOT NULL DEFAULT '0',
  `FUNC_MENU_ID` int(11) NOT NULL DEFAULT '0',
  `LAST_UPDATOR` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL,
  `LAST_UPDATE_TIME` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`FUNC_ROLE_ID`,`FUNC_MENU_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of set_frole_fmenu
-- ----------------------------
