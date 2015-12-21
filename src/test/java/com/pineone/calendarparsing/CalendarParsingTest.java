package com.pineone.calendarparsing;

import com.pineone.parsing.calenderparsing.CalendarParsing;
import org.junit.Test;

/**
 * Created by Melvin on 2015. 12. 13..
 */
public class CalendarParsingTest {

    CalendarParsing calendarParsing = new CalendarParsing();

    @Test
    public void calendarParsingTest(){

        String changeSentence = calendarParsing.getData("yyyy-MM-dd hh:mm:ss(aa)");
        System.out.println(changeSentence);

        String changeSentence1 = calendarParsing.getData("yyyy년 MM월 dd일, hh시 mm분 ss초 (aa)");
        System.out.println(changeSentence1);

    }

}
