package com.pineone.changedata;

import com.pineone.parsing.changedata.ChangeData;
import org.junit.Test;

/**
 * Created by Melvin on 2015. 12. 6..
 */
public class ChangeDataTest {

  ChangeData changeData = new ChangeData();

    @Test
    public void changeDataTest() throws Exception {

        String source = "aaa[kitae]bbb";

        String beforechangeData = "kitae";

        String afterChangeData = "melvin";

        changeData.changeData(source, beforechangeData, afterChangeData);

    }
}
