//지능형 기차 2

package BOJ;

import java.util.Scanner;
public class No_2460 {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int [] take_off = new int [10];     //내린 사람
        int [] ride = new int [10];         //탄 사람

        for (int i = 0; i < 10; i++) {
            take_off[i] = sc.nextInt();
            ride[i] = sc.nextInt();
        }

        int [] num_arr = new int[10];
        int num = 0;
        for (int i = 0; i < 10; i++) {
            num -= take_off[i];
            num += ride[i];
            num_arr[i] = num;
        }

        int max = 0;
        for (int i = 0; i < 10; i++) {
            if(max < num_arr[i]){
                max = num_arr[i];
            }
        }

        System.out.println(max);
    }
}
