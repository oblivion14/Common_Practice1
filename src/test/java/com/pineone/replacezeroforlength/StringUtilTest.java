package com.pineone.replacezeroforlength;

import org.junit.Test;

import com.pineone.replacetozeroforlength.StringUtilManager;

/**
 * Created by Melvin on 2015. 12. 10..
 */
public class StringUtilTest {
    StringUtilManager stringUtilManager = new StringUtilManager();

    public StringUtilTest() {
    }

    @Test
    public void stringUtilTest() throws Exception {
        byte num = 12;
        byte length = 4;
        this.stringUtilManager.stringUtilManager(num, length);
    }

    @Test
    public void stringUtilTest1() throws Exception {
        short num = 350;
        byte length = 8;
        this.stringUtilManager.stringUtilManager(num, length);
    }

    @Test
    public void stringUtilTest2() throws Exception {
        byte num = 10;
        byte length = 14;
        this.stringUtilManager.stringUtilManager(num, length);
    }
}
