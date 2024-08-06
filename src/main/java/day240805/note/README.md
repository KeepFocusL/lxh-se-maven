## 回顾
见上次课的笔记

## 高纬度学习情况可视化
![img.png](img.png)

## 回顾之前的第三方包管理方式及问题
以：引入 `Jsoup` 的过程为例。
如果要使用第三方的 `Jsoup` 我们当前的步骤是怎样的？
- ![img_2.png](img_2.png)
- ![img_1.png](img_1.png)
### 大家发到群里的截图
- ![img_3.png](img_3.png)
- ![img_4.png](img_4.png)
### 点评
。。。
### 我的回顾过程
![img_5.png](img_5.png)
### 问题
- 需要自己主动去下载 jar 包，自己添加到项目
- 从远程仓库重新 clone 之后，忘记点击 Add as Library
- 比如邮件发送需要的 jar 包不止一个、多个版本的匹配问题
- 远程仓库除了 Java 源代码，还需要存储 jar 包
- jar 包版本更新的时候，需要重复操作一遍完整过程
- 等等...

### 进一步思考
- 下一个问题：如果要更新 `Jsoup` 又该怎么做？
- 再回忆之前引入邮件发送功能，不止一个 jar 包，它的更新又如何？
  - ![img_6.png](img_6.png)

## 提前准备：加速相关配置 `settings.xml` (先照做)
- ![img_7.png](img_7.png)
### 问题解答
- ![img_8.png](img_8.png)
- ![img_9.png](img_9.png)

## 用 Java 的思想理解 `Build system`
- ![img_10.png](img_10.png)
- ![img_41.png](img_41.png)

## Maven 初见
记得阅读一手资源
- https://maven.apache.org/
### 下载
- ![img_38.png](img_38.png)
### 安装之前的检查：`Verify the signature`
对下载回来的软件包进行安全校验。注重安全意识、养成习惯
- ![img_11.png](img_11.png)
- ![img_12.png](img_12.png)
- ![img_13.png](img_13.png)

### 安装 Install Apache Maven
![img_14.png](img_14.png)

## 复习环境变量相关知识
- ![img_15.png](img_15.png)
- ![img_37.png](img_37.png)

## 用 Maven 解决之前管理第三方包的问题
### 通过命令行的方式创建 Maven 项目（可以完全脱离 IDEA 编辑器）
1. Creating a Project
- `mvn archetype:generate -DgroupId=com.mycompany.app -DartifactId=my-app -DarchetypeArtifactId=maven-archetype-quickstart -DarchetypeVersion=1.4 -DinteractiveMode=false
  `
- `cd my-app`
2. The POM
- ![img_40.png](img_40.png)
3. Build the Project
- `mvn package`
  - 这一步如果报错，记得验证 pom.xml 中是否指定匹配的 JDK 版本
  - ![img_39.png](img_39.png)
4. Run
- `java -cp target/my-app-1.0-SNAPSHOT.jar com.mycompany.app.App`
- 预期的输出 `Hello World!`
#### 部分问题及解答
##### 问题1
- ![img_16.png](img_16.png)
- 原因：忘记进入项目所在目录
  - ![img_17.png](img_17.png)
##### 问题2
- ![img_18.png](img_18.png)
- 原因：编译和运行使用的 JDK 版本不一致
  - ![img_19.png](img_19.png)
  - 解决：检查环境变量，保持版本一致
##### 额外引出
- https://docs.oracle.com/javase/specs/jvms/se21/html/jvms-4.html
  - ![img_20.png](img_20.png)

### IDEA 集成 Maven 创建项目
- ![img_21.png](img_21.png)
- ![img_22.png](img_22.png)
- 验证
  ![img_23.png](img_23.png)

## 再次用 Java 的思路理解 `Build system`
- ![img_24.png](img_24.png)

## 复习部分 git 操作
- ![img_25.png](img_25.png)
- ![img_26.png](img_26.png)

## 在 `gitee` 或 `github` 上创建新的仓库存储新的 maven 项目代码
- ![img_27.png](img_27.png)

## 用 `maven` 的方式替换之前手动维护第三方依赖
鸟枪换炮
### Jsoup 依赖的 maven 管理方式测试
- ![img_28.png](img_28.png)
- ![img_29.png](img_29.png)
- ![img_30.png](img_30.png)
- ![img_31.png](img_31.png)

### maven 远程仓库之一
- https://mvnrepository.com/
- ![img_32.png](img_32.png)
- ![img_33.png](img_33.png)
- ![img_34.png](img_34.png)

### Email 相关依赖的 maven 管理方式测试
- ![img_35.png](img_35.png)

## 今日代码小结
- ![img_36.png](img_36.png)
