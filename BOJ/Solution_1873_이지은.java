import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1873_이지은 {
	static int [][] deltas = {{-1,0},{0,1},{1,0},{0,-1}};
	static String [][] map;
	static String [] move;
	static boolean shoot;
	static int newI;
	static int newJ;
	static int a,w,h;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t=1;t<=T;t++) {
			System.out.print("#"+t+" ");
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			h = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			map = new String[h][w];  // map은 String 임을 유의 
			for(int i=0;i<h;i++) {
				String s = br.readLine();
				for(int j=0;j<w;j++) {
					map[i][j] = Character.toString(s.charAt(j));
				}
			}
			int n = Integer.parseInt(br.readLine());
			String moveS = br.readLine();
			move = new String[n];
			for(int i=0;i<n;i++) {
				move[i] = Character.toString(moveS.charAt(i));
			}
			///입력받고 넣기 끝 
			
			int a, b;
			Loop: for(int i=0;i<h;i++) {
				for(int j=0;j<w;j++) {
					if(map[i][j].equals("^") || map[i][j].equals("v") ||map[i][j].equals("<")||map[i][j].equals(">")) {
						moveMethod(i,j);
						break Loop;
//						a = i;
//						b = j;
					}
				}
			}
//			moveMethod(a,b);
			//System.out.println("------------------------------------");
			for(int i=0;i<h;i++) {
				for(int j=0;j<w;j++) {
					System.out.print(map[i][j]);
				}
				System.out.println();
			}
		
		}
	}
	static void moveMethod(int i,int j) {
		for(String c : move) {
//			System.out.println("<"+c+" "+ i+" "+j + " - "+newI+" "+newJ +">");
			what(c,i,j); // 이동한 새로운 좌표의 값 

			if(shoot==false) {
				if(newI>=0 && newI<h && newJ>=0 && newJ<w) {
					if(map[newI][newJ].equals(".")) {
						map[newI][newJ]=map[i][j];
						map[i][j] = ".";
						
						i=newI;
						j=newJ;
//						System.out.println("평지로 이동");
						//continue; // ? 
					}else if(map[newI][newJ].equals("#")||map[newI][newJ].equals("*")||map[newI][newJ].equals("-")) {
						//갈 수 없어 // 아무것도 안해..?
//						System.out.println("갈 수 없어");
						continue;
					}
				
				}
			}else { // shoot이 true 일 때 
				shoot = false; // shoot 초기화
				while(true) {
					if(newI>=0 && newI<h && newJ>=0 && newJ<w) {
						if(map[newI][newJ].equals("#")) {
//							System.out.println("강철 벽 포탄이 뚫지 못해");
							break;
						}else if(map[newI][newJ].equals("*")) {
							map[newI][newJ]=".";
//							System.out.println("벽돌 벽 파괴되어 평지");
							break;
						}else {
//							System.out.println("지나가요 "+newI+" "+newJ);
							newI += deltas[a][0];
							newJ += deltas[a][1];
							continue;
						}
					}else {
//						System.out.println("밖으로");
						break;
					}
					
				}
				
			}
//			for(int a = 0;a<h;a++) {
//				for(int b=0;b<w;b++) {
//					System.out.print(map[a][b]);
//				}
//				System.out.println();
//			}
//			System.out.println();
		}
		
	}
	
	static void what(String c,int i ,int j) {
		//a 초기화 안해도 되나?
		if(c.equals("U")) {// || map[i][j].equals("^")){
			a=0;
			map[i][j]="^";
			
		}else if(c.equals("R")) {//||map[i][j].equals(">")) {
			a=1;
			map[i][j]=">";
			
		}else if(c.equals("D") ) {//|| map[i][j].equals("v")) {
			a=2;
			map[i][j]="v";
		}else if(c.equals("L")) {//|| map[i][j].equals("<")) {
			a=3;
			map[i][j]="<";
		}else if(c.equals("S")) {
			shoot = true;
			if(map[i][j].equals("^")) {
				a=0;
			}else if(map[i][j].equals(">")) {
				a=1;
			}else if(map[i][j].equals("v")) {
				a=2;
			}else if(map[i][j].equals("<")) {
				a=3;
			}
			//what(map[i][j],i,j);
			
		}
		newI = i + deltas[a][0];
		newJ = j + deltas[a][1];
		
	}

}


/*
 UUUUSUSLRRDLSDRSSSLSLRSLSDUDUUDDSUDDLSSRLSRSRSRULUDLSLSDDSSDDUDLLSDUSUSLSUSSSURDDSS 
  
 
 --.**..-......*-..
..--.-..*v.*.....#
#...*....**.#**..*
*......-..-##..*#.
*....*-..#...*....
-......*.*........
-..*.-.*.*..##....
*-....---.#.*-...-
#.*.....*........*
..-.*.....*...-...
-*#..*.....*...-.#
#-**...*.....-#-..
.....#*...##.#....
-.-..-*.*.*.-*.*.#
*..*.*.*.**#..*..-
#..*-*.**....*....
 */
