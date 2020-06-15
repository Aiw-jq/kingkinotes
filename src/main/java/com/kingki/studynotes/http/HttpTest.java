package com.kingki.studynotes.http;

import javax.net.ssl.HttpsURLConnection;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * 注意点1:GET请求不需要getOutputStream(),去掉相关代码
 * 注意点2:conn.getOutputStream()放的位置导致报错不同
 */
public class HttpTest {

    String path;
    String param;

    public HttpTest(String path,String param){
        this.path = path;
        this.param = param;
    }

    public void accessHttp(){
        try {
            URL url = new URL(path);
            HttpURLConnection conn =(HttpURLConnection)url.openConnection();
            OutputStream os = conn.getOutputStream();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("accept","*/*");
            conn.setRequestProperty("connection","Keep-Alive");
            conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            conn.setDoInput(true);
            conn.setDoOutput(false);
            //GET请求不需要以下代码
            PrintWriter out = new PrintWriter(os);
            out.print(param);
            out.flush();
            InputStream is = conn.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String str = "";
            while((str = br.readLine()) != null){
                System.out.println(str);
            }
            is.close();
            conn.disconnect();
            System.out.println("完毕!!!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] arg0){
        HttpTest httpTest = new HttpTest("http://dev.sunnyintell.com/pms170/anon/login/checkLoginCompany","");
        httpTest.accessHttp();
    }
}
