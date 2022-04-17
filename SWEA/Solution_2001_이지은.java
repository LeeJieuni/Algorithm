import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * SWEA: 2001 파리 퇴치
 * 
 */
public class Solution_2001_이지은 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t = 1;t<=T;t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int [][] map = new int[N][N];
			for(int i= 0; i<N;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<N;j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			int max = 0;
			for(int i=0;i<N-M+1;i++) {
				for(int j=0;j<N-M+1;j++) {
					int sum = 0;
					for(int k=0;k<M;k++) {
						for(int l=0;l<M;l++) {
							sum += map[i+k][j+l];
						}
					}
					if(max<sum) {
						max = sum;
					}
					
				}
			}
			System.out.println("#"+t+" "+max);
			
		}
	}

}
