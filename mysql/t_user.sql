drop table t_user;
create table t_user(
	id int(7) primary key auto_increment,
  username varchar(20) not null unique,
  password varchar(20) not null,
  birthday date,
  status int(1)
);
insert into t_user values(1,'admin','123',now(),0);
insert into t_user values(2,'tom','123',now(),1);
insert into t_user values(3,'james','123',now(),1);

insert into t_user values(null,'吴亦凡','123',now(),1);
insert into t_user values(null,'李云迪','456',now(),1);
insert into t_user values(null,'霍尊','789',now(),1);