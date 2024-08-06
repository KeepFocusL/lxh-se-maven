## 回顾

见上次课的笔记

## 由昨天 `.gitignore` 额外引出

- ![img_1.png](img_1.png)
- 从本质上理解为什么可以忽略它、删除它
    - .idea
    - target
    - #08e487c8 直接删了 lib
- `临界条件` 的思路
    - 比如：假设 gitee 每个仓库超过 5M 就要收费 => ...

## 通过 GAV 唯一定义

- ![img_2.png](img_2.png)
    - https://maven.apache.org/guides/getting-started/index.html
- ![img_3.png](img_3.png)
    - https://maven.apache.org/guides/mini/guide-naming-conventions.html
    - 《Java 开发手册》

## 可以开始准备域名了

- ![img.png](img.png)

## 合并两条commit的方法

- ![img_4.png](img_4.png)

## 查找commit纪录方法

`git reflog --date=iso`

## 回退commit操作

`git reset --hard 【具体要回退到哪个commit xxxxxxx (比如2aabfa4)】`

## git出现了冲突

- ![img_5.png](img_5.png)
- ![img_6.png](img_6.png)

## 无法解决冲突

- ![img_7.png](img_7.png)
- 终止命令 ==> `git rebase --abort`

## 代码打包给别人用

- ![img_8.png](img_8.png)

## Test方法

- ![img_9.png](img_9.png)

## JUnit5测试工具

- ![img_10.png](img_10.png)

## 动手一,非maven导入jar包来测试使用

- ![img_11.png](img_11.png)

### 方法如下

#### 在自己的项目运行package生成jar包

- ![img_13.png](img_13.png)

#### 在新的项目导入jar包

- ![img_15.png](img_15.png)

## 动手二,maven导入GAV来测试使用

- ![img_12.png](img_12.png)

### 方法如下

#### 在自己的项目运行install生成GAV

- ![img_16.png](img_16.png)

#### 在自己的项目复制GAV

- ![img_17.png](img_17.png)

### 在新的项目导入GAV

- ![img_19.png](img_19.png)

## 附加题

- ![img_14.png](img_14.png)
- 目的:让自己从 `消费者` 转变为 `生产者`,不要只是成为台下的看客,合适的时候应该上台