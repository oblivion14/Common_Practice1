package com.pineone.network.urlparser.finder;

import com.pineone.network.urlparser.itf.finder.IPortFinder;
import com.pineone.network.urlparser.model.UrlModel;

/**
 * Created by Melvin on 2015. 12. 6..
 */
public class PortFinder implements IPortFinder{

    UrlModel urlModel = new UrlModel();

    @Override
    public String findPort(String URL) {

        int hostNum = URL.indexOf(":") +1  ;

        if(URL.contains(":")) {

            if(URL.contains("/"))
            {
                int portNum = URL.indexOf("/");

                urlModel.setPortNumber(URL.substring(hostNum, portNum));
                String port = urlModel.getPortNumber();
//                System.out.println("port = "+  port);
                return port;
            }
            int portNum = URL.length();
            urlModel.setPortNumber(URL.substring(hostNum, portNum));
            String port = urlModel.getPortNumber();
//            System.out.println("port = "+  port);
            return port;
        }

        else {
            String portNum = "80";
//            System.out.println("port =" + portNum);
            return portNum;
        }


//        else if(URL.contains("/")){
//            int hostNum = URL.indexOf("/");
//            String host = URL.substring(protocolNum,hostNum);
//            System.out.println("host = "+  host);
//            return host;
//
//        }
//
//        else{
//            int hostNum = URL.indexOf(URL);
//            String host = URL.substring(protocolNum,hostNum);
//            System.out.println("host = "+  host);
//            return host;
//        }
    }

}


