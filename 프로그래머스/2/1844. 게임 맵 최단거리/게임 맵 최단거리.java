import java.util.*; 

class Solution {
    
    static int N, M, answer; 
    static int[][] maps; 
    
    static int[] dy = {-1, 1, 0, 0}; 
    static int[] dx = {0, 0, -1, 1}; 
    
    public int solution(int[][] maps) {
        answer = Integer.MAX_VALUE;
        N = maps.length; 
        M = maps[0].length; 
        this.maps = maps; 
        
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
                answer = Math.min(answer, node.cnt);
            }
            
            for(int d = 0; d < 4; d++) {
                int ny = node.y + dy[d]; 
                int nx = node.x + dx[d]; 
                
                if(ny < 0 || nx < 0 || ny >= N || nx >= M || maps[ny][nx] == 0 || visit[ny][nx])
                    continue; 
                
                que.offer(new Node(ny, nx, node.cnt + 1)); 
                visit[ny][nx] = true;
            }
        }
    }
    
    static class Node {
        int y, x, cnt; 
        
        public Node(int y, int x, int cnt) {
            this.y = y; 
            this.x = x; 
            this.cnt = cnt;
        }
    }
}