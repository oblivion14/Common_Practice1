package com.pineone.url.parser;

import com.pineone.network.subprojectparsing.ExtractDataFromSubProject;
import com.pineone.network.urlparser.manager.UrlParserManager;
import com.pineone.parsing.makedatatomap.MapData;
import org.junit.Test;

import java.util.Map;

/**
 * Created by Melvin on 2015. 12. 6..
 */
public class UrlParserTest {


    UrlParserManager urlparserManager = new UrlParserManager();

    MapData mapData = new MapData();

    ExtractDataFromSubProject extractDataFromSubProject = new ExtractDataFromSubProject();

    @Test
    public void ParserTest() throws Exception {

        System.out.println("==================================");

        String url = "http://c.pineone.net:48080/hello";
        Map<String, String> extractDataFromURI = mapData.writeDataToMap(url);

        System.out.println(extractDataFromURI);



        System.out.println("==================================");

    }

    @Test
    public void exceptProtocolAndPortAndSubProject() throws Exception {

        System.out.println("==================================");

        String url = "www.naver.com";

        Map<String, String> extractDataFromURI = mapData.writeDataToMap(url);

        System.out.println(extractDataFromURI);


        System.out.println("==================================");

    }

    @Test
    public void exceptOnlyPortNum() throws Exception {

        System.out.println("==================================");

        String url = "http://www.google.co.kr/helloproject";

        Map<String, String> extractDataFromURI = mapData.writeDataToMap(url);

        System.out.println(extractDataFromURI);

        System.out.println("==================================");

    }

}
