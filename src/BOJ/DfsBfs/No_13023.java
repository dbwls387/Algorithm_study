// BOJ 13023번 ABCDE

package BOJ.DfsBfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class No_13023 {

	static int N, M, result;
	static List<Integer>[] list;
	static boolean[] visit;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		list = new ArrayList[N];
		for (int i = 0; i < N; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list[a].add(b);
			list[b].add(a);
		}

		for (int i = 0; i < N; i++) {
			visit = new boolean[N];
			result = 0;
			dfs(i, 1);
			if (result == 1)
				break;
		}
		System.out.println(result);
	}

	static void dfs(int idx, int cnt) {
		if (result == 1)
			return;

		if (cnt == 5) {
			result = 1;
			return;
		}

		visit[idx] = true;
		for (int i = 0; i < list[idx].size(); i++) {
			int x = list[idx].get(i);
			if (!visit[x])
				dfs(x, cnt + 1);
		}

		visit[idx] = false;
	}

}
