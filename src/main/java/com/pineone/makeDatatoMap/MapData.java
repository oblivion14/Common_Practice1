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

    public void writeDataToMap(String url){

        String afterProtocol = protocolFinder.validationExcludeProtocol(url);

        urlModel.setProtocol(protocolFinder.validationProtocol(url));

        Map<String, String> protocolInfo = new HashMap<String, String>();

        protocolInfo.put("protocolName", urlModel.getProtocol());



        urlModel.setHostName(hostFinder.findHost(afterProtocol));

        Map<String, String> hostInfo = new HashMap<String, String>();

        hostInfo.put("HostName" , urlModel.getHostName());


        urlModel.setPortNumber(portFinder.findPort(afterProtocol));

        Map<String, String> portNumberInfo = new HashMap<String, String>();

        portNumberInfo.put("PortNumber" , urlModel.getPortNumber());


        urlModel.setSubProject(subProjectFinder.findSubProject(afterProtocol));

        Map<String, String> subProjectInfo= new HashMap<String, String>();

        subProjectInfo.put("SubProject" , urlModel.getSubProject());

        System.out.println(protocolInfo);

        System.out.println(hostInfo);

        System.out.println(portNumberInfo);

        System.out.println(subProjectInfo);

        extractData.extractData(urlModel.getSubProject());


    }
}
