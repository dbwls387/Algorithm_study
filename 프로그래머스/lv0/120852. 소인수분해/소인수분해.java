import java.util.*;

class Solution {
    public Integer[] solution(int n) {
        HashSet<Integer> hs = new HashSet<>();
        
        for(int i = 2; i <= n; i++) {
            while(n % i == 0) {
                hs.add(i);
                n /= i;
            }
        }
        
        Integer[] answer = hs.toArray(new Integer[0]);
        Arrays.sort(answer);
        
        return answer;
    }
}