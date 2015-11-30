/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50621
Source Host           : localhost:3306
Source Database       : shiro

Target Server Type    : MYSQL
Target Server Version : 50621
File Encoding         : 65001

Date: 2015-11-30 17:15:27
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `sample_city`
-- ----------------------------
DROP TABLE IF EXISTS `sample_city`;
CREATE TABLE `sample_city` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `CITY_NAME` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL,
  `PARENT_CITY` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of sample_city
-- ----------------------------
INSERT INTO sample_city VALUES ('1', '江西', null);
INSERT INTO sample_city VALUES ('2', '江苏', null);
INSERT INTO sample_city VALUES ('3', '浙江', null);
INSERT INTO sample_city VALUES ('11', '南昌', '1');
INSERT INTO sample_city VALUES ('12', '九江', '1');
INSERT INTO sample_city VALUES ('21', '南京', '2');
INSERT INTO sample_city VALUES ('22', '无锡', '2');
INSERT INTO sample_city VALUES ('31', '杭州', '3');
INSERT INTO sample_city VALUES ('32', '宁波', '3');
