/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50621
Source Host           : localhost:3306
Source Database       : shiro

Target Server Type    : MYSQL
Target Server Version : 50621
File Encoding         : 65001

Date: 2015-11-05 18:24:12
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `set_rgroup_rrole`
-- ----------------------------
DROP TABLE IF EXISTS `set_rgroup_rrole`;
CREATE TABLE `set_rgroup_rrole` (
  `RGROUP_ID` int(11) NOT NULL DEFAULT '0',
  `RESOURCE_ROLE_ID` int(11) NOT NULL DEFAULT '0',
  `LAST_UPDATOR` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL,
  `LAST_UPDATE_TIME` datetime DEFAULT NULL,
  PRIMARY KEY (`RGROUP_ID`,`RESOURCE_ROLE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of set_rgroup_rrole
-- ----------------------------
INSERT INTO set_rgroup_rrole VALUES ('10048', '10046', null, null);
