import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1074_이지은 { // Z
	static int N,r,c;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N= Integer.parseInt(st.nextToken());
		r= Integer.parseInt(st.nextToken());
		c= Integer.parseInt(st.nextToken());
		int a = (int)Math.pow(2, N);
		int front = 0;

		
		while(true) { //점점 2로 나눠가고 r,c값도 그에 맞춰 줄이면서 범위 좁히기 . 
			a = a/2;
			if(a==1) break;
			
			if(r<a && c<a) {
				front += 0;
				
			}else if(r<a && c>=a) {
				front += a*a; 
				c -= a;
			}else if(r>=a && c<a) {
				front += a*a*2;
				r -= a;
			}else if(r>=a && c>=a) {
				front += a*a*3;
				r -= a;
				c -= a;
			}
		}
		//범위가 제일 작아졌을 때. (0,0)~(1,1) 인 경우.차례대로 0,1,2,3 Z처럼 더해주기
		if(r==0 && c==0) {
			front +=0;
		}else if(r==0 &&c==1) {
			front += 1;
		}else if(r==1 &&c==0) {
			front += 2;
		}else if(r==1 &&c==1) {
			front += 3;
		}

		System.out.println(front);
		
	}

}
