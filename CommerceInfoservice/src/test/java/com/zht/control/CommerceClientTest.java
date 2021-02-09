package com.zht.control;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @Author : Zht
 * @Organization : U know Who
 * @Title :
 * @Description :
 * @Date : 2021/2/710:07
 */
public class CommerceClientTest {

    public static void main(String[] args) {
        String message = "test";
        String address = "http://localhost:6097/commerceInfoColService/webInfoColService";
        try {
            URL url = new URL(address);
            HttpURLConnection conn = (HttpURLConnection)url.openConnection();
            conn.setRequestMethod("POST");
            conn.setDoInput(true);
            conn.setDoOutput(true);
            conn.setAllowUserInteraction(true);
            conn.setUseCaches(false);
            conn.setReadTimeout(6000);
            conn.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/88.0.4324.146 Safari/537.36");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.connect();
            OutputStream out = conn.getOutputStream();
            BufferedOutputStream outputStream = new BufferedOutputStream(out);
            outputStream.write(message.getBytes());
            outputStream.flush();

            String temp = "";
            InputStream in = conn.getInputStream();
            byte[] bytes = new byte[1024];
            while (in.read(bytes, 0, 1024) != -1) {
                temp += new String(bytes);
            }
            int responseCode = conn.getResponseCode();
            System.out.println(responseCode);
            System.out.println(temp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
