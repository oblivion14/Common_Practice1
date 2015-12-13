package com.pineone.url.parser.finder;

import com.pineone.url.parser.itf.finder.IPorotocolFinder;
import com.pineone.url.parser.model.UrlModel;

/**
 * Created by Melvin on 2015. 12. 6..
 */
public class ProtocolFinder implements IPorotocolFinder {

//    URLRegister urlRegister = new URLRegister();
//    String URL = urlRegister.putURL();

    UrlModel urlModel = new UrlModel();

    @Override
    public String validationExcludeProtocol(String URL) {

        if(URL.contains("://"))
        {
            String excludeProtocol = findExcludeProtocol(URL);

            return excludeProtocol;
        }

        else{
            String modifyURL = "http://" + URL;

            String excludeProtocol = findExcludeProtocol(modifyURL);

            return excludeProtocol;

        }
    }

    @Override
    public String validationProtocol(String URL) {

        if(URL.contains("://"))
        {
            String protocol = findProtocol(URL);

            return protocol;
        }

        else{
            String modifyURL = "http://" + URL;

            String protocol = findProtocol(modifyURL);

            return protocol;

        }
    }

    @Override
    public String findExcludeProtocol(String url) {

        int protocolNum = url.indexOf("://");

        urlModel.setProtocol(url.substring(0, protocolNum));

        urlModel.setProtocol(url.replaceFirst("://", "000"));

        String excludeProtocol = urlModel.getProtocol();

//        System.out.println("excludeProtocol = " + excludeProtocol);

        return excludeProtocol;

    }

    @Override
    public String findProtocol(String URL) {

        int protocolNum = URL.indexOf("://");

        urlModel.setProtocol(URL.substring(0, protocolNum));

        String protocol = urlModel.getProtocol();

//        System.out.println("protocol = " + protocol);
        return protocol;

    }
}
