import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution_1218_이지은 {
	static Stack<String> stack;
	static boolean yes;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int t= 1;t<=10;t++) {
			yes = true;
			int L = Integer.parseInt(br.readLine());
			String s = br.readLine();
			stack = new Stack<String>();
			for(int i=0;i<L;i++) {
				String inputS = String.valueOf(s.charAt(i));
				if(isLeft(inputS)) {
					stack.push(inputS);	
				}else{
					isIn(inputS);
				}
			}
			
			System.out.print("#"+t+" ");
			if(stack.isEmpty() && yes) {
				System.out.print(1+"\n");
			}else {
				System.out.print(0+"\n");
			}
			
		}
		
	}
	//괄호의 왼쪽 문자면 스택에 넣을 수 있도록
	public static boolean isLeft(String s) {
		if(s.equals("(") || s.equals("[") || s.equals("{")||s.equals("<")){     
			return true;
		}
		return false;
	}
	public static void isIn(String s) {

		if(s.equals("}") && stack.peek().equals("{")){
			stack.pop();
		}else if(s.equals(")") && stack.peek().equals("(")) {
			stack.pop();
		}else if(s.equals("]") && stack.peek().equals("[")) {
			stack.pop();
		}else if(s.equals(">") && stack.peek().equals("<")) {
			stack.pop();
		}else {
			yes = false;
		}
		
	}
}
