/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50621
Source Host           : localhost:3306
Source Database       : shiro

Target Server Type    : MYSQL
Target Server Version : 50621
File Encoding         : 65001

Date: 2015-11-04 14:36:37
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `set_func_role`
-- ----------------------------
DROP TABLE IF EXISTS `set_func_role`;
CREATE TABLE `set_func_role` (
  `FUNC_ROLE_ID` int(11) NOT NULL DEFAULT '0',
  `FUNC_ROLE_CODE` varchar(64) COLLATE utf8_unicode_ci DEFAULT NULL,
  `FUNC_ROLE_NAME` varchar(128) COLLATE utf8_unicode_ci DEFAULT NULL,
  `FUNC_ROLE_TYPE` varchar(12) COLLATE utf8_unicode_ci DEFAULT NULL,
  `FUNC_ROLE_DESC` varchar(512) COLLATE utf8_unicode_ci DEFAULT NULL,
  `STATUS` char(255) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '0-禁用，1-启用',
  `LAST_UPDATOR` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL,
  `LAST_UPDATE_TIME` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`FUNC_ROLE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of set_func_role
-- ----------------------------
INSERT INTO SET_FUNC_ROLE VALUES ('40000', null, '高阶操作员', null, null, '1', null, null);
