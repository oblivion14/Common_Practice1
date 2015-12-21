package com.pineone.network.subprojectparsing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * Created by Melvin on 2015. 12. 10..
 *
 * URL 의 SubProject 에 데이터의 정보가 포함되어 있으면 추출하여 Map 형태로 제공해준다.
 */
public class ExtractDataFromSubProject {

    /**
     * "/" 이후와 "?" 이전의 내용을 SubProject 의 이름으로 구분하고 "?" 다음은 데이터의 묶음.
     *  Data 묶음 단위로 나누기 위해서 & 를 구분자로 넣고, 정보 = 값 으로 나누기 위해 "="를 다음 구분자로 제공한다.
     *
     */
    public static final String firstDivideChar = "&";
    public static final String secondDivideChar = "=";
    public static final String getSubProjectDataChar = "?";
    public static final String getSubProjectChar = "/";


    Map<String, String> catchData = new HashMap<>();

    public Map<String, String> extractData(String fullSubProject) {

        int subProjectLastNum = 0;
        int subProjectStartNum = 0;

        if (fullSubProject.contains(getSubProjectDataChar)) {
            subProjectStartNum = fullSubProject.lastIndexOf(getSubProjectChar);
            subProjectLastNum = fullSubProject.indexOf(getSubProjectDataChar);


            /**
             * "/"와 "?"사이의 내용을 SubProject 의 이름으로 추출해낸다.
             * ex )
             * /projects?name=한순호&age=30&sex=male - name : projects
             */
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

        /**
         * StringTokenizer 를 생성하여 "&"를 구분자로 나누어서 ArrayList 에 저장함
         * name=한순호&age=30&sex=male 일 경우 name=한순호 , age=30 , sex=male 로 나뉜다.
         */
        StringTokenizer stringTokenizer = new StringTokenizer(subProject, firstDivideChar);

        while (stringTokenizer.hasMoreTokens()) {
            collectData.add(stringTokenizer.nextToken());
        }

        String[] dataSet = null;
        String data = null;

        /**
         * 저장되어 있는 데이터들을 "=" 기준으로 정보=값 의 형태로 나뉘어 맵에 저장하여 준다.
         * Key 는 정보명, Value 는 값
         */
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




