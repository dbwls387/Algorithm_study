//쉽게 푸는 문제

package BOJ;

import java.util.Scanner;
public class No_1292 {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int a = sc.nextInt();
        int b = sc.nextInt();
        int[] arr = new int[1000];

        int q = 0;
        for (int i = 0; i < 1000; i++) {
            if (q == 1000) {
                break;
            }
            for (int j = 0; j < i; j++) {
                arr[q++] = i;
                if (q == 1000) {
                    break;
                }
            }
        }

        int sum = 0;
        for (int i = a - 1; i < b; i++) {
            sum += arr[i];
        }
        System.out.println(sum);
    }
}