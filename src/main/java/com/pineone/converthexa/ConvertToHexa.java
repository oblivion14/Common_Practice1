package com.pineone.converthexa;

/**
 * Created by Melvin on 2015. 12. 13..
 */
public class ConvertToHexa {

    public String convertToHexaString(int number) {

        int convertFirstNum = number / 16;

        String convertFirstNumStr = ""+convertFirstNum;

        if (convertFirstNum >= 10) {
            convertFirstNumStr = convertToChar(convertFirstNum);
        }


        int convertSecondNum = number%16;

        String convertSecondNumStr = ""+convertSecondNum;

        if (convertSecondNum >= 10) {
            convertSecondNumStr = convertToChar(convertSecondNum);
        }


        String convertValue = "" + convertFirstNumStr + convertSecondNumStr;

        System.out.println("16진수로 표현 : " + convertValue);
        String hexaStr = "0x" + convertValue;

        return hexaStr;
    }


    String convertToChar(int convertFirstNum){
        if(convertFirstNum == 10){
            return "a";
        }
        if(convertFirstNum == 11){
            return "b";
        }
        if(convertFirstNum == 12){
            return "c";
        }
        if(convertFirstNum == 13){
            return "d";
        }
        if(convertFirstNum == 14){
            return "e";
        }
        if(convertFirstNum == 15){
            return "f";
        }
        if(convertFirstNum == 16){
            return "1";
        }
        else
            return "";

    }
}
