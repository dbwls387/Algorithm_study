import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, X, K;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		// K번만큼 컵 위치 바꾸기
		for (int k = 0; k < K; k++) {
			// 입력
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			// 바꿔야 하는 컵 중 간식이 들어있는 컵(X)이 있을 경우 X 값을 변경된 위치로 갱신
			if (a == X) {
				X = b;
			} else if (b == X) {
				X = a;
			}
		}

		System.out.println(X);
	}

}
