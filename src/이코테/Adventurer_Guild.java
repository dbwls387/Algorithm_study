// 이코테 - 모험가 길드 

package 이코테;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Adventurer_Guild {

	static int N;
	static int[] arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int person = 0;
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			person++;
			if (person >= arr[i]) {
				cnt++;
				person = 0;
			}
		}
		System.out.println(cnt);
	}

}
