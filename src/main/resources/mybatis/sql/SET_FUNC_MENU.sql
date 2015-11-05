/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50621
Source Host           : localhost:3306
Source Database       : shiro

Target Server Type    : MYSQL
Target Server Version : 50621
File Encoding         : 65001

Date: 2015-11-05 18:23:49
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `set_func_menu`
-- ----------------------------
DROP TABLE IF EXISTS `set_func_menu`;
CREATE TABLE `set_func_menu` (
  `MENU_ID` int(11) NOT NULL DEFAULT '0',
  `PMENU_ID` int(11) DEFAULT NULL,
  `MENU_CODE` varchar(64) COLLATE utf8_unicode_ci DEFAULT NULL,
  `MENU_NAME` varchar(128) COLLATE utf8_unicode_ci DEFAULT NULL,
  `MENU_NAME_BRIEF` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL,
  `IS_LEAF` char(1) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '0-非叶子菜单，1-叶子菜单',
  `LV` int(11) DEFAULT NULL,
  `URL` varchar(128) COLLATE utf8_unicode_ci DEFAULT NULL,
  `DISPLAY_ORDER` int(11) DEFAULT NULL,
  `STATUS` char(1) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '0-无效，1-有效',
  `LAST_UPDATOR` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL,
  `LAST_UPDATE_TIME` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`MENU_ID`),
  UNIQUE KEY `URL` (`URL`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of set_func_menu
-- ----------------------------
INSERT INTO set_func_menu VALUES ('10050', '-1', '10050', '后台管理', null, '0', '1', null, '400000', '1', null, null);
INSERT INTO set_func_menu VALUES ('10051', '10050', '10050-10051', '用户维护', null, '1', '2', '/mt/user/user_read.html?opt=s7000', '400100', '1', null, null);
INSERT INTO set_func_menu VALUES ('10052', '10050', '10050-10052', '角色组维护', null, '1', '2', '/mt/rgroup/rgroup_read.html?opt=s5000', '400200', '1', null, null);
INSERT INTO set_func_menu VALUES ('10053', '10050', '10050-10053', '角色维护', null, '0', '2', null, '400300', '1', null, null);
INSERT INTO set_func_menu VALUES ('10054', '10050', '10050-10054', '资源维护', null, '1', '2', '/mt/resource/resource_read.html?opt=s2000', '400400', '1', null, null);
INSERT INTO set_func_menu VALUES ('10055', '10050', '10050-10055', '菜单维护', null, '1', '2', '/mt/menu/menu_read.html?opt=s3000', '400500', '1', null, null);
INSERT INTO set_func_menu VALUES ('10056', '10053', '10050-10053-10056', '功能角色维护', null, '1', '3', '/mt/role/role_menu_read.html?opt=s4000', '400320', '1', null, null);
INSERT INTO set_func_menu VALUES ('10057', '10053', '10050-10053-10057', '资源角色维护', null, '1', '3', '/mt/role/role_resource_read.html?opt=s6000', '400310', '1', null, null);
