class Solution {
    int solution(int[][] land) {
        int answer = 0;
    
        for(int i = 1; i < land.length; i++) {
            land[i][0] += Math.max(land[i - 1][1], Math.max(land[i - 1][2], land[i - 1][3]));
            land[i][1] += Math.max(land[i - 1][0], Math.max(land[i - 1][2], land[i - 1][3]));
            land[i][2] += Math.max(land[i - 1][0], Math.max(land[i - 1][1], land[i - 1][3]));
            land[i][3] += Math.max(land[i - 1][0], Math.max(land[i - 1][1], land[i - 1][2]));
        }
        
        for(int i = 0; i < 4; i++) {
            answer = Math.max(answer, land[land.length - 1][i]);
        }

        return answer;
    }
}

// class Solution {
    
//     static int N, M, max;
//     static int[][] land;
    
//     int solution(int[][] land) {
//         int answer = 0;

//         this.land = land;
//         max = Integer.MIN_VALUE;
//         N = land.length;
//         M = land[0].length;

//         dfs(0, -1, 0);
        
//         return max;
//     }
    
//     static void dfs(int idx, int before, int sum) {
//         if(idx == N) {
//             max = Math.max(max, sum); 
//             return;
//         }
        
//         for(int i = 0; i < M; i++) {
//             if(before == i) 
//                 continue;
            
//             dfs(idx + 1, i, sum + land[idx][i]);
//         }
//     }
// }