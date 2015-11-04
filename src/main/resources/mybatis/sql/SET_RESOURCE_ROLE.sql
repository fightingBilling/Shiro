/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50621
Source Host           : localhost:3306
Source Database       : shiro

Target Server Type    : MYSQL
Target Server Version : 50621
File Encoding         : 65001

Date: 2015-11-04 14:36:47
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `set_resource_role`
-- ----------------------------
DROP TABLE IF EXISTS `set_resource_role`;
CREATE TABLE `set_resource_role` (
  `RESOURCE_ROLE_ID` int(11) NOT NULL DEFAULT '0',
  `RESOURCE_ROLE_CODE` varchar(64) COLLATE utf8_unicode_ci DEFAULT NULL,
  `RESOURCE_ROLE_NAME` varchar(128) COLLATE utf8_unicode_ci DEFAULT NULL,
  `RESOURCE_ROLE_TYPE` varchar(12) COLLATE utf8_unicode_ci DEFAULT NULL,
  `RESOURCE_ROLE_DESC` varchar(512) COLLATE utf8_unicode_ci DEFAULT NULL,
  `STATUS` char(255) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '0-禁用，1-启用',
  `LAST_UPDATOR` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL,
  `LAST_UPDATE_TIME` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`RESOURCE_ROLE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of set_resource_role
-- ----------------------------
