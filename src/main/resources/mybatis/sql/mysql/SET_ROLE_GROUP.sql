/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50621
Source Host           : localhost:3306
Source Database       : shiro

Target Server Type    : MYSQL
Target Server Version : 50621
File Encoding         : 65001

Date: 2015-11-05 18:24:16
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `set_role_group`
-- ----------------------------
DROP TABLE IF EXISTS `set_role_group`;
CREATE TABLE `set_role_group` (
  `RGROUP_ID` int(11) NOT NULL DEFAULT '0',
  `RGROUP_CODE` varchar(64) COLLATE utf8_unicode_ci DEFAULT NULL,
  `RGROUP_NAME` varchar(128) COLLATE utf8_unicode_ci NOT NULL,
  `LAST_UPDATOR` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL,
  `LAST_UPDATE_TIME` datetime DEFAULT NULL,
  PRIMARY KEY (`RGROUP_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of set_role_group
-- ----------------------------
INSERT INTO set_role_group VALUES ('10048', null, '后台管理角色组', null, null);
