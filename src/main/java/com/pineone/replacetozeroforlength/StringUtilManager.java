package com.pineone.replacetozeroforlength;

/**
 * Created by Melvin on 2015. 12. 10..
 */
public class StringUtilManager {

    CastIntToString castIntToString = new CastIntToString();

    public StringUtilManager() {
    }

    public void stringUtilManager(int number, int length) {
        String stringNumber = this.castIntToString.castIntToString(number);
        int numberLength = stringNumber.length();
        int addZeroLength = length - numberLength;
        String zeroString = "";

        for(int i = 0; i < addZeroLength; ++i) {
            zeroString = zeroString + "0";
        }

        System.out.println(zeroString + number);
    }

}
