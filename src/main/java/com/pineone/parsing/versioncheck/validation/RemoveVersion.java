package com.pineone.parsing.versioncheck.validation;

import com.pineone.parsing.versioncheck.model.Platform;
import org.springframework.stereotype.Service;

/**
 * Created by Melvin on 2015. 12. 20..
 */

@Service
public class RemoveVersion {


    public static final String checkChar = ".0";


    Platform platform = new Platform();

    public Platform removeCheck(String name , String version){

        platform.setName(name);

        for(; version.endsWith(checkChar) == true ;){

            int num = version.lastIndexOf(checkChar);
            platform.setVersion(version.substring(0,num));
            version = platform.getVersion();

        }


        return platform;

    }
}
