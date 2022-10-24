// BOJ 16430번 제리와 톰 

package BOJ.Mathematics;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No_16430 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());

		gcd(A, B);

		System.out.println((B - A) / gcd(B - A, B) + " " + (B) / gcd(B - A, B));
	}

	static int gcd(int A, int B) {
		if (A == B || B == 0)
			return A;

		if (A > B)
			return gcd(B, A % B);
		else
			return gcd(A, B % A);
	}

}
