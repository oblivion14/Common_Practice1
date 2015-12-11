package com.pineone.extract;

import com.pineone.extractdata.ExtractData;
import com.pineone.makeDatatoMap.MapData;
import com.pineone.url.parser.manager.UrlParserManager;
import org.junit.Test;

import java.util.Map;

/**
 * Created by Melvin on 2015. 12. 10..
 */
public class ExtractTest {

    UrlParserManager urlparserManager = new UrlParserManager();

    MapData mapData = new MapData();

    ExtractData extractData = new ExtractData();


    @Test
    public void ExtractTest() throws Exception {

        String url = "http://c.pineone.net:48080/projects?name=한순호&age=30&sex=male";
        String sub = "name=한순호&age=30&sex=male";

        Map<String, String> extractDataFromURI = mapData.writeDataToMap(url);
        Map<String, String> extractDataFromSubData = extractData.extractData(url);
        Map<String, String> extractDataFromSubDataUsingToKen = extractData.useTokenizerExtractData(sub);


        System.out.println("URI 의미 : " + extractDataFromURI);
        System.out.println("SubProject Data : " + extractDataFromSubData);
        System.out.println("SubProject Data(Using Token) : " + extractDataFromSubDataUsingToKen);

    }
}
