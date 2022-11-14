// SWEA 8382번 방향 전환

import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.BufferedReader;

public class No_8382 {

	static int T, x1, y1, x2, y2, ans;
	static boolean check;

	static boolean[][][] visit;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			x1 = Integer.parseInt(st.nextToken());
			y1 = Integer.parseInt(st.nextToken());
			x2 = Integer.parseInt(st.nextToken());
			y2 = Integer.parseInt(st.nextToken());

			check = false;
			ans = Integer.MAX_VALUE;
			visit = new boolean[201][201][2];

			dfs(x1, y1, 0, 0); // 상, 하
			dfs(x1, y1, 1, 0); // 좌, 우

			System.out.println("#" + t + " " + ans);
		}

	}

	static void dfs(int x, int y, int d, int cnt) {

		if (x == x2 && y == y2) {
			ans = Math.min(ans, cnt);

			check = true;
			return;
		}

		if (visit[x + 100][y + 100][d])
			return;

		visit[x + 100][y + 100][d] = true;

		int nx1 = x;
		int nx2 = x;
		int ny1 = y;
		int ny2 = y;

		if (d == 0) { // 상 하 (세로이동)
			nx1 = x - 1; // 좌
			nx2 = x + 1; // 우
			d = 1;
		} else if (d == 1) { // 좌 우 (가로이동)
			ny1 = y - 1; // 상
			ny2 = y + 1; // 하
			d = 0;
		}

		if (-100 <= nx1 && nx1 <= 100 && -100 <= ny1 && ny1 <= 100) {
			visit[nx1][ny1][d] = true;
			dfs(nx1, ny1, d, cnt + 1);
			visit[nx1][ny1][d] = false;
		}
		if (-100 <= nx2 && nx2 <= 100 && -100 <= ny2 && ny2 <= 100) {
			visit[nx2 + 100][ny2 + 100][d] = true;
			dfs(nx2, ny2, d, cnt + 1);
			visit[nx2 + 100][ny2 + 100][d] = false;
		}
	}

}
