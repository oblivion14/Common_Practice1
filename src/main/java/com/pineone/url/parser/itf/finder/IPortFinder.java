package com.pineone.url.parser.itf.finder;

/**
 * Created by Melvin on 2015. 12. 6..
 */

/**
 * 입력받은 URL로 부터 Port부분을 찾는다.
 *
 * Exception..Port가 Null일경우 기본 포트인 80번을 지정해준다.
 * 기준은 " : "부터 " / " 까지.

 */
public interface IPortFinder {

    String findPort(String URL);

            //has Exception (null PortNum)



}
