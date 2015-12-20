package com.pineone.parsing.makedatatomap;

import com.pineone.network.subprojectparsing.ExtractDataFromSubProject;
import com.pineone.network.urlparser.finder.HostFinder;
import com.pineone.network.urlparser.finder.PortFinder;
import com.pineone.network.urlparser.finder.ProtocolFinder;
import com.pineone.network.urlparser.finder.SubProjectFinder;
import com.pineone.network.urlparser.model.UrlModel;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Melvin on 2015. 12. 11..
 */
public class MapData {

    UrlModel urlModel = new UrlModel();

    ProtocolFinder protocolFinder = new ProtocolFinder();

    HostFinder hostFinder = new HostFinder();

    PortFinder portFinder = new PortFinder();

    SubProjectFinder subProjectFinder = new SubProjectFinder();

    ExtractDataFromSubProject extractDataFromSubProject = new ExtractDataFromSubProject();

    Map<String, String> uriInfo = new HashMap<String, String>();

    public Map<String, String> writeDataToMap(String url){

        String afterProtocol = protocolFinder.validationExcludeProtocol(url);

        urlModel.setProtocol(protocolFinder.validationProtocol(url));

        uriInfo.put("protocolName", urlModel.getProtocol());



        urlModel.setHostName(hostFinder.findHost(afterProtocol));

        uriInfo.put("HostName" , urlModel.getHostName());


        urlModel.setPortNumber(portFinder.findPort(afterProtocol));

        uriInfo.put("PortNumber" , urlModel.getPortNumber());


        urlModel.setSubProject(subProjectFinder.findSubProject(afterProtocol));

        uriInfo.put("SubProject" , urlModel.getSubProject());


//        extractDataFromSubProject.extractData(urlModel.getSubProject());

        return uriInfo;


    }
}
