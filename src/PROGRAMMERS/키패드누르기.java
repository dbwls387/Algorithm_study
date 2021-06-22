package PROGRAMMERS;

import java.util.Scanner;

public class 키패드누르기 {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int arr_len = sc.nextInt(); //배열의 크기 먼저 입력받기
        int[] numbers = new int[arr_len];  //numbers 배열 입력받기
        for (int i = 0; i < arr_len; i++) {
            numbers[i] = sc.nextInt();
        }
        String hand = sc.next();    //어느 손 잡이인지 입력받기

        String answer = solution(numbers, hand);

        System.out.println(answer);
    }

    private static String solution(int[] numbers, String hand) {
        Scanner sc = new Scanner(System.in);
        StringBuffer answer = new StringBuffer();

        int left = 10;  //*    //현재의 왼손 위치
        int right = 12; //#    //현재의 오른손 위치

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == 1 || numbers[i] == 4 || numbers[i] == 7) { //왼손
                answer.append("L");
                left = numbers[i];
            } else if (numbers[i] == 3 || numbers[i] == 6 || numbers[i] == 9) { //오른손
                answer.append("R");
                right = numbers[i];
            } else {
                if (numbers[i] == 0) {   //키패드 0은 11로 치환
                    numbers[i] = 11;
                }
                int dis_l = (Math.abs(numbers[i] - left) / 3) + (Math.abs(numbers[i] - left) % 3);
                //현재 왼손과 누를 키패드의 거리
                int dis_r = (Math.abs(numbers[i] - right) / 3) + (Math.abs(numbers[i] - right) % 3);
                //현재 오른손과 누를 키패드의 거리

                if (dis_l < dis_r) {  //왼손과의 거리가 더 짧을 경우 왼손으로 누르기
                    answer.append("L");
                    left = numbers[i];
                } else if (dis_l > dis_r) {  //오른손과의 거리가 더 짧을 경우 오른손으로 누르기
                    answer.append("R");
                    right = numbers[i];
                } else {  //왼손 오른손의 거리가 같을 경우
                    if (hand.equals("left")) { //왼손잡이이면 왼손으로 누르기
                        answer.append("L");
                        left = numbers[i];
                    } else {  //오른손잡이이면 오른손으로 누르기
                        answer.append("R");
                        right = numbers[i];
                    }
                }
            }
        }

        return answer.toString();
    }
}