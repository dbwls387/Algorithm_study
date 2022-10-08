// SWEA 1952번 [모의 SW 역량테스트] 수영장

package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No_1952_recursion {

	static int T, min;
	static int[] price, plan;
	static int[] src, tgt;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			price = new int[4];
			plan = new int[12];

			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 4; i++) {
				price[i] = Integer.parseInt(st.nextToken());
			}

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 12; i++) {
				plan[i] = Integer.parseInt(st.nextToken());

			}

			min = price[3]; // 1년
			dfs(0, 0);

			sb.append("#").append(t).append(" ").append(min).append("\n");
		}

		System.out.println(sb.toString());

	}

	static void dfs(int idx, int sum) {
		if (idx >= 12) {
			min = Math.min(min, sum);

			return;
		}

		dfs(idx + 1, sum + plan[idx] * price[0]); // 1일
		dfs(idx + 1, sum + price[1]); // 1달
		dfs(idx + 3, sum + price[2]); // 3달
		// dfs(idx + 12, sum + price[3]); // 1년 -> 이 부분은 필요 없음
									// -> (왜냐면 위에서 첨부터 min 값을 1년 권으로 초기화 시켜줬기 때문)
	}

}
