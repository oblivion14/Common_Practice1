package com.pineone.parsing.versioncheck.validation;

import com.pineone.parsing.versioncheck.model.Platform;

import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * Created by Melvin on 2015. 12. 20..
 */
 public class DivideVersion {

    public static final String divideChar = ".";

        private Platform platform;
        private String major;
        private String minor;
        private String build;
        private String revision;

        public DivideVersion(Platform platform) {
            this.platform = platform;
        }

        public String getMajor() {
            return major;
        }

        public String getMinor() {
            return minor;
        }

        public String getBuild() {
            return build;
        }

        public String getRevision() {
            return revision;
        }

        public DivideVersion invoke() {
            ArrayList<String> divideVersion = new ArrayList<>();
            StringTokenizer stringTokenizer = new StringTokenizer(platform.getVersion(), divideChar);

            while (stringTokenizer.hasMoreTokens()) {
                divideVersion.add(stringTokenizer.nextToken());
            }

            major = divideVersion.get(0);
            minor = divideVersion.get(1);
            build = divideVersion.get(2);
            revision = divideVersion.get(3);
            return this;
        }
}
