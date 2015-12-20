package com.pineone.network.subprojectparsing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * Created by Melvin on 2015. 12. 10..
 */
public class ExtractDataFromSubProject {

    public static final String firstDivideChar = "&";
    public static final String secondDivideChar = "=";
    public static final String getSubProjectDataChar = "?";
    public static final String getSubProjectChar = "/";


    Map<String, String> catchData = new HashMap<>();

    public Map<String, String> extractData(String fullSubProject) {

        int subProjectLastNum = 0;
        int subProjectStartNum = 0;

        if (fullSubProject.contains(getSubProjectDataChar)) {
            subProjectLastNum = fullSubProject.indexOf(getSubProjectDataChar);
            subProjectStartNum = fullSubProject.lastIndexOf(getSubProjectChar);


            String subProjectStr = fullSubProject.substring(subProjectStartNum + 1, subProjectLastNum);
            catchData.put("SubProjectName", subProjectStr);
        }
        else {
            catchData.put("SubProjectName", fullSubProject);

        }

        int afterSubPro = subProjectLastNum + 1;

        catchData = extractEachData(afterSubPro, fullSubProject);

//        System.out.println(catchData);

        return catchData;


    }

    public Map<String, String> extractEachData(int startNum, String subProject) {

        int lastNumName = subProject.indexOf(secondDivideChar);
        String dataName = subProject.substring(startNum, lastNumName);

        int lastNumValue = subProject.indexOf(firstDivideChar);
        String valueName = subProject.substring(lastNumName + 1, lastNumValue);


        catchData.put(dataName, valueName);


        String afterSubProject = subProject.substring(lastNumValue + 1, subProject.length());

        for (; afterSubProject.contains(secondDivideChar); ) {

//            if(afterSubProject.isEmpty() == false){
            if (afterSubProject.contains(firstDivideChar)) {
                lastNumName = afterSubProject.indexOf(secondDivideChar);
                dataName = afterSubProject.substring(0, lastNumName);

                lastNumValue = afterSubProject.indexOf(firstDivideChar);
                valueName = afterSubProject.substring(lastNumName + 1, lastNumValue);

                catchData.put(dataName, valueName);
            } else {

                lastNumName = afterSubProject.indexOf(secondDivideChar);
                dataName = afterSubProject.substring(0, lastNumName);

                lastNumValue = afterSubProject.length();
                valueName = afterSubProject.substring(lastNumName + 1, lastNumValue);

                catchData.put(dataName, valueName);

                break;
            }


            afterSubProject = afterSubProject.substring(lastNumValue + 1, afterSubProject.length());
        }
        return catchData;
    }

    public Map<String, String> useTokenizerExtractData(String subProject) {

        Map<String, String> mapData = new HashMap<>();

        ArrayList<String> collectData = new ArrayList<>();

        StringTokenizer stringTokenizer = new StringTokenizer(subProject, firstDivideChar);

        while (stringTokenizer.hasMoreTokens()) {
            collectData.add(stringTokenizer.nextToken());
        }

        String[] dataSet = null;
        String data = null;

        for (int i = 0; i < collectData.size(); i++) {

            data = collectData.get(i);


            if (data.contains(secondDivideChar)) {
                dataSet = data.split(secondDivideChar);
            }

//            for (int j = 0; j < dataSet.length; j++) {

                mapData.put(dataSet[0], dataSet[1]);
//            }

        }
       return mapData;
    }
}




