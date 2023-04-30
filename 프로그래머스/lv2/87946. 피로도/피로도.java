import java.util.*; 

class Solution {
    
    static int answer, n;
    static int[] src, tgt; 
    static boolean[] select;
    
    public int solution(int k, int[][] dungeons) {
        answer = 0;
        
        n = dungeons.length;
        src = new int[n];
        tgt = new int[n];
        select = new boolean[n];
        for(int i = 0; i < n; i++) {
            src[i] = i;
        }
        
        perm(0, k, dungeons);
        
        return answer;
    }
    
    static void perm(int tgtIdx, int k, int[][] dungeons) {
        if(tgtIdx == n) {
            int cur = k;
            int cnt = 0;
            
            // System.out.println(Arrays.toString(tgt));
            for(int i = 0; i < n; i++) {
                int idx = tgt[i];
                if(dungeons[idx][0] > cur) {
                    break;
                } 
                
                cur -= dungeons[idx][1]; 
                cnt++; 
                
                // System.out.println(cur);
            }
            
            answer = Math.max(answer, cnt);
            
            return; 
        }
        
        for(int i = 0; i < n; i++) {
            if(select[i]) 
                continue;
            
            tgt[tgtIdx] = src[i];
            select[i] = true;
            perm(tgtIdx+1, k, dungeons);
            select[i] = false; 
        }
    }
}