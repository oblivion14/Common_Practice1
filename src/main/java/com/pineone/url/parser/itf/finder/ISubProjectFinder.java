package com.pineone.url.parser.itf.finder;

/**
 * Created by Melvin on 2015. 12. 6..
 */

/**
 * 입력받은 String형 URL에서 HOST부분을 찾는다.
 * 기준은  " / " 다음부터 " / "까지
 */
public interface ISubProjectFinder {

    String findSubProject(String URL);


}
