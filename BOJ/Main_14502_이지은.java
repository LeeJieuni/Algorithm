import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_14502_이지은 {
	static class Pos{
		int x;
		int y;
		public Pos(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
	}
	static int deltas[][] = {{-1,0},{0,1},{1,0},{0,-1}}; // 상우하좌
	static int N,M,map[][],origin[][],answer;
//	static List<Pos> virus; // 0인 곳 위치 넣는 리스트
	static Queue<Pos> virus; // 0인 곳 위치 넣는 리스트
	static List<Pos> wall; // 조합으로 뽑은 벽의 3개의 위치 리스트
	
	//0인곳을 리스트 받아서 3개 조합 만들어서 칸 세워보기
	static void wallwall(int depth) {
		if(depth==3) {
			spread();
			answer = Math.max(answer, findSafe());
			back();
//			mapSave(); //원래대로 돌려놓아야 다른 거 돌지 
			return;
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j]==0) {
					map[i][j]=1;
					wallwall(depth+1);
					map[i][j]=0;
				}
			}
		}
		
	}
	
	//bfs로 바이러스 2 채워넣기
	static void spread() {
		boolean visited[][] = new boolean[N][M];
//		Queue<Pos> virus = new LinkedList<>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j]==2) {
					virus.add(new Pos(i, j));
				}
			}
		}
		while(!virus.isEmpty()) {
			Pos now = virus.poll();
			visited[now.x][now.y] = true; // 혹시 지금 하는게 문제가 있으려나?
			
			for (int d = 0; d < 4; d++) {
				int dx = now.x + deltas[d][0];
				int dy = now.y + deltas[d][1];
				
				if(dx>=0 && dy>=0 && dx<N && dy<M && map[dx][dy]==0 && !visited[dx][dy]) {
					map[dx][dy] = 3;
					virus.offer(new Pos(dx, dy));
				}
			}
		}
	}
	
	//0의 최대값 찾기
	static int findSafe() {
		int res = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j]==0) {
					res++;
				}
			}
		}
		return res;
	}
	
	//origin에서 map으로 복사하기
	static void mapSave() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = origin[i][j];
			}
		}
	}
	static void back() { // 아니면 퍼진거 다시 회수하기
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j] == 3) {
					map[i][j]=0;
				}
			}
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		origin = new int[N][M];
		answer = 0;
		virus = new LinkedList<>();
		wall = new ArrayList<>();
		
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				origin[i][j] = Integer.parseInt(st.nextToken());
				if(origin[i][j]==2) {
					virus.add(new Pos(i, j));
				}
			}
		}
		
		mapSave();
		wallwall(0);
		System.out.println(answer);
	}

}
//오직 0 으로 된 곳만 안전 영역이군.
//벽을 3개만 세울 수 있음