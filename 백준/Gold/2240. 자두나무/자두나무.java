import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int T, W, max;
	static int[] arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		T = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());

		arr = new int[T + 1];
		for (int i = 1; i <= T; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		int[][][] dp = new int[T + 1][W + 1][3];
		for (int i = 1; i <= T; i++) {
			for (int j = 0; j <= W; j++) {
				if(j == 0) {	
					if(arr[i] == 1) 
						dp[i][j][1] = dp[i - 1][j][1] + 1;
					else 
						dp[i][j][1] = dp[i - 1][j][1];
					
					continue;
				}
				
				if (arr[i] == 1) {
					dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][2]) + 1;
					dp[i][j][2] = Math.max(dp[i - 1][j][2], dp[i - 1][j - 1][1]);
				} else {
					dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][2]);
					dp[i][j][2] = Math.max(dp[i - 1][j][2], dp[i - 1][j - 1][1]) + 1;
				}
			}
		}

		int answer = Math.max(dp[T][W][1], dp[T][W][2]);
		System.out.println(answer);
	}

}
