package com.pineone.network.nslookup;

/**
 * Created by Melvin on 2015. 12. 6..
 */
public class NsLookUpManager {

    NSLookUpService nsLookUpService = new NSLookUpService();

    public void executeNsLookUpManager(String domainName){

        System.out.println("=======================================");
        System.out.println("입력받은 HostName : " + domainName);

        nsLookUpService.nSLookUpService(domainName);

        System.out.println("=======================================");

    }
}
