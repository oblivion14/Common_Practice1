package com.pineone.gethtml;

import com.pineone.network.protocolaccess.htmldownload.GetContents;
import org.junit.Test;

/**
 * Created by Melvin on 2015. 12. 20..
 */
public class GetContentsTest {

    GetContents getContents = new GetContents();

    @Test
    public void setGetContents() throws Exception {

        getContents.getContents("http://rgate.net");

    }
}
