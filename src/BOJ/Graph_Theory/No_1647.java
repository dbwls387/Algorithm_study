// BOJ 1647번 도시 분할 계획 

package BOJ.Graph_Theory;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class No_1647 {

	static int N, M;
	static Edge[] edges;
	static int[] parent;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		edges = new Edge[M];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			edges[i] = new Edge(v1, v2, c);
		}

		Arrays.sort(edges, (e1, e2) -> e1.c - e2.c);

		parent = new int[N + 1];
		makeSet();

		int cnt = 0;
		int sum = 0;
		for (int i = 0; i < M; i++) {
			Edge edge = edges[i];

			if (union(edge.v1, edge.v2)) {
				cnt++;
				sum += edge.c;
			}

			if (cnt == N - 2)
				break;
		}

		System.out.println(sum);
	}

	static void makeSet() {
		for (int i = 1; i <= N; i++) {
			parent[i] = i;
		}
	}

	static int findSet(int x) {
		if (parent[x] == x)
			return x;

		return parent[x] = findSet(parent[x]);
	}

	static boolean union(int x, int y) {
		int px = findSet(x);
		int py = findSet(y);

		if (px == py)
			return false;

		if (py > px)
			parent[py] = px;
		else
			parent[px] = py;

		return true;
	}

	static class Edge {
		int v1, v2, c;

		public Edge(int v1, int v2, int c) {
			this.v1 = v1;
			this.v2 = v2;
			this.c = c;
		}
	}
}
