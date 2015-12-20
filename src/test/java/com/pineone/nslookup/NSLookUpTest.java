package com.pineone.nslookup;

import com.pineone.network.nslookup.NsLookUpManager;
import org.junit.Test;

/**
 * Created by Melvin on 2015. 12. 6..
 */
public class NSLookUpTest {

    NsLookUpManager nsLookUpManager = new NsLookUpManager();

    @Test
    public void nSLookUpTest() throws Exception {

        String domainName = "c.pineone.net";

        nsLookUpManager.executeNsLookUpManager(domainName);

    }

    @Test
    public void nSLookUpTest2() throws Exception {

        String domainName = "www.google.co.kr";

        nsLookUpManager.executeNsLookUpManager(domainName);

    }

    @Test
    public void nSLookUpTest3() throws Exception {

        String domainName = "www.naver.com";

        nsLookUpManager.executeNsLookUpManager(domainName);

    }

}
