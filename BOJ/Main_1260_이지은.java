import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main_1260_이지은 {
	static int N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		N = Integer.parseInt(s[0]); // 정점 개수
		int M = Integer.parseInt(s[1]); // 간선 개수
		int V = Integer.parseInt(s[2]); // 탐색 시작할 정점 번호 V

		int[][] adjMatrix = new int[N+1][N+1];
		for (int i = 0; i < M; i++) {
			s = br.readLine().split(" ");
			int from = Integer.parseInt(s[0]);
			int to = Integer.parseInt(s[1]);

			adjMatrix[to][from] = adjMatrix[from][to] = 1;
		}

//		for (int[] is : adjMatrix) {
//			System.out.println(Arrays.toString(is));
//		}
//		
		dfs(adjMatrix,new boolean[N+1],V);
		System.out.println();
		bfs(adjMatrix,V);

		
	}

	public static void dfs(int[][] adjMatrix,boolean[] visited,int current) {
		
		visited[current] = true;
		System.out.print(current+" ");
		
		for (int j = 0; j < N+1; j++) {
			if(!visited[j] && adjMatrix[current][j] !=0) {
				dfs(adjMatrix,visited,j);	
			}
		}
		
	}
	
	public static void bfs(int[][] adjMatrix, int start) {
		Queue<Integer> queue = new LinkedList<>();
		boolean[] visited = new boolean[N+1];

		queue.offer(start);
		visited[start] = true;

		while (!queue.isEmpty()) {
			int current = queue.poll();
			System.out.print(current+" ");
			
			for(int j=1;j<N+1;j++) {
				if(!visited[j] && adjMatrix[current][j] !=0) {
					queue.offer(j);
					visited[j]=true;
				}
			}
		}

	}

}
