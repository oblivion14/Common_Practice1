package com.pineone.url.parser;

import com.pineone.makeDatatoMap.MapData;
import com.pineone.url.parser.manager.UrlParserManager;
import org.junit.Test;

/**
 * Created by Melvin on 2015. 12. 6..
 */
public class UrlParserTest {


    UrlParserManager urlparserManager = new UrlParserManager();

    MapData mapData = new MapData();

    @Test
    public void ParserTest() throws Exception {

        System.out.println("==================================");

        String url = "http://c.pineone.net:48080/hello";

        mapData.writeDataToMap(url);

        System.out.println("==================================");

    }

    @Test
    public void exceptProtocolAndPortAndSubProject() throws Exception {

        System.out.println("==================================");

        String url = "www.naver.com";

        mapData.writeDataToMap(url);


        System.out.println("==================================");

    }

    @Test
    public void exceptOnlyPortNum() throws Exception {

        System.out.println("==================================");

        String url = "http://www.google.co.kr/helloproject";

        mapData.writeDataToMap(url);

        System.out.println("==================================");

    }

}
