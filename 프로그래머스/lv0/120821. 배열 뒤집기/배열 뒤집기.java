class Solution {
    public int[] solution(int[] num_list) {
        int[] answer = {};
        
        int size = num_list.length;
        answer = new int[size];
        for(int i = 0; i < size; i++) {
            answer[i] = num_list[size - i - 1];
        }
        
        return answer;
    }
}