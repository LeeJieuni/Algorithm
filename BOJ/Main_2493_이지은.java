import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_2493_이지은 {
//	static int N,k;
//	static int [] tower;
//	static int [] r;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		
		Stack<int[]> stack = new Stack<>(); // {인덱스, 높이}
//		tower = new int[N]; 
//		r = new int[N];
		//String s = br.readLine();
		//tower = Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt).toArray();
		String [] str = br.readLine().split(" ");
		for(int i=0;i<N;i++) { // 
//			tower[i] = Integer.parseInt(str[i]);
			int height = Integer.parseInt(str[i]);
		//	while(true)
			if(stack.isEmpty()) {
				sb.append("0 ");
				stack.push(new int[] {i+1,height});
			}else {
				while(true) {
					if(stack.isEmpty()) {
						sb.append("0 ");
						stack.push(new int[] {i+1,height});
						break;
					}
					if(height<=stack.peek()[1]) {
						sb.append(stack.peek()[0]+" ");
						stack.push(new int[] {i+1,height});
						break;
					}else {
						stack.pop();
					}
					
				}
			}
		}
		
//		for(k=N-1;k>0;k--) {
//			next(k);
//		}
//		for(int i=0;i<N;i++) {
//			sb.append(r[i]+" ");
//			//System.out.print(r[i]+" ");
//		}
		System.out.println(sb.toString());
		br.close();
		
	}
//	static void next(int i) {
//		if((i-1)>=0) {
//			if(tower[k]<=tower[i-1]) {
//				r[k] = i;//tower[i-1];
//			}else {
//				next(i-1);
//			}
//		}else {
//			r[k] = 0;
//		}
//	}
}
