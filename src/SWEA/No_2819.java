// SWEA 2819번 격자판의 숫자 이어 붙이기

package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class No_2819 {

	static int T, ans;
	static String str = "";
	static HashSet<String> hash = new HashSet<>();
	static int[][] arr = new int[4][4];

	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			for (int i = 0; i < 4; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 4; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			hash.clear();
			ans = 0;
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 4; j++) {
					dfs(i, j, 0, str + arr[i][j]);
				}
			}

			System.out.println("#" + t + " " + hash.size());
		}
	}

	static void dfs(int y, int x, int cnt, String str) {
		// 출력
		if (cnt == 6) {
			hash.add(str);
			str = "";
			return;
		}

		// 4방 방문 시도
		for (int d = 0; d < 4; d++) {
			int ny = y + dy[d];
			int nx = x + dx[d];

			if (ny < 0 || nx < 0 || ny >= 4 || nx >= 4)
				continue;

			dfs(ny, nx, cnt + 1, str + arr[ny][nx]);
		}
	}
}
