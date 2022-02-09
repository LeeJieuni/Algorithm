import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Solution_3499_이지은 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder("");
		int T = Integer.parseInt(br.readLine());
		for(int testCase = 1;testCase <=T;testCase++) {
			LinkedList<String> list = new LinkedList<>();
			int N = Integer.parseInt(br.readLine());
			//String []card = br.readLine().split(" ");
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			int half = (int)Math.ceil(N/2.0);
			for(int i=0;i<half;i++) {
				list.add(st.nextToken());
			}
			for(int i= 1;i<N;i+=2) {
				list.add(i,st.nextToken());
			}
			sb.append("#").append(testCase).append(" ");
			for(int i=0;i<N;i++) {
				sb.append(list.get(i)).append(" ");
			}
			sb.append("\n");
			
			
			
		}
		System.out.println(sb.toString());
	}

}
