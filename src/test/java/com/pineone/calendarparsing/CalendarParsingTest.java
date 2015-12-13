package com.pineone.calendarparsing;

import com.pineone.calenderparsing.CalendarParsing;
import org.junit.Test;

import java.util.Calendar;

/**
 * Created by Melvin on 2015. 12. 13..
 */
public class CalendarParsingTest {


    Calendar calendar = Calendar.getInstance();

    CalendarParsing calendarParsing = new CalendarParsing();

    @Test
    public void calendarParsingTest(){

        calendarParsing.getData(calendar, "yyyy-MM-dd hh:mm:ss(aa)");

        calendarParsing.getData(calendar, "yyyy년 MM월 dd일, hh시 mm분 ss초 (aa)");
    }
}
