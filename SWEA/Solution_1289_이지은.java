import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_1289_이지은 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		for(int i=1;i<=n;i++) {
			String s= br.readLine();
			int count = 0;
			int [] sArr = new int[s.length()];
			for(int j=0;j<s.length();j++) {
				sArr[j] = s.charAt(j)-'0';
			}
			for(int j=0;j<s.length();j++) {
				if(sArr[j]==1) {
					for(int k=j;k<s.length();k++) {
						if(sArr[k]==1) { 
							sArr[k]=0;
						}else if(sArr[k]==0) {
							sArr[k]=1;
						}
					}
					count++;
				}
			}
			
			
			System.out.println("#"+i+" "+count);
		}
	}

}
