/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50621
Source Host           : localhost:3306
Source Database       : shiro

Target Server Type    : MYSQL
Target Server Version : 50621
File Encoding         : 65001

Date: 2015-11-05 18:24:20
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
  `LAST_UPDATE_TIME` datetime DEFAULT NULL,
  PRIMARY KEY (`RESOURCE_ROLE_ID`,`RESOURCE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of set_rrole_resource
-- ----------------------------
INSERT INTO set_rrole_resource VALUES ('10046', '100', null, null);
INSERT INTO set_rrole_resource VALUES ('10046', '992', null, null);
INSERT INTO set_rrole_resource VALUES ('10046', '993', null, null);
INSERT INTO set_rrole_resource VALUES ('10046', '994', null, null);
INSERT INTO set_rrole_resource VALUES ('10046', '995', null, null);
INSERT INTO set_rrole_resource VALUES ('10046', '996', null, null);
INSERT INTO set_rrole_resource VALUES ('10046', '997', null, null);
INSERT INTO set_rrole_resource VALUES ('10046', '998', null, null);
INSERT INTO set_rrole_resource VALUES ('10046', '999', null, null);
