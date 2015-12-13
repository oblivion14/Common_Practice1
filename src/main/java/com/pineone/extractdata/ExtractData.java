package com.pineone.extractdata;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Melvin on 2015. 12. 10..
 */
public class ExtractData {


    Map<String, String> catchData = new HashMap<>();

    public void extractData(String fullSubProject) {

        int subProjectNum = 0;

        if (fullSubProject.contains("?")) {
            subProjectNum = fullSubProject.indexOf("?");

            String subProjectStr = fullSubProject.substring(0, subProjectNum);
            catchData.put("SubProjectName", subProjectStr);
        }

        int afterSubPro = subProjectNum + 1;

        catchData = extractEachData(afterSubPro, fullSubProject);

        System.out.println(catchData);


    }

    public Map<String, String> extractEachData(int startNum, String subProject) {


        if (subProject.contains("=")) {

            int lastNumName = subProject.indexOf("=");
            String dataName = subProject.substring(startNum, lastNumName);

            int lastNumValue = subProject.indexOf("&");
            String valueName = subProject.substring(lastNumName + 1, lastNumValue);


            catchData.put(dataName, valueName);


            String afterSubProject = subProject.substring(lastNumValue+1 , subProject.length());

            for(; afterSubProject.contains("="); ){

//            if(afterSubProject.isEmpty() == false){
            if(afterSubProject.contains("&")) {
                    lastNumName = afterSubProject.indexOf("=");
                    dataName = afterSubProject.substring(0, lastNumName);

                    lastNumValue = afterSubProject.indexOf("&");
                    valueName = afterSubProject.substring(lastNumName + 1, lastNumValue);

                    catchData.put(dataName,valueName);
                }
                else {

                lastNumName = afterSubProject.indexOf("=");
                dataName = afterSubProject.substring(0, lastNumName);

                lastNumValue = afterSubProject.length();
                valueName = afterSubProject.substring(lastNumName + 1, lastNumValue);

                catchData.put(dataName,valueName);

                break;
            }


                afterSubProject = afterSubProject.substring(lastNumValue + 1, afterSubProject.length());
            }
            return catchData;
        }
        return null;
    }
}



