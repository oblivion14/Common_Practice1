package com.pineone.parsing.calenderparsing;

import java.util.Calendar;

/**
 * Created by Melvin on 2015. 12. 13..
 */
public class CalendarParsing {

    ChangeArrayData changeArrayData = new ChangeArrayData();

    /**
     * 캘린더 클래스를 이용하여서 년.월.일 등의 정보를 받아온다.
     * 출력하고 싶은 달력 출력 포맷형태를 받아서 매핑하여 출력해준다.
     * @param format
     * @return
     */
    public String getData( String format){

        Calendar calendar = Calendar.getInstance();

        int year = calendar.get(Calendar.YEAR); // 년도를 리턴
        int month = calendar.get(Calendar.MONTH) + 1; // 월을 리턴
        int day = calendar.get(Calendar.DAY_OF_MONTH); // 일을 리턴
        int week = calendar.get(Calendar.DAY_OF_WEEK); // 요일을 리턴
        int amPm = calendar.get(Calendar.AM_PM); // 오전/오후를 리턴
        int hour = calendar.get(Calendar.HOUR); // 시를 리턴
        int minute = calendar.get(Calendar.MINUTE); // 분을 리턴
        int second = calendar.get(Calendar.SECOND); // 초를 리턴


    /**
    * "aa"가 있는 경우 AM/PM을 반영한다.
    */
        if(format.contains("aa")){
            String[] beforeYear = {"yyyy","MM", "dd", "hh", "mm", "ss", "aa"};

            String amPmStr = getParseAmPm(amPm);

            String[] afterYear= {""+year , ""+month , ""+day, ""+hour, ""+minute, ""+second, amPmStr};

            String changeSentence = changeArrayData.changeArrToStr(format, beforeYear, afterYear);

            return changeSentence;
        }

        else {


            String[] beforeYear = {"yyyy", "MM", "dd", "hh", "mm", "ss"};

            String[] afterYear = {"" + year, "" + month, "" + day, "" + hour, "" + minute, "" + second};

            String changeSentence = changeArrayData.changeArrToStr(format, beforeYear, afterYear);

            return changeSentence;
        }

//        String changeYear = changeData.changeData(format, beforeYear, afterYear);


//        System.out.println(changeYear);

//        System.out.println(year+"-"+month+"-"+day+" "+hour+":"+minute+":"+second+"("+amPmStr+")");



//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
//
//        costomizeCalendar(now)
//
//
//        System.out.println(simpleDateFormat.format(now));

    }

    private String getParseAmPm(int amPm) {

       if(amPm == 1)
           return "PM";
        else
           return "AM";
    }


}
