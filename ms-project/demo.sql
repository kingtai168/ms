/*
SQLyog 企业版 - MySQL GUI v8.14 
MySQL - 5.1.40-community : Database - pub
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`pub` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_bin */;

USE `pub`;

/*Table structure for table `t_menu` */

DROP TABLE IF EXISTS `t_menu`;

CREATE TABLE `t_menu` (
  `menuid` varchar(32) COLLATE utf8_bin NOT NULL,
  `menuname` varchar(200) COLLATE utf8_bin NOT NULL,
  `pid` varchar(32) COLLATE utf8_bin DEFAULT NULL,
  `menuurl` varchar(500) COLLATE utf8_bin DEFAULT NULL,
  `menutype` int(2) NOT NULL,
  `ordernum` int(10) NOT NULL DEFAULT '0',
  `icon` varchar(300) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`menuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `t_menu` */

insert  into `t_menu`(`menuid`,`menuname`,`pid`,`menuurl`,`menutype`,`ordernum`,`icon`) values ('0','系统菜单','-1',NULL,1,0,'menu-plugin'),('10','进货管理','0',NULL,1,1,'menu-1'),('1010','进货入库','10','view/jinhuo/jinhuo.jsp',0,1,'menu-11'),('1020','退货出库','10','view/jinhuo/tuihuo.jsp',0,2,'menu-12'),('1030','进货单据查询','10','view/jinhuo/jinsearch.jsp',0,3,'menu-13'),('1040','退货单据查询','10','view/jinhuo/mingxi.jsp',0,4,'menu-14'),('1050','当前库存查询','10','view/kucun/kcsearch.jsp',0,5,'menu-15'),('20','销售管理','0',NULL,1,2,'menu-2'),('2010','销售出库','20','view/chushou/chuku.jsp',0,1,'menu-21'),('2020','客户退货','20','view/chushou/tuiku.jsp',0,2,'menu-22'),('2030','销售单据查询','20','view/chushou/chusearch.jsp',0,3,'menu-23'),('2040','客户退货查询','20','view/chushou/mingxi.jsp',0,4,'menu-24'),('2050','当前库存查询','20','view/kucun/kcsearch.jsp',0,5,'menu-25'),('30','库存管理','0',NULL,1,3,'menu-3'),('3010','商品报损','30','../kucun/baosun.jsp',0,1,'menu-31'),('3020','商品报溢','30','../kucun/baoyi.jsp',0,2,'menu-32'),('3030','库存报警','30','../kucun/baojing.jsp',0,3,'menu-33'),('3040','报损报溢查询','30','../kucun/biansearch.jsp',0,4,'menu-34'),('3050','当前库存查询','30','../kucun/kcsearch.jsp',0,5,'menu-35'),('40','统计报表','0',NULL,1,4,'menu-4'),('4010','供应商统计','40','../tongji/gystj.jsp',0,1,'menu-41'),('4020','客户统计','40','../tongji/khtj.jsp',0,2,'menu-42'),('4030','商品采购统计','40','../tongji/spcgtj.jsp',0,3,'menu-43'),('4040','商品销售统计','40','../tongji/spxstj.jsp',0,4,'menu-44'),('4050','按日统计分析','40','../tongji/tjfxri.jsp',0,5,'menu-45'),('4060','按月统计分析','40','../tongji/tjfxyue.jsp',0,6,'menu-46'),('50','基础资料','0',NULL,1,5,'menu-5'),('5010','供应商管理','50','../ziliao/gys.jsp',0,1,'menu-51'),('5020','客户管理','50','../ziliao/kh.jsp',0,2,'menu-52'),('5030','商品管理','50','../ziliao/spxx.jsp',0,3,'menu-53'),('5040','期初库存','50','../ziliao/kc.jsp',0,4,'menu-54'),('60','系统管理','0',NULL,1,6,'menu-6'),('6010','角色管理','60','role/toQuery.do',0,1,'menu-61'),('6020','用户管理','60','toUserPage.do',0,2,'menu-62'),('6030','数据库管理','60','view/power/beifen.jsp',3,3,'menu-63');

/*Table structure for table `t_role` */

DROP TABLE IF EXISTS `t_role`;

CREATE TABLE `t_role` (
  `roleid` varbinary(32) NOT NULL,
  `rolename` varchar(100) COLLATE utf8_bin NOT NULL,
  `bz` varchar(300) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`roleid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `t_role` */

insert  into `t_role`(`roleid`,`rolename`,`bz`) values ('1','管理员','系统管理');

/*Table structure for table `t_rolemenu` */

DROP TABLE IF EXISTS `t_rolemenu`;

CREATE TABLE `t_rolemenu` (
  `roleid` varchar(32) COLLATE utf8_bin NOT NULL,
  `menuid` varchar(32) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`roleid`,`menuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `t_rolemenu` */

insert  into `t_rolemenu`(`roleid`,`menuid`) values ('1','10'),('1','1010'),('1','1020'),('1','1030'),('1','1040'),('1','1050'),('1','20'),('1','2010'),('1','2020'),('1','2030'),('1','2040'),('1','2050'),('1','30'),('1','3010'),('1','3020'),('1','3030'),('1','3040'),('1','3050'),('1','40'),('1','4010'),('1','4020'),('1','4030'),('1','4040'),('1','4050'),('1','4060'),('1','50'),('1','5010'),('1','5020'),('1','5030'),('1','5040'),('1','60'),('1','6010'),('1','6020'),('1','6030');

/*Table structure for table `t_user` */

DROP TABLE IF EXISTS `t_user`;

CREATE TABLE `t_user` (
  `userid` varchar(32) COLLATE utf8_bin NOT NULL,
  `logincode` varchar(200) COLLATE utf8_bin NOT NULL,
  `password` varchar(200) COLLATE utf8_bin NOT NULL,
  `username` varchar(200) COLLATE utf8_bin NOT NULL,
  `roleid` varchar(32) COLLATE utf8_bin NOT NULL,
  `state` tinyint(2) NOT NULL DEFAULT '0',
  `bz` varchar(200) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `t_user` */

insert  into `t_user`(`userid`,`logincode`,`password`,`username`,`roleid`,`state`,`bz`) values ('1','admin','admin','管理员','1',0,'系统管理员');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
