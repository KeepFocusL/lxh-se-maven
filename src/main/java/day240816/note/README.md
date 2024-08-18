## iae-study-journal 日历多点亮了7天
- html + css + js
- web 1.0
![img.png](img.png)

## 再次举例 iae-project-app 可能的一些扩展
- 有空的时候、感兴趣的自己真的去做它

## 要学会灵活运用课上所学的知识点
比如：课上将模糊查询的时候是以学生表为例子，要会跟另一个项目的 article 表也联系起来
- ![img_1.png](img_1.png)

## 复习 GitHub Pages 操作
- ![img_2.png](img_2.png)
- ![img_3.png](img_3.png)

## 复习 `if not exists` 的作用
- ![img_4.png](img_4.png)

## 将 `create table` 类比成 `定义Excel表格的表头`
![img_5.png](img_5.png)

## 多表
### 创建新表
- ![img_6.png](img_6.png)
### 外键约束
- 插入不存在的班级
  - ![img_7.png](img_7.png)
- 删除已经被 referenced 的数据
  - ![img_8.png](img_8.png)
- 外键相关的两个字段类型不匹配
  - ![img_9.png](img_9.png)
- Missing index（被 referenced 的字段必需是索引字段）
  - ![img_10.png](img_10.png)
  - ![img_11.png](img_11.png)
### 思考时间：如何表示 `学生` 和 `课程` 之间的选修关系
- ![img_12.png](img_12.png)
- 思考过程
  - 增加字段 - 在 course 表中增加
    - ![img_13.png](img_13.png)
  - 增加字段 - 在 students 表中增加
    - ![img_14.png](img_14.png)
  - 增加表 - 关联表
    - ![img_15.png](img_15.png)
  - 核心稳定、功能可扩展、开闭原则。。。
    - ![img_16.png](img_16.png)
### 不同 GUI 图形界面客户端的显示差异及本质
- ![img_17.png](img_17.png)

### 从多表中查询数据
- ![img_18.png](img_18.png)

## 课后作业
- ![img_19.png](img_19.png)
- ![img_20.png](img_20.png)
- 提醒
  - ![img_21.png](img_21.png)