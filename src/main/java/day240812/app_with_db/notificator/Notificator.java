package day240812.app_with_db.notificator;

import day240812.app_with_db.dto.CustomResult;
import day240812.app_with_db.util.MyReflectUtil;

import java.util.ArrayList;
import java.util.List;

import static day240812.app_with_db.App.PROPERTIES;


public interface Notificator {
    static Notificator getInstance() {
        return MyReflectUtil.getInstance(PROPERTIES.getProperty("notificator"));
    }

    static void notice(List<CustomResult> results) {
        String msg = getMsgFromResult(results);
        if (!msg.isBlank()) {
            String to = PROPERTIES.getProperty("to");
            Notificator.getInstance().send(to, msg);
            //System.out.println("成功给【" + to + "】发送了通知");
        } else {
            System.out.println("没有命中任何关键词，无需发送通知");
        }
    }

    static String getMsgFromResult(List<CustomResult> results) {
        String[] kws = PROPERTIES.getProperty("keywords").split(",");
        List<CustomResult> hitResults;
        StringBuilder sb = new StringBuilder();
        for (String kw : kws) {
            hitResults = new ArrayList<>();
            for (CustomResult cr : results) {
                if (cr.getTitle().contains(kw)) {
                    hitResults.add(cr);
                }
            }
            if (!hitResults.isEmpty()) {
                sb.append("*** 命中关键词【").append(kw).append("】").append(hitResults.size()).append("条\n");
                for (CustomResult hitCr : hitResults) {
                    sb.append(hitCr.getTitle()).append("\n").append(hitCr.getUrl()).append("\n").append(hitCr.getCreatedAt()).append("\n").append(hitCr.getUpdatedAt()).append("\n");
                }
            }
        }
        return sb.toString();
    }

    void send(String to, String msg);
}
