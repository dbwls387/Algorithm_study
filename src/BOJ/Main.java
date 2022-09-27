// BOJ 17144번 미세먼지 안녕! 

package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int R, C, T, clear_up, clear_down, ans;
	static int[][] map, cost;
	static Queue<Node> dust = new ArrayDeque<>();

	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());

		map = new int[R][C];
		cost = new int[R][C];
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				int input = Integer.parseInt(st.nextToken());

				map[i][j] = input;

				if (input == -1) {
					clear_down = i;
				} else if (input != 0) {
					dust.offer(new Node(i, j, input));
				}
			}
		}

		clear_up = clear_down - 1;

		bfs();

		ans = 0;

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] == -1)
					continue;
				ans += map[i][j];
			}
		}

		System.out.println(ans);
	}

	static void bfs() {

		for (int t = 0; t < T; t++) {
			int size = dust.size();	// 한 타임의 맵 먼지 수 만큼 돌리기 
			
			for (int j = 0; j < size; j++) {
				Node node = dust.poll();
				int give = 0;

				for (int d = 0; d < 4; d++) {
					int ny = node.y + dy[d];
					int nx = node.x + dx[d];

					if (ny < 0 || nx < 0 || ny >= R || nx >= C || map[ny][nx] == -1)
						continue;

					cost[ny][nx] += map[node.y][node.x] / 5;	// 후에 더할 먼지 수 
					give += map[node.y][node.x] / 5;	// 준 먼지 수 
				}

				map[node.y][node.x] -= give;
			}

			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					map[i][j] += cost[i][j];	// 나눠줄 먼지 계산 끝내고 그걸 더하기 
					cost[i][j] = 0;	// 계산할 배열 초기화 
				}	
			}

			rotation(); // 반시계 방향 회전
			downRotation(); // 시계 방향 회전

			dust.clear();
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					if (map[i][j] > 0)
						dust.offer(new Node(i, j, map[i][j]));
				}
			}
		}
	}

	// 우-하-좌-상
	static int[] ry = { 0, 1, 0, -1 };
	static int[] rx = { 1, 0, -1, 0 };

	static void rotation() { // 반시계 방향 회전 ( 위의 공청기 )
		int dir = 0; // 0: 우, 1: 하, 2: 좌, 3: 상
		int y = 0, x = 0;

		int tmp = map[y][x];

		while (dir < 4) {
			int ny = y + ry[dir];
			int nx = x + rx[dir];

			if (ny < 0 || nx < 0 || ny > clear_up || nx >= C) {
				dir++;
				continue;
			}

			map[y][x] = map[ny][nx];

			y = ny;
			x = nx;
		}

		map[1][0] = tmp;
		map[clear_up][1] = 0;
		map[clear_up][0] = -1;
	}

	// 좌-하-우-상
	static int[] down_ry = { 0, 1, 0, -1 };
	static int[] down_rx = { -1, 0, 1, 0 };

	static void downRotation() { // 시계 방향 회전 ( 아래 공청기 )
		int dir = 0; // 0: 좌, 1: 하, 2: 우, 3: 상
		int y = clear_down, x = C - 1;

		int tmp = map[y][x];

		while (dir < 4) {
			int ny = y + down_ry[dir];
			int nx = x + down_rx[dir];

			if (ny < clear_down || nx < 0 || ny >= R || nx >= C) {
				dir++;
				continue;
			}

			map[y][x] = map[ny][nx];

			y = ny;
			x = nx;
		}

		map[clear_down + 1][C - 1] = tmp;
		map[clear_down][1] = 0;
		map[clear_down][0] = -1;
	}

	static class Node {
		int y, x, a;

		public Node(int y, int x, int a) {
			this.y = y;
			this.x = x;
			this.a = a;
		}
	}

}
