# MyBatis-resultMap元素的结构及使用 demo
文档：MyBatis-resultMap元素的结构及使用

## 数据库SQL
```sql
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint(2) NOT NULL,
  `name` varchar(20) DEFAULT NULL,
  `sex` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
--插入数据
INSERT INTO `user` (`name`,sex) 
VALUES('tom',1),('jerry',1);


DROP TABLE IF EXISTS `customer`;
CREATE TABLE `customer` (
  `cust_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `name` varchar(255) NOT NULL DEFAULT '' COMMENT '用户真实姓名',
  `birth_date` datetime NOT NULL DEFAULT '1990-01-01 00:00:00' COMMENT '出生年月日',
  `sex` int(11) NOT NULL DEFAULT '1' COMMENT '性别',
  PRIMARY KEY (`cust_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='客户';
```