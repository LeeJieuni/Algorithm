import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//RGB거리
public class Main_1149_이지은 {

	public static void main(String[] args) throws NumberFormatException, IOException  {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int RGB[][] = new int[N][3]; // R 0, G 1, B 2

		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			RGB[i][0] = Integer.parseInt(st.nextToken());
			RGB[i][1] = Integer.parseInt(st.nextToken());
			RGB[i][2] = Integer.parseInt(st.nextToken());
		}

		for (int i = 1; i < N; i++) {
			RGB[i][0] += Math.min(RGB[i-1][1],RGB[i-1][2]);
			RGB[i][1] += Math.min(RGB[i-1][0],RGB[i-1][2]);
			RGB[i][2] += Math.min(RGB[i-1][1],RGB[i-1][0]);
		}
		
		System.out.println(Math.min(Math.min(RGB[N-1][0],RGB[N-1][1]),RGB[N-1][2]));
	}

}
