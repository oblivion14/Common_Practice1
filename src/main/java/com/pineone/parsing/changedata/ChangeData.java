package com.pineone.parsing.changedata;

/**
 * Created by Melvin on 2015. 12. 6..
 * 전체 문장과 변경을 원하는 문자와, 변경될 문자를 입력받아서 문자를 치환한 값을 리턴해준다.
 *
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
