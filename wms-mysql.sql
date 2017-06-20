/*
Navicat MySQL Data Transfer

Source Server         : MySQL
Source Server Version : 50713
Source Host           : localhost:3306
Source Database       : wms

Target Server Type    : MYSQL
Target Server Version : 50713
File Encoding         : 65001

Date: 2017-06-20 23:35:48
*/

USE wms;
SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for wms_category
-- ----------------------------
DROP TABLE IF EXISTS `wms_category`;
CREATE TABLE `wms_category` (
  `category_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `category_name` varchar(255) NOT NULL,
  `category_parent` int(10) unsigned DEFAULT NULL,
  PRIMARY KEY (`category_id`),
  KEY `category_parent` (`category_parent`),
  CONSTRAINT `wms_category_ibfk_1` FOREIGN KEY (`category_parent`) REFERENCES `wms_category` (`category_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=47 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of wms_category
-- ----------------------------
INSERT INTO `wms_category` VALUES ('1', '危化品', null);
INSERT INTO `wms_category` VALUES ('2', '食品', null);
INSERT INTO `wms_category` VALUES ('3', '日用品', null);
INSERT INTO `wms_category` VALUES ('4', '电子设备', null);
INSERT INTO `wms_category` VALUES ('5', '医药品', null);
INSERT INTO `wms_category` VALUES ('6', '爆炸品', '1');
INSERT INTO `wms_category` VALUES ('7', '压缩气体和液化气体', '1');
INSERT INTO `wms_category` VALUES ('8', '易燃液体', '1');
INSERT INTO `wms_category` VALUES ('9', '易燃固体和自燃物品', '1');
INSERT INTO `wms_category` VALUES ('10', '氧化剂和有机过氧化物', '1');
INSERT INTO `wms_category` VALUES ('11', '毒害品和感染性物品', '1');
INSERT INTO `wms_category` VALUES ('12', '放射性物品', '1');
INSERT INTO `wms_category` VALUES ('13', '腐蚀品', '1');
INSERT INTO `wms_category` VALUES ('14', '糖果/巧克力', '2');
INSERT INTO `wms_category` VALUES ('15', '饮料/水', '2');
INSERT INTO `wms_category` VALUES ('16', '肉类/豆制品零食', '2');
INSERT INTO `wms_category` VALUES ('17', '饼干糕点', '2');
INSERT INTO `wms_category` VALUES ('18', '冲调保健', '2');
INSERT INTO `wms_category` VALUES ('19', '酒类', '2');
INSERT INTO `wms_category` VALUES ('20', '牛奶乳品', '2');
INSERT INTO `wms_category` VALUES ('21', '坚果炒货', '2');
INSERT INTO `wms_category` VALUES ('22', '蜜饯果干', '2');
INSERT INTO `wms_category` VALUES ('23', '厨卫用品', '3');
INSERT INTO `wms_category` VALUES ('24', '收纳用品', '3');
INSERT INTO `wms_category` VALUES ('25', '洗护用品', '3');
INSERT INTO `wms_category` VALUES ('26', '文具', '3');
INSERT INTO `wms_category` VALUES ('27', '体育用品', '3');
INSERT INTO `wms_category` VALUES ('28', '五金', '3');
INSERT INTO `wms_category` VALUES ('29', '箱包', '3');
INSERT INTO `wms_category` VALUES ('30', '电脑/笔记本', '4');
INSERT INTO `wms_category` VALUES ('31', '手机/平板', '4');
INSERT INTO `wms_category` VALUES ('32', '智能家居', '4');
INSERT INTO `wms_category` VALUES ('33', '电脑耗材/手机周边', '4');
INSERT INTO `wms_category` VALUES ('34', '线材/插线板', '4');
INSERT INTO `wms_category` VALUES ('35', '家电', '4');
INSERT INTO `wms_category` VALUES ('36', '打印机/扫描仪', '4');
INSERT INTO `wms_category` VALUES ('37', '音箱/耳机', '4');
INSERT INTO `wms_category` VALUES ('38', '感冒用药', '5');
INSERT INTO `wms_category` VALUES ('39', '肠胃用药', '5');
INSERT INTO `wms_category` VALUES ('40', '五官用药', '5');
INSERT INTO `wms_category` VALUES ('41', '皮肤用药', '5');
INSERT INTO `wms_category` VALUES ('42', '妇科用药', '5');
INSERT INTO `wms_category` VALUES ('43', '小儿用药', '5');
INSERT INTO `wms_category` VALUES ('44', '维钙保健', '5');
INSERT INTO `wms_category` VALUES ('45', '医药用品', '5');
INSERT INTO `wms_category` VALUES ('46', '美颜瘦身', '5');

-- ----------------------------
-- Table structure for wms_condition
-- ----------------------------
DROP TABLE IF EXISTS `wms_condition`;
CREATE TABLE `wms_condition` (
  `condition_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `condition_desciption` varchar(255) NOT NULL,
  PRIMARY KEY (`condition_id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of wms_condition
-- ----------------------------
INSERT INTO `wms_condition` VALUES ('1', '通风');
INSERT INTO `wms_condition` VALUES ('2', '干燥');
INSERT INTO `wms_condition` VALUES ('3', '阴凉');
INSERT INTO `wms_condition` VALUES ('4', '避光');
INSERT INTO `wms_condition` VALUES ('5', '冷藏');
INSERT INTO `wms_condition` VALUES ('6', '不可堆叠');
INSERT INTO `wms_condition` VALUES ('7', '防火');
INSERT INTO `wms_condition` VALUES ('8', '防爆');
INSERT INTO `wms_condition` VALUES ('9', '隔绝空气');
INSERT INTO `wms_condition` VALUES ('10', '防尘');
INSERT INTO `wms_condition` VALUES ('11', '清洁');
INSERT INTO `wms_condition` VALUES ('12', '切勿倒置');
INSERT INTO `wms_condition` VALUES ('13', '切勿撞击');

-- ----------------------------
-- Table structure for wms_product
-- ----------------------------
DROP TABLE IF EXISTS `wms_product`;
CREATE TABLE `wms_product` (
  `product_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `product_name` varchar(255) NOT NULL,
  `product_code` varchar(255) NOT NULL,
  `product_category` int(10) unsigned NOT NULL,
  `product_supplier` varchar(255) DEFAULT NULL,
  `product_standard` varchar(255) DEFAULT NULL,
  `product_uint` varchar(255) DEFAULT NULL,
  `product_in_price` decimal(10,2) NOT NULL,
  `product_out_price` decimal(10,2) NOT NULL,
  `product_description` varchar(255) DEFAULT NULL,
  `product_image` varchar(255) NOT NULL DEFAULT 'no-image.png',
  PRIMARY KEY (`product_id`),
  KEY `product_category` (`product_category`),
  CONSTRAINT `wms_product_ibfk_1` FOREIGN KEY (`product_category`) REFERENCES `wms_category` (`category_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of wms_product
-- ----------------------------
INSERT INTO `wms_product` VALUES ('1', '德芙巧克力', 'wms-dfqkl-000001', '14', '玛氏公司', 'EQ2080', '块', '8.00', '14.20', '德芙是世界最大宠物食品和休闲食品制造商美国跨国食品公司玛氏（Mars）公司在中国推出的系列产品。', 'wms-dfqkl-000001.jpg');
INSERT INTO `wms_product` VALUES ('2', '可口可乐', 'wms-kkkl-000001', '15', '可口可乐公司', 'EQ2341', '瓶', '1.25', '3.00', '可口可乐在美国乔治亚州亚特兰大市诞生，自此便与社会发展相互交融，激发创新灵感。现在，它每天为全球的人们带来怡神畅快的美妙感受。', 'wms-kkkl-000001.jpg');

-- ----------------------------
-- Table structure for wms_product_condition
-- ----------------------------
DROP TABLE IF EXISTS `wms_product_condition`;
CREATE TABLE `wms_product_condition` (
  `product_condition_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `product_id` int(10) unsigned NOT NULL,
  `condition_id` int(10) unsigned NOT NULL,
  PRIMARY KEY (`product_condition_id`),
  KEY `product_id` (`product_id`),
  KEY `condition_id` (`condition_id`),
  CONSTRAINT `wms_product_condition_ibfk_1` FOREIGN KEY (`product_id`) REFERENCES `wms_product` (`product_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `wms_product_condition_ibfk_2` FOREIGN KEY (`condition_id`) REFERENCES `wms_condition` (`condition_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of wms_product_condition
-- ----------------------------
INSERT INTO `wms_product_condition` VALUES ('1', '1', '2');
INSERT INTO `wms_product_condition` VALUES ('2', '1', '3');
INSERT INTO `wms_product_condition` VALUES ('3', '1', '13');
INSERT INTO `wms_product_condition` VALUES ('4', '2', '4');
INSERT INTO `wms_product_condition` VALUES ('5', '2', '3');
INSERT INTO `wms_product_condition` VALUES ('6', '2', '7');

-- ----------------------------
-- Table structure for wms_user
-- ----------------------------
DROP TABLE IF EXISTS `wms_user`;
CREATE TABLE `wms_user` (
  `user_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `user_name` varchar(255) NOT NULL,
  `user_pswd` varchar(255) NOT NULL,
  `user_type` int(10) unsigned NOT NULL,
  `user_email` varchar(255) DEFAULT NULL,
  `user_cellphone` varchar(255) DEFAULT NULL,
  `user_address` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  KEY `user_type` (`user_type`),
  CONSTRAINT `wms_user_ibfk_1` FOREIGN KEY (`user_type`) REFERENCES `wms_user_type` (`user_type_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of wms_user
-- ----------------------------
INSERT INTO `wms_user` VALUES ('1', 'sanalar', 'e10adc3949ba59abbe56e057f20f883e', '1', 'sanalar@163.com', '1234567890', '中国农业大学东校区');

-- ----------------------------
-- Table structure for wms_user_type
-- ----------------------------
DROP TABLE IF EXISTS `wms_user_type`;
CREATE TABLE `wms_user_type` (
  `user_type_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `user_type_name` varchar(255) NOT NULL,
  PRIMARY KEY (`user_type_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of wms_user_type
-- ----------------------------
INSERT INTO `wms_user_type` VALUES ('1', '仓库总经理');
