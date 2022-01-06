// 1003 피보나치 함수

package BOJ.Dynamic_programming;

import java.util.Scanner;

public class No_1003 {
    static Scanner sc=new Scanner(System.in);
    public static void main(String[] args) {
        int T = sc.nextInt();
        int []N = new int[T];
        for (int i = 0; i < T; i++) {
            N[i] = sc.nextInt();
        }

        int [][]cnt = new int[41][2];
        //N은 0~40까지의 수이기 때문에 배열의 크기는 41이고,
        //0과 1의 횟수를 구하는 거라서 배열의 크기는 2이다.

        cnt[0][0] = 1;
        cnt[0][1] = 0;
        cnt[1][0] = 0;
        cnt[1][1] = 1;
        for (int i = 2; i < 41; i++) {  //N=0, 1일 경우는 위에서 미리 넣었기 때문에 i=2부터 시작
            for (int j = 0; j < 2; j++) {
                cnt[i][j] = cnt[i - 2][j] + cnt[i - 1][j];
            }
        }

        for (int i = 0; i < T; i++) {   //출력
            System.out.println(cnt[N[i]][0] + " " + cnt[N[i]][1]);
        }
    }
}