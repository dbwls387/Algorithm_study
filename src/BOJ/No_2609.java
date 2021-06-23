//최대공약수와 최소공배수

package BOJ;

import java.util.Scanner;
public class No_2609 {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int a = sc.nextInt();
        int b = sc.nextInt();

        System.out.println(gcd(a, b));
        System.out.println(lcm(a, b));
    }

    public static int gcd (int a, int b) {    //최대공약수 재귀
        if(b == 0)
            return a;
        return gcd(b, a%b);
    }

    public static int lcm (int a, int b) {  //최소공배수
        return a*b / gcd(a, b);
    }
}