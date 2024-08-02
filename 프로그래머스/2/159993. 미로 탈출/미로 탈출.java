import java.util.*; 

class Solution {
    
    static int answer, N, M, sy, sx; 
    static boolean open;
    static Character[][] maps; 
    
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    
    public int solution(String[] str_maps) { 
        N = str_maps.length; 
        M = str_maps[0].length(); 
        maps = new Character[N][M]; 
        
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                maps[i][j] = str_maps[i].charAt(j); 
            }
        }
        
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(maps[i][j] == 'S') {
                    sy = i; 
                    sx = j; 
                }                    
            }
        }
        
        answer = Integer.MAX_VALUE; 
        bfs(); 
        
        if(!open || answer == Integer.MAX_VALUE)
            answer = -1; 
        
        return answer;
    }
    
    static void bfs() {
        Queue<Node> que = new ArrayDeque<>(); 
        boolean[][] visit = new boolean[N][M];
        open = false; 
        
        que.offer(new Node(sy, sx, 1)); 
        visit[sy][sx] = true;
        
        while(!que.isEmpty()) {
            Node node = que.poll();
            
            if(maps[node.y][node.x] == 'E' && open) {
                answer = Math.min(answer, node.dir - 1); 
            }
            
            for(int d = 0; d < 4; d++) {
                int ny = node.y + dy[d]; 
                int nx = node.x + dx[d]; 
                
                if(ny < 0 || nx < 0 || ny >= N || nx >= M || maps[ny][nx] == 'X' || visit[ny][nx])
                    continue; 
                
                if(!open && maps[ny][nx] == 'L') {
                    open = true; 
                    
                    que.clear(); 
                    visit = new boolean[N][M]; 
                    
                    que.offer(new Node(ny, nx, node.dir + 1)); 
                    visit[ny][nx] = true; 
                    break;
                }
                                
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
