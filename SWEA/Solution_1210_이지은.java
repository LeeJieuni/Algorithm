import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_1210_이지은 {
	static int x,y;
	static String [][]map;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder("");
		for(int testCase = 1;testCase<=10;testCase++) {
			br.readLine(); // 테스트 케이스 입력된 것 생략
			map = new String[100][100]; // String 형임
			for(int i=0;i<100;i++) {
				map[i] = br.readLine().split(" ");
			}

			y=0;
			for(int j=0;j<100;j++) {
				if(map[99][j].equals("2")){
					y = j;
				}
			}
			for(int i=98;i>=0;i--) { //그 다음꺼로 해도 되나? 99아니고?
				for(int j=0;j<100;j++) {
					if(j==y){
						if((j-1)>0 && map[i][j-1].equals("1")) {
							//왼쪽으로
							x = i;
							next(-1);
							break;
							
						}else if((j+1)<100 && map[i][j+1].equals("1")) {
							//오른쪽으로
							x = i;
							next(1);
							break;
						}else {
							break;
						}
					}
				}
			}

			System.out.println("#"+testCase+" "+y);
		}
	}
	public static void next(int leftRight) { // x 대신 int i로 받아올까?
		if((y+leftRight)>0 && (y+leftRight)<100) {
			if(map[x][y+leftRight].equals("1")) {
				y += leftRight;
				next(leftRight);
			}
		}else {
			return;
		}
	}
}
