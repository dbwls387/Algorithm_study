//피보나치 수 5

package BOJ;

import java.util.Scanner;
public class No_10870 {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int n = sc.nextInt();
        int[] fn = new int[n + 1];

        fn[0] = 0;
        if (n != 0) {
            fn[1] = 1;
            for (int i = 2; i <= n; i++) {
                fn[i] = fn[i - 1] + fn[i - 2];
            }
        }
        System.out.println(fn[n]);
    }
}
