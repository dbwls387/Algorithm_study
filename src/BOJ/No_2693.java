//N번째 큰 수

package BOJ;

import java.util.Arrays;
import java.util.Scanner;

public class No_2693 {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int T = sc.nextInt();
        int [] arr = new int[10];
        int [] answer = new int[T];

        for (int i = 0; i < T; i++) {
            for (int j = 0; j < 10; j++) {
                arr[j] = sc.nextInt();
            }

            Arrays.sort(arr);
            answer[i] = arr[7];
        }

        for (int i = 0; i < T; i++) {
            System.out.println(answer[i]);
        }
    }
}