import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_3040_이지은 {//백설 공주와 일곱 난쟁이

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int [] hat = new int [9];
//		int [] two = new int [2]; // 2개를 골랐을 때 이것을 뺀 나머지 배열의 값의 합이 100인 것을 찾기
		for(int i=0;i<9;i++) {
			hat[i] = Integer.parseInt(br.readLine());
		}
		
		Loop : for(int i=0;i<8;i++) {
			for(int j=i+1;j<9;j++) {

				int sum =0;
				int x = hat[i];
				int y = hat[j];
				hat[i] = 0;
				hat[j] = 0;
				for(int k = 0;k<9;k++) sum += hat[k];
			
				if(sum==100) {
					for(int k = 0;k<9;k++) {
						if(hat[k] != 0 ) {
							System.out.println(hat[k]);
						}
						
					}
					break Loop;
				}else {
					 hat[i] = x;
					 hat[j] = y;
				}
			}
		}

	}

}
/*
 * 
 * chrome 확장 프로그램중 submit_java 
 * 백준이나 swea제출할 때 클래스명알아서 바꿔주고 패키지 자동삭제 해줌
 * 
 * 
 * swea에서 input output 복사해주는 버튼 생기는 애 
 * samsung expert 뭐시기 
 * 
 */
