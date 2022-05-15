import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//이항계수 구하기
//페르마 소정리
public class Solution_3238_이지은 {
	static long N,R,P,answer;
//	static int N,R,P,answer;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int TC = 1; TC <= T; TC++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Long.parseLong(st.nextToken());
			R = Long.parseLong(st.nextToken());
			P = Long.parseLong(st.nextToken());
//			int N = Integer.parseInt(st.nextToken());
//			R = Integer.parseInt(st.nextToken());
//			P = Integer.parseInt(st.nextToken());
			answer=1;
			long smallR=1;
//			int index=2147483645;
			int n = (int) (N%P);
			int r = (int) (R%P);
			int n_r = (int) ((N-R)%P);
//			int index = (int) (N+1);
			long fact[] = new long[n];
			fact[0]=1;
			for (int i = 1; i <=N ; i++) {
				fact[i]=(i*fact[i-1])%P;
//				answer = (answer*i) %P;
			}
			
			smallR = (long) Math.pow(fact[(int) (N-R)], P-2);
			smallR *= (long) Math.pow(fact[(int) (R)], P-2);
//			//answer %= P;
//			for (int i = 1; i <= R; i++) {
//				smallR = (smallR*i)%P;
//			}
//			for (int i = 1; i <=(N-R); i++) {
//				smallR = (smallR*i)%P;
//			}
//			smallR =  (long) Math.pow(smallR, P-2);
			
			answer = (fact[(int) N]%P) * (smallR %P);
//			answer = (int) ((fact[(int) N]%P) * (smallR %P));
			
			System.out.println("#" + TC + " "+answer);
		}

	}

}
