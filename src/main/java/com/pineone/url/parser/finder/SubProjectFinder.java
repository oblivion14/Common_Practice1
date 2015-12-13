package com.pineone.url.parser.finder;

import com.pineone.url.parser.itf.finder.ISubProjectFinder;
import com.pineone.url.parser.model.UrlModel;

/**
 * Created by Melvin on 2015. 12. 6..
 */
public class SubProjectFinder implements ISubProjectFinder {


    UrlModel urlModel = new UrlModel();
    @Override
    public String findSubProject(String URL) {

        int portNum = URL.indexOf("/") + 1;

        if (URL.contains("/")) {

            int subProjectNum = URL.length();
            urlModel.setSubProject(URL.substring(portNum, subProjectNum));
            String subProject = urlModel.getSubProject();
//            System.out.println(protocolNum);
//            System.out.println(hostNum);
//            System.out.println(URL.length());
//            System.out.println("subproject = " + subProject);
            return subProject;

        }

        else return "";
    }
}



