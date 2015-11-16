/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50621
Source Host           : localhost:3306
Source Database       : shiro

Target Server Type    : MYSQL
Target Server Version : 50621
File Encoding         : 65001

Date: 2015-11-05 18:24:07
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `set_rgroup_frole`
-- ----------------------------
DROP TABLE IF EXISTS `set_rgroup_frole`;
CREATE TABLE `set_rgroup_frole` (
  `RGROUP_ID` int(11) NOT NULL DEFAULT '0',
  `FUNC_ROLE_ID` int(11) NOT NULL DEFAULT '0',
  `LAST_UPDATOR` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL,
  `LAST_UPDATE_TIME` datetime DEFAULT NULL,
  PRIMARY KEY (`RGROUP_ID`,`FUNC_ROLE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of set_rgroup_frole
-- ----------------------------
INSERT INTO set_rgroup_frole VALUES ('10048', '10038', null, null);
