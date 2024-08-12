package day240812.app_with_db.repository;

import day240812.app_with_db.dto.CustomResult;

import java.sql.*;
import java.util.List;

public class DbRepository implements Repository {
    @Override
    public void store(List<CustomResult> results) {
        // 这个版本可以先快速实现功能，有些额外的思考或者性能的优化可以放到下一步

        // Java 代码作为 MySQL 的客户端(C)，类似于命令行的操作：带上必要的信息，连上 MySQL 服务端(S)
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo01", "root", "123456");
            System.out.println("Connected to database");

            // 检查并创建表
            String checkTableSql = "SELECT COUNT(*) FROM information_schema.TABLES WHERE TABLE_SCHEMA = 'demo01' AND TABLE_NAME = 'article';";
            PreparedStatement checkTableStmt = connection.prepareStatement(checkTableSql);
            ResultSet resultSet = checkTableStmt.executeQuery();
            boolean tableExists = false;
            if (resultSet.next()) {
                int count = resultSet.getInt(1);
                tableExists = count > 0;
            }
            if (!tableExists) {
                String createTableSql = "CREATE TABLE article (id INT AUTO_INCREMENT PRIMARY KEY, title VARCHAR(255));";
                PreparedStatement createTableStmt = connection.prepareStatement(createTableSql);
                createTableStmt.executeUpdate();
                System.out.println("Table 'demo01.article' created.");
            }

            // 往 MySQL 服务端(S) 上对应的数据库和表中插入具体的数据
            for (CustomResult cr : results) {
                String insertSql = "insert into article(title) values(?);";
                PreparedStatement pStmt = connection.prepareStatement(insertSql);
                pStmt.setString(1, cr.getTitle());
                pStmt.executeUpdate();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}