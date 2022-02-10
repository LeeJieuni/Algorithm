import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1233_이지은 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder("");
		
		for(int testCase=1;testCase<=10;testCase++) {
			
			sb.append("#").append(testCase).append(" ");
			int N = Integer.parseInt(br.readLine());
			int result = 1;
			for(int i=0;i<N;i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				st.nextToken();
				
				char second = st.nextToken().charAt(0);
				// 입력이 4개 들어올 때 2번째 꺼가 기호가 아니거나 = 숫자이거나
				if(st.hasMoreTokens()) {
					if(second>=48 && second <=57) {
						result = 0;
						//break; 있으면 다른 줄 제대로 못읽어서
					}
				}else{//입력이 2개 들어올 때  2번째 꺼가 숫자가 아니면 = 기호이면 유효성 0 
					if(second<48 || second>57) {
						result = 0;
					}
				}
			}
			sb.append(result).append("\n");
		}
		System.out.println(sb.toString());
	}

}
