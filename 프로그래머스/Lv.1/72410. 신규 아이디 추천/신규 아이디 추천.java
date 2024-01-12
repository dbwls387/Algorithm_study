class Solution {
    public String solution(String new_id) { 
        String answer = ""; 
        
        // 1단계 : 대문자 -> 소문자 
        answer = new_id.toLowerCase();  
        
        // 2단계 : 소문자, 숫자, -, _, . 를 제외한 모든 문자 제외 
        answer = answer.replaceAll("[^0-9a-z-_.]", ""); 
        
        for(int i = 0; i < answer.length(); i++) {
            char ch = answer.charAt(i); 
            
            // 3단계 : 마침표가 2번 이상 연속되면 하나의 마침표로 치환 
            if(ch == '.') {
                for(int j = i + 1; j < answer.length(); j++) {
                    if(answer.charAt(j) == '.') {
                        answer = answer.substring(0, j) + answer.substring(j + 1); 
                        j--; 
                    } else {
                        break;
                    }
                }
            }
        }
        
        // 4단계 : new_id에서 마침표가 처음이나 끝에 위치한다면 제거 
        if(answer.length() > 0 && answer.charAt(0) == '.') {
            answer = answer.substring(1); 
        } 
        if(answer.length() > 0 && answer.charAt(answer.length() - 1) == '.') {
            answer = answer.substring(0, answer.length() - 1); 
        }       
        
        // 5단계 : new_id가 빈 문자열이라면, "a"를 대입 
        if(answer.length() == 0) {
            answer = "a"; 
        }
        
        // 6단계 : 길이가 16자 이상이면 첫 15개의 문자만 남겨두기 
        if(answer.length() >= 16) {
            answer = answer.substring(0, 15); 
        }
        // 6-2 : 마침표가 끝에 위치하면 마침표 제거 
        if(answer.length() > 0 && answer.charAt(answer.length() - 1) == '.') {
            answer = answer.substring(0, answer.length() - 1); 
        } 
        
        // 7단계 : 길이가 2자 이하라면, 마지막 문자를 길이가 3이 될 때까지 추가 
        if(answer.length() <= 2) { 
            char final_ch = answer.charAt(answer.length() - 1); 
            
            while(true) {
                if(answer.length() == 3) 
                    break; 
                
                answer += final_ch; 
            }
        }
        
        return answer;
    }
}