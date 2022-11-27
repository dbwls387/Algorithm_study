import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// BOJ - No_1753 최단 경로

public class Main {

	static int V, E, K;
	static List<List<Edge>> vertex = new ArrayList<>();
	static int[] cost;
	static boolean[] visit;

	static int INF = Integer.MAX_VALUE;

	static PriorityQueue<Edge> pque = new PriorityQueue<>((e1, e2) -> e1.c - e2.c);

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(br.readLine());

		visit = new boolean[V + 1];
		cost = new int[V + 1];
		for (int i = 0; i <= V; i++) {
			vertex.add(new ArrayList<Edge>());
			cost[i] = INF;
		}

		for (int i = 1; i <= E; i++) {
			st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());

			vertex.get(v1).add(new Edge(v2, w));
		}

		dijkstra();

		for (int i = 1; i <= V; i++) {
			if (cost[i] == INF)
				System.out.println("INF");
			else
				System.out.println(cost[i]);
		}
	}

	static void dijkstra() {
		pque.offer(new Edge(K, 0));
		cost[K] = 0;

		while (!pque.isEmpty()) {
			Edge e = pque.poll();

			if (e.c > cost[e.v])
				continue;

			if (visit[e.v])
				continue;

			visit[e.v] = true;

			for (Edge ne : vertex.get(e.v)) {
				if (cost[e.v] + ne.c < cost[ne.v]) {
					cost[ne.v] = cost[e.v] + ne.c;
					pque.offer(new Edge(ne.v, cost[ne.v]));
				}
			}
		}
	}

	static class Edge {
		int v, c;

		public Edge(int v, int c) {
			this.v = v;
			this.c = c;
		}
	}

}
