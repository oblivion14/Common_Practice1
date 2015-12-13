package com.pineone.changedata;

/**
 * Created by Melvin on 2015. 12. 6..
 */
public class ChangeData {

    public String changeData (String source , String beforeChangeData , String afterChangeData)
    {
        System.out.println("Basic Source =" + source);

        if(source.contains(beforeChangeData)){

            int num = source.indexOf(beforeChangeData);

            int lastNum = num + beforeChangeData.length() ;

            String beforeString = source.substring(0,num);

            String afterString = source.substring(lastNum,source.length());

            source = beforeString + afterChangeData + afterString;

            System.out.println("Change Data=" + source);

            return source;
        }

        else return source;
    }
}
