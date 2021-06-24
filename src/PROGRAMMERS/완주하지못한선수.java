package PROGRAMMERS;

import java.util.Arrays;

public class 완주하지못한선수 {
    public static void main(String[] args) {
        String [] participant = {"leo", "kiki", "eden"};
        String [] completion = {"eden", "kiki"};

        String answer = solution(participant, completion);
        System.out.println(answer);
    }

    private static String solution(String[] participant, String[] completion) {
        String answer = "";
        Arrays.sort(participant);
        Arrays.sort(completion);

        int i;
        for (i = 0; i < completion.length; i++) {
            if (!participant[i].equals(completion[i])) {
                answer = participant[i];
                break;
            }
        }
        answer = participant[i];

        return answer;
    }
}