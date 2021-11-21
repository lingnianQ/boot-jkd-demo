use jkds;
drop table if exists my_collect;
create table my_collect(
	 id int(7) not null auto_increment,
     phone_id int(7) not null,
     name varchar(100) not null,
     url varchar(300) not null,
     price float(10,1) not null,
     intro varchar(300) not null,
     num int(5) not null,
     total float(15,1) not null,
     user_id int(5) not null,
     create_date datetime,
     status int(1),
     primary key(id)
)ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
-- Records of shop_cart
-- insert into shopCart VALUES(1,2,'testname','img.png',1.0,'test',1,2.0,2,null,1)