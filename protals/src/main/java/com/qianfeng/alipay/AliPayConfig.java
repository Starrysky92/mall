package com.qianfeng.alipay;

import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by Administrator on 2017/9/20 0020.
 */
public class AliPayConfig {
    // 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
    public static String app_id ="2016081900289740";

    // 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQCOXKn46OeTifzhTZXJx5tQOKkpmE9vVKaj5CjA5UbHP7zfW29oKWVD7hG48BSTaIe92FzBShec132xwuBb3kwrlx744Dyp21pmbhiZPzAFtr7IboWfVnCEw75Y3Wt9m2kQMXGJrA2PF2nheV//3NzRl6aMojoMCTAkQxBszP2VVMckAdyeGa3Z8lYAMbuXmNigl/Q8GZlp7BxPr0k/kq38Wn1N9+C+j3ESXFESrCuBZLto7l9TdHtTQMJ0iXnwWqchcxzDXa6zQk6JRnP93y0RNq/UGAMH51H19COz5BsWn5yY6E+ZT8+LmXnTUB4m/1oXdVygUDInu/qFgYjltUtlAgMBAAECggEAR03AUIyPGMW/ZDWQ9azFbOvERrIj7zYt9N6dTuhHiBqzhgftB/Xb46dFNyUAmUh83KiW5LUwmH0SVsutxjXUXuzlNXBS0hys7artJSyR5/q9GfTJdqI73zOPjkDwysvhVpv9KyCC9g2bGbTKUYQVEeFsKPpEKq0bcL4qZuRRis5Xw7EWJu6ZOslYRVMWkemOLcZNgp9lS/RcCdbUYvjT9SRJ4XB7QgefBXaKnNxDwycwxVjdquqMrezTZpNhu0G/k3KiyZR51/7CSU+wnfWyrKeuWGoj31+hS227Hxplr33FHn8rwnooHkouZfrXlKS4G66fFHJOfeD7/nvzWGdeYQKBgQDZl0H6U52NuzgRpu0Z7eFreXuvCRMG4nxi7b4/pJIeJcm5ehuYXBTOeNfQyfRfXhujJkn0xCp1Hrpnf1UZ+USXwJQ/O1P5U6SfvNTqgv/z0uDrh+r2k0thFhMPkMaJHgMM0HtyNJMliPoweWL3vj/P8gI0V85e+WsxtXUCt1gE6QKBgQCnfeDN8YI/Eiy1RaSnHUm11BZHTD2IN1QVtG6RQP43Bi0SLYOid1eWGunBCxN+Dzgf+CJSdnSmCGb+Raz5pV99A6fzg9EPwG1dwGTzOntEfJ9RixYQHfOGiR2qDq+hWfxJ7v8bwatyfHRvDtAeN2zncRoCdTckj7R2ra/vwKS1HQKBgQDA317QccW6mDV/ECQjU8T461pDMRv4glIXrv1wlIQgzQYerqo/R3/59Qv4OsuurVB6MbpkiG3KG07H5wqcV2QBz+aYlhI9c3L9VPi2VyBiFI7iuDwCDVZH3LVQmtghOsUhWrvR4+B66Qw8Y5ziVXVi8fYaR6rabOQjz+DEY5hV4QKBgQCkPaqZKG8I/AB9TSqVeQHT3IJwLdHU5jR9CC64HxxpxpOh1KHVSePIXOHFm9/kaHYn20GEzYW7XlfolVh2gXTueQxTnXn/UTmtikEzxbAky3PLGXFsIoKv9XryTG5q8XuU4Fim1jYSEPp4APWR+9W96kmQCXMmVginq8/vcV/R/QKBgFKEi7QDEtlRvdLnOv+E4Ugn4h9YLY3Hj2YAnPImKdSlpZaqAtwVWf0t3JkUdjHu69oT4J763p7f5SUWiRsfBIOwjGOytNWeWEPIEkszJslc0Q464uWQVTFpG/F/zEvSlfprODHlfcwFqQHXpl5jIi34c6NGB08i8OZ0d7cwyjgf";
    // 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAu+AhqebLD1mCLVlP0vU1fSXEhG5RSzgzFbadXtVSnYAEOHy7nTamOdshGmgVapv83KzitEiW/5wW89+i1LP0YcEfjk1s7ji0GKTKYUjR4BSNjdnP2jRCbFd9qiseyd326mJKuoZVQtLaeYp4O2FXmdR0n3xW54peltVGrPn+aZKcFZet2ZlsBW37ggSBbRU7xRY8JEtJntIL6DwB+ezmDa/mu7atlL6gDe1pDZ5YrIlMihVWtwhagzHgCfdylRlE4yrL98Gsw8WjaAiS5SeoG5Vg2hVQIQu+kOClLQm47yq1HjrfRHtZZcnmXVcs+U+KAkRsUeDwwYcW8j6oiGC2TQIDAQAB";
    // 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String notify_url = "http://localhost:8090/callback.html";

    // 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String return_url = "http://localhost:8090/callback.html";

    // 签名方式
    public static String sign_type = "RSA2";

    // 字符编码格式
    public static String charset = "utf-8";

    // 支付宝网关
    public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";

    // 日志路径
    public static String log_path = "e:/log/";
    /**
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
