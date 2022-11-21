// SWEA 5208번 [파이썬 S/W 문제해결 구현] 5일차 - 전기버스2

package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No_5208 {

	static int T, N, cnt, ans;
	static int[] arr;

	static int[] src, tgt;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());

			arr = new int[N - 1];
			for (int i = 0; i < N - 1; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}

			ans = Integer.MAX_VALUE;
			dfs(1, 0, arr[0]);

			System.out.println("#" + t + " " + ans);
		}
	}

	static void dfs(int idx, int cnt, int ch) {

		if (cnt >= ans)
			return;

		if (idx >= N - 1) {
			ans = Math.min(ans, cnt);
			return;
		}

		if (ch < 1)
			return;

		dfs(idx + 1, cnt, ch - 1);
		dfs(idx + 1, cnt + 1, arr[idx]);
	}

}
