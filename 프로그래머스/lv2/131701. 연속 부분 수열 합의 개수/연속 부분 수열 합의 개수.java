import java.util.*; 

class Solution {
    public int solution(int[] elements) {
        int answer = 0;
        
        Set<Integer> set = new HashSet<>();
        
        int size = elements.length;
        int[] arr = new int[size * 2]; 
        int idx = 0; 
        for(int i = 0; i < size * 2; i++) {
            arr[i] = elements[idx++]; 
            if(i == size - 1) 
                idx = 0;
        }
        
        for(int len = 1; len <= size; len++) {
            int sum = 0; 
            
            for(int i = len; i < len + size; i++) {
                sum += arr[i];
                set.add(sum); 
            }
        }
        
        return set.size();
    }
}