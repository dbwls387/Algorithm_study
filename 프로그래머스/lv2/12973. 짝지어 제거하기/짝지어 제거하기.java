import java.util.Stack;

class Solution
{
    public int solution(String s)
    {
        char[] charArr = s.toCharArray();
        Stack<Character> stack= new Stack<>();
        
        // 괄호 문제처럼 스택으로 구현
        for(int i=0; i<charArr.length; i++) {
            if(stack.empty())   // 스택이 비었을 경우 문자 넣기 
                stack.push(charArr[i]);
            else {
                // 스택 가장 위의 문자와 현재 비교할 문자가 같다면 (짝지어)
                if(stack.peek() == charArr[i]) {    
                    stack.pop();    // 짝지어 제거 
                } else {    // 짝지어가 아니라면
                    stack.push(charArr[i]); // 문자 넣기
                }
            }
        }

        // 스택이 비었다면 짝지어가 모두 제거됨 -> 1 출력 
        // 스택에 문자가 남아있다면 짝지어가 성립하지 않는 경우 -> 0 출력
        int result = stack.empty() ? 1 : 0;   
        
        return result;
    }
}