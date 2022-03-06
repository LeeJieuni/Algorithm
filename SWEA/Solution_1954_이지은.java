import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_1954_이지은 {

	static int[][] deltas= {{0,1},{1,0},{0,-1},{-1,0}};
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1;t<=T;t++) {
			int n = Integer.parseInt(br.readLine());
			int [][]map = new int[n][n];
			System.out.println("#"+t);
			
			int x=0;
			int y=n-1;
			int index=1;
			int num=1; // 넣어줄 숫자
			for(int j=0;j<n;j++) {
				map[0][j]= num++;
			}
			
			for(int i=n-1;i>0;i--) {
				for(int k=0;k<2;k++) {
					for(int j=0;j<i;j++) {
						x += deltas[index][0];
						y += deltas[index][1];
						
						map[x][y] = num++;
					}
					if(index==3)index=0;
					else index++;
				}
				
			}
			
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					System.out.print(map[i][j]+" ");
				}
				System.out.println();
			}
			
		}
	}	
}


