// BOJ 1527번 금민수의 개수

package BOJ.Bruteforcing_Algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No_1527 {

	static int A, B, cnt = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());

		for (int i = A; i <= B; i++) {
			String str;
			str = Integer.toString(i);

			int check = 0;
			for (int j = 0; j < str.length(); j++) {
				if (str.charAt(j) != '4' && str.charAt(j) != '7') {
					check = 0;
					break;
				}
				if (str.charAt(j) == '4' || str.charAt(j) == '7') {
					check = 1;
				}
			}
			if (check == 1) {
				cnt++;
			}
		}
		System.out.println(cnt);
	}
}
