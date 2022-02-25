import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//정올 1681:해밀턴 순환회로
//백트래킹 DFS
public class Main_1681 {
	static int N, min;
	static int Matrix[][];

	public static void dfs(boolean[] visited, int current, int sum, int cnt) { // sum: 직전까지 합한 것
		
		visited[current] = true;

		if (cnt == N ) {// 마지막 장소
			if(Matrix[current][1]==0) {
				return;
			}
			sum += Matrix[current][1];
			if (min > sum) {
				min = sum;
			}
			
			return;
		}
		if(sum>min) {
			return;
		}

		for (int j = 1; j <= N; j++) {
			if(!visited[j] && Matrix[current][j] != 0) {
				sum += Matrix[current][j];
				dfs(visited, j, sum, cnt+1);
				sum -= Matrix[current][j];
				visited[j] = false;
				
			}
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		Matrix = new int[N + 1][N + 1];
		min = Integer.MAX_VALUE;
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				Matrix[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		dfs(new boolean[N + 1], 1, 0, 1);
		System.out.println(min);
	}

}
