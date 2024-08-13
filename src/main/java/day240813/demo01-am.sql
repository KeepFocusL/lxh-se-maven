-- 查询所有数据库
show databases;

-- 创建数据库
create database demo02;
-- 删除数据库
drop database demo02;
-- 演示创建已经存在的数据库
create database demo01;
-- 演示 if not exists（如果不存在才创建）
create database if not exists demo01;


-- 再创建一个下面语句需要的数据库
create database demo;

-- 使用/进入指定的数据库
use demo;

-- 查看: 当前数据库下的表
show tables;

create table demo_user
(
    id int primary key auto_increment comment '表头单元格之ID, int数据类型，主键，唯一标识，自动递增',
    username char(20) not null,
    name varchar(20) comment '真实姓名',
    age int comment '年龄',
    gender char(1) comment '性别：男、女、中'
);

insert into demo_user(username, name, age, gender) value('u001', '张xx', 18, '男');

select * from demo_user;

-- 修改字段
alter table demo_user
    modify name varchar(20) not null comment '真实姓名';

alter table demo_user
    modify age int not null comment '年龄';

drop table demo_user;


-- DDL : 表结构
-- 创建: 基本语法
# create table demo_table(
#                         id int comment 'ID, 唯一标识',
#                         field1 varchar(20) comment 'field1 注释',
#                         field2 varchar(10) comment 'field2 注释',
#                         field3 int comment 'field3 注释'
# ) comment '表注释';


-- 创建: 基本语法 (约束)
create table demo_user
(
    id       int primary key auto_increment comment 'ID, 唯一标识，主键，自动递增',
    username varchar(20) not null comment '用户名',
    name     varchar(10) not null comment '姓名',
    age      int comment '年龄',
    gender   char(1) default '男' comment '性别：男、女、中'
) comment '用户表';

-- 增加约束：让 username 字段是唯一的
-- alter table demo_user add unique (username);
alter table demo_user
    modify username varchar(20) not null unique comment '用户名';

-- 查看: 查看指定表结构
desc demo_user;

-- 查看: 数据库的建表语句
show create table demo_user;

alter table students add hometown varchar(11) comment '家乡';

alter table students modify hometown varchar(11) comment 'hometown';

alter table students change hometown hometown2 varchar(13) comment 'hometown';

alter table students drop column hometown2;

rename table students to student;

rename table student to students;