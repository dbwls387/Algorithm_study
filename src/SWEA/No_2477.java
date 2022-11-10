// 2477번 [모의 SW 역량테스트] 차량 정비소

package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class No_2477 {
	
	/*
	 * T: 테스트 케이스 
	 * N: 접수 창구 개수 
	 * M: 정비 창구 개수
	 * K: 차량 정비소를 방문한 고객의 수 
	 * A: 지갑을 두고 간 고객이 이용한 접수 창구 번호 A
	 * B: 지갑을 두고 간 고객이 이용한 접수 창구 번호 B
	 * 
	 * arrA: 접수 창구가 고장을 접수하는 데 걸리는 시간
	 * arrB: 정비 창구가 차량을 정비하는 데 걸리는 시간 
	 * arrT: k번째 고객이 차량 정비소를 방문하는 시간  
	 */

	static int T, N, M, K, A, B;
	static int[] arrA, arrB;
	static People[] arrT;
	static Queue<People> reception, repair;
	static Queue<People> que;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			A = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());

			arrA = new int[N + 1];
			arrB = new int[M + 1];
			arrT = new People[K + 1];

			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= N; i++) {
				arrA[i] = Integer.parseInt(st.nextToken());
			}

			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= M; i++) {
				arrB[i] = Integer.parseInt(st.nextToken());
			}

			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= K; i++) {
				int input = Integer.parseInt(st.nextToken());
				arrT[i] = new People(1, input);
			}
			
			// 입력 끝 
			
			/*
			 * 1. 고객이 차량 정비소에 도착 
			 * 	 -> 빈 접수 창구가 있으면 빈 창구에서 접수 
			 *   -> 없으면 창구가 빌 때까지 기다리기 
			 *   --> 여러 고객이 기다리면 : 고객번호가 낮은 순서대로 접수 
			 *   --> 빈 창구가 여러 곳 : 접수 창구번호가 작은 곳으로 가기 
			 *   
			 * 2. 빈 정비 창구 
			 *   -> 먼저 기다리는 고객 우선 접수 
			 *   -> 접수 창구에서 동시에 접수를 완료한 고객들의 경우, 이용했던 접수 창구번호가 작은 고객 우선 
			 *   -> 빈 창구가 여러 곳 : 정비 창구번호가 작은 곳으로 가기  
			 *   
			 * *** 지갑을 분실한 고객과 같은 접수 창구, 정비 창구를 이용한 고객들 번호의 합  *** 
			 */

			reception = new ArrayDeque<>();
			repair = new ArrayDeque<>();

			solve();
		}

	}

	static void solve() {
		// #1 고객이 차량 정비소에 도착
		
		

	}
	
	static void recepFunc() {
		// 접수 창구 도착 순서대로 정렬
		for (int i = 1; i < K; i++) {
			if (arrT[i].time < arrT[i + 1].time) {
				int tmp = arrT[i].time;
				arrT[i].time = arrT[i + 1].time;
				arrT[i + 1].time = tmp;
			}
		}
		
		que = new ArrayDeque<>();
		for (int i = 1; i <= K; i++) {
			que.add(new People(i, arrT[i].time));
		}

		int time = 0;
		int[] wait = new int[N + 1];
		while (!que.isEmpty()) {
			if (time < que.peek().time) {
				time = que.peek().time;
			}

			for (int i = 1; i <= N; i++) {
				if (wait[i] <= time) {
					People people = que.poll();
					wait[i] = time + arrA[i];
					
					repair.offer(new People(people.num, wait[i], i));
					
					
				}
			}
			
			time++;
		}
	}

	static class People {
		int num;
		int time;
		int repairNum;

		public People(int num, int time) {
			this.num = num;
			this.time = time;
		}

		public People(int num, int time, int repairNum) {
			this.num = num;
			this.time = time;
			this.repairNum = repairNum;
		}
	}
}
