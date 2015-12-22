package com.pineone.personal_prac.quiz;

import java.util.Scanner;

/**
 * Created by Melvin on 2015. 12. 22..
 * [문제1] 주어진 문자열 데이터를 가지고 실행결과와 같이 출력되도록 코드를 완성하세요.
 데이터의 형식은 문제, 답, 선택지의 순서로 되어 있으며 구분자는 `(숫자1옆의 키)입니다.
 [실행결과]
 [1] 다음 중 키워드가 아닌 것은?
 1.final 2.True  3.if    4.public

 [2] 다음 중 자바의 연산자가 아닌 것은?
 1.&     2.|     3.++    4.!=    5./     6.^

 [3] 다음 중 메서드의 반환값이 없음을 의미하는 키워드는?
 1.void  2.null  3.false


 */
public class Quiz {

    public static final String divideChar = "\\`";

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int count = 0;
        int totalNum = 0;

        String[] data = {
                "다음 중 키워드가 아닌 것은?`2`final`True`if`public",
                "다음 중 자바의 연산자가 아닌 것은?`6`&`|`++`!=`/`^",
                "다음 중 메서드의 반환값이 없음을 의미하는 키워드는?`1`void`null`false",
        };

        /**
         * [문제3] 문제2에서 완성된 코드를 이용해서, 문제의 순서를 임의로 바꾸고, 선택지도 임의로 바뀌어 출력되도록 하세요.

         void shuffle(String[] data) - 주어진 문자열배열의 각 요소의 순서를 임으로 뒤바꾼다.

         */

        shuffle(data);

        for(int i=0;i<data.length;i++) {
            /** 1. String클래스의 String[] split(String regex, int limit)를 사용해서 문제와 선택지를 나누세요.
                2. 문제를 출력하세요.
                3. 선택지를 나누기 위해 String[] split(String regex)를 사용하세요.
                4.반복문을 이용해서 선택지를 출력하세요. **/


            String[] qnA = data[i].split(divideChar,3);
            System.out.println( "[" + (i+1) + "]." + qnA[0]);

            String[] choose = qnA[2].split(divideChar);

            for(int j = 0 ; j < choose.length; j++){

                System.out.print((j+1) + "." + choose[j]+"  ");
            }
            System.out.println();


            /**
             *
             * 문제2 ]
             *  문제1에서 완성된 코드에 사용자 입력을 받아서 정답여부를 판단하여 마지막에 최종점수를
             실행결과와 같이 출력하도록 코드를 완성하세요.

             [1] 다음 중 키워드가 아닌 것은?
             1.final 2.True  3.if    4.public
             [답]2

             [2] 다음 중 자바의 연산자가 아닌 것은?
             1.&     2.|     3.++    4.!=    5./     6.^
             [답]6

             [3] 다음 중 메서드의 반환값이 없음을 의미하는 키워드는?
             1.void  2.null  3.false
             [답]1 출력코드
             */

            System.out.print("[답] ");
            String answer = scanner.nextLine();



            if(answer.equals(qnA[1])){
                count = count + 1;
            }
            totalNum = qnA.length;
            System.out.println();

        }
        /**
         * 문제 2]
         * "정답개수/전체문항수 :3/3" 출력코드 작성
         */

        System.out.print("정답개수/전체문항수 : " + count + "/" + totalNum);
    } // main

    private static void shuffle(String[] data) {
        /**
         *        // 코드를 완성하세요.
         //  1. 배열data의 개수가 0보다 같거나 적으면 메서드 전체를 빠져나간다.
         //  2. 선택지의 순서를 뒤바꾼다. 반복문과 Math.random()사용

         */

        if(data.length < 1){
            return;

        }
        else{
            for(int k = 0; k < data.length ; k++) {
                int getNum = (int) (Math.random() * data.length);

                String temp;

                temp = data[k];
                data[k] = data[getNum];
                data[getNum] = temp;

            }
        }

    }
}

/**
 * [정리]
 * Split 등 인자값으로 String형을 사용하는 경우 "?"만 전달하면 인식하지 못한다.
 * 특수문자의 경우 "\\?" "\\`" 등 \\를 붙여줘야 인식.
 *
 * .split("\\?",3)
 *   String[] qnA = data[i].split(divideChar,3);
 *   뒤의 int 형 인자를 받는다면 ? 가 아무리 많아도 ? 기준으로 3개 로만 나ㅇ뉘어진다.
 *   data = 안녕?메롱?뭐하니?뭐해?뭘봐? 일 경우
 *   qnA[0] = 안녕 , qnA[1] = 메롱 , qnA[2] = 뭐하니?뭐해?뭘봐?
 *
 *   void 형 메서드를 빠져나오려면 그냥 return; 만..
 *
 *   "뒤섞기" 하기 위해선 temp가 처음과 끝
 *   temp = random1
 *   random1 = random2
 *   random2 = temp
 */

