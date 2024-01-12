import java.util.*; 

class Solution {
    
    static int N, M, answer;
    static int[][] maps; 
    
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    
    public int solution(int[][] maps) {
        this.maps= maps; 
        N = maps.length; 
        M = maps[0].length; 
        
        answer = 0;
        
        bfs(); 
        
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
                answer = node.dis; 
                
                return; 
            }
            
            for(int d = 0; d < 4; d++) {
                int ny = node.y + dy[d];
                int nx = node.x + dx[d]; 
                
                if(ny < 0 || ny >= N || nx < 0 || nx >= M || visit[ny][nx] || maps[ny][nx] == 0) 
                    continue; 
                
                que.offer(new Node(ny, nx, node.dis + 1)); 
                visit[ny][nx] = true; 
            }
        }
        
        answer = -1; 
    }
    
    static class Node {
        int y, x, dis; 
        
        public Node(int y, int x, int dis) {
            this.y = y; 
            this.x = x; 
            this.dis = dis; 
        }
    }
}