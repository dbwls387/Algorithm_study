import java.util.*; 

class Solution {
    public int solution(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int n = nums.length;
        int answer = 0;
        
        for(int i = 0; i < n; i++) {
            set.add(nums[i]); 
        }
        
        int size = set.size(); 
        if(n/2 > size) 
            answer = size; 
        else 
            answer = n/2;
        
        return answer;
    }
}