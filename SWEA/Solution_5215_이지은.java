import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_5215_이지은 {
	static int N,L, tk[][], max;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int t = 1;t<=T;t++) {
			max=0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());

			tk = new int[N][2];
			for(int n=0;n<N;n++) {
				st = new StringTokenizer(br.readLine());
				tk[n][0] = Integer.parseInt(st.nextToken());
				tk[n][1] = Integer.parseInt(st.nextToken());
			}
			//Arrays.sort(tk, Comparator.comparingInt(o1->o1[0])); //첫번째 인자를 기준으로 오름차순 정렬
			combination(0,0,0);
			System.out.println("#"+t+" "+max);
		}
		
		
	}
	public static void combination(int start, int tasteSum,int cal) {
		if(cal>L) {
			return;
		}
		if(cal<L) {
			if(max<tasteSum) {
				max = tasteSum;
			}
		}
		
		if(start == N) {
			return;
		}
		
		combination(start+1,tasteSum+tk[start][0],cal+tk[start][1]);
		combination(start+1,tasteSum,cal);
		
	}

}
