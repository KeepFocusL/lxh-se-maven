## 回顾
见上次课的笔记

## `How to uploading artifact...` 思考过程
- ![img.png](img.png)
- ![img_1.png](img_1.png)
  - Introduction to Repositories
    - ![img_2.png](img_2.png)
- ![img_3.png](img_3.png)
  - Guide to uploading artifacts
    - ![img_4.png](img_4.png)
    - 跟上图同一个页面，往下再滚动点 ![img_5.png](img_5.png)
- Maven Repository Layout
  - ![img_6.png](img_6.png)
  - ![img_7.png](img_7.png)
  - mini
    - ![img_8.png](img_8.png)
    - ![img_9.png](img_9.png)

### 方式一：纯手工
- 纯手工的方式准备 `uploading artifact` 需要的所有东西（上一张截图显示的东西）
- 如果你有时间，应该自己完整的看一遍相关 `一手资源`
#### step1：pom.xml 增加几个插件配置
- 让下一步执行 `mvn install` 命令的时候同时把 javadoc 和 sources 也同步生成好
```xml
<project>
  ...
  <dependencies>
    <dependency>
      ...
    </dependency>
  </dependencies>
  
  <!-- 把 build 区域的内容复制到自己项目的 pom.xml 的相应位置中 -->
  <build>
    <pluginManagement>
      <plugins>
        <plugin>
          <groupId>org.apache.maven.plugins</groupId>
          <artifactId>maven-source-plugin</artifactId>
          <version>3.3.1</version>
          <executions>
            <execution>
              <id>attach-sources</id>
              <goals>
                <goal>jar-no-fork</goal>
              </goals>
            </execution>
          </executions>
        </plugin>
        <plugin>
          <groupId>org.apache.maven.plugins</groupId>
          <artifactId>maven-javadoc-plugin</artifactId>
          <version>3.7.0</version>
          <executions>
            <execution>
              <id>attach-javadocs</id>
              <goals>
                <goal>jar</goal>
              </goals>
            </execution>
          </executions>
        </plugin>
        <plugin>
          <groupId>org.apache.maven.plugins</groupId>
          <artifactId>maven-gpg-plugin</artifactId>
          <version>3.2.4</version>
          <executions>
            <execution>
              <id>sign-artifacts</id>
              <phase>verify</phase>
              <goals>
                <goal>sign</goal>
              </goals>
            </execution>
          </executions>
        </plugin>
      </plugins>
    </pluginManagement>
  
    <plugins>
      <plugin>
        <groupId>org.apache.maven.plugins</groupId>
        <artifactId>maven-source-plugin</artifactId>
      </plugin>
      <plugin>
        <groupId>org.apache.maven.plugins</groupId>
        <artifactId>maven-javadoc-plugin</artifactId>
      </plugin>
      <plugin>
        <groupId>org.sonatype.central</groupId>
        <artifactId>central-publishing-maven-plugin</artifactId>
        <version>0.5.0</version>
        <extensions>true</extensions>
        <configuration>
          <publishingServerId>central</publishingServerId>
          <autoPublish>true</autoPublish>
          <waitUntil>validated</waitUntil><!-- uploaded、validated、published -->
        </configuration>
      </plugin>
    </plugins>
  </build>

</project>
```
#### step2：完善 pom.xml，提供必要的信息
  - ![img_14.png](img_14.png)

#### step3：`mvn install` 生成那4个原始的文件
  - 去 .m2/repository/【你的 groupid 】/【artifactid】/【version】下验证有那4个上传到远程参考需要的原始资料
    - jar、javadoc、sources、pom
    - ![img_10.png](img_10.png)

#### step4：Checksums
  - 参考资料：https://maven.apache.org/plugins-archives/maven-install-plugin-2.4/examples/installing-checksums.html
  - `mvn install -DcreateChecksum=true`
  - ![img_11.png](img_11.png)
  - 这个步骤在大家的电脑遇到了问题。（见下次课的笔记）

#### step5：Signature
  - 参考资料：https://central.sonatype.org/publish/requirements/gpg/
  - todo。。。

#### step6：Layout 所有原材料都准备好之后，还要按规定的路径格式存放它们
  - 先从报错开始：
    - ![img_12.png](img_12.png)
  - 正确的文件存放 layout
    - ![img_13.png](img_13.png)
  - zip code-execution-timer.zip io/github/iae666-b/code-execution-timer/1.0.0/*
    - 这个压缩包解压出来的第一层直接就是 `io` 目录（你的 `groupid` 的第一点 `.` 左边的字符）

#### step7：去远程仓库(选择之一，也是 maven 官方链接过来的网站)：`https://central.sonatype.com`
- 注册 `https://central.sonatype.com` 账号，可以直接用 GitHub 的账号登录
  - ![img_15.png](img_15.png)
- Create a Namespace
  - ![img_16.png](img_16.png)
- Publishing
  - ![img_17.png](img_17.png)
  - ![img_18.png](img_18.png)

### 方式二：自动化
- 添加相应自动化插件
  - `maven-gpg-plugin`
    ```xml
        <plugin>
            <groupId>org.apache.maven.plugins</groupId>
            <artifactId>maven-gpg-plugin</artifactId>
            <version>3.2.4</version>
            <executions>
                <execution>
                    <id>sign-artifacts</id>
                    <phase>verify</phase>
                    <goals>
                        <goal>sign</goal>
                    </goals>
                </execution>
            </executions>
        </plugin>
    ```
  - `central-publishing-maven-plugin`
    ```xml
        <plugin>
            <groupId>org.sonatype.central</groupId>
            <artifactId>central-publishing-maven-plugin</artifactId>
            <version>0.5.0</version>
            <extensions>true</extensions>
            <configuration>
                <publishingServerId>central</publishingServerId>
                <autoPublish>true</autoPublish>
                <waitUntil>validated</waitUntil><!-- uploaded、validated、published -->
            </configuration>
        </plugin>
    ```
- Generate User Token
  - ![img_19.png](img_19.png)
- 将上一步获取到的 username 和 password 设置到 ~/.m2/settings.xml 的 server 配置区域中
  - ![img_20.png](img_20.png)
- `mvn deploy`
  - 下课前在同学的电脑上已经演示了完整操作过程

## 小结
### 手工
- 阅读 `一手资源`
- 理清楚了最终需要上传哪些东西到远程仓库
  - ![img_9.png](img_9.png)
- 然后分步骤准备这些材料
  - 最基础的4个jar包
  - Checksums
    - `***.md5`
    - `***.sha1`
  - Signature
    - `***.asc`
- 把所有原材料安装指定的路径规则打包好
- 注册目标账户
- 上传 && 发布
- 验证使用
### 自动
- 就是将手工操作的那些复杂步骤自动化
- 手工操作的那些才是背后的本质
