import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;


public class Main_2309_이지은 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int [] height = new int[9];
//		LinkedList<Integer> height = new LinkedList<>();
		for(int i=0;i<9;i++) {
			height[i] = Integer.parseInt(br.readLine());
//			height.add(Integer.parseInt(br.readLine()));
		}
		Arrays.sort(height);
//		Collections.sort(height);
		
		Loop : for(int i=0;i<8;i++) {
			for(int j=i+1;j<9;j++) {
//				int y = height.remove(j);
//				int x = height.remove(i);
				int sum =0;
				int x = height[i];
				int y = height[j];
				height[i] = 0;
				height[j] = 0;
				for(int k = 0;k<9;k++) sum += height[k];
//				for(int k = 0;k<7;k++) {
//					sum += height.get(k);
//				}
			
				if(sum==100) {
					for(int k = 0;k<9;k++) {
						if(height[k] != 0 ) {
//							System.out.println(height.get(k));
							System.out.println(height[k]);
						}
						
					}
					break Loop;
				}else {
					 height[i] = x;
					 height[j] = y;
//					height.add(i,x);
//					height.add(j,y);
				}
			}
		}
		
		
	}

	

}
