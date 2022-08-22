// BOJ 2605번 줄 세우기

package BOJ.Implementation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class No_2605 {

	static int N;
	static int[] num;
	static List<Integer> ans = new ArrayList<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		num = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
			ans.add(i + 1);
		}

		for (int i = 1; i < N; i++) {
			int n = ans.remove(i);
			ans.add(i - num[i], n);
		}

		for (int i = 0; i < N; i++) {
			System.out.print(ans.get(i) + " ");
		}
	}
}
