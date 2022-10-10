// BOJ 2458번 키 순서 

package BOJ.Graph_Theory;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class No_2458 {

	static int N, M, tmp, ans;
	static List<Integer>[] list;

	static int[] cnt;
	static boolean[] visit;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		list = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			list[a].add(b);
		}

		cnt = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			tmp = 0;
			visit = new boolean[N + 1];
			dfs(i, i);
			cnt[i] += tmp;
		}

		ans = 0;
		for (int i = 1; i <= N; i++) {
			if (cnt[i] == N)
				ans++;
		}

		System.out.println(ans);
	}

	static void dfs(int cur, int start) {
		tmp += 1;
		for (int i = 0; i < list[cur].size(); i++) {
			int next = list[cur].get(i);
			if (visit[next])
				continue;

			visit[next] = true;
			cnt[next] += 1;
			dfs(next, start);
		}
	}

}
