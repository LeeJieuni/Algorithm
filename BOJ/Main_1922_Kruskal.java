package MST;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1922_Kruskal {
	static class Edge implements Comparable<Edge>{
		int from, to, weight;

		public Edge(int from, int to, int weight) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return this.weight - o.weight; 
		}
		
	}
	static int N,M;
	static Edge[] edgeList;
//--	서로소 집합 코드 
	static int[] parents;
	
	static void makeSet() { // 단위 집합 생성
		parents = new int[N+1];
		
		for (int i = 1; i <= N; i++) {
			parents[i]=i; // 자신의 부모노드를 자신의 값으로 세팅
		}
	}
	
	public static int findSet(int a) { // a의 집합 찾기 = a의 대표자 찾기
		if(a==parents[a]) return a; // 부모가 자신일 때 루트
		return parents[a] = findSet(parents[a]);
	}
	
	public static boolean union(int a, int b) { //a,b 두 집합 합치기
		// 합쳐지면 true, 못하면 false 반환
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		if(aRoot==bRoot) {
			return false;
		}
		parents[bRoot] = aRoot;
		return true;
		
		
	}
	
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine()); //컴퓨터 수 = 노드 수
		M = Integer.parseInt(br.readLine()); //간선 수
		edgeList = new Edge[M];
		
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			edgeList[i] = new Edge(from, to, weight); //간선리스트 만들기
		}
		
		makeSet();// 서로소 집합 만들기
		
		Arrays.sort(edgeList); //가중치 오름차순으로 정렬
		
		int result = 0;
		int count = 0; // 몇개의 노드가 합쳐졌는지 ( 노드-1개의 간선수 여야함)
		
		for (Edge edge : edgeList) {
			if(union(edge.from,edge.to)) {
				result += edge.weight;
				count++;
				if(count==N-1) break;
			}
		}
		
		System.out.println(result);
		
	}

}
