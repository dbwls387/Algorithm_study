package PROGRAMMERS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 부스트캠프자가진단_No6 {
    public static void main(String[] args) {
        //int[] arr = {1, 2, 3, 3, 3, 3, 4, 4};  //테스트 케이스 1
        int[] arr = {3, 2, 4, 4, 2, 5, 2, 5, 5};  //테스트 케이스 2
        //int[] arr = {3, 5, 7, 9, 1};    //테스트 케이스 3

        List<Integer> answer;
        answer = Solution(arr);
        System.out.println(answer);
    }

    private static List<Integer> Solution (int [] arr) {
        List<Integer> answer = new ArrayList<>();

        Arrays.sort(arr);

        int cnt = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] == arr[i]) {
                cnt++;
            }
            if (cnt > 0) {
                if ((arr[i] != arr[i - 1]) || (i == arr.length - 1)) {
                    answer.add(cnt + 1);
                    cnt = 0;
                }
            }
        }
        if (answer.size() == 0) {
            answer.add(-1);
        }
        return answer;
    }
}