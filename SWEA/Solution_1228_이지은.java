

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Solution_1228_이지은 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringBuilder sb = new StringBuilder("");
		for(int t=1;t<=10;t++) {
			LinkedList<Integer> list = new LinkedList<>();
			int N = Integer.parseInt(br.readLine()); //원본암호문 길이
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0;i<N;i++) {
				list.add(Integer.parseInt(st.nextToken()));
			}
			N = Integer.parseInt(br.readLine()); // 명령어 개수
			st = new StringTokenizer(br.readLine());
			for(int i = 0;i<N;i++) {
				if(st.nextToken().equals("I")) {
					
					int x = Integer.parseInt(st.nextToken()); //x위치 다음
					int y = Integer.parseInt(st.nextToken());
//					System.out.print("x:"+x+" y:"+y+"\n");
					for(int j = 0;j<y;j++) {
						list.add(x,Integer.parseInt(st.nextToken()));
						x++;
					}
				}
				
			}
			System.out.print("#"+t+" ");
			for(int i=0;i<10;i++) {
				System.out.print(list.get(i)+" ");
			}
			System.out.println();	
		}
		
	}

}
