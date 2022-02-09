import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_16926_이지은 {
	static int N,M,R;
	static int map[][], after[][];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder("");
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		map = new int [N+1][M+1]; //인덱스 1부터 시작하도록
		after = new int [N+1][M+1];
		for(int i=1;i<=N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1;j<=M;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}//-입력 끝
		rotate(R); // count: 바깥에서부터 몇번째 줄 할 차례인지

		for(int i=1;i<=N;i++) {
			for(int j=1;j<=M;j++) {
//				System.out.print(map[i][j]+ " ");
				sb.append(map[i][j]).append(" ");
			}
//			System.out.println();
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
	
	public static void rotate(int R) {
		if(R==0) return;
		int count = 1;
		while(true) {
			if(count >(M/2) || count > (N/2)) { //count가 N,M길이의 반을 넘어가면 돌릴 이유 X->종료
				break;
			}
			for(int i=count;i<M+1-count;i++) {
				after[count][i] = map[count][i+1];//위
				after[N+1-count][i+1] = map[N+1-count][i];//아래
			}
			
			for(int i=count;i<N+1-count;i++) {
				after[i+1][count] = map[i][count];//왼쪽
				after[i][M+1-count] = map[i+1][M+1-count];//오른쪽
			}
			count++;
		}
		for(int i=1;i<=N;i++) {
			for(int j=1;j<=M;j++) {
				map[i][j] = after[i][j];
			}
		}
		rotate(--R);
		
	}

}
