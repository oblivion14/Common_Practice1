package com.pineone.parsing.calenderparsing;

/**
 * Created by Melvin on 2015. 12. 13..
 */
public class ChangeArrayData {

    String changeArrToStr(String basicText, String[] beforeData, String[] afterData){


        int count = 0;

        /**
         * 포맷에 맞추어 등록한 형태에 따라 실제 날자의 값으로 대치하여 전달.
         */
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

