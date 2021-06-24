//hashmap 사용해서 다시 풀었음

package PROGRAMMERS;

import java.util.*;

public class 부스트캠프자가진단_No6 {
    public static void main(String[] args) {
        //int[] arr = {1, 2, 3, 3, 3, 3, 4, 4};  //테스트 케이스 1
        //int[] arr = {3, 2, 4, 4, 2, 5, 2, 5, 5};  //테스트 케이스 2
        //int[] arr = {3, 5, 7, 9, 1};    //테스트 케이스 3
        int[] arr = {3, 2, 5, 5, 4, 4, 2, 5, 2, 5, 5};

        List<Integer> answer;
        answer = Solution(arr);
        System.out.println(answer);
    }

    private static List<Integer> Solution (int [] arr) {
        List<Integer> answer = new ArrayList<>();
        Map<Integer, Integer> map = new LinkedHashMap<>();

        for (int a : arr) {
            if(map.get(a) != null){
                int cnt = map.get(a);
                map.put(a, ++cnt);
            } else{
                map.put(a, 1);
            }
        }
        for(int key : map.keySet()){
            if(map.get(key) > 1){
                answer.add(map.get(key));
            }
        }
        if(answer.size() == 0){
            answer.add(-1);
        }

        return answer;
    }
}