use jkds;
DROP TABLE IF EXISTS `t_phone`;
create table t_phone(
     id int(7) primary key auto_increment,
     phoneName varchar(50),
     urls varchar(300),
     price float(10,1),
     remark varchar(300),
     phone_type_id int(7),
     num int(7) default 0
    );
insert into t_phone values(1,'Redmi Note 11 Pro','001.webp',1999.0,'Redmi Note 11 Pro系列',1,0);
insert into t_phone values(2,'Redmi Note 11 5G','002.webp',1199.0,'5000mAh',1,0);
insert into t_phone values(3,'黑鲨4S','003.webp',2699.0,'磁动力升降肩键',2,0);
insert into t_phone values(4,'黑鲨4S Pro','004.webp',5499.0,'磁动力升降肩键',2,0);
insert into t_phone values(5,'Xiaomi Civi','005.webp',2599.0,'3200万高清质感自拍',3,0);
insert into t_phone values(6,'Xiaomi MIX 4','006.webp',4199.0,'CUP全面屏',1,0);
insert into t_phone values(7,'Redmi Note 10 Pro','007.webp',1499.0,'天玑1100年度旗舰芯片',1,0);
insert into t_phone values(8,'Redmi Note 10 5G','008.webp',1099.0,'5G小金刚 | 旗舰续航',2,0);
insert into t_phone values(9,'小米手表Color 运动版','009.webp',649.0,'超长续航，支持血氧功能',1,0);
insert into t_phone values(10,'Redmi 手表2','010.webp',399.0,'AMOLED高清大屏',1,0);
insert into t_phone values(11,'小米手环6 NFC版','011.webp',249.0,'全屏实力',2,0);
insert into t_phone values(12,'Redmi 手表','012.webp',299.0,'35g超轻/1.4"大屏/多功能NFC',2,0);
insert into t_phone values(13,'Xiaomi 真无线降噪耳机 3 pro','013.webp',689.0,'动态降噪 静听曼妙',3,0);
insert into t_phone values(14,'Redmi Buds 3 半入耳真无线蓝牙','014.webp',189.0,'轻巧半入耳，舒适有天分',1,0);
insert into t_phone values(15,'Redmi Buds 3 青春版','015.webp',99.0,'轻巧无线 持久动听',1,0);
insert into t_phone values(16,'Redmi AirDots 3 Pro','016.webp',289.0,'小巧无线 持久动听',2,0);
insert into t_phone values(17,'小米电视6 65" OLED','017.webp',6999.0,'小米电视6 65" OLED',1,0);
insert into t_phone values(18,'小米电视6 至尊版 65寸','018.webp',7799.0,'画质新境界',2,0);
insert into t_phone values(19,'小米电视 ES55 2022款','019.webp',2899.0,'多分区，画质轻旗舰',3,0);
insert into t_phone values(20,'米家互联网对开门冰箱 540L','020.webp',2799.0,'重磅新品福利特惠',2,0);
insert into t_phone values(21,'米家超薄电磁炉','021.webp',449.0,'纤薄美学，精准猛火',3,0);
insert into t_phone values(22,'米家集尘扫拖机器人','022.webp',2999.0,'自动倒垃圾，45天不粘尘',2,0);
insert into t_phone values(23,'Redmi全自动波轮洗衣机1A 8kg','023.webp',799.0,'一键操作，父母爱用',1,0);
insert into t_phone values(24,'米家电烤箱','024.webp',299.0,'一键操作',3,0);
insert into t_phone values(25,'Redmi Note 11 Pro','001.webp',1999.0,'Redmi Note 11 Pro系列',1,0);
insert into t_phone values(26,'Redmi Note 11 5G','002.webp',1199.0,'5000mAh',1,0);
insert into t_phone values(27,'黑鲨4S','003.webp',2699.0,'磁动力升降肩键',2,0);
insert into t_phone values(28,'黑鲨4S Pro','004.webp',5499.0,'磁动力升降肩键',2,0);
insert into t_phone values(29,'Xiaomi Civi','005.webp',2599.0,'3200万高清质感自拍',3,0);
insert into t_phone values(30,'Xiaomi MIX 4','006.webp',4199.0,'CUP全面屏',1,0);
insert into t_phone values(31,'Redmi Note 10 Pro','007.webp',1499.0,'天玑1100年度旗舰芯片',1,0);
insert into t_phone values(32,'Redmi Note 10 5G','008.webp',1099.0,'5G小金刚 | 旗舰续航',2,0);
insert into t_phone values(33,'小米手表Color 运动版','009.webp',649.0,'超长续航，支持血氧功能',1,0);
insert into t_phone values(34,'Redmi 手表2','010.webp',399.0,'AMOLED高清大屏',1,0);
insert into t_phone values(35,'小米手环6 NFC版','011.webp',249.0,'全屏实力',2,0);
insert into t_phone values(36,'Redmi 手表','012.webp',299.0,'35g超轻/1.4"大屏/多功能NFC',2,0);
insert into t_phone values(37,'Xiaomi 真无线降噪耳机 3 pro','013.webp',689.0,'动态降噪 静听曼妙',3,0);
insert into t_phone values(38,'Redmi Buds 3 半入耳真无线蓝牙','014.webp',189.0,'轻巧半入耳，舒适有天分',1,0);
insert into t_phone values(39,'Redmi Buds 3 青春版','015.webp',99.0,'轻巧无线 持久动听',1,0);
insert into t_phone values(40,'Redmi AirDots 3 Pro','016.webp',289.0,'小巧无线 持久动听',2,0);
insert into t_phone values(41,'小米电视6 65" OLED','017.webp',6999.0,'小米电视6 65" OLED',1,0);
insert into t_phone values(42,'小米电视6 至尊版 65寸','018.webp',7799.0,'画质新境界',2,0);
insert into t_phone values(43,'小米电视 ES55 2022款','019.webp',2899.0,'多分区，画质轻旗舰',3,0);
insert into t_phone values(44,'米家互联网对开门冰箱 540L','020.webp',2799.0,'重磅新品福利特惠',2,0);
insert into t_phone values(45,'米家超薄电磁炉','021.webp',449.0,'纤薄美学，精准猛火',3,0);
insert into t_phone values(46,'米家集尘扫拖机器人','022.webp',2999.0,'自动倒垃圾，45天不粘尘',2,0);
insert into t_phone values(47,'Redmi全自动波轮洗衣机1A 8kg','023.webp',799.0,'一键操作，父母爱用',1,0);
insert into t_phone values(48,'米家电烤箱','024.webp',299.0,'一键操作',3,0);