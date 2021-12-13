/*
 Navicat MySQL Data Transfer

 Source Server         : lulongjian
 Source Server Type    : MySQL
 Source Server Version : 50730
 Source Host           : 192.168.228.201:3306
 Source Schema         : club

 Target Server Type    : MySQL
 Target Server Version : 50730
 File Encoding         : 65001

 Date: 15/06/2021 22:33:16
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for sys_notice
-- ----------------------------
DROP TABLE IF EXISTS `sys_notice`;
CREATE TABLE `sys_notice`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `title` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '标题',
  `content` varchar(2550) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '内容',
  `publish` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'publish',
  `crt_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_notice
-- ----------------------------
INSERT INTO `sys_notice` VALUES (2, '谢谢', 'undefined', '1', '2021-06-15 22:01:58');
INSERT INTO `sys_notice` VALUES (3, '新学新', '施工工地上', '1', '2021-06-15 22:05:59');
INSERT INTO `sys_notice` VALUES (4, 'v在v在v发撒烦烦烦烦烦烦方法', 'v甚至v在v', '1', '2021-06-15 22:06:04');
INSERT INTO `sys_notice` VALUES (5, '是否', '算法啊啊啊算法啊啊啊算法啊啊啊算法啊啊啊算法啊啊啊算法啊啊啊算法啊啊啊算法啊啊啊算法啊啊啊算法啊啊啊算法啊啊啊算法啊啊啊算法啊啊啊算法啊啊啊算法啊啊啊算法啊啊啊算法啊啊啊算法啊啊啊算法啊啊啊算法啊啊啊算法啊啊啊算法啊啊啊算法啊啊啊算法啊啊啊算法啊啊啊算法啊啊啊算法啊啊啊算法啊啊啊算法啊啊啊算法啊啊啊算法啊啊啊算法啊啊啊算法啊啊啊算法啊啊啊算法啊啊啊算法啊啊啊算法啊啊啊算法啊啊啊算法啊啊啊算法啊啊啊算法啊啊啊算法啊啊啊算法啊啊啊算法啊啊啊算法啊啊啊算法啊啊啊算法啊啊啊算法啊啊啊算法啊啊啊算法啊啊啊算法啊啊啊算法啊啊啊算法啊啊啊算法啊啊啊算法啊啊啊算法啊啊啊算法啊啊啊算法啊啊啊算法啊啊啊算法啊啊啊算法啊啊啊算法啊啊啊算法啊啊啊算法啊啊啊算法啊啊啊算法啊啊啊算法啊啊啊算法啊啊啊算法啊啊啊算法啊啊啊算法啊啊啊算法啊啊啊算法啊啊啊算法啊啊啊算法啊啊啊算法啊啊啊算法啊啊啊算法啊啊啊算法啊啊啊算法啊啊啊算法啊啊啊', '1', '2021-06-15 22:11:31');

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '姓名',
  `password` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',
  `flag` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '标识位，1：管理员，2：学生',
  `addr` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '宿舍地址',
  `college` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '学院',
  `stude_class` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '班级',
  `phone` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '手机',
  `no` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '学号',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES (1, 'admin', '123456', '1', NULL, NULL, NULL, NULL, 'admin');
INSERT INTO `sys_user` VALUES (2, 'adminwww', '123456', '2', '4342', '1111', 'rqwr', '432424423', '1111');
INSERT INTO `sys_user` VALUES (3, '飞洒发', 'fsafasf', '2', 'fasfasf', 'faf', 'fasfsa', 'fasfsaf', '方式发布');
INSERT INTO `sys_user` VALUES (4, 'adminfsafsaf', '123456', '2', 'fsafasf', 'fasfasf', 'fsafsaf', 'fsafasf', 'fsafsaf');
INSERT INTO `sys_user` VALUES (5, 'adminvxzvxzv', '123456', '2', 'fqwfqw', 'fasafaf', 'fwqfwf', 'fwqfqwf', 'vzvz');

SET FOREIGN_KEY_CHECKS = 1;
