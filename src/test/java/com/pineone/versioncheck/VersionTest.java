package com.pineone.versioncheck;

import com.pineone.versioncheck.model.Platform;
import org.junit.Test;

/**
 * Created by Melvin on 2015. 12. 20..
 */
public class VersionTest {


    VersionCheck versionCheck = new VersionCheck();

    Platform platform = new Platform();

    Platform platform1 = new Platform();
    Platform platform2 = new Platform();

    @Test
    public void removeVersionTest() throws Exception {

        platform.setName("Melvin");

        platform.setVersion("1.0.0.0");

        platform = versionCheck.checkVersion(platform);

        System.out.println(platform.getName() + " " + platform.getVersion());
    }


    @Test
    public void nullVersionTest() throws Exception {

        platform.setName("Melvin");

        platform = versionCheck.checkVersion(platform);

        System.out.println(platform.getName() + " "+  platform.getVersion());

    }

    @Test
    public void compareVersionTest() throws Exception {

        platform1.setName("MelvinBefore");
        platform1.setVersion("3.0.4.12");

        platform2.setName("MelvinCurrent");
        platform2.setVersion("3.0.4.10");

        versionCheck.versionCompare(platform1, platform2);

    }
}
