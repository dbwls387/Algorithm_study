// BOJ 2628번 종이자르기

package BOJ.Sorting;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class No_2628 {

	static int N, width, height, max;
	static List<Integer> zero = new ArrayList<>();
	static List<Integer> one = new ArrayList<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		width = Integer.parseInt(st.nextToken());
		height = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(br.readLine());

		zero.add(0);
		one.add(0);
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int ch = Integer.parseInt(st.nextToken());

			if (ch == 0)
				zero.add(Integer.parseInt(st.nextToken()));
			else
				one.add(Integer.parseInt(st.nextToken()));
		}
		zero.add(height);
		one.add(width);

		Collections.sort(zero);
		Collections.sort(one);

		max = 0;
		for (int i = 0; i < zero.size() - 1; i++) {
			int x = zero.get(i + 1) - zero.get(i);
			for (int j = 0; j < one.size() - 1; j++) {
				int y = one.get(j + 1) - one.get(j);

				max = Math.max(max, x * y);
			}
		}

		System.out.println(max);
	}

}
