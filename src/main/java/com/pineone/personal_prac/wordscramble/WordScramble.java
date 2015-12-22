package com.pineone.personal_prac.wordscramble;

import java.util.Scanner;

/**
 * Created by Melvin on 2015. 12. 21..
 * 문제 1 ] getAnswer(String[] strArr)는 배열strArr의 요소중의 하나를 임의로 골라서 반환한다.(Math.random()사용)
 getScrambledWord(String str)는 주어진 문자열 str의 각 문자의 순서를 뒤섞은 다음, 새로운 문자열로 반환한다.
 (Math.random()사용)

 문제 2 ]  1. 화면을 통해 사용자의 입력을 받는다.(Scanner클래스 사용)
 2. 사용자가 q 또는 Q를 입력하면 프로그램을 종료한다.
 3. 사용자가 정답을 맞출때까지 반복하다가
    사용자가 정답을 맞추면, while문을 빠져나간다.

 문제 3 ] [문제3] 문제2의 예제를 변경해서, 문제를 맞추더라도 프로그램이 종료되지 않고 다음문제를 보여주도록 하세요.

 [문제4] 실행결과를 잘 보고, 다음의 예제의 getHint메서드를 완성하세요.

 String getHint(String answer, char[] hint) - 문제의 답의 일부를 보여주는 메서드
 한번 틀릴 때마다 한글자씩 더 보여준다.
 answer - 문제의 정답
 hint - 문제의 이전 힌트(previous hint)


 *
 */
public class WordScramble {

    public static void main(String[] args) {

        String[] strArr = {"CHANGE", "LOVE", "HOPE", "VIEW"};
        Scanner scanner = new Scanner(System.in);

        while (true) {

            String answer = getAnswer(strArr);
            String question = getScrambledWord(answer);
            char[] hint = new char[answer.length()]; // 선택된 answer 길이만큼의 char 배열의 길이를 설정

            /**
             * hint 를 '-'로 초기화 한다. 정답이 LOVE 라면 hint 는 "____"이 된다.
             */
            for (int i = 0; i < hint.length; i++) {
                hint[i] = '_';
            }

            while (true) {

                System.out.println("Question :" + question);
                System.out.print("Your answer is :");

                String guess = scanner.nextLine();

                if (guess.equalsIgnoreCase("Q")) {
                    System.out.println("프로그램을 종료합니다.");
                    System.exit(0);
                }

                if (guess.equalsIgnoreCase(answer) == false) {
                    System.out.println("정답이 아닙니다. 다시 입력해주세요");
                    System.out.println("Hint: " + getHint(answer, hint));
                } else if (guess.equalsIgnoreCase(answer) == true) {
                    System.out.println("정답입니다.");
                    System.out.println();
                    break;
                } else
                    continue;

            } // while
        }
    }

    public static void guessAnswerOneTime(String answer, String question) {
        while(true) {

            System.out.println("Question :" + question);
            System.out.print("Your answer is :");

            Scanner scanner = new Scanner(System.in);
            String guess = scanner.next();

            if(guess.equals("q") || guess.equals("Q")){
                System.out.println("프로그램을 종료합니다.");
                System.exit(0);
            }

            if(guess.equalsIgnoreCase(answer) == false){
                System.out.println("정답이 아닙니다. 다시 입력해주세요");
                continue;
            }
            else if(guess.equalsIgnoreCase(answer) == true){
                System.out.println("정답입니다.");
                break;
            }
            else
                continue;

        } // while
    }

    public static void guessAnswerManyTime(String answer, String question) {
        while(true) {

            String[] strArr = { "CHANGE", "LOVE", "HOPE", "VIEW"};

            answer = getAnswer(strArr);
            question = getScrambledWord(answer);

            System.out.println("Question :" + question);
            System.out.print("Your answer is :");

            Scanner scanner = new Scanner(System.in);
            String guess = scanner.next();

            if(guess.equalsIgnoreCase("q")){
                System.out.println("프로그램을 종료합니다.");
                System.exit(0);
            }

            if(guess.equalsIgnoreCase(answer) == false){
                System.out.println("정답이 아닙니다. 다시 입력해주세요");
                continue;
            }
            else if(guess.equalsIgnoreCase(answer) == true){
                System.out.println("정답입니다.");
                System.out.println();
                break;
            }
            else
                continue;

        } // while
    }

//    public String getAnswer(String[] strArr); //내용 완성
//
//    public String getScrambledWord(String str) ; // 내용 완성

    /**
     * 입력받은 String[] 단어중에서 랜덤으로 하나의 단어를 선택하여 반환해 준다.
     * @param strArr
     * @return
     */
    public static String getAnswer(String[] strArr){

        int getNumber = (int) (Math.random() *strArr.length);

        return strArr[getNumber];
    }

    /**
     * 입력받은 문자열을 Char 형 배열로 바꾸어서 안의 문자를 랜덤하게 섞어서 반환해준다.
     *
     * @param str
     * @return
     */

    public static String getScrambledWord(String str) {

       char[] chArr = str.toCharArray();

        for(int i=0; i<str.length(); i++) {
            int idx = (int) (Math.random() * str.length());

            char tmp = chArr[0];
            chArr[0] = chArr[idx];
            chArr[idx] = tmp;
        }

        return new String(chArr);
    }

    public static String getHint(String answer, char[] hint){

        int count = 0; // 힌트에 포함된 '_'의 개수

        /** 1. 반복문을 이용해서 hint에 포함된 '_'의 개수를 센다.
            2. count의 값이 2보다 클 때만 정답의 한 글자를 hint에 넣는다.
            정답을 다 알려주는 상황이 되지 않게 하기 위함.

            [주의] 반드시 이전 힌트 보다 한글자를 더 보여줘야함.
            예를 들어 정답이 "LOVE"이고 이전 힌트가 "L___"이었다면
            그 다음 힌트는 "L__E"또는 "L_V_" 와 같은 식이어야 한다.
            Math.random()을 사용해서 정답의 한 글자를 골라서 힌트에 넣으면 된다.
         */

       for(int i=0; i < hint.length; i++){
           if(hint[i] == '_'){
               count ++;
           }
       }

        if(count > 2){
            while(true){
                int getNum = (int)(Math.random() * answer.length());

                if(hint[getNum] == '_'){
                    hint[getNum] = answer.charAt(getNum);
                    break;
                }
            }
        }

        return new String(hint);
    }
    /**
     * [정리]
     *
     * Math.random() 은 소수점을 반환
     * int(Math.random() * 정수) 를 해주어야 원하는 값을 얻을 듯.
     *
     * .toCharArray();
     * char[] chArr = str.toCharArray()를 사용하면
     * str에 담겨있는 String 내용을 Char형으로 쪼개서 Char[]에 담아서 사용 가능.
     * 사용 ex) String 형 문자 뒤섞기.
     *
     * new String(chArr)
     * chArr.toString (주소값 저장됨) 이 아닌 chArr안에 들어있는 문자들의 실제 내용을 생성
     *
     * .CharAt(getNum)
     * String.CharAt(int a)를 사용하면 String의 Int번째 문자를 뽑아 char형으로 추출
     */
}



