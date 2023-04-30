import java.util.*; 

class Solution {
    
    static int N, M, min; 
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1}; 
    
    static int[][] maps; 
    
    public int solution(int[][] maps) {
        min = Integer.MAX_VALUE;        
        N = maps.length; 
        M = maps[0].length;
        
        this.maps = maps;
        
        bfs();
        
        if(min == Integer.MAX_VALUE) 
            min = -1;
        
        return min;
    }
    
    static void bfs() {
        Queue<Node> que = new ArrayDeque<>(); 
        boolean[][] visit = new boolean[N][M];
        
        visit[0][0] = true; 
        que.add(new Node(0, 0, 1)); 
        while(!que.isEmpty()) {
            Node node = que.poll();
            
            if(node.y == N-1 && node.x == M-1) {
                min = Math.min(min, node.count); 
                
                return; 
            }
            
            for(int d = 0; d < 4; d++) {
                int ny = node.y + dy[d];
                int nx = node.x + dx[d];
                
                if(ny < 0 || nx < 0 || ny >= N || nx >= M || maps[ny][nx] == 0 || visit[ny][nx]) continue; 
                
                que.add(new Node(ny, nx, node.count + 1)); 
                visit[ny][nx] = true; 
            }
        }
    }
    
    static class Node {
        int y, x, count;
        
        public Node(int y, int x, int count) {
            this.y = y;
            this.x = x;
            this.count = count; 
        }
    }
}
