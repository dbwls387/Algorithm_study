import java.util.*; 

class Solution {
    
    static int n; 
    static int[] dis; 
    static List<Integer>[] list; 
    
    public int solution(int n, int[][] edge) {
        this.n = n; 
        
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
        
        dis = new int[n + 1]; 
        bfs(); 
        
        Arrays.sort(dis); 
        
        int cnt = 0; 
        for(int i = n; i >= 1; i--) {
            if(dis[i] == dis[n])    // dis[n]은 가장 멀리 떨어진 노드의 길이 
                cnt++; 
            else 
                break;
        }
        
        return cnt;
    }
    
    static void bfs() {
        Queue<Integer> que = new ArrayDeque<>(); 
        boolean[] visit = new boolean[n + 1]; 
        
        que.add(1); 
        visit[1] = true;
        
        while(!que.isEmpty()) {
            int node = que.poll(); 
            
            for(int i = 0; i < list[node].size(); i++) {
                int a = list[node].get(i); 
                
                if(visit[a]) 
                    continue; 
                
                que.add(a); 
                visit[a] = true; 
                
                dis[a] = dis[node] + 1; 
            }
        }
        
        return;         
    }
}