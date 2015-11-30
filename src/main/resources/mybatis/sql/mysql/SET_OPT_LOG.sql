/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50621
Source Host           : localhost:3306
Source Database       : shiro

Target Server Type    : MYSQL
Target Server Version : 50621
File Encoding         : 65001

Date: 2015-11-30 17:17:25
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `set_opt_log`
-- ----------------------------
DROP TABLE IF EXISTS `set_opt_log`;
CREATE TABLE `set_opt_log` (
  `LOG_ID` int(11) NOT NULL AUTO_INCREMENT,
  `OPT_USER_NAME` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL,
  `LOG_TYPE` int(11) DEFAULT NULL,
  `OPT_NAME` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL,
  `LOG_DESC` varchar(256) COLLATE utf8_unicode_ci DEFAULT NULL,
  `OPT_IP` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL,
  `STATUS` char(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `LAST_UPDATOR` varchar(32) COLLATE utf8_unicode_ci NOT NULL,
  `LAST_UPDATE_TIME` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP,
  `OPT_DATE` datetime NOT NULL,
  PRIMARY KEY (`LOG_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of set_opt_log
-- ----------------------------
INSERT INTO set_opt_log VALUES ('1', 'admin', '1', 'none', 'admin于2015-11-30 10:57:37 登录系统，耗时0.145秒', '0:0:0:0:0:0:0:1', '1', 'system', '2015-11-30 11:50:38', '2015-11-30 10:57:37');
INSERT INTO set_opt_log VALUES ('2', 'admin', '1', 'none', 'admin于2015-11-30 11:06:53 登录系统，耗时0.123秒', '0:0:0:0:0:0:0:1', '1', 'system', '2015-11-30 11:50:43', '2015-11-30 11:06:53');
INSERT INTO set_opt_log VALUES ('3', 'admin', '2', 'none', 'admin于2015-11-30 11:16:34 退出系统，耗时0.001秒', '0:0:0:0:0:0:0:1', '1', 'system', '2015-11-30 11:50:48', '2015-11-30 11:16:35');
INSERT INTO set_opt_log VALUES ('4', 'admin', '1', 'none', 'admin于2015-11-30 11:24:31 登录系统，耗时0.048秒', '0:0:0:0:0:0:0:1', '1', 'system', '2015-11-30 11:51:24', '2015-11-30 11:24:32');
INSERT INTO set_opt_log VALUES ('5', 'admin', '1', 'none', 'admin于2015-11-30 11:48:01 登录系统，耗时0.191秒', '0:0:0:0:0:0:0:1', '1', 'system', '2015-11-30 11:51:29', '2015-11-30 11:48:02');
INSERT INTO set_opt_log VALUES ('6', 'admin', '1', 'none', 'admin于2015-11-30 12:32:22 登录系统，耗时0.054秒', '0:0:0:0:0:0:0:1', '1', 'system', '2015-11-30 12:32:22', '2015-11-30 12:32:22');
INSERT INTO set_opt_log VALUES ('7', 'admin', '1', 'none', 'admin于2015-11-30 14:01:55 登录系统，耗时0.87秒', '0:0:0:0:0:0:0:1', '1', 'system', '2015-11-30 14:01:56', '2015-11-30 14:01:56');
INSERT INTO set_opt_log VALUES ('8', 'admin', '2', 'none', 'admin于2015-11-30 14:13:19 退出系统，耗时0.001秒', '0:0:0:0:0:0:0:1', '1', 'system', '2015-11-30 14:13:20', '2015-11-30 14:13:20');
INSERT INTO set_opt_log VALUES ('9', 'admin', '1', 'none', 'admin于2015-11-30 14:13:30 登录系统，耗时0.052秒', '0:0:0:0:0:0:0:1', '1', 'system', '2015-11-30 14:13:31', '2015-11-30 14:13:31');
INSERT INTO set_opt_log VALUES ('10', 'admin', '1', 'none', 'admin于2015-11-30 14:21:21 登录系统，耗时0.125秒', '0:0:0:0:0:0:0:1', '1', 'system', '2015-11-30 14:21:22', '2015-11-30 14:21:22');
INSERT INTO set_opt_log VALUES ('11', 'admin', '1', 'none', 'admin于2015-11-30 14:23:06 登录系统，耗时0.166秒', '0:0:0:0:0:0:0:1', '1', 'system', '2015-11-30 14:23:07', '2015-11-30 14:23:07');
INSERT INTO set_opt_log VALUES ('12', 'admin', '1', 'none', 'admin于2015-11-30 14:28:08 登录系统，耗时0.137秒', '0:0:0:0:0:0:0:1', '1', 'system', '2015-11-30 14:28:09', '2015-11-30 14:28:09');
INSERT INTO set_opt_log VALUES ('13', 'admin', '1', 'none', 'admin于2015-11-30 14:49:23 登录系统，耗时0.167秒', '0:0:0:0:0:0:0:1', '1', 'system', '2015-11-30 14:49:24', '2015-11-30 14:49:24');
INSERT INTO set_opt_log VALUES ('14', 'admin', '1', 'none', 'admin于2015-11-30 16:40:46 登录系统，耗时0.539秒', '127.0.0.1', '1', 'system', '2015-11-30 16:40:47', '2015-11-30 16:40:47');
