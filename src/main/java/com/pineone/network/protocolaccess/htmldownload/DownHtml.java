package com.pineone.network.protocolaccess.htmldownload;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;

/**
 * Created by Melvin on 2015. 12. 20..
 */
public class DownHtml {

    public void getImage(String uri) throws IOException {

        URL url = new URL(uri);

        HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();

        httpURLConnection.setRequestMethod("GET");

        httpURLConnection.setConnectTimeout(3000);

        httpURLConnection.setReadTimeout(3000);

        BufferedInputStream bufferedInputStream = new BufferedInputStream(httpURLConnection.getInputStream());
        FileOutputStream fileOutputStream = new FileOutputStream("docker012.png");
        byte[] buffer = new byte[1024];

        int n = 0;
        int count = 0;

        while ((n = bufferedInputStream.read(buffer)) != -1) {
            fileOutputStream.write(buffer, 0, n);
            fileOutputStream.flush();
            count += n;

        }

        fileOutputStream.close();
        bufferedInputStream.close();


        System.out.println("ResponseBodyCode : " + httpURLConnection.getResponseCode());
        System.out.println("ResponseHeaderCode" + httpURLConnection.getHeaderFields());


    }


    public void getContents(String uri) throws IOException{


        URL url = new URL(uri);

        HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();

        httpURLConnection.setRequestMethod("GET");

        httpURLConnection.setConnectTimeout(3000);

        httpURLConnection.setReadTimeout(3000);

        InputStream inputStream = httpURLConnection.getInputStream();

       BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, Charset.forName("UTF-8")));

        String data = "";

        while((data = bufferedReader.readLine())!=null){
            System.out.println(data);
        }

        bufferedReader.close();
        inputStream.close();


        System.out.println("ResponseBodyCode : " + httpURLConnection.getResponseCode());
        System.out.println("ResponseHeaderCode" + httpURLConnection.getHeaderFields());


    }
}

