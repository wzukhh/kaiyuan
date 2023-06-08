
SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for ky_admin
-- ----------------------------
DROP TABLE IF EXISTS `ky_admin`;
CREATE TABLE `ky_admin`  (
  `admin_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '管理员ID',
  `admin_type` tinyint(4) NOT NULL COMMENT '管理员类型，0:超级管理员，1:操作管理员，2:普通管理员',
  `username` varchar(8) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名',
  `password` varchar(8) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '登录密码',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `use_password` tinyint(1) NOT NULL COMMENT '是否使用密码，0:使用，1:不使用',
  `valid` tinyint(1) NOT NULL DEFAULT 0 COMMENT '是否有效，0:有效，1:无效',
  PRIMARY KEY (`admin_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of ky_admin
-- ----------------------------

-- ----------------------------
-- Table structure for ky_order
-- ----------------------------
DROP TABLE IF EXISTS `ky_order`;
CREATE TABLE `ky_order`  (
  `order_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '订单ID',
  `status` tinyint(4) NOT NULL COMMENT '订单状态，0:待加工，1:待发货，2:已发货，3:待收款，4:已收款',
  `user_id` int(11) NOT NULL COMMENT '客户ID',
  `product_id` int(11) NOT NULL COMMENT '产品类型',
  `product_name` varchar(70) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '产品名称',
  `amount` int(11) NOT NULL COMMENT '订单金额（分）',
  `mount` int(11) NOT NULL COMMENT '份数',
  `length` int(11) NULL DEFAULT NULL COMMENT '材料的长（厘米）',
  `width` int(11) NULL DEFAULT NULL COMMENT '材料的宽（厘米）',
  `area` int(11) NULL DEFAULT NULL COMMENT '材料面积（平方厘米）',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `valid` tinyint(4) NOT NULL DEFAULT 0 COMMENT '是否有效，0:有效，1:无效',
  PRIMARY KEY (`order_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of ky_order
-- ----------------------------

-- ----------------------------
-- Table structure for ky_product
-- ----------------------------
DROP TABLE IF EXISTS `ky_product`;
CREATE TABLE `ky_product`  (
  `product_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '广告产品ID',
  `product_name` varchar(70) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '广告产品名称',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `valid` tinyint(4) NOT NULL DEFAULT 0 COMMENT '是否有效，0:有效，1:无效',
  PRIMARY KEY (`product_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of ky_product
-- ----------------------------

-- ----------------------------
-- Table structure for ky_user
-- ----------------------------
DROP TABLE IF EXISTS `ky_user`;
CREATE TABLE `ky_user`  (
  `user_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '客户ID',
  `user_name` varchar(70) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '客户名称',
  `contact` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '联系方式',
  `contact_type` tinyint(1) NOT NULL COMMENT '联系方式类型，0:手机号，1:QQ号，2:邮箱',
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '客户地址',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '修改时间',
  `valid` tinyint(1) NOT NULL DEFAULT 0 COMMENT '是否有效，0:有效，1:无效',
  PRIMARY KEY (`user_id`) USING BTREE,
  INDEX `普通索引`(`contact`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of ky_user
-- ----------------------------

SET FOREIGN_KEY_CHECKS = 1;
