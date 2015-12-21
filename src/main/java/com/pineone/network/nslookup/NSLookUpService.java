package com.pineone.network.nslookup;

import java.net.InetAddress;

/**
 * Created by Melvin on 2015. 12. 6..
 *
 * Domain Name을 입력받으면 해당 도메인의 IP를 찾아서 출력해준다.
 */
public class NSLookUpService {

    public void nSLookUpService(String domainName){

        if (domainName.length() == 0) {
            System.out.println("입력받은 내용이 없음");

            System.exit(0);
        }

        /**
         * InetAddress - 컴퓨터의 Ip정보를 저장하는 클래스 , 모두 스태틱 메서드
         * getByName메서드를 이용해서 ip를 가지고 온다.
         * getHostAddress - IP를 추력해준다.
         */
        try {
            InetAddress inetAddress= InetAddress.getByName(domainName);

//            System.out.println(inetAddress.getCanonicalHostName());
            System.out.println("입력받은 HostName 의 IP : " + inetAddress.getHostAddress());
//            System.out.println(inetAddress.getHostName());
            System.out.println("입력받은 HostName + IP : " +  inetAddress.toString());
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }
    }
}

