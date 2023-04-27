import java.util.*;

class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        int sum = brown + yellow;
        for(int i = 1; i <= sum; i++) {
            if(sum % i == 0) {                
                if((i-2) * (sum/i - 2) == yellow) {                   
                    answer[0] = sum / i;
                    answer[1] = i;
                    break;
                }
            }
        }
        
        return answer;
    }
}