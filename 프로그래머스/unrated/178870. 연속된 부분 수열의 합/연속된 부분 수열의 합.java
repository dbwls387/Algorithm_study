class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        
        // 1, 2, 3, 4, 5
        int left = 0;
        int right = 0;
        int sum = sequence[0];
        int len = Integer.MAX_VALUE;
        
        while (right < sequence.length && left <= right) {            
            if (sum < k) {
                if (right + 1 >= sequence.length) break;
                
                right++;
                sum += sequence[right];
            } else if (sum > k) {
                sum -= sequence[left];
                left++;
            } else {
                if (len > right - left + 1) {
                    answer[0] = left;
                    answer[1] = right;
                    len = right - left + 1;
                }
                
                if (right + 1 >= sequence.length) break;
                right++;
                sum += sequence[right];
            }            
        }
        
        return answer;
    }
}
