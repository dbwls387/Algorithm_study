class Solution {
    public int solution(String my_string) {
        int answer = 0;
        
        String num = "";
        for(int i = 0; i < my_string.length(); i++) {
            for(int j = i; j < my_string.length(); j++) {
                if (Character.isDigit(my_string.charAt(j))) {
                    num += my_string.charAt(j);
                    i++;
                } else {
                    if(num.length() > 0) {
                        answer += Integer.parseInt(num);
                        num = "";
                    }
                    break;
                }
            }
        }
        
        if(num.length() > 0) {
            answer += Integer.parseInt(num);
        }
        
        return answer;
    }
}