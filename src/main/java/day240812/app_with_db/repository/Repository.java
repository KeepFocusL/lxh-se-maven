package day240812.app_with_db.repository;

import day240812.app_with_db.dto.CustomResult;
import day240812.app_with_db.util.MyReflectUtil;

import java.util.List;

import static day240812.app_with_db.App.PROPERTIES;

public interface Repository {

    static Repository getInstance() {
        return MyReflectUtil.getInstance(PROPERTIES.getProperty("repository"));
    }

    void store(List<CustomResult> results);
}
