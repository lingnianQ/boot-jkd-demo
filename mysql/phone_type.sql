USE jkds;
 CREATE TABLE phone_type(
	id INT (7) primary key auto_increment,
 	phoneTypeName VARCHAR(20)
);
insert into phone_type values(1,'特惠产品');
insert into phone_type values(2,'火爆产品');
insert into phone_type values(3,'新品推荐');