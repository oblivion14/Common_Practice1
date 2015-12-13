package com.pineone.nslookup;

import java.net.InetAddress;

/**
 * Created by Melvin on 2015. 12. 6..
 *
 * Domain Name을 입력받으면 해당 도메인의 IP를 찾아준다.
 */
public class NSLookUpService {

    public void nSLookUpService(String domainName){

        if (domainName.length() == 0) {
            System.out.println("입력받은 내용이 없음");

            System.exit(0);
        }

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

