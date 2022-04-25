import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//숫자놀이(60점)
// 자릿수를 나누고 먼저 오는것 기준으로 영어 알파벳 오름차순으로 정렬
// 자릿수
public class Main_1755 {

	static class num implements Comparable<num> {
		int o; // 1의 자릿수
		int t; // 10의 자릿수

		public num(int o) { // 숫자가 하나 입력되면 한자릿수 숫자
			this.o = o;
		}

		public num(int o, int t) { // 숫자가 두개 입력되면 두자릿수 숫자
			super();
			this.o = o;
			this.t = t;
		}

		@Override
		public int compareTo(num o) {
			if(this.t==0) {
				
			}
			if (this.t == o.t) { // 앞자리숫자가 같으면 1의 자릿수 비교
				// numberOrder의 index가 더 작다면 그게 더 먼저 나타나게 정렬
				int thiso = 0; // 현재수의 순위
				int oo = 0; // 비교할 수의 순위

				for (int i = 0; i < 10; i++) { // 현재 수의 순위 찾기
					if (numberOrder[i] == this.o) {
						thiso = i;
						break;
					}
				}
				for (int i = 0; i < 10; i++) { // 비교할 수의 순위 찾기
					if (numberOrder[i] == o.o) {
						oo = i;
						break;
					}
				}
				return thiso - oo;
			} else { // 같지 않으면 10의 자릿수 비교
				// numberOrder의 index가 더 작다면 그게 더 먼저 나타나게 정렬
				int thist = 0; // 현재수의 순위
				int ot = 0; // 비교할 수의 순위

				for (int i = 0; i < 10; i++) { // 현재 수의 순위 찾기
					if (numberOrder[i] == this.t) {
						thist = i;
						break;
					}
				}
				for (int i = 0; i < 10; i++) { // 비교할 수의 순위 찾기
					if (numberOrder[i] == o.t) {
						ot = i;
						break;
					}
				}
				return thist - ot;
			}
		}

		@Override
		public String toString() { //확인을 위한 toString
			return "num [t=" + t + ", o=" + o + "] = "+(t*10+o);
		}

	}

	static int M, N;
	static int[] numberOrder = { 8, 5, 4, 9, 1, 7, 6, 3, 2, 0 }; // 숫자를 영어 알파벳 오름차순으로 정렬한 리스트
	static PriorityQueue<num> list; // 정렬을 위한 리스트

	public static void main(String[] args) throws IOException {
		/* 입력 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken()); // M 이상
		N = Integer.parseInt(st.nextToken()); // N 이하

		list = new PriorityQueue<>(); //순자 큐를 이용해 자동 정렬한 리스트

		createList(); //list에 넣어줄 값 생성
//		ArrayList<String> l = 
		StringBuilder sb = new StringBuilder();
		int index=0; // 한자리숫자가 들어갈 인덱스
		int cntOne = 0; //한자리숫자 갯수
		for (int i = 0; i < N-M+1; i++) {
			num n = list.poll();
			// 정렬된 리스트는 숫자가 자릿수별로 끊어져 있으므로 합쳐서 출력하기
			if (n.t == 0) {// 한자리 숫자일 때
				sb.insert(index, n.o+" "); // 앞쪽에 넣어주기
				index += 2; // 값을 넣었으면 다음 한자리 숫자를 위해 숫자와 공백만큼 인덱스 뒤로 넘겨주기
				cntOne++;
			} else { // 두자릿수일때
				sb.append(n.t*10 + n.o).append(" "); // 값 넣어주기
			}
		}
		
		int end = (N-M+1)/10==0?0:1;
		end += (N-M+1)/10;
		index=0;
		for (int i = 0; i < end; i++) {
			if(cntOne!=0) {
				index = cntOne*2 + (10-cntOne)*3;
				sb.insert(index,"r");
				cntOne=0;
			}else {
				index += 3*10;
				if(index<=sb.length()) {
					sb.insert(index,"r");
				}
				
			}
			
		}
		
		
		System.out.println(sb.toString()); //출력

	}

	// M이상 N이하의 정수를 생성해주는 리스트
	public static void createList() {
		for (int i = M; i <= N; i++) {
			list.add(new num(i%10,i/10%10));
//			if (i % 10 == i) { // 자릿수가 하나인 것 확인
//				list.add(new num(i,0)); // 한자릿수라면 값 하나 넣어주기
//			} else { // 두자릿수라면 앞 자릿수대로 정렬 후 뒷자리수로 정렬
//				list.add(new num(i % 10, i / 10 % 10)); // 두자릿수라면 값 2개 넣어주기
//			}
		}
	}

}
