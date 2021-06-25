//일곱 난쟁이

package BOJ.Bruteforcing_Algorithm;

import java.util.Arrays;
import java.util.Scanner;
public class No_2309 {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int [] arr = new int[9];

        int sum = 0;
        for (int i = 0; i < 9; i++) {
            arr[i] = sc.nextInt();
            sum += arr[i];
        }

        int tall = 0;
        int a=0, b=0;   //가짜 난쟁이들
        for (int i = 0; i < 9; i++) {
            for (int j = i+1; j < 9; j++) {
                tall = sum - arr[i] -arr[j];
                if(tall == 100){
                    a = arr[i];
                    b = arr[j];
                    break;
                }
            }
        }

        Arrays.sort(arr);   //정렬
        for (int i = 0; i < 9; i++) {
            if(arr[i] != a && arr[i] != b) { //가짜 난쟁이 제외 출력
                System.out.println(arr[i]);
            }
        }
    }
}