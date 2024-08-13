## 回顾
见上次课的笔记

## 从之前画过的一张图开始
- ![img0.png](img0.png)
- 引出：通过`图形界面`连接到`MySQL 服务器`
- MySQL数据的图形界面客户端也非常多（到处都是接口和实现类的关系）

## 用 `IntelliJ IDEA` 编辑器自带的`可视化数据库管理`软件
- ![img_1.png](img_1.png)
- 备选方案
  - ![img.png](img.png)
  - ![img_17.png](img_17.png)
  - 还有很多 GUI 图形界面客户端

- New `Data Source` -> `MySQL` 
  - ![img_3.png](img_3.png)
  - Download missing driver files
  ![img_2.png](img_2.png)
- 可能遇到的问题
  - ![img_4.png](img_4.png)
  - 解决方法：切换网络再重试
- 测试连接情况
  - ![img_5.png](img_5.png)

## `0 of xxx` Click here to display other schemas
- ![img_6.png](img_6.png)

## 在 console 执行 SQL 命令，体验自动提醒功能
- ![img_7.png](img_7.png)

## `命令行` vs `GUI` 本质是一致
- ![img_8.png](img_8.png)

## 创建表的模板格式
- ![img_9.png](img_9.png)

## GUI 可视化操作之后对应的 SQL 语句
- ![img_10.png](img_10.png)
- ![img_12.png](img_12.png)

## MySQL 关键字的大小写写法格式
- ![img_11.png](img_11.png)

## 基础的增删改操作
- ![img_14.png](img_14.png)
- ![img_15.png](img_15.png)

## 课上其他截图
- 创建表的类比
![img_23.png](img_23.png)
- `show create table xxx`
![img_24.png](img_24.png)
- `not null` 约束
  - ![img_25.png](img_25.png)
  - ![img_26.png](img_26.png)
- `default`
![img_27.png](img_27.png)
- `unique`
![img_38.png](img_38.png)
- 动手时间
![img_39.png](img_39.png)
- 通过 GUI 创建表
  - ![img_40.png](img_40.png)
  - ![img_41.png](img_41.png)
  - ![img_42.png](img_42.png)
  - ![img_29.png](img_29.png)
- `update 和 delete` 与 `where` 更配哦
  - ![img_37.png](img_37.png)
- 数据类型及相关文档
  - ![img_28.png](img_28.png)

## 课后作业
- ![img_19.png](img_19.png)
#### 数据库
- 帖子内容表
  - ![img_18.png](img_18.png)
- 配置表
  - ![img_20.png](img_20.png)
- 任务表（附加作业）
  - ![img_21.png](img_21.png)
  - ![img_22.png](img_22.png)
### 代码
分版本完成
- app_with_data_v2（把采集回来的 title, url, created_at, updated_at 都存储到新增加的 article 表）
- app_with_data_v3（将之前读取`配置文件`改成读取新规划的`配置表`）
- app_with_data_v4（附加作业，选做）
