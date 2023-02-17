class Solution {
    public int[] solution(int money) {
        int cnt = money / 5500;
        int change = money % 5500;
        
        int[] answer = {cnt, change};
        
        return answer;
    }
}