use demo02;

CREATE TABLE `user`
(
    `id`      int(11) NOT NULL AUTO_INCREMENT,
    `name`    varchar(255) DEFAULT NULL,
    `balance` int(11) DEFAULT NULL,
    PRIMARY KEY (`id`)
);

## -------

select id, name, balance from user;

insert into user(name, balance) values('小白', 999);

update user set balance = balance + 5 where name = '小白';

delete from user where name = '小白';

## -------

CREATE TABLE `article`
(
    `id`    int(11) not null auto_increment,
    `title` varchar(255) not null,
    primary key (`id`),
    `url` varchar(255) not null unique,
    `create_at` varchar(255) not null,
    `updated_at` varchar(255) not null


);
show tables ;

desc article;


insert into article(title) values ('打折转让XXX');