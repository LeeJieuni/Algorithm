import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_9205_이지은 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		Loop:for (int TC = 1; TC <= T; TC++) {
			int N = Integer.parseInt(br.readLine());
			
			int pos[][] = new int[N+2][N+2]; 
			boolean d[][] = new boolean[N+2][N+2]; 
			List<int[]> p = new ArrayList<>();
			for (int i = 0; i < N+2; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				p.add(new int[] {x,y});
			}
			for (int i = 0; i < N+2; i++) {
				for (int j = 0; j < N+2; j++) {
					int[] p1 = p.get(i);
					int[] p2 = p.get(j);
					pos[i][j] = dist(p1[0],p1[1],p2[0],p2[1]);
					if(pos[i][j] <= 50*20) {
						d[i][j] = true;
					}
				}
			}
			for (int i = 0; i < N+2; i++) {
				for (int j = 0; j < N+2; j++) {
					for (int k = 0; k < N+2; k++) {
						if(d[j][i]& d[i][k]) {
							d[j][k] = true;
						}
					}
				}
			}
			
			if(d[0][N+1]) {
				System.out.println("happy");
			}else {
				System.out.println("sad");
			}
			
			
			
		}
	}
	
	//두 좌표 사이 거리 구하기
	static int dist(int x, int y, int x2, int y2) {
		return Math.abs(x-x2)+Math.abs(y-y2);
	}
}
/*
 
굳이 편의점을 안들려도 되는군!!!!
1
1
0 0
9999 9999
0 1
answer:happy
*/