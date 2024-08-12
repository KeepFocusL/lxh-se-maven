package day240812.app_with_db.downloader;

import day240812.app_with_db.util.MyReflectUtil;

import static day240812.app_with_db.App.PROPERTIES;

public abstract class Downloader {

    public static Downloader getInstance() {
        return MyReflectUtil.getInstance(PROPERTIES.getProperty("downloader"));
    }

    public abstract String download(String url);
}
