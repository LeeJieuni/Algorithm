import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//서로소 집합
public class Solution_3289_이지은 {

	static int N, M, result;
	static int parents[];

	// 단위 집합 생성
	public static void makeSet() {
		parents = new int[N + 1];
		// 자신의 부모노드를 자신의 값으로 세팅
		for (int i = 1; i <= N; i++) {
			parents[i] = i;
		}
	}

	// a의 집합 찾기 : a의 대표자 찾기
	public static int findSet(int a) {
		if (a == parents[a]) return a; // 루트

		// 루트 아니면 부모 찾으러 가기(루트 찾으러가기)
		return parents[a] = findSet(parents[a]); // path compression
	}

	// a,b 두 집합 합치기
	public static boolean union(int a, int b) { // 합쳐지면 true, 합쳐지지 못하면 false 반환
		int aRoot = findSet(a);
		int bRoot = findSet(b); // 두 집합의 대표자 찾기

		if (aRoot == bRoot)
			return false; // 이미 같은 집합 // boolean->int로 하고 반환할까?

		parents[bRoot] = aRoot; // a밑에 b 붙이기 (합쳐짐)
		return true;

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			StringBuilder sb = new StringBuilder("");
			sb.append("#").append(tc).append(" ");
			N = Integer.parseInt(st.nextToken()); // 각각 본인이 대표자인 n개의 집합
			M = Integer.parseInt(st.nextToken()); // 입력으로 주어지는 연산의 개수
			
			makeSet();
			
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int what = Integer.parseInt(st.nextToken()); // 1 or 0
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				if (what == 0) { // 합집합
					union(a, b);
				} else if (what == 1) { // 같은 집합인지 확인
					if (findSet(a) == findSet(b)) {
						result = 1;
					} else {
						result = 0;
					}

					sb.append(result);
				}

			}
			System.out.println(sb.toString());

		}
	}
}