/*
Navicat MySQL Data Transfer

Source Server         : aaa
Source Server Version : 80022
Source Host           : localhost:3306
Source Database       : library

Target Server Type    : MYSQL
Target Server Version : 80022
File Encoding         : 65001

Date: 2021-01-16 13:07:26
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for maneger
-- ----------------------------
DROP TABLE IF EXISTS `maneger`;
CREATE TABLE `maneger` (
  `username` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `password` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `name` varchar(255) COLLATE utf8_bin DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of maneger
-- ----------------------------
INSERT INTO `maneger` VALUES ('root', 'root', 'root');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `uid` int unsigned NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '用户名',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '密码',
  `name` varchar(10) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '真实姓名',
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '201817416', 'yangkai', '杨凯');
INSERT INTO `user` VALUES ('2', '201817419', 'yk666', '张三');
INSERT INTO `user` VALUES ('3', '201817412', '123456', '小李');
INSERT INTO `user` VALUES ('6', '201817433', '123456', '小王');
INSERT INTO `user` VALUES ('7', '201817455', '09876', '王五');
INSERT INTO `user` VALUES ('9', '201817499', '123456', '李四');

-- ----------------------------
-- Table structure for user_books
-- ----------------------------
DROP TABLE IF EXISTS `user_books`;
CREATE TABLE `user_books` (
  `username` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `bookname` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `author` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `publisher` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `dingjia` decimal(6,2) DEFAULT NULL,
  `starttime` datetime DEFAULT NULL,
  `endtime` datetime DEFAULT NULL,
  `bookid` int NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`bookid`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of user_books
-- ----------------------------
INSERT INTO `user_books` VALUES ('201817419', '三体', '刘慈欣', '清华大学出版社', '33.30', '2021-01-02 19:32:59', '2021-01-02 19:33:03', '1');
INSERT INTO `user_books` VALUES ('201817416', 'Java程序设计', '黑马', '人民邮电出版社', '22.20', '2020-01-02 00:00:00', '2020-02-03 00:00:00', '2');
INSERT INTO `user_books` VALUES (null, '物联网导论', '刘云浩', '科学出版社', '11.10', '2020-03-04 00:00:00', '2020-09-10 00:00:00', '3');
INSERT INTO `user_books` VALUES ('201817416', '计算机操作系统', '汤晓丹', '西安电子出版社', '12.00', '2020-12-25 23:04:21', '2020-12-25 23:04:21', '4');
INSERT INTO `user_books` VALUES ('201817416', 'ES6标准入门', '栾一峰', '工信出版社', '67.00', '2021-01-02 14:25:22', '2021-01-02 14:25:22', '5');
INSERT INTO `user_books` VALUES (null, 'MySQL数据库', '黑马程序员', '清华大学出版社', '45.00', '2021-01-02 14:26:17', '2021-01-02 14:26:17', '6');
INSERT INTO `user_books` VALUES ('201817419', '微机原理与应用', '杨杰', '电子工业出版社', '34.00', '2020-08-04 00:00:00', '2020-10-09 00:00:00', '7');
INSERT INTO `user_books` VALUES ('201817419', '计算机组成原理', '白中英', '科学出版社', '89.00', '2020-09-10 00:00:00', '2020-11-11 00:00:00', '8');
INSERT INTO `user_books` VALUES (null, '高等数学', '上海交通大学', '科学出版社', '23.00', '2021-01-02 19:16:22', '2021-01-02 19:16:22', '9');
INSERT INTO `user_books` VALUES (null, '数据通信原理', '毛京丽', '北京邮电大学出版社', '45.00', '2021-01-02 18:16:21', '2021-01-02 18:16:21', '10');
INSERT INTO `user_books` VALUES (null, '计算机网络', '谢希仁', '电子工业出版社', '11.23', null, null, '11');
INSERT INTO `user_books` VALUES ('201817419', '网络技术实验', '华为', '人民邮电出版社', '22.30', null, null, '12');
INSERT INTO `user_books` VALUES (null, '无线通信网络与应用', '石明魏', '人民邮电出版社', '24.67', null, null, '13');
INSERT INTO `user_books` VALUES (null, '离散数学', '左小林', '上海出版社', '23.56', null, null, '14');
INSERT INTO `user_books` VALUES (null, '线性代数', '王天泽', '科学出版社', '12.11', null, null, '15');
INSERT INTO `user_books` VALUES (null, '电子电工技术', '陈新龙', '清华大学出版社', '29.99', null, null, '20');
