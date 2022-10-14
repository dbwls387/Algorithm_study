// SWEA 4012번 [모의 SW 역량테스트] 요리사

package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No_4012 {
	
	static int T, N, min;
	static int[][] map;
	static int[] arrA, arrB; 
	static boolean[] select; 

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			select = new boolean[N];

			arrA = new int[N / 2];
			arrB = new int[N / 2];

			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			min = Integer.MAX_VALUE;

			comb(0, 0);

			System.out.println("#" + t + " " + min);
		}

	}

	static void comb(int srcIdx, int tgtIdx) {
		if (tgtIdx == N / 2) {
			check();

			return;
		}

		if (srcIdx == N)
			return;

		select[srcIdx] = true;
		comb(srcIdx + 1, tgtIdx + 1); 

		select[srcIdx] = false;
		comb(srcIdx + 1, tgtIdx);
	}

	static void check() {
		int idxA = 0;
		int idxB = 0;

		for (int i = 0; i < N; i++) { 
			if (select[i])
				arrA[idxA++] = i;
			else
				arrB[idxB++] = i;
		}

		int sumA = 0;
		int sumB = 0;
		for (int i = 0; i < N / 2; i++) {
			for (int j = 0; j < N / 2; j++) {
				if (i == j)
					continue;
				sumA += map[arrA[i]][arrA[j]];
				sumB += map[arrB[i]][arrB[j]];
			}
		}

		min = Math.min(min, Math.abs(sumA - sumB));
	}

}
