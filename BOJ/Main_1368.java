package MST;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;



public class Main_1368 {
	
	static class Edge implements Comparable<Edge> {
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
	
	static int N;
//	static Edge[] edgeList;
	static ArrayList<Edge> edgelist;
	static int wCost[], adjCost[][];
	
	static int[] parents;
	static void makeSet() {
		parents = new int[N+1];
		for (int i = 1; i <= N; i++) {
			parents[i] = i;
		}
	}
	
	static int findSet(int a) {
		if(a==parents[a]) return a;
		return parents[a] = findSet(parents[a]);
	}
	
	static boolean union(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		
		if(aRoot == bRoot) return false;
		
		parents[bRoot] = aRoot;
		return true;
	}
	
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine()); // 정점 수
		edgelist = new ArrayList<>();
		for (int i = 1; i <= N; i++) {
			int w = Integer.parseInt(br.readLine()); 
//			edgeList[i] = new Edge(0, i, w); // 우물을 0이라하고 각 정점에서 우물에 이르는 비용을 가중치로 줌
			edgelist.add(new Edge(0, i, w));
		}
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 1; j <= N; j++) {

				int a = Integer.parseInt(st.nextToken());
				if(i!=j) {
//					edgeList[i] = new Edge(i, j, a); // i->j == j->i 
					edgelist.add(new Edge(i, j, a));
				}
			}
		}
		
		makeSet();
		
//		Arrays.sort(edgeList);
		Collections.sort(edgelist);
		
		int result = 0, cnt = 0;
		for (Edge edge : edgelist) {
			if(union(edge.from,edge.to)) {
				result += edge.weight;
				if(++cnt == N)break;
			}
		}
		
		System.out.println(result);
		
		
		
		
		
		
	}

}
