import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_1225_이지은 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder("");
		for(int tc = 1;tc<=10;tc++) {
			int n = Integer.parseInt(br.readLine());
			Queue<Integer> queue = new LinkedList<Integer>();
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=0;i<8;i++) {
				queue.offer(Integer.parseInt(st.nextToken()));
			}
			
			Loop: while(true) {
				int a;
				for(int i=1;i<=5;i++) {
					a = queue.poll();
					if(a-i<=0) {
						queue.offer(0);
						break Loop;
					}
					queue.offer(a-i);
				}
			}
			
			
			sb.append("#"+ n+" ");
			
			for(int i=0;i<8;i++) {
				sb.append(queue.poll()+" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
		
	}

}
