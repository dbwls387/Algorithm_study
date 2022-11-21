// 4193번 수영대회 결승전 

package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class No_4193 {

	static int T, N, A, B, C, D, ans;
	static int[][] map;
	static Queue<Node> tonado;

	static boolean[][] visit;

	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());

			tonado = new ArrayDeque<>();

			map = new int[N][N];
			StringTokenizer st;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			st = new StringTokenizer(br.readLine());
			A = Integer.parseInt(st.nextToken()); // 시작 위치
			B = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine());
			C = Integer.parseInt(st.nextToken()); // 도착 위치
			D = Integer.parseInt(st.nextToken());

			ans = Integer.MAX_VALUE;
			visit = new boolean[N][N];
			bfs();

			System.out.println("#" + t + " " + ans);
		}

	}

	static void bfs() {
		Queue<Node> que = new ArrayDeque<>();
		que.offer(new Node(A, B, 0));
		visit[A][B] = true;

		while (!que.isEmpty()) {
			Node node = que.poll();

			if (node.y == C && node.x == D) {
				ans = Math.min(ans, node.time);
				break;
			}

			for (int d = 0; d < 4; d++) {
				int ny = node.y + dy[d];
				int nx = node.x + dx[d];

				if (ny < 0 || nx < 0 || ny >= N || nx >= N || visit[ny][nx] || map[ny][nx] == 1)
					continue;

				if (map[ny][nx] == 2) {
					if ((node.time + 1) % 3 == 0) {
						que.offer(new Node(ny, nx, node.time + 1));
					} else {
						que.offer(new Node(node.y, node.x, node.time + 1));
					}
				} else if (map[ny][nx] == 0) {
					que.offer(new Node(ny, nx, node.time + 1));
					visit[ny][nx] = true;
				}
			}
		}

		if (ans == Integer.MAX_VALUE)
			ans = -1;
	}

	static class Node {
		int y, x, time;

		public Node(int y, int x, int time) {
			this.y = y;
			this.x = x;
			this.time = time;
		}
	}
}
