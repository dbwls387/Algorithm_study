//소수 찾기

package BOJ;

import java.util.Scanner;

public class No_1978 {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int N = sc.nextInt();
        int[] arr = new int[N];
        int cnt = 0;    //소수가 아닌 것 세기

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        for (int i = 0; i < N; i++) {
            if(arr[i] == 1){    //1은 소수가 아님
                cnt++;
            }
            for (int j = 2; j < arr[i]; j++) {
                if (arr[i] % j == 0) {  //1과 자신을 제외하고 나눠지는 경우
                    cnt++;
                    break;
                }
            }
        }
        System.out.println(N - cnt);    //전체 개수 중에서 소수가 아닌거 제외 = 소수의 개수
    }
}