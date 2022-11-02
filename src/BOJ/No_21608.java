// BOJ 21608번 상어 초등학교 

package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class No_21608 {

	static int N, ans;
	static int[][] arr, map;

	static PriorityQueue<Node> pque;

	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		arr = new int[N * N][5];
		for (int i = 0; i < N * N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		map = new int[N][N];

		for (int i = 0; i < N * N; i++) {
			bfs(i);
		}

		// 학생의 만족도 총 합 구하기
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				int cnt = 0;

				int idx = 0;
				for (int k = 0; k < N * N; k++) {
					if (arr[k][0] == map[i][j]) {
						idx = k;
						break;
					}
				}

				for (int d = 0; d < 4; d++) {
					int ny = i + dy[d];
					int nx = j + dx[d];

					if (ny < 0 || nx < 0 || ny >= N || nx >= N)
						continue;

					for (int k = 1; k <= 4; k++) {
						if (map[ny][nx] == arr[idx][k]) {
							cnt++;
							break;
						}
					}
				}

				if (cnt == 0)
					ans += 0;
				else if (cnt == 1)
					ans += 1;
				else if (cnt == 2)
					ans += 10;
				else if (cnt == 3)
					ans += 100;
				else if (cnt == 4)
					ans += 1000;
			}
		}

		System.out.println(ans);
	}

	static void bfs(int idx) {
		pque = new PriorityQueue<>();

		for (int y = 0; y < N; y++) {
			for (int x = 0; x < N; x++) {
				int cntLike = 0;
				int cntEmp = 0;

				if (map[y][x] != 0)
					continue;

				for (int d = 0; d < 4; d++) {
					int ny = y + dy[d];
					int nx = x + dx[d];

					if (ny < 0 || nx < 0 || ny >= N || nx >= N)
						continue;

					for (int i = 1; i <= 4; i++) {
						if (map[ny][nx] == arr[idx][i]) {
							cntLike++;
							break;
						}
					}

					if (map[ny][nx] == 0) // 인접한 칸이 비어있는 경우 개수 세기
						cntEmp++;
				}

				pque.add(new Node(y, x, cntLike, cntEmp));
			}
		}

		Node node = pque.poll();
		map[node.y][node.x] = arr[idx][0];
	}

	static class Node implements Comparable<Node> {
		int y, x, cntLike, cntEmp;

		public Node(int y, int x, int cntLike, int cntEmp) {
			this.y = y;
			this.x = x;
			this.cntLike = cntLike;
			this.cntEmp = cntEmp;
		}

		@Override
		public int compareTo(Node o) {
			if (this.cntLike == o.cntLike) {
				if (this.cntEmp == o.cntEmp) {
					if (this.y == o.y)
						return this.x - o.x;
					else
						return this.y - o.y;
				} else
					return o.cntEmp - this.cntEmp;
			} else
				return o.cntLike - this.cntLike;
		}
	}
}