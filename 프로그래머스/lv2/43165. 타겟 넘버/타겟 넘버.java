class Solution {
    
    static int[] numbers;
    static int target;
    static int answer;
    
    public int solution(int[] numbers, int target) {
        this.answer = 0;
        
        this.numbers = numbers;
        this.target = target;
        
        dfs(0, 0);
        
        return answer;
    }
    
    static void dfs(int index, int calc) {
        if (index == numbers.length) {
            if (calc == target) {
                answer++;
            }
            
            return;
        }
        
        dfs(index + 1, calc + numbers[index]);
        dfs(index + 1, calc - numbers[index]);
    }
}