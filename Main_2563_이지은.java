import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2563_이지은 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int newX=0,newY=0,sum=0;
		boolean [][] map = new boolean[101][101]; 
		for(int i = 0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			newX = Integer.parseInt(st.nextToken());
			newY = Integer.parseInt(st.nextToken());
			
			for(int j=newX;j<newX+10;j++) {
				for(int k=newY;k<newY+10;k++) {
					if(map[j][k]==false) {
						map[j][k]=true;
					}
				}
			}
		}
		
		for(int i=1;i<101;i++) {
			for(int j=1;j<101;j++) {
				if(map[i][j]==true) sum++;
			}
		}
		
		System.out.println(sum);
	}
}
