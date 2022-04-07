import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_1953_이지은 {
	static class Pos{
		int x;
		int y;
		int time;
		public Pos(int x, int y,int time) {
			super();
			this.x = x;
			this.y = y;
			this.time = time;
		}
	}
	static int N,M,L , map[][];
	static boolean visited[][];
	static int deltas[][] = {{-1,0},{0,1},{1,0},{0,-1}}; // 상우하좌 . 상 하나 더 넣을까?말까? %로 할까?
	static int arrest(int r,int c) {
		//L이 다 되면 0 or L 이면 끝내기
		visited = new boolean[N][M];
		Queue<Pos> q = new LinkedList<>();
		
		q.offer(new Pos(r, c,1));
		visited[r][c] = true;
		
		while(!q.isEmpty()) {
			
			Pos now = q.poll();
			if(now.time==L) break;
			
			for (int d = 0; d < 4; d++) {
				int dx = now.x + deltas[d][0];
				int dy = now.y + deltas[d][1];
				
				if(canGo(dx,dy,d,map[now.x][now.y])) {
					q.offer(new Pos(dx, dy,now.time+1));
					visited[dx][dy] = true;
				}
			}
		}
		return calcPos();
	}
	//값에 따라 갈 수 있는 곳이 달라짐.
	static boolean canGo(int dx, int dy,int d,int origin) { // 새로 갈곳의 x,y 좌표, 방향 , 원래의것
		if(dx<0 || dy<0 || dx>=N || dy>=M || map[dx][dy]==0 || visited[dx][dy]) return false;
		if(dx>=0 && dy>=0 && dx<N && dy<M && map[dx][dy]>0) {
			int newT = map[dx][dy];
			
			switch(d) {
			case 0: //상
				if(newT==3||newT==4||newT==7) return false;
				else {
					if(origin==3||origin==5||origin==6) return false;
				}
				break;
			case 1: //우
				if(newT==2||newT==4||newT==5) return false;
				else {
					if(origin==2||origin==6||origin==7) return false;
				}
				break;
			case 2: //하
				if(newT==3||newT==5||newT==6) return false;
				else {
					if(origin==3||origin==4||origin==7) return false;
				}
				break;
			case 3: //좌
				if(newT==2||newT==6||newT==7) return false;
				else {
					if(origin==2||origin==4||origin==5) return false;
				}
				break;
			}
		}
		return true;
		
	}
	
	//탈주범이 위치할 수 있는 장소의 개수 계산
	static int calcPos() {
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(visited[i][j]==true) cnt++;
			}
		}
		return cnt;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int TC = 1; TC <= T; TC++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			int R = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			map = new int[N][M];
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < M; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int answer = arrest(R,C);
//			for (int i = 0; i < N; i++) {
//				for (int j = 0; j < M; j++) {
//					if(visited[i][j])System.out.print(1+" ");
//					else System.out.print(0+" ");
//				}
//				System.out.println();
//				
//			}
			System.out.println("#" + TC + " "+answer);
		}

	}

}
/*
 * 1
10 10 4 3 9
0 0 0 0 0 0 0 0 0 0
0 0 0 7 5 0 5 0 0 0
0 0 3 2 2 6 0 0 0 0
0 4 7 2 2 2 7 0 0 4
0 3 0 1 1 2 2 0 0 5
0 5 6 1 1 1 1 6 2 5
7 4 1 2 0 0 4 6 0 0
5 3 1 7 0 2 2 6 5 7
7 3 2 1 1 7 1 0 2 7
3 4 0 0 4 0 5 1 0 1
*/
