// SWEA 4008번 [모의 SW 역량테스트] 숫자 만들기
// dfs

package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No_4008_dfs {

	static int T, N, min, max, ans;
	static int[] oper, num;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());

			StringTokenizer st = new StringTokenizer(br.readLine());
			oper = new int[4];
			for (int i = 0; i < 4; i++) {
				oper[i] = Integer.parseInt(st.nextToken());
			}

			st = new StringTokenizer(br.readLine());
			num = new int[N];
			for (int i = 0; i < N; i++) {
				num[i] = Integer.parseInt(st.nextToken());
			}

			min = Integer.MAX_VALUE;
			max = Integer.MIN_VALUE;

			dfs(num[0], 1, oper[0], oper[1], oper[2], oper[3]);

			ans = Math.abs(max - min);

			sb.append("#").append(t).append(" ").append(ans).append("\n");
		}

		System.out.println(sb.toString());
	}

	static void dfs(int result, int idx, int plus, int minus, int mul, int div) {
		if (idx == N) {
			max = Math.max(max, result);
			min = Math.min(min, result);

			return;
		}

		if (plus > 0)
			dfs(result + num[idx], idx + 1, plus - 1, minus, mul, div);

		if (minus > 0)
			dfs(result - num[idx], idx + 1, plus, minus - 1, mul, div);

		if (mul > 0)
			dfs(result * num[idx], idx + 1, plus, minus, mul - 1, div);

		if (div > 0)
			dfs(result / num[idx], idx + 1, plus, minus, mul, div - 1);
	}

}
