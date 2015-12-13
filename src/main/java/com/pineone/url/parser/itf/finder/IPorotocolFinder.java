package com.pineone.url.parser.itf.finder;

/**
 * Created by Melvin on 2015. 12. 6..
 */
public interface IPorotocolFinder {

    /**
     * 입력받은 URL에서 Protocol 부분을 찾는다.
     * 기준은 " // " 앞부분
     */

    String findProtocol(String URL);

    String findExcludeProtocol(String url);

    String validationExcludeProtocol(String URL);

    String validationProtocol(String URL);


}
