class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        
        int[][] map = new int[n][m];
        for(int i = 0; i < puddles.length; i++) {
            map[puddles[i][1] - 1][puddles[i][0] - 1] = -1;
        }
     
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(map[i][j] == -1) {
                    if(i == 0) {
                        for(int k = j; k < m; k++) {
                            map[i][k] = -1;
                        }
                    } else if(j == 0) {
                        for(int k = i; k < n; k++) {
                            map[k][j] = -1;
                        }
                    }
                    
                    continue;
                }
                
                if(i == 0 || j == 0) {
                    map[i][j] = 1;
                    
                    continue;
                }             
                
                if(map[i - 1][j] == -1 && map[i][j - 1]== -1) {
                    map[i][j] = -1;
                } else if(map[i - 1][j] == -1) {
                    map[i][j] = map[i][j - 1];
                } else if(map[i][j - 1] == -1) {
                    map[i][j] = map[i - 1][j];
                } else {
                    map[i][j] = (map[i - 1][j] + map[i][j - 1]) % 1_000_000_007;
                }
            }
        }
        
         
        // for(int i = 0; i < n; i++) {
        //     for(int j = 0; j < m; j++) {
        //         System.out.print(map[i][j] + " ");
        //     }
        //     System.out.println(); 
        // }
        
        answer = map[n - 1][m - 1];
        answer %= 1_000_000_007;
        
        if(map[n - 1][m - 1] == -1)
            answer = 0; 
        
        return answer;
    }
}