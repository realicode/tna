/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50628
Source Host           : localhost:3306
Source Database       : smarta

Target Server Type    : MYSQL
Target Server Version : 50628
File Encoding         : 65001

Date: 2016-03-15 06:15:26
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `sys_auth`
-- ----------------------------
DROP TABLE IF EXISTS `sys_auth`;
CREATE TABLE `sys_auth` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `ORGANIZATION_ID` bigint(20) DEFAULT NULL,
  `JOB_ID` bigint(20) DEFAULT NULL,
  `USER_ID` bigint(20) DEFAULT NULL,
  `GROUP_ID` bigint(20) DEFAULT NULL,
  `ROLE_IDS` varchar(500) DEFAULT NULL,
  `TYPE` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `idx_sys_auth_organization` (`ORGANIZATION_ID`),
  KEY `idx_sys_auth_job` (`JOB_ID`),
  KEY `idx_sys_auth_user` (`USER_ID`),
  KEY `idx_sys_auth_group` (`GROUP_ID`),
  KEY `idx_sys_auth_type` (`TYPE`)
) ENGINE=InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_auth
-- ----------------------------
INSERT INTO `sys_auth` VALUES ('1', '0', '0', '1', '0', '1', 'user');
INSERT INTO `sys_auth` VALUES ('2', '0', '0', '2', '0', '2', 'user');

-- ----------------------------
-- Table structure for `sys_group`
-- ----------------------------
DROP TABLE IF EXISTS `sys_group`;
CREATE TABLE `sys_group` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(100) DEFAULT NULL,
  `TYPE` varchar(50) DEFAULT NULL,
  `IS_SHOW` tinyint(1) DEFAULT NULL,
  `DEFAULT_GROUP` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `idx_sys_group_type` (`TYPE`),
  KEY `idx_sys_group_show` (`IS_SHOW`),
  KEY `idx_sys_group_default_group` (`DEFAULT_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_group
-- ----------------------------

-- ----------------------------
-- Table structure for `sys_job`
-- ----------------------------
DROP TABLE IF EXISTS `sys_job`;
CREATE TABLE `sys_job` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(100) DEFAULT NULL,
  `PARENT_ID` bigint(20) DEFAULT NULL,
  `PARENT_IDS` varchar(200) DEFAULT '',
  `ICON` varchar(200) DEFAULT NULL,
  `WEIGHT` int(11) DEFAULT NULL,
  `IS_SHOW` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `idx_sys_job_nam` (`NAME`),
  KEY `idx_sys_job_parent_id` (`PARENT_ID`),
  KEY `idx_sys_job_parent_ids_weight` (`PARENT_IDS`,`WEIGHT`)
) ENGINE=InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_job
-- ----------------------------
INSERT INTO `sys_job` VALUES ('1', '职务', '0', '0/', null, '1', '1');

-- ----------------------------
-- Table structure for `sys_organization`
-- ----------------------------
DROP TABLE IF EXISTS `sys_organization`;
CREATE TABLE `sys_organization` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(100) DEFAULT NULL,
  `TYPE` varchar(20) DEFAULT NULL,
  `PARENT_ID` bigint(20) DEFAULT NULL,
  `PARENT_IDS` varchar(200) DEFAULT '',
  `ICON` varchar(200) DEFAULT NULL,
  `WEIGHT` int(11) DEFAULT NULL,
  `IS_SHOW` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `idx_sys_organization_name` (`NAME`),
  KEY `idx_sys_organization_type` (`TYPE`),
  KEY `idx_sys_organization_parent_id` (`PARENT_ID`),
  KEY `idx_sys_organization_parent_ids_weight` (`PARENT_IDS`,`WEIGHT`)
) ENGINE=InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_organization
-- ----------------------------
INSERT INTO `sys_organization` VALUES ('1', '组织机构', null, '0', '0/', null, '1', '1');

-- ----------------------------
-- Table structure for `sys_permission`
-- ----------------------------
DROP TABLE IF EXISTS `sys_permission`;
CREATE TABLE `sys_permission` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(100) DEFAULT NULL,
  `PERMISSION` varchar(100) DEFAULT NULL,
  `DESCRIPTION` varchar(200) DEFAULT NULL,
  `IS_SHOW` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `idx_sys_permission_name` (`NAME`),
  KEY `idx_sys_permission_permission` (`PERMISSION`),
  KEY `idx_sys_permission_show` (`IS_SHOW`)
) ENGINE=InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_permission
-- ----------------------------
INSERT INTO `sys_permission` VALUES ('1', '所有', '*', '所有数据操作的权限', '1');
INSERT INTO `sys_permission` VALUES ('2', '新增', 'create', '新增数据操作的权限', '1');
INSERT INTO `sys_permission` VALUES ('3', '修改', 'update', '修改数据操作的权限', '1');
INSERT INTO `sys_permission` VALUES ('4', '删除', 'delete', '删除数据操作的权限', '1');
INSERT INTO `sys_permission` VALUES ('5', '查看', 'view', '查看数据操作的权限', '1');
INSERT INTO `sys_permission` VALUES ('6', '审核', 'audit', '审核数据操作的权限', '1');

-- ----------------------------
-- Table structure for `sys_resource`
-- ----------------------------
DROP TABLE IF EXISTS `sys_resource`;
CREATE TABLE `sys_resource` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(100) DEFAULT NULL,
  `TYPE` varchar(100) DEFAULT 'menu',
  `IDENTITY` varchar(100) DEFAULT NULL,
  `URI` varchar(200) DEFAULT NULL,
  `PARENT_ID` bigint(20) DEFAULT NULL,
  `PARENT_IDS` varchar(200) DEFAULT '',
  `ICON` varchar(200) DEFAULT NULL,
  `WEIGHT` int(11) DEFAULT NULL,
  `IS_SHOW` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `idx_sys_resource_name` (`NAME`),
  KEY `idx_sys_resource_identity` (`IDENTITY`),
  KEY `idx_sys_resource_user` (`URI`),
  KEY `idx_sys_resource_parent_id` (`PARENT_ID`),
  KEY `idx_sys_resource_parent_ids_weight` (`PARENT_IDS`,`WEIGHT`)
) ENGINE=InnoDB AUTO_INCREMENT=1024 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_resource
-- ----------------------------
INSERT INTO `sys_resource` VALUES ('0', 'a', 'menu', null, null, null, '', null, null, '0');
INSERT INTO `sys_resource` VALUES ('1', '资源鼻祖', 'menu', '', '', '0', '0/', null, '1', '1');
INSERT INTO `sys_resource` VALUES ('2', '系统管理', 'menu', 'sys:manage', '', '1', '0/1/', null, '100', '1');
INSERT INTO `sys_resource` VALUES ('3', '组织机构管理', 'menu', '', 'sys/resource/list', '2', '0/1/2/', null, '1', '1');
INSERT INTO `sys_resource` VALUES ('4', '角色管理', 'menu', 'user', 'sys/organization/list', '2', '0/1/2/', null, '10', '1');
INSERT INTO `sys_resource` VALUES ('5', '系统状态', 'menu', 'sys:audit', '', '1', '0/1/', null, '200', '1');
INSERT INTO `sys_resource` VALUES ('6', '应用中间件', 'menu', '', '', '5', '0/1/5/', null, '1', '1');
INSERT INTO `sys_resource` VALUES ('7', 'SpringBoot', 'menu', 'sys:audit:m:sp', '/xx/xxx', '6', '0/1/5/6', null, '1', '1');
INSERT INTO `sys_resource` VALUES ('8', '数据库相关', 'menu', 'user', '/admin/sys/user/main', '5', '0/1/5/', null, '1', '1');
INSERT INTO `sys_resource` VALUES ('9', '测试功能', 'fun', null, null, null, '', null, null, '1');
INSERT INTO `sys_resource` VALUES ('1001', '用户管理', 'menu', null, null, '2', '0/1/2', null, '30', '1');
INSERT INTO `sys_resource` VALUES ('1002', '管辖部门管理', 'menu', null, null, '2', '0/1/2', null, '40', '1');
INSERT INTO `sys_resource` VALUES ('1003', '日志管理', 'menu', null, null, '2', '0/1/2/', null, '50', '1');
INSERT INTO `sys_resource` VALUES ('1004', '企业用户管理', 'menu', null, null, '1001', '0/1/2/1001', null, '20', '1');
INSERT INTO `sys_resource` VALUES ('1005', '药监用户管理', 'menu', null, null, '1001', '0/1/2/1001', null, '10', '1');
INSERT INTO `sys_resource` VALUES ('1006', '企业信息管理', 'menu', null, null, '1', '0/1', null, '10', '1');
INSERT INTO `sys_resource` VALUES ('1007', '企业基本信息管理', 'menu', '', 'company/baseinfo', '1006', '0/1/1006', '', '10', '1');
INSERT INTO `sys_resource` VALUES ('1008', '企业经济信息', 'menu', null, null, '1006', '0/1/1006', null, '20', '1');
INSERT INTO `sys_resource` VALUES ('1009', '企业药品信息管理', 'menu', null, null, '1006', '0/1/1006', null, '30', '1');
INSERT INTO `sys_resource` VALUES ('1010', '药品基本信息管理', 'menu', null, null, '1009', '0/1/1006/1009', null, '10', '1');
INSERT INTO `sys_resource` VALUES ('1011', '药品成品信息管理', 'menu', null, 'drug/cpinfo', '1009', '0/1/1006/1009', null, '20', '1');
INSERT INTO `sys_resource` VALUES ('1012', '现场检查信息管理', 'menu', null, null, '1', '0/1', null, '20', '1');
INSERT INTO `sys_resource` VALUES ('1013', '检查项元数据管理', 'menu', null, null, '1012', '0/1/1012', null, '1', '1');
INSERT INTO `sys_resource` VALUES ('1014', '检查任务管理', 'menu', null, null, '1012', '0/1/1012', null, '20', '1');
INSERT INTO `sys_resource` VALUES ('1015', '检查报告管理', 'menu', null, null, '1012', '0/1/1012', null, '30', '1');
INSERT INTO `sys_resource` VALUES ('1016', '风险管理', 'menu', null, null, '1', '0/1', null, '40', '1');
INSERT INTO `sys_resource` VALUES ('1017', '数据统计报表', 'menu', null, null, '1', '0/1', null, '50', '1');
INSERT INTO `sys_resource` VALUES ('1018', '药品信息统计', 'menu', null, null, '1017', '0/1/1017', null, '10', '1');
INSERT INTO `sys_resource` VALUES ('1019', '企业信息统计', 'menu', null, null, '1017', '0/1/1017', null, '20', '1');
INSERT INTO `sys_resource` VALUES ('1020', '质量风险研判', 'menu', null, null, '1016', '0/1/1016', null, '10', '1');
INSERT INTO `sys_resource` VALUES ('1021', '我的工作台', 'menu', null, null, '1', '0/1', null, '9', '1');
INSERT INTO `sys_resource` VALUES ('1022', '我的代办事项', 'menu', null, null, '1021', '0/1/1021', null, '20', '1');
INSERT INTO `sys_resource` VALUES ('1023', '我的桌面', 'menu', null, 'myfav/dashboard', '1021', '0/1/1021', null, '10', '1');

-- ----------------------------
-- Table structure for `sys_role`
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(100) DEFAULT NULL,
  `ROLE` varchar(100) DEFAULT NULL,
  `DESCRIPTION` varchar(200) DEFAULT NULL,
  `IS_SHOW` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `idx_sys_role_name` (`NAME`),
  KEY `idx_sys_role_role` (`ROLE`),
  KEY `idx_sys_role_show` (`IS_SHOW`)
) ENGINE=InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('1', '超级管理员', 'admin', '拥有所有权限', '1');
INSERT INTO `sys_role` VALUES ('2', '监管委管理员', 'role_jgw_admin', '拥有监管委的所有权限', '1');
INSERT INTO `sys_role` VALUES ('3', '区县局管理员', 'role_qxj_admin', '拥有区县局的所有权限', '1');
INSERT INTO `sys_role` VALUES ('4', '企业管理员', 'role_company_admin', '拥有企业的所有权限', '1');

-- ----------------------------
-- Table structure for `sys_role_resource_permission`
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_resource_permission`;
CREATE TABLE `sys_role_resource_permission` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `ROLE_ID` bigint(20) DEFAULT NULL,
  `RESOURCE_ID` bigint(20) DEFAULT NULL,
  `PERMISSION_IDS` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `unique_sys_role_resource_permission` (`ROLE_ID`,`RESOURCE_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_role_resource_permission
-- ----------------------------
INSERT INTO `sys_role_resource_permission` VALUES ('1', '1', '2', '1');
INSERT INTO `sys_role_resource_permission` VALUES ('2', '1', '5', '1');
INSERT INTO `sys_role_resource_permission` VALUES ('3', '2', '2', '1');

-- ----------------------------
-- Table structure for `sys_user`
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `USERNAME` varchar(100) DEFAULT NULL,
  `EMAIL` varchar(100) DEFAULT NULL,
  `MOBILE_PHONE_NUMBER` varchar(20) DEFAULT NULL,
  `PASSWORD` varchar(100) DEFAULT NULL,
  `SALT` varchar(10) DEFAULT NULL,
  `CREATE_DATE` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `STATUS` char(2) DEFAULT NULL,
  `DELETED` tinyint(1) DEFAULT NULL,
  `ADMIN` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `unique_sys_user_username` (`USERNAME`),
  UNIQUE KEY `unique_sys_user_email` (`EMAIL`),
  UNIQUE KEY `unique_sys_user_mobile_phone_number` (`MOBILE_PHONE_NUMBER`),
  KEY `idx_sys_user_status` (`STATUS`)
) ENGINE=InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('1', 'admin', 'admin@realaicy.com', '13920888888', 'ec21fa1738f39d5312c6df46002d403d', 'yDd1956wn1', '2016-03-13 11:39:34', '1', '0', '1');
INSERT INTO `sys_user` VALUES ('2', 'jgw_admin', 'jgw_admin@abssoft.com.cn', '13920111111', '5f915c55c6d43da136a42e3ebabbecfc', 'hSSixwNQwt', '2016-03-13 11:39:34', '1', '0', '0');
INSERT INTO `sys_user` VALUES ('3', 'qxj_admin', 'qxj_admin@abssoft.com.cn', '13920333333', 'a10b3c7af051a81fe2506318f982ce28', 'MANHOoCpnb', '2016-03-13 11:39:34', '1', '0', '0');
INSERT INTO `sys_user` VALUES ('4', 'company_a_admin', 'company_a_admin@abssoft.com.cn', '13412345674', '594813c5eb02b210dacc1a36c2482fc1', 'iY71e4dtoa', '2016-03-13 11:39:34', '1', '0', '0');

-- ----------------------------
-- Table structure for `sys_user_organization_job`
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_organization_job`;
CREATE TABLE `sys_user_organization_job` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `USER_ID` bigint(20) DEFAULT NULL,
  `ORGANIZATION_ID` bigint(20) DEFAULT NULL,
  `JOB_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `unique_sys_user_organization_job` (`USER_ID`,`ORGANIZATION_ID`,`JOB_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user_organization_job
-- ----------------------------
