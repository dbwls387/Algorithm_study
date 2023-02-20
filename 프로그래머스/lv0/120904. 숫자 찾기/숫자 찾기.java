class Solution {
    public int solution(int num, int k) {
        int answer = 0;
        
        String sNum = Integer.toString(num);
        for(int i = 0; i < sNum.length(); i++) {
            if(sNum.charAt(i) == (char)(k + '0')) {
                answer = i+1;
                break;
            }
        }
        
        return answer == 0 ? -1 : answer;
    }
}