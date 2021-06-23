//최소, 최대

package BOJ;

import java.util.Scanner;

public class No_10818 {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int N = sc.nextInt();
        int [] arr = new int [N];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        int min = arr[0];
        int max = arr[0];
        for (int i = 0; i < N; i++) {
            if(arr[i] < min) {  //최소
                min = arr[i];
            }
            if(max < arr[i]) {  //최대
                max = arr[i];
            }
        }
        System.out.println(min + " " + max);
    }
}
