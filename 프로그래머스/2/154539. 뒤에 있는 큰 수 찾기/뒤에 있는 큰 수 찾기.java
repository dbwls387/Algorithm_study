import java.util.*; 

class Solution {
    
    static Stack<Node> stack = new Stack<>(); 
    
    public int[] solution(int[] numbers) {
        int N = numbers.length;
        int[] answer = new int[N]; 
        
        for(int i = 0; i < N; i++) {
            if(stack.isEmpty()) {
                stack.add(new Node(i, numbers[i])); 
            } else {
                while(!stack.isEmpty()) {
                    Node node = stack.peek(); 
                    
                    if(node.num < numbers[i]) {
                        answer[node.idx] = numbers[i]; 
                        stack.pop(); 
                    } else {
                        stack.add(new Node(i, numbers[i])); 
                        break; 
                    }
                    
                    if(stack.isEmpty()) {
                        stack.add(new Node(i, numbers[i])); 
                    }
                }
            }
        }
        
        while(!stack.isEmpty()) {
            Node node = stack.pop(); 
            answer[node.idx] = -1; 
        }
        
        return answer;
    }
    
    public class Node {
        int idx; 
        int num; 
        
        public Node (int idx, int num) {
            this.idx = idx;
            this.num = num;
        }
    }
}