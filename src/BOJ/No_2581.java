//소수

package BOJ;

import java.util.Scanner;
public class No_2581 {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int m = sc.nextInt();
        int n = sc.nextInt();

        int min = 0, sum = 0;
        for (int i = m; i <= n; i++) {
            if (prime(i) != 0) {  //소수일 경우
                if (sum == 0) {
                    min = i;
                }
                sum += i;
            }
        }
        if (sum == 0) {
            System.out.println(-1);
        } else {
            System.out.println(sum);
            System.out.println(min);
        }
    }
    private static int prime(int n){
        //소수가 아닐 경우 0을 리턴
        if(n == 1){    //1은 소수가 아님
            return 0;
        }
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {  //1과 자신을 제외하고 나눠지는 경우
                return 0;
            }
        }
        return 1;
    }
}