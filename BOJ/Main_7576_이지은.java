
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class tomato {
	int x;
	int y;
	int depth;

	tomato(int x, int y, int depth) {
		this.x = x;
		this.y = y;
		this.depth = depth;
	}
}

public class Main_7576_이지은 { // 토마토
	static int[][] deltas = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static int[][] map;
	static boolean[][] visited;
	static Queue<tomato> q;
	static int N, M, day;

	public static void bfs() {

		while (!q.isEmpty()) {
			tomato t = q.poll();
			visited[t.x][t.y] = true;
			day = Math.max(day, t.depth);
			for (int i = 0; i < 4; i++) {
				int x = t.x + deltas[i][0];
				int y = t.y + deltas[i][1];
				if (x >= 0 && x < N && y >= 0 && y < M && map[x][y] != -1 && !visited[x][y]) { // && map[t.x][t.y] == 1
					if (map[x][y] == 0) { // 사실 무조건 인것 같아서 이 조건 없어도 될듯?
						visited[x][y] = true;
						map[x][y] = 1; // 토마토 익히고
						q.offer(new tomato(x, y, t.depth + 1)); // 토마토 배열에 넣기
					}
				}
			}

		}
		boolean ripen = true;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (!visited[i][j]) {
					ripen = false;
				}
			}
		}

		if (!ripen) {// Arrays.asList(map).contains(0)) {
			// !visited 있으면
			System.out.println(-1);
		} else {
			System.out.println(day);
		}

	}

	public static void main(String[] args) throws IOException {
		q = new LinkedList<tomato>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visited = new boolean[N][M];
		day = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1) {
					q.add(new tomato(i, j, 0));
				} else if (map[i][j] == -1) { // 갈 수 없으니까 미리 방문처리해두기
					visited[i][j] = true;
				}

			}
		}

		bfs();

	}

}
