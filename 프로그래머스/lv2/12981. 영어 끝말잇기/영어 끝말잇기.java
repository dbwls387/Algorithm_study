import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        Set<String> set = new HashSet();
        
        int lose = 0;
        String front = words[0];
        set.add(words[0]);
        for(int i = 1; i < words.length; i++) {
            if(set.contains(words[i])) {
                lose = i;
                break;
            } else {
                set.add(words[i]);
            }
            
            if(front.charAt(front.length() - 1) != words[i].charAt(0)) {
                lose = i;
                break;
            } else {
                front = words[i];
            }
        }
        
        
        int[] answer = new int[2];
        if(lose == 0) {
            answer[0] = 0;
            answer[0] = 0;
        } else {
            lose++;
            if(lose % n == 0) {
                answer[0] = n;
                answer[1] = lose / n;
            } else {
                answer[0] = lose % n;
                answer[1] = lose / n + 1;
            }
        }      
        
        return answer;
    }
}