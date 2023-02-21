import java.util.Arrays;

// aaabbcccd
class Solution {
    public String solution(String s) {
        String answer = "";
        char[] arr = s.toCharArray();
        int size = s.length();
        
        if(size == 1) {
            return s;
        }
        
        Arrays.sort(arr);
        
        if(arr[0] != arr[1])
            answer += arr[0];
        for(int i = 1; i < size - 1; i++) {
            if(arr[i] == arr[i+1] || arr[i] == arr[i-1]) {
                continue;
            }
            answer += arr[i];
        }
        if(arr[size - 1] != arr[size - 2])
            answer += arr[size - 1];
        
        return answer;
    }
}