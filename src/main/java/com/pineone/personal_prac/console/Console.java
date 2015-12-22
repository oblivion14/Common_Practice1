package com.pineone.personal_prac.console;

import java.util.Scanner;

/**
 * Created by Melvin on 2015. 12. 22..
 이번 문제는 도스창과 같은 콘솔어플리케이션을 만들어보는 것입니다. 도스창 처럼 명령어를 입력하면
 명령어가 실행된 결과를 화면에 보여주는 텍스트 기반의 어플리케이션입니다.(text-based application)

 [문제1] 에제를 실행하면 '>>'와 같은 프롬프트가 나타나서 사용자의 입력을 기다리고,
 사용자가 입력한 내용을 화면에 출력한다. 만일 사용자가 'q' 또는 'Q'를 입력하면 프로그램을 종료한다.
 다음의 예제를 완성하세요.

 [문제2] 사용자가 입력한 명령라인을 공백(' ')을 구분자로 해서 잘라서 배열에 저장한 다음에
 배열의 내용을 출력하는 예제. 코드를 완성하세요.

 */
public class Console {



    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] arrInputData;

        while(true) {
            String prompt = ">> ";
            System.out.print(prompt);

            String commander = scanner.nextLine().trim();

            arrInputData = commander.split("\\s+");

                      /**
                     다음의 코드를 완성하세요. 문제2)
                     1. 입력받은 값에서 앞뒤 공백을 제거한다. (String클래스의 trim()사용)
                     2. 입력받은 명령라인의 내용을 공백을 구분자로 해서 나눠서 argArr에 담는다.
                         String클래스의 split(String regex)를 사용 - 공백이 하나 이상인 경우에도 하나의 공백으로 간주해야함
                         실행결과를 주의깊게 확인하세요.
                 */

            if(commander.equalsIgnoreCase("q")){
                System.out.println("프로그램 종료");
                System.exit(0);
            }

            else {
                for(String data : arrInputData){
                    System.out.println(data);
                }
            }
                  /**
                     다음과 같은 내용의 코드를 넣으세요. 문제1 )
                     1. 화면으로부터 라인단위로 입력받는다.  - java.util.Scanner클래스 사용
                     2. q 또는 Q를 입력하면 실행종료한다.
                  */

        } // while(true)
    } // main
}

/**
 * 실행결과] 문제1 ]
 >>hello
 hello
 >>help
 help
 >>ok
 ok
 >>q
 */

/**
 * [실행결과] 문제 2 ]
 >>java ConsoleEx2.java aaa     bbb      ccc
 java
 ConsoleEx2.java
 aaa
 bbb
 ccc
 >>q
 */

/** [정리]
 자바 특수문자 "\\s+"
 "\s"는 공백을 의미하는데 "\s+" 를 사용하니 하나이상의 공백을 의미.
 실제로 " +"로 사용해도 가능
 arrInputData = commander.split("\\s+");
 로 입력 문자열 1        2 3       4 를 받으면 공백의 크깅 상관없이
 1
 2
 3
 4
 로 저장. "\\s"라면 공백 크기만큼 println이 실행됨을 확인.


 */