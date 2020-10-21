drop table if exists word;

create table word (
	id int auto_increment primary key,
	word VARCHAR(128) not null,
	definition VARCHAR(1024) default null
);

insert into word (word) values ('test'), ('orange');
insert into word (word) values ('test'), ('apple');

