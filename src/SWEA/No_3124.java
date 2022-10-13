// SWEA 3124번 최소 스패닝 트리 

package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class No_3124 {

	static int T, V, E;
	static int sum;

	static int[] parent;
	static Edge[] edges;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());

			parent = new int[V + 1];
			edges = new Edge[E];

			for (int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine());

				int v1 = Integer.parseInt(st.nextToken());
				int v2 = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());

				edges[i] = new Edge(v1, v2, c);
			}

			Arrays.sort(edges, (e1, e2) -> e1.c - e2.c);

			int cnt = 0;
			sum = 0;

			makeSet();

			for (int i = 0; i < E; i++) {
				Edge edge = edges[i];

				if (union(edge.v1, edge.v2)) {
					cnt++;
					sum += edge.c;
				}

				if (cnt == V - 1)
					break;
			}

			System.out.println(sum);
		}
	}

	static void makeSet() {
		for (int i = 1; i <= V; i++) {
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
