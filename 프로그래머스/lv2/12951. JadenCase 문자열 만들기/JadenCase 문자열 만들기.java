class Solution {
    public String solution(String s) {
        String answer = "";
        String[] arr = s.split(" ");

        for (int i = 0; i < arr.length; i++) {
            if (arr[i].length() == 0) {
                answer += ' ';
                continue;
            }
            char ch = arr[i].charAt(0);
            if (ch == ' ')
                answer += ch;

            if (!Character.isDigit(ch)) {
                answer += Character.toString(ch).toUpperCase();
            } else {
                answer += ch;
            }

            answer += arr[i].substring(1).toLowerCase();

            if (i != arr.length - 1)
                answer += ' ';
        }

        if (s.substring(s.length() - 1).equals(" "))
            answer += ' ';

        return answer;
    }
}