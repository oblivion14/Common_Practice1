package com.pineone.converthexa;

/**
 * Created by Melvin on 2015. 12. 13..
 */
public class ConvertToInt {

    public int convertToHexaInt(String data) {

        String strFirstNumber = data.substring("0x".length(), "0x".length() + 1);
        String strSecondNumber = data.substring("0x".length()+1, "0x".length() + 2);

        int firstNum = getNum(strFirstNumber);

        int secondNum = getNum(strSecondNumber);

        int result = (firstNum * 16) + secondNum;

        return result;

    }

    private int getNum(String strFirstNumber) {
        int firstNum;
        if(strFirstNumber.equals("a") | strFirstNumber.equals("b") | strFirstNumber.equals("c") |
                strFirstNumber.equals("d") | strFirstNumber.equals("e") | strFirstNumber.equals("f")){
            firstNum = convertToInt(strFirstNumber);
        }
        else{
        firstNum = Integer.parseInt(strFirstNumber);
    }
        return firstNum;
    }


    int convertToInt(String data) {
        if (data.equals("a")) {
            return 10;
        }
        if (data.equals("b")) {
            return 11;
        }
        if (data.equals("c")) {
            return 12;
        }
        if (data.equals("d")) {
            return 13;
        }
        if (data.equals("e")) {
            return 14;
        }
        if (data.equals("f")) {
            return 15;
        }

        return 0;
    }
}
