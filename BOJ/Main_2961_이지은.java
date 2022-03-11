import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class Main_2961_이지은 { // 도영이가 만든 맛있는 음식
	static int sour[],bitter[];
	static boolean visited[];
	static int numbers[];
	static int N, result;
	static void subset(int depth) {
		if(depth==N) {
			int s=1;
			int b=0;
			for(int i=0;i<N;i++) {
				if(visited[i]) {
					s *= sour[i];
					b += bitter[i];
				}
			}
			if(s!=1 && b!=0) {
				if(result>Math.abs(s-b)) {
					result = Math.abs(s-b);
				}
			}
			return;
		}
		visited[depth]=true;
		subset(depth+1);
		visited[depth]=false;
		subset(depth+1);
		
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		sour = new int[N];
		bitter = new int [N];
		visited = new boolean[N];
		result = Integer.MAX_VALUE;
		
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			sour[i] = Integer.parseInt(st.nextToken());
			bitter[i]=Integer.parseInt(st.nextToken());
		}
		
		subset(0);
		
		System.out.println(result);
		
		
	}

}
