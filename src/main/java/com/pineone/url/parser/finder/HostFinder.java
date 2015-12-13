package com.pineone.url.parser.finder;

import com.pineone.url.parser.itf.finder.IHostfinder;
import com.pineone.url.parser.model.UrlModel;

/**
 * Created by Melvin on 2015. 12. 6..
 */
public class HostFinder implements IHostfinder {

    UrlModel urlModel = new UrlModel();

    @Override
    public String findHost(String URL) {

        int protocolNum = URL.indexOf("000") +3  ;

        if(URL.contains(":")) {

            int hostNum = URL.indexOf(":");

            urlModel.setHostName(URL.substring(protocolNum,hostNum));
            String host = urlModel.getHostName();

//            System.out.println("host = "+  host);
            return host;

        }

        else if(URL.contains("/")){
            int hostNum = URL.indexOf("/");
            String host = getHost(URL, protocolNum, hostNum);
            return host;

        }

        else{
            int hostNum = URL.length();
            String host = getHost(URL, protocolNum, hostNum);
            return host;
        }

    }

    private String getHost(String URL, int protocolNum, int hostNum) {
        urlModel.setHostName(URL.substring(protocolNum,hostNum));
        String host = urlModel.getHostName();
//        System.out.println("host = "+  host);
        return host;
    }
}
