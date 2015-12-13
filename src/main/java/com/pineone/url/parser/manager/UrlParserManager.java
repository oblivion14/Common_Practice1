package com.pineone.url.parser.manager;

import com.pineone.extractdata.ExtractData;
import com.pineone.url.parser.finder.HostFinder;
import com.pineone.url.parser.finder.PortFinder;
import com.pineone.url.parser.finder.ProtocolFinder;
import com.pineone.url.parser.finder.SubProjectFinder;
import com.pineone.url.parser.itf.manager.IManager;

/**
 * Created by Melvin on 2015. 12. 6..
 */

public class UrlParserManager implements IManager{

    ProtocolFinder protocolFinder = new ProtocolFinder();

    HostFinder hostFinder = new HostFinder();

    PortFinder portFinder = new PortFinder();

    SubProjectFinder subProjectFinder = new SubProjectFinder();

    ExtractData extractData = new ExtractData();

    @Override
    public void executeURLParser(String url) {

        String afterProtocol = protocolFinder.validationExcludeProtocol(url);

        protocolFinder.validationProtocol(url);

//        protocolFinder.validation(url).;

        hostFinder.findHost(afterProtocol);

        portFinder.findPort(afterProtocol);

        String subProject = subProjectFinder.findSubProject(afterProtocol);



    }

}
