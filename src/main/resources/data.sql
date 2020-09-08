drop table if exists words;

create table words (
	id int auto_increment primary key,
	word VARCHAR(128) not null,
	definition VARCHAR(1024) default null
);

insert into words (word) values ('test'), ('orange');

