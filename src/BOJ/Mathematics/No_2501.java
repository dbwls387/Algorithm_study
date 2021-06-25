//약수 구하기

package BOJ.Mathematics;

import java.util.Scanner;

public class No_2501 {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int N = sc.nextInt();
        int K = sc.nextInt();

        int[] arr = new int[N]; //약수 들을 저장할 배열

        int q = 0;
        for (int i = 1; i <= N; i++) {
            if (N % i == 0) {   //약수
                arr[q++] = i;
            }
        }

        if (arr.length < K) {   //약수의 개수가 K개보다 적을 경우
            System.out.println(0);  //0을 출력
        } else {
            System.out.println(arr[K-1]);   //K번째로 작은 수 출력
        }
    }
}