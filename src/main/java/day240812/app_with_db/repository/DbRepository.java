package day240812.app_with_db.repository;

import day240812.app_with_db.dto.CustomResult;
import day240812.app_with_db.util.MyDBUtil;

import java.sql.*;
import java.util.List;

public class DbRepository implements Repository {
    @Override
    public void store(List<CustomResult> results) {
        String insertSql = "insert into article(title,url,create_at,update_at) values(?,?,?,?);";

        try {
            for (CustomResult cr : results) {
                PreparedStatement pStmt = MyDBUtil.getConnection().prepareStatement(insertSql);
                pStmt.setString(1, cr.getTitle());
                pStmt.setString(2, cr.getUrl());
                pStmt.setString(3, cr.getCreatedAt());
                pStmt.setString(4, cr.getUpdatedAt());
                pStmt.executeUpdate();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}