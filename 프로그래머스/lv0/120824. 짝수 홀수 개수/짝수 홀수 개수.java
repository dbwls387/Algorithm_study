class Solution {
    public int[] solution(int[] num_list) {        
        int cnt = 0;
        int size = num_list.length;
        for(int i = 0; i < size; i++) {
            if(num_list[i] % 2 == 0) 
                cnt++;
        }
        
        int[] answer = {cnt, size-cnt};
        
        return answer;
    }
}