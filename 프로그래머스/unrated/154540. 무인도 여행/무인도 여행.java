import java.util.*;

class Solution {
    
    static int N, M, sum;
    static int[][] arr;
    static boolean[][] visit;
    List<Integer> list = new ArrayList<>();
    
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    
    public int[] solution(String[] maps) {        
        N = maps.length;
        M = maps[0].length();
        
        arr = new int[N][M];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(maps[i].charAt(j) == 'X') 
                    arr[i][j] = 0;
                else
                    arr[i][j] = maps[i].charAt(j) - '0'; 
            }
        }
        visit = new boolean[N][M];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(!visit[i][j] && arr[i][j] != 0) {
                    sum = 0;
                    dfs(i, j);
                    list.add(sum);                    
                }
            }
        }
        
        if(list.size() == 0) {
            int[] answer = {-1};
            return answer;
        }
        
        int[] answer = new int[list.size()];
        for(int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        Arrays.sort(answer);
        
        return answer;
    }
    
    static void dfs(int y, int x) {
        visit[y][x] = true;
        sum += arr[y][x];
        
        for(int d = 0; d < 4; d++) {
            int ny = y + dy[d];
            int nx = x + dx[d];
            
            if(ny < 0 || nx < 0 || ny >= N || nx >= M || arr[ny][nx] == 0 || visit[ny][nx]) 
                continue;
            
            dfs(ny, nx); 
        }
    }
}