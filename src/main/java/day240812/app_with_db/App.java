package day240812.app_with_db;

import day240812.app_with_db.downloader.Downloader;
import day240812.app_with_db.dto.CustomResult;
import day240812.app_with_db.notificator.Notificator;
import day240812.app_with_db.parser.Parser;
import day240812.app_with_db.repository.Repository;
import day240812.app_with_db.util.MyEmailUtil;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

public class App {
    public static final Properties PROPERTIES;

    static {
        // 读取配置文件，获取整个程序需要的全局配置信息
        PROPERTIES = loadFromConfiguration();

        // 初始化
        init();
    }

    private static void init() {
        // Email 相关设置
        MyEmailUtil.FROM = PROPERTIES.getProperty("from", "admin@xxx.com");
        MyEmailUtil.SECRET_TOKEN = PROPERTIES.getProperty("secret_token");
    }

    public static void main(String[] args) {
        // 开始
        System.out.println("程序开始运行...");

        // 下载
        String url = PROPERTIES.getProperty("url");
        System.out.println("Downloader - 正在下载...：" + url);
        String html = Downloader.getInstance().download(url);
        //System.out.println(html);
        System.out.println("Downloader - 下载完成！");

        // 解析
        System.out.println("Parser - 正在解析...");
        List<CustomResult> results = Parser.getInstance().parse(html);
        //System.out.println(results);
        System.out.println("Parser - 解析完成！(共获取到" + results.size() + "条数据)");

        // 存储
        System.out.println("Repository - 正在存储...");
        Repository.getInstance().store(results);
        System.out.println("Repository - 存储完成！");

        // 通知
        System.out.println("Notificator - 正在通知...");
        Notificator.notice(results);
        System.out.println("Notificator - 通知完成！");

        // 结束
        System.out.println("程序结束运行");
    }

    private static Properties loadFromConfiguration() {
        Properties properties = new Properties();
        String fileName = "src/main/java/day240812/app_with_db/config-local.properties";
        try {
            properties.load(new FileReader(fileName));
        } catch (FileNotFoundException e) {
            System.out.println("配置文件[" + fileName + "]不存在。");
            throw new RuntimeException(e);
        } catch (IOException e) {
            System.out.println("未知的错误！");
            throw new RuntimeException(e);
        }
        //System.out.println(properties);
        System.out.println("配置文件读取成功");
        return properties;
    }
}
