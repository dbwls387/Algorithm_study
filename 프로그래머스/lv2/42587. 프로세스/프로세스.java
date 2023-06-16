import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        PriorityQueue<Integer> pque = new PriorityQueue<>(Collections.reverseOrder()); 
        
        for(int i = 0; i < priorities.length; i++) {
            pque.add(priorities[i]);
        }
        
        int idx = 0; 
        while(!pque.isEmpty()) {
            for(int i = 0; i < priorities.length; i++) {
                if(priorities[i] == pque.peek()) {
                    if(location == i) {
                        idx++; 
                        return idx;
                    }
                    
                    idx++;
                    pque.poll();
                }
            }
        }
        
        return idx;
    }
}