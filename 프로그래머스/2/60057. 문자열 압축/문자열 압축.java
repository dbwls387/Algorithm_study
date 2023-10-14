class Solution {
    public int solution(String s) {
        int answer = Integer.MAX_VALUE;
        
        if(s.length() == 1) 
            return 1;
        
        for(int i = 1; i <= s.length(); i++) {
            String str = ""; 
            String prevStr = ""; 
            int cnt = 1;
            
            for(int j = 0; j <= s.length() - i; j+=i) {
                String currStr = s.substring(j, j + i); 
                
                if(prevStr.equals(currStr)) {
                    cnt++; 
                    continue;
                } else if(cnt > 1) {
                    str += cnt + prevStr; 
                    cnt = 1;
                } else {
                    str += prevStr;
                }
                
                prevStr = currStr;
            }
                
            if(cnt > 1) 
                str += (cnt + prevStr);
            else 
                str += prevStr;
            
            if(s.length() % i != 0) 
                str += s.substring(s.length() - s.length() % i, s.length());
            
            answer = Math.min(answer, str.length()); 
            str = "";
        }
        
        return answer;
    }
}