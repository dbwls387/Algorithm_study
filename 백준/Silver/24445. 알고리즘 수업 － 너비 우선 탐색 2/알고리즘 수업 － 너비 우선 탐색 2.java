// BOJ 24445번 알고리즘 수업 - 너비 우선 탐색 2

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, M, R;
	static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
	static boolean[] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		for (int i = 0; i <= N; i++) {
			list.add(new ArrayList<>());
		}

		visited = new boolean[N + 1];

		int u, v;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			u = Integer.parseInt(st.nextToken());
			v = Integer.parseInt(st.nextToken());
			list.get(u).add(v);
			list.get(v).add(u);
		}

		bfs(R);
	}

	static void bfs(int x) {
		Queue<Integer> que = new LinkedList<>();
		que.add(x);
		visited[x] = true;

		int cnt = 0;
		int[] result = new int[N + 1];

		while (!que.isEmpty()) {
			int q = que.poll();
			Collections.sort(list.get(q), Collections.reverseOrder());
			cnt++;
			result[q] = cnt;

			for (int i : list.get(q)) {
				if (!visited[i]) {
					visited[i] = true;
					que.add(i);
				}
			}
		}

		for (int i = 1; i <= N; i++) {
			System.out.println(result[i]);
		}
	}
}
