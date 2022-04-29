import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1158_이지은 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder("");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		Queue<Integer> queue = new LinkedList<>();
		sb.append("<");
		for(int i = 0; i<N;i++) {
			queue.offer(i+1);
		}
		while(!queue.isEmpty()) {
			for(int j=0;j<K;j++) {
				if(j == (K-1)) {
					sb.append(queue.poll()).append(", ");
				}else {
					queue.offer(queue.poll());
				}
			}
		}
		sb.setLength(sb.length()-2);
		sb.append(">");
		System.out.println(sb.toString());

	}

}
