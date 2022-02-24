import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_1238_이지은 {

//	static boolean[][] adj;
	static int N, start;
	static int result;

	public static void bfs(boolean[][] adj) {
		Queue<Integer> queue = new LinkedList<Integer>();
		boolean[] visited = new boolean[101];

		queue.offer(start);
		visited[start] = true;
		while (!queue.isEmpty()) {
			int size = queue.size();
			int max = 0;

			for (int s = 0; s < size; s++) {

				int current = queue.poll();

				if (current > max) {
					max = current;
				}

				for (int i = 1; i < adj[current].length; i++) {
					if (adj[current][i] && !visited[i]) {
						queue.offer(i);
						visited[i] = true;
					}
				}

			}
			result = max;
		}
	}

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int tc = 1; tc <= 10; tc++) {

			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			start = Integer.parseInt(st.nextToken());

//			adj = new boolean[101][101];
			boolean[][] adj = new boolean[101][101];
			result = Integer.MIN_VALUE;

			st = new StringTokenizer(br.readLine());

			for (int i = 0; i < N / 2; i++) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());

				adj[from][to] = true;
			}

			bfs(adj);

			System.out.println("#" + tc + " " + result);
		}
	}

}
