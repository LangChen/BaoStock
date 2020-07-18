/*
 Navicat Premium Data Transfer

 Source Server         : DockerMysql
 Source Server Type    : MySQL
 Source Server Version : 50728
 Source Host           : localhost:3306
 Source Schema         : Baostock

 Target Server Type    : MySQL
 Target Server Version : 50728
 File Encoding         : 65001

 Date: 18/07/2020 21:26:53
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for history_day_k_data
-- ----------------------------
DROP TABLE IF EXISTS `history_day_k_data`;
CREATE TABLE `history_day_k_data` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `date` varchar(30) NOT NULL COMMENT '交易所行情日期	',
  `code` varchar(20) NOT NULL COMMENT '证券代码',
  `open` decimal(15,4) NOT NULL COMMENT '开盘价',
  `high` decimal(15,4) NOT NULL COMMENT '最高价',
  `low` decimal(15,4) NOT NULL COMMENT '最低价',
  `close` decimal(15,4) NOT NULL COMMENT '收盘价',
  `preclose` decimal(15,4) NOT NULL COMMENT '前收盘价',
  `volume` bigint(15) NOT NULL COMMENT '成交量',
  `amount` decimal(20,4) NOT NULL COMMENT '成交额',
  `adjustflag` tinyint(2) NOT NULL COMMENT '复权状态',
  `turn` decimal(10,6) NOT NULL COMMENT '换手率',
  `tradestatus` tinyint(2) NOT NULL COMMENT '交易状态',
  `pctChg` decimal(20,6) NOT NULL COMMENT '涨跌幅(百分比)',
  `peTTM` decimal(20,6) NOT NULL COMMENT '滚动市盈率',
  `psTTM` decimal(20,6) NOT NULL COMMENT '滚动市销率',
  `pcfNcfTTM` decimal(20,6) NOT NULL COMMENT '滚动市现率',
  `pbMRQ` decimal(20,6) NOT NULL COMMENT '市净率',
  `isST` tinyint(2) NOT NULL COMMENT '是否ST',
  `createDate` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '导入时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8mb4 COMMENT='A股日k线历史数据';

-- ----------------------------
-- Table structure for stock
-- ----------------------------
DROP TABLE IF EXISTS `stock`;
CREATE TABLE `stock` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `code` varchar(20) NOT NULL COMMENT '证券代码',
  `code_name` varchar(50) NOT NULL COMMENT '证券名称',
  `tradeStatus` tinyint(2) NOT NULL COMMENT '交易状态(1：正常交易 0：停牌）',
  `createDate` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建日期',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4406 DEFAULT CHARSET=utf8mb4;

SET FOREIGN_KEY_CHECKS = 1;
