package com.pineone.versioncheck;

import com.pineone.versioncheck.model.Platform;
import com.pineone.versioncheck.validation.DivideVersion;
import com.pineone.versioncheck.validation.RemoveVersion;

/**
 * Created by Melvin on 2015. 12. 20..
 */
public class VersionCheck
{

	public static final String	initialVersion	= "0.0.0.1";
    public static final String checkChar = ".0";


    RemoveVersion				removeVersion	= new RemoveVersion();

	public Platform checkVersion(Platform platform)
	{
        if(platform.getVersion() == null){
            platform.setVersion(initialVersion);
        }

        DivideVersion divideVersion = new DivideVersion(platform).invoke();
        String major = divideVersion.getMajor();
        String minor = divideVersion.getMinor();
        String build = divideVersion.getBuild();
        String revision = divideVersion.getRevision();

        System.out.println("name : "  + platform.getName() +
                ", major : " + major + ", minor : " + minor + ", build : " + build + ", revision : " + revision);



        if(platform.getVersion().endsWith(checkChar) == true) {
            platform = removeVersion.removeCheck(platform.getName(),
                    platform.getVersion());
        }

        return platform;
    }

    public void versionCompare(Platform platform1 , Platform platform2){


        DivideVersion divideVersion1 = new DivideVersion(platform1).invoke();
        int major1 = Integer.parseInt(divideVersion1.getMajor());
        int minor1 = Integer.parseInt(divideVersion1.getMinor());
        int build1 = Integer.parseInt(divideVersion1.getBuild());
        int revision1 = Integer.parseInt(divideVersion1.getRevision());

        System.out.println("name : "  + platform1.getName() + ", version : " + platform1.getVersion());
        System.out.println(
                "major : " + major1 + ", minor : " + minor1 + ", build : " + build1 + ", revision : " + revision1);

        DivideVersion divideVersion2 = new DivideVersion(platform2).invoke();
        int major2 = Integer.parseInt(divideVersion2.getMajor());
        int minor2 = Integer.parseInt(divideVersion2.getMinor());
        int build2 = Integer.parseInt(divideVersion2.getBuild());
        int revision2 = Integer.parseInt(divideVersion2.getRevision());

        System.out.println("name : "  + platform2.getName() + " , version : " + platform1.getVersion());
        System.out.println(
                "major : " + major2 + ", minor : " + minor2 + ", build : " + build2 + ", revision : " + revision2);

        int gapMajorVersion;
        int gapMinorVersion;
        int gapBuildVersion;
        int gapRevisionVersion;


        if(major1 > major2) {
            gapMajorVersion = major1 - major2;
            System.out.println(platform1.getName() + "의 MajorVersion 이" + gapMajorVersion + " 만큼 높습니다.");


        }
            else if(major2 > major1){
            gapMajorVersion= major2 - major1;
            System.out.println(platform2.getName() + "의 MajorVersion 이" + gapMajorVersion + " 만큼 높습니다.");

            }

        else{

            if(minor1 > minor2) {
                gapMinorVersion = minor1 - minor2;
                System.out.println(platform1.getName() + "의 MinorVersion 이" + gapMinorVersion + " 만큼 높습니다.");
            }
            else if(minor2 > minor1) {
                gapMinorVersion = minor2 - minor1;
                System.out.println(platform2.getName() + "의 MinorVersion 이" + gapMinorVersion + " 만큼 높습니다.");

            }
            else{
                if(build1 > build2) {
                    gapBuildVersion = build1 - build2;
                    System.out.println(platform1.getName() + "의 BuildVersion 이" + gapBuildVersion + " 만큼 높습니다.");
                }

                else if(minor2 > minor1) {
                    gapBuildVersion = build2 - build1;
                    System.out.println(platform2.getName() + "의 BuildVersion 이" + gapBuildVersion + " 만큼 높습니다.");
                }
                else{
                    if(revision1 > revision2) {
                        gapRevisionVersion = revision1 - revision2;
                        System.out.println(platform1.getName() + "의 RevisionVersion 이" + gapRevisionVersion + " 만큼 높습니다.");
                    }

                    else if(revision2 > revision1) {
                        gapRevisionVersion = revision2 - revision1;
                        System.out.println(platform2.getName() + "의 RevisionVersion 이" + gapRevisionVersion + " 만큼 높습니다.");

                    }
                    else
                        System.out.println("두 플랫폼의 버전은 같습니다");
                }
            }


        }

    }


}


