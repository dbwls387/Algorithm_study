import java.util.*;

class Solution {
    
    static List<Integer>[] arr; 
    static boolean[] visit;
    
    public int solution(int n, int[][] computers) {
        arr = new ArrayList[n];
        for(int i = 0; i < n; i++) {
            arr[i] = new ArrayList<>();
        }
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {   
                if(i == j) 
                    continue; 
                
                if(computers[i][j] == 1) 
                    arr[i].add(j); 
            }
        }
        
        int answer = 0;
        visit = new boolean[n]; 
        for(int i = 0; i < n; i++) {
            if(!visit[i]) {
                bfs(i); 
                answer++;
            }
        }
        
        return answer;
    }
    
    static void bfs(int x) {
        Queue<Integer> que = new ArrayDeque<>(); 
        que.offer(x); 
        visit[x] = true;
        
        while(!que.isEmpty()) {
            int y = que.poll(); 
            
            for(int i = 0; i < arr[y].size(); i++) {
                if(!visit[arr[y].get(i)]) {
                    que.offer(arr[y].get(i));
                    visit[arr[y].get(i)] = true;    
                }
            }
        }
    }    
}