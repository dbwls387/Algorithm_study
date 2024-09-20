import java.util.*; 

class Solution {
    
    static int answer, N, M; 
    static int[][] maps; 
    
    static int[] dy = {-1, 1, 0, 0}; 
    static int[] dx = {0, 0, -1, 1}; 
    
    public int solution(int[][] maps) {
        this.maps = maps; 
        N = maps.length; 
        M = maps[0].length; 
        
        answer = Integer.MAX_VALUE; 
        bfs(); 
        
        if(answer == Integer.MAX_VALUE) 
            answer = -1; 
        
        return answer;
    }
    
    static void bfs() {
        Queue<Node> que = new ArrayDeque<>(); 
        boolean[][] visit = new boolean[N][M]; 
        
        que.offer(new Node(0, 0, 1)); 
        visit[0][0] = true; 
        
        while(!que.isEmpty()) {
            Node node = que.poll(); 
            
            if(node.y == N - 1 && node.x == M - 1) {
                answer = Math.min(answer, node.dir); 
            }
            
            for(int d = 0; d < 4; d++) {
                int ny = node.y + dy[d]; 
                int nx = node.x + dx[d]; 
                
                if(ny < 0 || nx < 0 || ny >= N || nx >= M || visit[ny][nx] || maps[ny][nx] == 0 ) 
                    continue; 
                
                que.offer(new Node(ny, nx, node.dir + 1)); 
                visit[ny][nx] = true; 
            }
        }
    }
    
    static class Node {
        int y, x, dir; 
        
        public Node (int y, int x, int dir) {
            this.y = y; 
            this.x = x; 
            this.dir = dir; 
        }
    }
}