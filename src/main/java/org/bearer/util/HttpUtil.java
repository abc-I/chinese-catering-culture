package org.bearer.util;

import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;

/**
 * @author Li
 * @version 1.0
 * @date Created in 2021/6/15 9:48
 */
@Component
public class HttpUtil {

    public static String doGet(String urlPath, HashMap<String, String> param) throws IOException {
        StringBuilder sb = new StringBuilder(urlPath);

        if (param != null) {
            for (String key : param.keySet()) {
                if (key != null) {
                    sb.append(key).append(param.get(key)).append("&");
                }
            }
            int index = sb.lastIndexOf("&");
            sb.deleteCharAt(index);
        }

        URL url = new URL(sb.toString());
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setConnectTimeout(5000);
        conn.setRequestMethod("GET");

        if (conn.getResponseCode() == HttpURLConnection.HTTP_OK) {
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(conn.getInputStream()));
            StringBuilder string = new StringBuilder();

            String line;
            while ((line = reader.readLine()) != null) {
                string.append(line);
            }
            return string.toString();
        }
        return null;
    }
}
