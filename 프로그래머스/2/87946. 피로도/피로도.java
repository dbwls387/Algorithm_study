class Solution {
    
    static int k, answer, N; 
    static int[] src, tgt;
    static int[][] dungeons;
    static boolean[] select; 
    
    public int solution(int k, int[][] dungeons) {
        this.k = k; 
        this.dungeons = dungeons; 
        
        answer = 0; 
        
        N = dungeons.length; 
        src = new int[N]; 
        tgt = new int[N];
        select = new boolean[N]; 
        
        for(int i = 0; i < N; i++) {
            src[i] = i; 
        }
        perm(0); 
        
        return answer;
    }
    
    static void perm(int tgtIdx) {
        if(tgtIdx == N) {
            int cnt = 0; 
            int cur = k; 
            
            for(int i = 0; i < N; i++) {
                if(cur < dungeons[tgt[i]][0]) 
                    break; 
                
                cur -= dungeons[tgt[i]][1]; 
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