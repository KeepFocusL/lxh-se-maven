package day240812.app_with_db.parser;

import day240812.app_with_db.dto.CustomResult;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

public class XmfishParser implements Parser {
    @Override
    public List<CustomResult> parse(String html) {
        Document document = Jsoup.parse(html);
        List<CustomResult> results = new ArrayList<>();
        Elements es = document.select("tbody[id=threadlist]").select("tr[class=tr3]");
        for (Element e : es) {
            // 过滤公告、置顶
            Element noticeAndTop = e.select("td.icon a i").first();
            if (noticeAndTop.hasAttr("alt") && "置顶帖标志".equals(noticeAndTop.attr("alt"))) {
                continue;
            }

            Element titleElement = e.select("td.subject a.subject_t").first();
            String title = titleElement.text();
            String url = titleElement.attr("href");
            url = "http://bbs.xmfish.com/" + url;
            String createdAt = e.select("td.author").first().select("p").text();
            String updatedAt = e.select("td.author").eq(1).select("p > a").attr("title");
            results.add(new CustomResult(title, url, createdAt, updatedAt));
        }
        return results;
    }
}
