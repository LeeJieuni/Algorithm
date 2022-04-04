import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_3307_이지은 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int TC = 1; TC <= T; TC++) {
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			int[] list = new int[N + 1];
			for (int i = 1; i <= N; i++) {
				list[i] = Integer.parseInt(st.nextToken());
			}
			int[] LIS = new int[N + 1];
			for (int i = 1; i <= N; i++) {
				LIS[i] = 1;
				for (int j = 1; j <=(i-1) ; j++) {
					if(list[j]<list[i] && LIS[i]<1+LIS[j]) {
						LIS[i] = 1 + LIS[j];
					}
				}
			}
			

			System.out.println("#" + TC + " "+Arrays.stream(LIS).max().getAsInt());
		}
	}

}
