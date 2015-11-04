/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50621
Source Host           : localhost:3306
Source Database       : shiro

Target Server Type    : MYSQL
Target Server Version : 50621
File Encoding         : 65001

Date: 2015-11-04 14:37:06
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `set_rrole_resource`
-- ----------------------------
DROP TABLE IF EXISTS `set_rrole_resource`;
CREATE TABLE `set_rrole_resource` (
  `RESOURCE_ROLE_ID` int(11) NOT NULL DEFAULT '0',
  `RESOURCE_ID` int(11) NOT NULL DEFAULT '0',
  `LAST_UPDATOR` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL,
  `LAST_UPDATE_TIME` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`RESOURCE_ROLE_ID`,`RESOURCE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of set_rrole_resource
-- ----------------------------
