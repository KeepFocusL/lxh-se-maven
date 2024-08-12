package day240812.app_with_db.parser;

import day240812.app_with_db.dto.CustomResult;
import day240812.app_with_db.util.MyReflectUtil;

import java.util.List;

import static day240812.app_with_db.App.PROPERTIES;

public interface Parser {
    static Parser getInstance() {
        return MyReflectUtil.getInstance(PROPERTIES.getProperty("parser"));
    }

    List<CustomResult> parse(String html);
}
