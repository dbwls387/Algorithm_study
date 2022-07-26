// 4949번 균형잡힌 세상 

package BOJ.String;

import java.util.Scanner;
import java.util.Stack;

public class No_4949 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String input;

		while (true) {
			input = sc.nextLine();
			if (input.compareTo(".") == 0) {
				break;
			}
			
			Stack<Character> stack = new Stack<>();

			for (int i = 0; i < input.length(); i++) {
				char iChar = input.charAt(i);
				if (iChar == '(' || iChar == '[') {
					stack.push(iChar);
				} else if (iChar == ')') {
					if (stack.empty() || stack.peek() != '(') {
						stack.push(iChar);
						break;
					} else {
						stack.pop();
					}
				} else if (iChar == ']') {
					if (stack.empty() || stack.peek() != '[') {
						stack.push(iChar);
						break;
					} else {
						stack.pop();
					}
				}
			}

			if (stack.empty()) {
				System.out.println("yes");
			} else {
				System.out.println("no");
			}
		}
	}

}
