package day240812.app_with_db.notificator;

import day240812.app_with_db.util.MyEmailUtil;

public class EmailNotificator implements Notificator {
    @Override
    public void send(String to, String msg) {
        try {
            msg = msg.replaceAll("\\n", "<br>");
            MyEmailUtil.send(to, msg);
        } catch (Exception e) {
            System.out.println("邮件发送失败！！！");
            throw new RuntimeException(e);
        }
    }
}
