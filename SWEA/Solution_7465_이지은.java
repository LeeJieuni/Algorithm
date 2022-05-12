import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//창용 마을 무리의 개수
//서로소집합
public class Solution_7465_이지은 {
	static int N,M;
	static int[] parents;
	
	public static int findSet(int a) {
		if(a==parents[a])return a;
		
		return parents[a] = findSet(parents[a]);
	}
	//a,b 두 집합 합치기
		public static boolean union(int a, int b) { // 합쳐지면 true, 합쳐지지 못하면 false 반환
			int aRoot = findSet(a);
			int bRoot = findSet(b); // 두 집합의 대표자 찾기

			if(aRoot == bRoot) return false; // 이미 같은 집합
			
//			parents[bRoot] = aRoot; // a밑에 b 붙이기 (합쳐짐)
			for (int i = 1; i <= N; i++) {
				if(parents[i]==bRoot) {
					parents[i] = aRoot;
				}
			}
			return true;
		
		}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			N = Integer.parseInt(st.nextToken()); // 사람 수
			M = Integer.parseInt(st.nextToken());
			parents = new int[N+1];
			ArrayList<Integer> list = new ArrayList<>(); //집합의 대표자들 넣어서 다른거 몇개인지.
			
			//자신의 부모노드를 자신의 값으로 세팅
			for (int i = 1; i <= N; i++) {
				parents[i] = i;
			}
			
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine()," ");
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				union(from,to);
			}
			
			list.add(parents[1]);
			for (int i = 2; i <= N; i++) {
				if(list.contains(parents[i])) {
					continue;
				}else {
					list.add(parents[i]);
				}
			}

			System.out.println("#"+tc+" "+list.size());
		}
	}
}
