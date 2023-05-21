import java.util.*;

class Solution {
    
    static Stack<Node> s = new Stack<>();
    
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        
        for (int i = 0; i < numbers.length; i++) {
            if (s.isEmpty()) {
                s.add(new Node(numbers[i], i));
            } else {
                while (!s.isEmpty()) {
                    Node n = s.peek();
                    
                    if (n.x < numbers[i]) {
                        answer[n.index] = numbers[i];
                        s.pop();
                    } else {
                        s.add(new Node(numbers[i], i));
                        break;
                    }
                    
                    if (s.isEmpty()) {
                        s.add(new Node(numbers[i], i));
                    }
                }
            }
        }
        
        while (!s.isEmpty()) {
            Node n = s.pop();
            
            answer[n.index] = -1;
        }
        
        return answer;
    }
    
    public class Node {
        int x;
        int index;
        
        public Node (int x, int index) {
            this.x = x;
            this.index = index;
        }
    }
}