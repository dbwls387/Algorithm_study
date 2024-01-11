class Solution {
    public int solution(String s) {
        int answer = 0;

        int N = s.length(); 
        outer: for(int i = N; i > 0; i--) {
            inner: for(int j = 0; j <= N - i; j++) {
                int start = j; 
                int end = j + i - 1; 
                
                while(start < end) {
                    if(s.charAt(start) != s.charAt(end)) {
                        continue inner; 
                    }
                    
                    start++; 
                    end--; 
                }
                
                answer = i; 
                break outer;                
            }
        }

        return answer;
    } 
}