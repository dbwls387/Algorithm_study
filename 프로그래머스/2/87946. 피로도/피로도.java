import java.util.*; 

class Solution {
    
    static int N, k, answer; 
    static int[][] dungeons; 
    
    static int[] src, tgt; 
    static boolean[] select; 
    
    public int solution(int k, int[][] dungeons) {
        N = dungeons.length; 
        this.dungeons = dungeons; 
        this.k = k; 
        
        src = new int[N]; 
        tgt = new int[N]; 
        select = new boolean[N]; 
        for(int i = 0; i < N; i++) {
            src[i] = i; 
        }
        
        answer = 0; 
        perm(0);
        
        return answer;
    }
    
    static void perm(int tgtIdx) {
        if(tgtIdx == N) {
            int tired = k; 
            int cnt = 0; 
            
            for(int i = 0; i < N; i++) {              
                if(tired < dungeons[tgt[i]][0]) 
                    break; 
                
                tired -= dungeons[tgt[i]][1]; 
                cnt++; 
            }
            
            answer = Math.max(answer, cnt); 
            
            return; 
        }
        
        for(int i = 0; i < N; i++) {
            if(select[i]) 
                continue; 
            
            tgt[tgtIdx] = src[i]; 
            
            select[i] = true;             
            perm(tgtIdx + 1); 
            select[i] = false;
        }
    }
}