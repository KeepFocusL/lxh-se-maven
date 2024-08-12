package day240812.app_with_db.downloader;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class JsoupDownloader extends Downloader {
    @Override
    public String download(String url) {
        String result = null;
        try {
            Document document = Jsoup.connect(url).get();
            result = document.html();
        } catch (IOException e) {
            System.out.println("IO 异常");
            throw new RuntimeException(e);
        }
        return result;
    }

    public JsoupDownloader() {
        System.out.println("JsoupDownloader.JsoupDownloader");
    }
}
