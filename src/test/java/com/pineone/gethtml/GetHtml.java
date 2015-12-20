package com.pineone.gethtml;

import com.pineone.network.protocolaccess.htmldownload.DownHtml;
import org.junit.Test;

/**
 * Created by Melvin on 2015. 12. 20..
 */
public class GetHtml {

    DownHtml downHtml = new DownHtml();

    @Test
    public void testName() throws Exception {

        downHtml.getImage("http://freestory.net/wp/wp-content/uploads/2015/03/docker012.png");

        downHtml.getContents("http://rgate.net");

    }
}
