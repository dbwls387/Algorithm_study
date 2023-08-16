import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        
        int size = topping.length; 
        int[] left_arr = new int[size];
        int[] right_arr = new int[size];
        int left_cnt = 0; 
        int right_cnt = 0; 
        Set<Integer> left_set = new HashSet<Integer>();
        Set<Integer> right_set = new HashSet<Integer>();
        
        for(int i = 0; i < size; i++) {
            if(!left_set.contains(topping[i])) {
                left_cnt++; 
            } 
            left_arr[i] = left_cnt; 
            
            if(!right_set.contains(topping[size - i - 1])) {
                right_cnt++; 
            } 
            right_arr[size - i - 1] = right_cnt; 
            
            left_set.add(topping[i]); 
            right_set.add(topping[size - i - 1]); 
        }
        
        for(int i = 0; i < size - 1; i++) {
            if(left_arr[i] == right_arr[i + 1]) 
                answer++; 
        }
        
        return answer;
    }
}