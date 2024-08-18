create database demo04;

use demo04;

create table job
(
    id    int auto_increment,
    root  varchar(10) null comment '超级管理员',
    admin varchar(10) null comment '系统配置员',
    user  varchar(10) null comment '文章管理员',
    constraint id
        primary key (id)
)
    comment '用户身份';

create table permissions
(
    id           int auto_increment,
    permissions1 varchar(10) null comment '用户管理',
    permissions2 varchar(10) null comment '文章管理',
    permissions3 varchar(10) null comment '系统配置',
    permissions4 varchar(10) null comment '权限分配',
    constraint id
        primary key (id)
)
    comment '权限';

create table job_permissions
(
    id             int auto_increment comment '主键' primary key,
    job_id         int not null comment '角色ID',
    permissions_id int not null comment '权限ID',

    constraint fk_job_id foreign key (job_id) references job (id),
    constraint fk_permissions_id foreign key (permissions_id) references permissions (id)
) comment '角色权限关联的中间表';

insert into job_permissions(job_id, permissions_id)
values (1, 1),
       (1, 2),
       (1, 3),
       (1, 4),
       (2, 1),
       (2, 2),
       (2, 3),
       (3, 2);

# 查询方法一: 分步查询
# 1. 查找关联表 job_permissions 根据 用户身份 的ID进行过滤,查找 permissions_id 字段 (具体的权限)
select permissions_id from job_permissions where job_id = 1;

# 2. 根据上一步得到的 permissions_id,再查询用户的具体功能
select * from permissions where id in (1, 2, 3, 4);

# 查询方法二: 一次性查询
select * from permissions where id in (select permissions_id from job_permissions where job_id = 1);