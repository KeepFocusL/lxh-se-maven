package com.day240805;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class JsoupTest {
    public static void main(String[] args) throws IOException {
        Document doc = Jsoup.connect("https://www.baidu.com/").get();
        //获取 baidu 官网首页的 html 源代码
        System.out.println(doc.html());
    }
}
