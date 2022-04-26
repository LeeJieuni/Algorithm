import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_16935_이지은 {
	static int N,M,R;
	static int map[][],after[][];
	
	public static void calc1() {
		for(int i=0;i<N/2;i++) {
			int [] temp= map[i].clone();
			map[i] = map[N-1-i];
			map[N-1-i] = temp.clone();
		}
	}
	
	public static void calc2() {
		for(int i=0;i<M/2;i++) {
			int [] temp = new int[N];
			for(int j=0;j<N;j++) {
				temp[j] = map[j][i];
				map[j][i] = map[j][M-1-i];
				map[j][M-1-i] = temp[j];
			}
		}
	}
	
	public static void calc3() { //오른쪽으로 90도
		after = new int[M][N];

		for(int i = 0;i<N;i++) {
			for(int j=0;j<M;j++) {
				after[j][N-1-i] = map[i][j];
			}
		}
		int temp = N;
		N= M;
		M = temp;
		map = after;
	} 
	public static void calc4() { // 왼쪽으로 90도
		after = new int[M][N];

		for(int i = 0;i<N;i++) {
			for(int j=0;j<M;j++) {
				after[M-1-j][i] = map[i][j];
			}
		}
		int temp = N;
		N= M;
		M = temp;
		map = after;

	}
	public static void calc5() {
		after = new int[N][M];
		for(int i=0;i<N/2;i++) {
			for(int j=0;j<M/2;j++) {
				after[i][j+M/2] = map[i][j];
			}
		}
		for(int i = 0;i<N/2;i++) {
			for(int j=M/2;j<M;j++) {
				after[i+N/2][j] = map[i][j];
			}
		}
		for(int i=N/2;i<N;i++) {
			for(int j=M/2;j<M;j++) {
				after[i][j-M/2] = map[i][j];
			}
		}
		for(int i=N/2;i<N;i++) {
			for(int j=0;j<M/2;j++) {
				after[i-N/2][j] = map[i][j];
			}
		}
		
		map = after;
	}
	public static void calc6() {
		after = new int[N][M];
		for(int i=0;i<N/2;i++) {
			for(int j=0;j<M/2;j++) {
				after[i+N/2][j] = map[i][j];
			}
		}
		for(int i=N/2;i<N;i++) {
			for(int j=0;j<M/2;j++) {
				after[i][j+M/2] = map[i][j];
			}
		}
		
		for(int i=N/2;i<N;i++) {
			for(int j=M/2;j<M;j++) {
				after[i-N/2][j] = map[i][j];
			}
		}
		for(int i = 0;i<N/2;i++) {
			for(int j=M/2;j<M;j++) {
				after[i][j-M/2] = map[i][j];
			}
		}
		
		
		map = after;
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder("");
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		map = new int [N][M]; 
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<R;i++) {
			int r = Integer.parseInt(st.nextToken());
			switch(r){
				case 1:
					calc1();
					break;
				case 2:
					calc2();
					break;
				case 3:
					calc3();
					break;
				case 4:
					calc4();
					break;
				case 5:
					calc5();
					break;
				case 6:
					calc6();
					break;
					
					
				default:
					break;
			}
			
		}
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				sb.append(map[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
	

}
