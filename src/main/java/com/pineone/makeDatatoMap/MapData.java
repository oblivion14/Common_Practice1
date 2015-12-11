package com.pineone.makeDatatoMap;

import com.pineone.extractdata.ExtractData;
import com.pineone.url.parser.finder.HostFinder;
import com.pineone.url.parser.finder.PortFinder;
import com.pineone.url.parser.finder.ProtocolFinder;
import com.pineone.url.parser.finder.SubProjectFinder;
import com.pineone.url.parser.model.UrlModel;

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

    ExtractData extractData = new ExtractData();

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


        extractData.extractData(urlModel.getSubProject());

        return uriInfo;


    }
}
