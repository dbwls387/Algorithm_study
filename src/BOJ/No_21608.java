// BOJ 21608번 상어 초등학교 

package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class No_21608 {

	static int N;
	static int[][] arr, map;

	static Queue<Node> que;

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
	}

	static void bfs(int idx) {
		que = new ArrayDeque<>();

		int cntLike = 0;
		int cntEmp = 0;
		for (int y = 0; y < N; y++) {
			for (int x = 0; x < N; x++) {
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
			}
		}
		
		
	}

	static class Node {
		int y, x, cntLike, cntEmp;

		public Node(int y, int x, int cntLike, int cntEmp) {
			this.y = y;
			this.x = x;
			this.cntLike = cntLike;
			this.cntEmp = cntEmp;
		}
	}
}
