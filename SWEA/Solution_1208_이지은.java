import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.OptionalInt;
import java.util.StringTokenizer;

public class Solution_1208_이지은 {
	static int diff;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int t=1;t<=10;t++) {
			int dumpNum = Integer.parseInt(br.readLine());
			int [] box = new int[100];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=0;i<100;i++) {
				box[i] = Integer.parseInt(st.nextToken());
			}
			//--입력 끝
			Arrays.sort(box);
			
			for(int i=0;i<dumpNum;i++) {
				
				box[0]++;
				box[99]--;
				Arrays.sort(box);
				diff = Arrays.stream(box).max().getAsInt()-Arrays.stream(box).min().getAsInt();
				if(diff== 0|| diff==1) {
					break;
				}
				
			}
			
			System.out.println("#"+t+" "+diff);
			
		}
	}

}
