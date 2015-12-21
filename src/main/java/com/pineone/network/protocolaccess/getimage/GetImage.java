package com.pineone.network.protocolaccess.getimage;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Melvin on 2015. 12. 21..
 */
public class GetImage {

    public void getImage(String uri)  {

        /**
         * 입력받은 URL을 이용하여 "Get"방식의 Connection 을 생성하여 연결
         *
         */
        try {
            URL url = new URL(uri);

            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();

            httpURLConnection.setRequestMethod("GET");

            httpURLConnection.setConnectTimeout(3000);

            httpURLConnection.setReadTimeout(3000);

            /**
             * 버퍼에 Http 로 부터 입력받는 스트림을 저장하여 파일로 저장한다.
             */
            BufferedInputStream bufferedInputStream = new BufferedInputStream(httpURLConnection.getInputStream());
            FileOutputStream fileOutputStream = new FileOutputStream("docker012.png");
            byte[] buffer = new byte[1024];

            int n = 0;
            int count = 0;

            /**
             * 파일을(Image) 읽어서 출력해준다.
             */
            while ((n = bufferedInputStream.read(buffer)) != -1) {
                fileOutputStream.write(buffer, 0, n);
                fileOutputStream.flush();
                count += n;

            }

            fileOutputStream.close();
            bufferedInputStream.close();

            /**
             * Response 코드와 Header 에 담겨져 있는 내용을 출력해준다.
             */
            System.out.println("ResponseCode : " + httpURLConnection.getResponseCode());
            System.out.println("ResponseHeaderCode" + httpURLConnection.getHeaderFields());
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
