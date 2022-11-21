// SWEA 1227번  미로 2

package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class No_1227 {

	static int sy, sx, ey, ex;
	static int[][] map;

	static boolean[][] visit;

	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int t = 1; t <= 10; t++) {
			br.readLine();

			map = new int[100][100];
			for (int i = 0; i < 100; i++) {
				char[] tmp = br.readLine().toCharArray();
				for (int j = 0; j < 100; j++) {
					map[i][j] = tmp[j] - '0';
					if (map[i][j] == 2) {
						sy = i;
						sx = j;
					} else if (map[i][j] == 3) {
						ey = i;
						ex = j;
					}
				}
			}

			visit = new boolean[100][100];
			if (bfs())
				System.out.println("#" + t + " " + 1);
			else
				System.out.println("#" + t + " " + 0);
		}

	}

	static boolean bfs() {
		Queue<Node> que = new ArrayDeque<>();
		que.offer(new Node(sy, sx));
		visit[sy][sx] = true;

		while (!que.isEmpty()) {
			Node node = que.poll();

			if (map[node.y][node.x] == 3) {
				return true;
			}

			for (int d = 0; d < 4; d++) {
				int ny = node.y + dy[d];
				int nx = node.x + dx[d];

				if (ny < 0 || nx < 0 || ny >= 100 || nx >= 100 || visit[ny][nx] || map[ny][nx] == 1)
					continue;

				que.offer(new Node(ny, nx));
				visit[ny][nx] = true;
			}

		}

		return false;
	}

	static class Node {
		int y, x;

		public Node(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}

}
