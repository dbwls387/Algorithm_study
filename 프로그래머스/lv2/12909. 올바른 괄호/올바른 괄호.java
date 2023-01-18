import java.util.Stack;

class Solution {
    boolean solution(String s) {
        boolean answer = true;

        char[] arr = s.toCharArray();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == '(') {
                stack.push(arr[i]);
            } else {
                if(stack.empty()) {
                    stack.push(arr[i]);
                    break;
                } else {
                    if(stack.peek()=='(') {
                        stack.pop();
                    } else {
                        break;
                    }
                }
            }
        }

        answer = stack.empty() ? true : false;

        return answer;
    }
}