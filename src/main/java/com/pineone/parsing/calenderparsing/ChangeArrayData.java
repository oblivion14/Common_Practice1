package com.pineone.parsing.calenderparsing;

/**
 * Created by Melvin on 2015. 12. 13..
 */
public class ChangeArrayData {

    String changeArrToStr(String basicText, String[] beforeData, String[] afterData){


        int count = 0;

        for(String data : beforeData) {

                if (basicText.contains(data)) {

                    int num = basicText.indexOf(data);

                    int lastNum = num + data.length();

                    String beforeString = basicText.substring(0, num);

                    String afterString = basicText.substring(lastNum, basicText.length());

                    basicText = beforeString + afterData[count] + afterString;

                    count++;
                }
            }

        return basicText;
        }
    }

