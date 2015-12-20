package com.pineone.network.urlparser.manager;

import com.pineone.network.subprojectparsing.ExtractDataFromSubProject;
import com.pineone.network.urlparser.finder.HostFinder;
import com.pineone.network.urlparser.finder.PortFinder;
import com.pineone.network.urlparser.finder.ProtocolFinder;
import com.pineone.network.urlparser.finder.SubProjectFinder;
import com.pineone.network.urlparser.itf.manager.IManager;

/**
 * Created by Melvin on 2015. 12. 6..
 */

public class UrlParserManager implements IManager{

    ProtocolFinder protocolFinder = new ProtocolFinder();

    HostFinder hostFinder = new HostFinder();

    PortFinder portFinder = new PortFinder();

    SubProjectFinder subProjectFinder = new SubProjectFinder();

    ExtractDataFromSubProject extractDataFromSubProject = new ExtractDataFromSubProject();

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
