/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50621
Source Host           : localhost:3306
Source Database       : shiro

Target Server Type    : MYSQL
Target Server Version : 50621
File Encoding         : 65001

Date: 2015-11-04 14:36:42
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `set_resource`
-- ----------------------------
DROP TABLE IF EXISTS `set_resource`;
CREATE TABLE `set_resource` (
  `RESOURCE_ID` int(11) NOT NULL DEFAULT '0',
  `SECURITY_FILTER` varchar(15) COLLATE utf8_unicode_ci DEFAULT NULL,
  `URL_PATTERN` varchar(384) COLLATE utf8_unicode_ci DEFAULT NULL,
  `STATUS` char(255) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '0-禁用，1-启用',
  `LAST_UPDATOR` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL,
  `LAST_UPDATE_TIME` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`RESOURCE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of set_resource
-- ----------------------------
INSERT INTO SET_RESOURCE VALUES ('992', 'cAuthc', '/mt/rgroup/rgroup_read.html', '1', null, null);
INSERT INTO SET_RESOURCE VALUES ('993', 'cAuthc', '/mt/user/user_read.html', '1', null, null);
INSERT INTO SET_RESOURCE VALUES ('994', 'cAuthc', '/mt/role/role_resource_read.html', '1', null, null);
INSERT INTO SET_RESOURCE VALUES ('995', 'cAuthc', '/mt/role/role_menu_read.html', '1', null, null);
INSERT INTO SET_RESOURCE VALUES ('996', 'cAuthc', '/mt/resource/resource_read.html', '1', null, null);
INSERT INTO SET_RESOURCE VALUES ('997', 'cAuthc', '/mt/menu/menu_read.html', '1', null, null);
INSERT INTO SET_RESOURCE VALUES ('999', 'cAuthc', '/default.html', '1', null, null);