import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_17144_이지은 {

	static int upper[][] = { { 0, 1 }, { -1, 0 }, { 0, -1 }, { 1, 0 } }; // 우 상 좌 하
	static int lower[][] = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } }; // 우 하 좌 상
	static int R, C, AC;
	static int map[][]; // 초기 값 저장 // 에어컨 틀고 최종값 저장
	static int plus[][]; // 미세먼지가 확산되었을 때 값 저장

	//공기청정기 가동
	public static void circulation() {
		int x = AC - 1; // 에어컨 위쪽 위치
		int y = 0;

		// 윗부분 순환
		for (int d = 0; d < 4; d++) {
			if (d != 0) {
				map[x + upper[d][0]][y + upper[d][1]] = plus[x][y];
			}

			while (true) {
				int dx = x + upper[d][0];
				int dy = y + upper[d][1];
				if (dx < 0 || dx >= AC || dy < 0 || dy >= C) {
					break;
				}
				if (plus[x][y] == -1) { // 공기청정기에서 나오면 0 나오기
					map[dx][dy] = 0;
				} else if (map[dx][dy] == -1) { // 공기청정기로 들어갈 때
					// nothing?
				} else {
					map[dx][dy] = plus[x][y];
				}
				x = dx;
				y = dy;
			}
		}

		// 아래부분 순환
		x = AC; // 에어컨 아래쪽 위치
		y = 0;//
		for (int d = 0; d < 4; d++) {
			if (d != 0) {
				map[x + lower[d][0]][y + lower[d][1]] = plus[x][y];
			}

			while (true) {
				int dx = x + lower[d][0];
				int dy = y + lower[d][1];
				if (dx < AC || dx >= R || dy < 0 || dy >= C) {
					break;
				}
				if (plus[x][y] == -1) { // 공기청정기에서 나오면 0 나오기
					map[dx][dy] = 0;
				} else if (map[dx][dy] == -1) { // 공기청정기로 들어갈 때
					// nothing?
				} else {
					map[dx][dy] = plus[x][y];
				}
				x = dx;
				y = dy;
			}
		}
	}

	//미세먼지 확산
	static void spread() {
		//확산 전 plus 초기화
				for (int i = 0; i < R; i++) {
					for (int j = 0; j < C; j++) {
						plus[i][j]=0;
					}
				}
		// 미세먼지 확산 - 1초
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] > 0) { // 미세먼지 있을 때
					int cnt = 0;
					for (int k = 0; k < 4; k++) {
						int dx = i + upper[k][0];
						int dy = j + upper[k][1];
						if (dx >= 0 && dx < R && dy >= 0 && dy < C && map[dx][dy] != -1) {
							plus[dx][dy] += map[i][j] / 5;
							cnt++;
						}
					}
					plus[i][j] += map[i][j] - (map[i][j] / 5) * cnt; 
				}
			}
		}
		// 에어컨 넣어주기
		plus[AC - 1][0] = -1;
		plus[AC][0] = -1;
		
		// 미세먼지 확산 후 map에 값 넣어주기
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				map[i][j] = plus[i][j];
			}
		}
	}
	
	//미세먼지 개수 계산
	static int count() {
		int sum = 0;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				sum += map[i][j];
			}
		}
		return sum+2; // 공기청정기값 +2
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		plus = new int[R][C];
		AC = 0; // 에어컨 위치 (아래쪽)

		// 입력
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == -1) {
					AC = i; // 아마 밑에꺼가 저장될 것. 그 점 유의해서 -1 한것으로 쓰기
				}
			}
		}
		for (int i = 0; i < T; i++) {
			spread();
			circulation();
		}

		System.out.println(count());
	}

}
