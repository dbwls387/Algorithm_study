import java.util.*;

class Solution {
    
    static ArrayList<Integer>[] list; 
    static int[] depth; 
    static int n;
    
    public int solution(int n, int[][] edge) {
        this.n = n;
        depth = new int[n + 1]; 
        
        list = new ArrayList[n + 1]; 
        for(int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>(); 
        } 
        
        for(int i = 0; i < edge.length; i++) {
            int a = edge[i][0]; 
            int b = edge[i][1]; 
            list[a].add(b); 
            list[b].add(a); 
        }
        
        bfs(); 
        
        int cnt = 0; 
        Arrays.sort(depth); 
        int max = depth[n]; 
        for(int i = n; i >= 1; i--) {
            if(max == depth[i]) 
                cnt++; 
            else 
                break;
        }
        
        return cnt;
    }
    
    static void bfs() {
        boolean[] visit = new boolean[n + 1]; 
        Queue<Integer> que = new ArrayDeque<>(); 
        
        que.add(1); 
        visit[1] = true; 
        
        while(!que.isEmpty()) {
            int a = que.poll(); 
            
            for(int i = 0; i < list[a].size(); i++) { 
                int b = list[a].get(i);
                
                if(visit[b]) 
                    continue; 
                
                que.add(b); 
                visit[b] = true; 
                depth[b] = depth[a] + 1; 
            }
        } 
        
        return; 
    }
}