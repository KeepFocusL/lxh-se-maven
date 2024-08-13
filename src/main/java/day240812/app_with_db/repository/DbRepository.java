package day240812.app_with_db.repository;

import day240812.app_with_db.dto.CustomResult;
import day240812.app_with_db.util.MyDBUtil;

import java.sql.*;
import java.util.List;

public class DbRepository implements Repository {
    @Override
    public void store(List<CustomResult> results) {
        String insertSql = "insert into article(title) values(?);";

        // Java 代码作为 MySQL 的客户端(C)，类似于命令行的操作：带上必要的信息，连上 MySQL 服务端(S)
        try {
            // 往 MySQL 服务端(S) 上对应的数据库和表中插入具体的数据
            for (CustomResult cr : results) {
                PreparedStatement pStmt = MyDBUtil.getConnection().prepareStatement(insertSql);
                pStmt.setString(1, cr.getTitle());
                pStmt.executeUpdate();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
