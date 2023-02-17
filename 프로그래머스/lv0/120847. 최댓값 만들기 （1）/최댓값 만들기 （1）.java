class Solution {
    public int solution(int[] numbers) {
        int answer = 0;
        
        int size = numbers.length;
        for(int i = 0; i < size; i++) {
            for(int j = 0; j < size; j++) {
                if(i != j)
                    answer = Math.max(answer, numbers[i] * numbers[j]);
            }
        }
        
        return answer;
    }
}