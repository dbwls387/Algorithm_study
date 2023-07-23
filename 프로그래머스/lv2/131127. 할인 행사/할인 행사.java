import java.util.*;

class Solution {
    
    static Map<String, Integer> map = new HashMap<>();
    
    public int solution(String[] want, int[] number, String[] discount) {        
        int answer = 0;
        
        for(int i = 0; i < 10; i++) {
            map.put(discount[i], map.getOrDefault(discount[i], 0) + 1);
        }
        
        int left = 0;
        while (left + 10 <= discount.length) {
            boolean isTrue = true;
            for (int i = 0; i < want.length; i++) {
                String w = want[i];
                if (map.get(w) == null || map.get(w) != number[i]) {
                    isTrue = false;
                    break;
                }
            }

            if (isTrue) {
                answer++;
            } else {
                isTrue = true;
            }
            
            if (left + 10 == discount.length) break;

            map.put(discount[left], map.get(discount[left]) - 1);
            map.put(discount[left + 10], map.getOrDefault(discount[left + 10], 0) + 1);
            left++;
        }
        
        return answer;
    }
}