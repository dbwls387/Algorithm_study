class Solution {
    public String solution(String s) {
        String answer = "";
        String[] arr = s.split(" ");

        for (int i = 0; i < arr.length; i++) {
            if (arr[i].length() == 0) { // 공백 연속으로 들어올 경우
                answer += ' ';
                continue;
            }
            
            char ch = arr[i].charAt(0); // 단어의 첫 문자
            if (!Character.isDigit(ch)) {   // 첫 문자가 숫자가 아니면
                answer += Character.toString(ch).toUpperCase(); // 대문자
            } else {
                answer += ch;   // 숫자이면 그대로 정답 문자열에 추가
            }

            answer += arr[i].substring(1).toLowerCase();    // 나머지 글자는 모두 소문자

            if (i != arr.length - 1)    // 제일 마지막 단어 뒤엔 공백 X
                answer += ' ';
        }

        // 맨 뒤에 공백이 있을 경우 
        if (s.substring(s.length() - 1).equals(" "))
            answer += ' ';

        return answer;
    }
}