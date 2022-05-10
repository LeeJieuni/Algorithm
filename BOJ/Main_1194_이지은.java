import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1194_이지은 { // bfs?
	static class Pos {
		int x;
		int y;
		int move;
		int key;
//		boolean [] keys;
		public Pos(int x, int y, int move, int key) {
			super();
			this.x = x;
			this.y = y;
			this.move = move;
			this.key = key;
		}
		
	}
	static int deltas[][] = {{-1,0},{1,0},{0,-1},{0,1}};
	static char lower[]= {'a','b','c','d','e','f'};
	static char upper[]= {'A','B','C','D','E','F'};
	static int h,w,ans;
	static char map[][];
//	static boolean keys[];
	
	
	static void escape(int x, int y,int m, int k) {
		Queue<Pos> qq = new LinkedList<Pos>();
		boolean visited[][][] = new boolean[64][h][w];
		
		qq.offer(new Pos(x, y, m, k));
		map[x][y]='.'; // 현재 있는곳 나중에 이동 가능하도록
		while(!qq.isEmpty()) {
			Pos q = qq.poll();
			
			for (int d = 0; d < 4; d++) {
				int dx = q.x + deltas[d][0];
				int dy = q.y + deltas[d][1];
				
				if(dx>=0 && dy>=0 && dx<h && dy<w && map[dx][dy] != '#' && !visited[q.key][dx][dy]) {
					if(map[dx][dy] == '.') {
						qq.offer(new Pos(dx, dy,q.move+1,q.key));
						visited[q.key][dx][dy] = true;
					} else if (map[dx][dy]=='1') {
//						map[dx][dy] = Math.min(ans, b)
//						ans = Math.min(ans, q.move+1);
						ans = q.move+1;
						return;
					} else {
						for (int i = 0; i < 6; i++) {
							if(map[dx][dy] == lower[i]) { // 키 획득
								int newKey = q.key | (1<<i);
								visited[q.key][dx][dy] = true;
								visited[newKey][dx][dy] = true;
								qq.offer(new Pos(dx, dy, q.move+1,newKey));
//								map[dx][dy]='.';
							}
							if(map[dx][dy] == upper[i]) { //문일 때
								int door = 1<<i;
								if((q.key & door) >0) { //키가 있으면
									visited[q.key][dx][dy]=true;
									qq.offer(new Pos(dx, dy, q.move+1,q.key));
									
								}
							}
						}
					}
					
				
					
				}
			}
			
		}
		
	}
	
	
	//3차원 - 2차원 ,n개인거잖아 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		h = Integer.parseInt(st.nextToken());
		w = Integer.parseInt(st.nextToken());
		map = new char[h][w];
//		keys = new boolean[6]; // 0~5인덱스까지 a~f나타냄.
		ans = Integer.MAX_VALUE;
		int x=0,y=0;
		
		for (int i = 0; i < h; i++) {
			String s= br.readLine();
			for (int j = 0; j < w; j++) {
				map[i][j] = s.charAt(j);
				if(map[i][j]=='0') {
					x=i;y=j;
				}
			}
		}
		escape(x, y,0,0);
		if(ans==Integer.MAX_VALUE) {
			ans = -1;
		}
		System.out.println(ans);
		
		
//		print();
		
	}
	static void print() {
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
	}

}
