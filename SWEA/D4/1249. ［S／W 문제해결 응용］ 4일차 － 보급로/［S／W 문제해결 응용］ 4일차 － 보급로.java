// bfs

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class Solution {

	static int T, N, min;
	static int[][] map, ans;

	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];

			for (int i = 0; i < N; i++) {
				char tmp[] = br.readLine().toCharArray();
				for (int j = 0; j < N; j++) {
					map[i][j] = tmp[j] - '0';
				}
			}

			min = Integer.MAX_VALUE;
			ans = new int[N][N];

			for (int i = 0; i < N; i++) {
				Arrays.fill(ans[i], Integer.MAX_VALUE);
			}
			ans[0][0] = 0;

			bfs();

			System.out.println("#" + t + " " + min);
		}

	}

	static void bfs() {
		Queue<Node> que = new ArrayDeque<>();
		que.offer(new Node(0, 0));

		while (!que.isEmpty()) {
			Node node = que.poll();

			if (node.y == N - 1 && node.x == N - 1) {
				min = Math.min(min, ans[N - 1][N - 1]);
			}

			if (min <= ans[node.y][node.x])
				continue;

			for (int d = 0; d < 4; d++) {
				int ny = node.y + dy[d];
				int nx = node.x + dx[d];

				if (ny < 0 || nx < 0 || ny >= N || nx >= N)
					continue;

				if (ans[ny][nx] > ans[node.y][node.x] + map[ny][nx]) {
					que.offer(new Node(ny, nx));
					ans[ny][nx] = ans[node.y][node.x] + map[ny][nx];
				}
			}
		}
	}

	static class Node {
		int y, x;

		public Node(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
}