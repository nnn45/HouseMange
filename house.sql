/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 80030
 Source Host           : localhost:3306
 Source Schema         : mydemo

 Target Server Type    : MySQL
 Target Server Version : 80030
 File Encoding         : 65001

 Date: 22/12/2023 04:13:43
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for house
-- ----------------------------
DROP TABLE IF EXISTS `house`;
CREATE TABLE `house`  (
  `houseId` int(0) NOT NULL AUTO_INCREMENT,
  `houseName` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `houseTypeid` int(0) NOT NULL,
  `address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `area` int(0) NULL DEFAULT NULL,
  `price` int(0) NULL DEFAULT NULL,
  `houseDesc` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`houseId`) USING BTREE,
  INDEX `house_ibfk_1`(`houseTypeid`) USING BTREE,
  CONSTRAINT `house_ibfk_1` FOREIGN KEY (`houseTypeid`) REFERENCES `housetype` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of house
-- ----------------------------
INSERT INTO `house` VALUES (4, '房屋1', 1, '江苏省南京市江宁区金陵科技学院', 120, 1350000, '三室一厅，坐北朝南。');
INSERT INTO `house` VALUES (5, 'Test01', 6, 'ssss', 666, 888, 'ssssssss');
INSERT INTO `house` VALUES (6, 'Test002', 12, '555', 55, 555, '5555');
INSERT INTO `house` VALUES (7, 'test', 1, 'ssssss', 55, 55, '55');

-- ----------------------------
-- Table structure for housetype
-- ----------------------------
DROP TABLE IF EXISTS `housetype`;
CREATE TABLE `housetype`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `houseTypeName` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `houseTypeDesc` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of housetype
-- ----------------------------
INSERT INTO `housetype` VALUES (1, '商品房', '指具有经营资格的房地产开发公司开发经营的住宅，商品房从法律角度来分析，能够按法律、法规及有关规定在市场上自由交易，不受政府政策限制');
INSERT INTO `housetype` VALUES (2, '经济适用房', '是国家为解决中低收人家的住房问题而修建的普通住房，这类住宅因减免了工程报建中的部分费用，其成本略低于普通商品房，故称为经济适用房。这一具有社会保障性质的住宅，兼具经济性和实用性的特点');
INSERT INTO `housetype` VALUES (3, '军产房', '指军队享有房屋所有权(即产权)的房屋 。这类房产土地是由国家专门划拨的军事用地，由部队盖建，并且只分配给所属部队的军人使用');
INSERT INTO `housetype` VALUES (4, '公房', '也称公有住房，是指由国家以及国有企业、事业单位投资兴建、销售的住房。在住房未出售之前，住房的产权由国家及产权单位所有，发展到现在常见的是单位集资房');
INSERT INTO `housetype` VALUES (5, '小产权房', '按产权证的发证机关来区分，国家发产权证的叫大产权，国家不发产权证的，由乡镇政府发证书的叫小产权，又被称为乡产权');
INSERT INTO `housetype` VALUES (6, '公租房', '即公共租赁房，是解决新就业职工等夹心层群体住房困难的一个产品。公共租赁住房不是归个人所有，而是由政府或公共机构所有，用低于市场价或者承租者承受起的价格，向新就业职工出租，包括一些新的大学毕业生，还有一些从外地迁移到城市工作的群体');
INSERT INTO `housetype` VALUES (7, '廉租房', '指政府以租金补贴或实物配租的方式，向符合城镇居民最低生活保障标准且住房困难的家庭提供社会保障性质的住房。廉租房的分配形式以租金补贴为主，实物配租和租金减免为辅');
INSERT INTO `housetype` VALUES (8, '安置房', '是政府进行城市道路建设和其他公共设施建设项目时，对被拆迁住户进行安置所建的房屋。安置的对象是城市居民被拆迁户,也包括征拆迁房屋的农户。随着城市建设发展步伐的进一步加快，政府尽可能新建更多的安置房，不断满足拆迁户的需求已迫在眉睫');
INSERT INTO `housetype` VALUES (9, '私房', '称私有住宅、私产住宅。它由个人或家庭购买建造的住宅。在农村，农民的住宅基本上是自建私有住宅。公有住房通过住宅消费市场出售给个人和家庭，也转为私有住宅');
INSERT INTO `housetype` VALUES (12, 'Test011', 'ssss');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `user_id` int(0) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `password` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `role` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT 'user',
  PRIMARY KEY (`user_id`) USING BTREE,
  UNIQUE INDEX `username`(`username`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'user1', 'pwd1', 'user');
INSERT INTO `user` VALUES (2, 'user2', 'pwd2', 'user');
INSERT INTO `user` VALUES (3, 'admin', 'pwd', 'admin');

SET FOREIGN_KEY_CHECKS = 1;
