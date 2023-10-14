import java.util.*;

class Solution {
    
    static int N, answer;
    static int[] src, tgt;
    static boolean[] select;
    static Set<Integer> set = new HashSet<>(); 
    
    public int solution(String numbers) {
        answer = 0;
        N = numbers.length();
        select = new boolean[N]; 
        src = new int[N];
        
        int num = Integer.parseInt(numbers);
        int idx = 0;
        while(num > 0) {
            src[idx++] = num % 10;
            num /= 10;
        }
            
        for(int i = 1; i <= N; i++) {
            tgt = new int[i];
            
            perm(0, i);
        }
        
        return answer;
    }
    
    static void perm(int tgtIdx, int tgtNum) {
        if(tgtIdx == tgtNum) {
            // 소수 판별 후 answer++ 
            
            String strN = "";
            for(int i = 0; i < tgtNum; i++) {
                strN += tgt[i];
            }
            
            int n = Integer.parseInt(strN);
            
            if(set.contains(n))
                return; 
            set.add(n);
            
            if(n < 2) 
                return; 
            for(int i = 2; i <= (int)Math.sqrt(n); i++) {
                if(n % i == 0) 
                    return; 
            }
            answer++; 
            
            return; 
        }
        
        for(int i = 0; i < N; i++) {
            if(select[i]) 
                continue;
            
            tgt[tgtIdx] = src[i];
            select[i] = true;
            perm(tgtIdx + 1, tgtNum);
            select[i] = false;            
        }
    }
}