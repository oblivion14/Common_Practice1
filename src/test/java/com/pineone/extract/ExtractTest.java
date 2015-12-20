package com.pineone.extract;

import com.pineone.network.subprojectparsing.ExtractDataFromSubProject;
import com.pineone.parsing.makedatatomap.MapData;
import com.pineone.network.urlparser.manager.UrlParserManager;
import org.junit.Test;

import java.util.Map;

/**
 * Created by Melvin on 2015. 12. 10..
 */
public class ExtractTest {

    UrlParserManager urlparserManager = new UrlParserManager();

    MapData mapData = new MapData();

    ExtractDataFromSubProject extractDataFromSubProject = new ExtractDataFromSubProject();


    @Test
    public void ExtractTest() throws Exception {

        String url = "http://c.pineone.net:48080/projects?name=한순호&age=30&sex=male";
        String sub = "name=한순호&age=30&sex=male";

        Map<String, String> extractDataFromURI = mapData.writeDataToMap(url);
        Map<String, String> extractDataFromSubData = extractDataFromSubProject.extractData(url);
        Map<String, String> extractDataFromSubDataUsingToKen = extractDataFromSubProject.useTokenizerExtractData(sub);


        System.out.println("URI 의미 : " + extractDataFromURI);
        System.out.println("SubProject Data : " + extractDataFromSubData);
        System.out.println("SubProject Data(Using Token) : " + extractDataFromSubDataUsingToKen);

    }
}
