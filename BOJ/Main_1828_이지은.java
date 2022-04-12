import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//정올 1828 냉장고
public class Main_1828_이지은 {

	public static void main(String[] args) throws IOException  {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int [][] minmax = new int[N][2];
		
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			minmax[i][0] = Integer.parseInt(st.nextToken()); // 최소
			minmax[i][1] = Integer.parseInt(st.nextToken()); // 최대 
		}
		

		Arrays.sort(minmax,(o1,o2)->{
			if(o1[1] == o2[1]){ 
				return Integer.compare(o1[0],o2[0]); 
			}else{ 
				return Integer.compare(o1[1],o2[1]); 
			}
		});

		int max = minmax[0][1];
		int r =1;
//		System.out.println(Arrays.deepToString(minmax));
		for(int i=1;i<N;i++) {
			if(minmax[i][0]>max) {
				r++;
				max = minmax[i][1];
			}
		}
		System.out.println(r);
	}

}
