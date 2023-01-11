class Solution {
    public int[] solution(String s) {
        int[] answer = {};

        int cnt = 0;
        int cnt_zero = 0;
        while(true) {
            if(s.equals("1"))
                break;

            char[] arr = s.toCharArray();
            int cnt_one = 0;

            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == '1')
                    cnt_one++;
                else
                    cnt_zero++;
            }

            s = Integer.toBinaryString(cnt_one);
            cnt++;
        }

        answer = new int[]{cnt, cnt_zero};

        return answer;
    }
}