package BOJ.Greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class No_2212 {

	static int N, K;
	static int[] arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		K = Integer.parseInt(br.readLine());

		arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr); // 센서 오름차순 정렬

		if (K >= N) {
			System.out.println(0);
		} else {

			Integer[] dif = new Integer[N - 1]; // 센서들간의 차이 구하기
			for (int i = 0; i < N - 1; i++) {
				dif[i] = arr[i + 1] - arr[i];
			}

//		Arrays.sort(dif, Collections.reverseOrder()); // 차이 내림차순 정렬
			Arrays.sort(dif);
			System.out.println(Arrays.toString(dif));

			int ans = 0;
			for (int i = 0; i < K; i++) {
				ans += dif[i];
			}

			System.out.println(ans);
		}
	}

}
