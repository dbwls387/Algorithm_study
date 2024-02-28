import java.util.*;

class Solution {
    
    static PriorityQueue<Integer> pq = new PriorityQueue<>(); 
    
    public int solution(int[] scoville, int K) {
        int answer = 0;
                
        for(int i = 0; i < scoville.length; i++) {
            pq.offer(scoville[i]); 
        }
        
        while(true) {
            if(pq.peek() >= K || pq.size() < 2) 
                break; 
            
            int x = pq.poll(); 
            int y = pq.poll(); 
            
            if(x == 0 && y == 0) {
                answer = -1; 
                break;
            }                
            
            pq.offer(x + y * 2); 
            
            answer++; 
            
            // ex) [0, 1] : 3 => -1 와 같은 경우 
            // 아래처럼 -1 처리 해줘야 함
            if(pq.peek() < K && pq.size() < 2) {  
                answer = -1; 
                break;
            } 
        }
        
        return answer;
    }
}