import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {        
        Map<Integer, Integer> map = new HashMap<>(); 
        
        for(int i = 0; i < tangerine.length; i++) {
            if(map.containsKey(tangerine[i])) {
                map.put(tangerine[i], map.get(tangerine[i]) + 1);
            } else {
                map.put(tangerine[i], 1);
            }
        }
        
        // map 정렬
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort((o1, o2) -> map.get(o2.getKey()) - map.get(o1.getKey()));
        
        // for(int i = 0; i < list.size(); i++) {
        //     System.out.println(list.get(i).getValue());
        // }
        
        int sum = 0;
        int answer = 0;
        for(int i = 0; i < list.size(); i++) {
            if(sum >= k) 
                break;
            
            sum += list.get(i).getValue();
            answer++;
        }
        
        return answer;
    }
}