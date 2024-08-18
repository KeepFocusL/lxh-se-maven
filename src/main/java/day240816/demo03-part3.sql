-- 【上面】动手练习时间 part2


-- 一对一: 学生 与 学生证

-- 学生证
# create table student_id_card
# (
#     id         int primary key auto_increment comment 'ID',
#     number     varchar(10)  not null comment '学号',
#     school     varchar(50)  not null comment '大学',
#     department varchar(100) not null comment '院系',
#     created_at datetime     not null comment '领证时间',
#     student_id int          not null unique comment '学生ID',
#     constraint fk_student_id foreign key (student_id) references students (id)
# ) comment '学生证';
create table student_id_card
(
    id         int primary key key auto_increment comment 'ID',
    number     varchar(10)  not null comment '学号',
    school     varchar(50)  not null comment '大学',
    department varchar(100) not null comment '院系',
    created_at datetime     not null comment '领证时间',
    student_id int          not null unique comment '学生ID',
    constraint fk_student_id foreign key (student_id) references students (id)
) comment '学生证';

# insert into student_id_card(id, number, school, department, created_at, student_id)
# values (1, '188996600', '菜鸡大学', '计科', '2021-09-01', 4),
#        (2, '188996601', '菜鸡大学', '电子', '2020-09-01', 5),
#        (3, '188996602', '菜鸡大学', '物理', '2022-09-01', 6);
insert into student_id_card(id, number, school, department, created_at, student_id)
VALUES (1, '188996600', '菜鸟大学', '极客', '2021-09-01', 4),
       (2, '188996601', '菜鸟大学', '垫子', '2020-09-01', 5),
       (3, '188996602', '菜鸟大学', '物理', '2022-09-01', 6);


-- 把学生证分配给一个不存在的学生，由于有外键约束，会报错
-- [23000][1452] Cannot add or update a child row: a foreign key constraint fails (`demo03`.`student_id_card`, CONSTRAINT `fk_student_id` FOREIGN KEY (`student_id`) REFERENCES `students` (`id`))
#     insert into student_id_card
#     value (null, '188996603', 'NB大学', 'Java', '2023-09-01', 66);
      insert into student_id_card
          value (null, '188996603', 'NB大学', 'Java', '2023-09-01', 66);
-- 体现一对一的关系。把 student_id 设置成 unique
alter table student_id_card
add constraint student_id_uk
        unique (student_id);

insert into student_id_card
    value (null, '188996605', 'NB大学2', 'Go', '2023-09-01', 4);


-- 给 number 字段增加唯一约束
alter table student_id_card
    add constraint uk_number
        unique (number);