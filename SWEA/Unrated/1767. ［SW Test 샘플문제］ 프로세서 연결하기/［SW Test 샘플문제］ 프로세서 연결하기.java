import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {

	static int T, N, C, size, ans;
	static int[][] map;

	static List<Node> list;

	static int[] src, tgt;

	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());

			size = 0;
			list = new ArrayList<>();

			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());

					if (map[i][j] == 1) {
						if (i == 0 || j == 0 || i == N - 1 || j == N - 1)
							continue;

						list.add(new Node(i, j));
						size++;
					}
				}
			}

			src = new int[size];
			for (int i = 0; i < size; i++) {
				src[i] = i;
			}

			ans = Integer.MAX_VALUE;
			for (int i = size; i >= 0; i--) {
				C = i;
				tgt = new int[C];

				comb(0, 0);

				if (ans < Integer.MAX_VALUE)
					break;
			}

			System.out.println("#" + t + " " + ans);
		}

	}

	static void dfs(int idx, int cnt) {
		if (idx == C) {
			ans = Math.min(ans, cnt);
			return;
		}

		for (int d = 0; d < 4; d++) {
			Node node = list.get(tgt[idx]);
			int y = node.y;
			int x = node.x;

			while (true) {
				y += dy[d];
				x += dx[d];

				if (y < 0 || x < 0 || y >= N || x >= N) {
					dfs(idx + 1, cnt);
					break;
				}

				if (map[y][x] != 0)
					break;

				map[y][x] = 2;
				cnt++;
			}
			while (true) {
				y -= dy[d];
				x -= dx[d];

				if (y == node.y && x == node.x)
					break;

				map[y][x] = 0;
				cnt--;
			}
		}
	}

	static void comb(int srcIdx, int tgtIdx) {
		if (tgtIdx == C) {
			dfs(0, 0);

			return;
		}

		for (int i = srcIdx; i < size; i++) {
			tgt[tgtIdx] = src[i];
			comb(i + 1, tgtIdx + 1);
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
