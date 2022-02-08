import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
//1. 배열로 받아서 정렬하고 큰거 뽑고 아니면 하나씩 인덱스 낮추는 방법  으로 품
//2. 조합으로 두개 뽑아서 합이 기준을 만족하는 방법도 있을 듯

public class Solution_9229_이지은 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		for(int tc = 1;tc<=TC;tc++) {
		
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken()); // 과자 개수
			int M = Integer.parseInt(st.nextToken()); // 무게 합 제한
			String [] s = br.readLine().split(" ");
			int [] weight = new int[N]; 
			for(int i=0;i<N;i++) {
				weight[i] = Integer.parseInt(s[i]);
			}
			Arrays.sort(weight);

			int max = -1;

			for(int i=N-1;i>0;i--) {
				for(int j=i-1;j>=0;j--) {
					if(weight[i]+weight[j]<=M) {
						if(max< weight[i]+weight[j]) {
							max = weight[i]+weight[j];
						}	
					}else {
						continue;
					}
				}
			}
			System.out.println("#"+tc+" "+max);
			
			
		}
	}

}
