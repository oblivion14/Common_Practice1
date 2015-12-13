package com.pineone.extract;

import com.pineone.makeDatatoMap.MapData;
import com.pineone.url.parser.manager.UrlParserManager;
import org.junit.Test;

/**
 * Created by Melvin on 2015. 12. 10..
 */
public class ExtractTest {

    UrlParserManager urlparserManager = new UrlParserManager();

    MapData mapData = new MapData();


    @Test
    public void ExtractTest() throws Exception {

        String url = "http://c.pineone.net:48080/projects?name=한순호&age=30&sex=male";

        mapData.writeDataToMap(url);
        System.out.println("==================================");

    }
}
