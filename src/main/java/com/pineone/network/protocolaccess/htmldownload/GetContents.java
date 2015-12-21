package com.pineone.network.protocolaccess.htmldownload;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.charset.MalformedInputException;

/**
 * Created by Melvin on 2015. 12. 20..
 */
public class GetContents {

    public void getContents(String uri) {

        /**
         * 입력받은 URL을 이용하여 "Get"방식의 Connection 을 생성하여 연결
         */
        try {
            URL url = new URL(uri);

            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();

            httpURLConnection.setRequestMethod("GET");

            httpURLConnection.setConnectTimeout(3000);

            httpURLConnection.setReadTimeout(3000);

            /**
             * Http 로 부터 입력받는 스트림을 버퍼에 저장한다.
             */

            InputStream inputStream = httpURLConnection.getInputStream();

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, Charset.forName("UTF-8")));

            String data = "";

            /**
             * 버퍼에 있는 내용을 줄 단위로 읽어와 출력해준다.
             */
            while ((data = bufferedReader.readLine()) != null) {
                System.out.println(data);
            }

            bufferedReader.close();
            inputStream.close();

            /**
             *  Response 코드와 Header 에 담겨져 있는 내용을 출력해준다.
             */

            System.out.println("ResponseCode : " + httpURLConnection.getResponseCode());
            System.out.println("ResponseHeaderCode" + httpURLConnection.getHeaderFields());

        }
        catch (MalformedInputException e){
            e.printStackTrace();
        }
        catch (IOException e){
            e.printStackTrace();
        }


    }
}

