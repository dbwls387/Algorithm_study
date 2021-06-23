//이진수

package BOJ;

import java.util.Scanner;

public class No_3460 {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int T = sc.nextInt();
        int [] n_arr = new int[T];
        for (int q = 0; q < T; q++) {
            n_arr[q] = sc.nextInt();
        }

        for (int i = 0; i < T; i++) {
            int[] arr = new int[n_arr[i]];
            int w = 0;
            while (true) {   //이진수 구하기
                arr[w++] = n_arr[i] % 2;
                n_arr[i] = n_arr[i] / 2;
                if(n_arr[i] == 0 || n_arr[i] == 1) {
                    arr[w] = n_arr[i];
                    break;
                }
            }

            for (int j = 0; j < arr.length; j++) {
                if (arr[j] == 1) {
                    System.out.print(j + " ");
                }
            }
        }
    }
}
