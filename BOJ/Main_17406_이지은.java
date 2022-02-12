import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_17406_이지은 { // 배열 돌리기 4 ( 삼성 채용기출 중 하나였음. 16년도 이전에 나왔던 방식 중하나. a형??기출
	static int N,M,K,f;
	static boolean[] isSelected;
	static int  numbers[],idx[],map[][],r[],c[],s[],after[][],result[],middle[][];
	
	public static void permutation(int cnt) {
		if(cnt==K) {
			rotate(numbers);
			f++;
			return;
		}
		
		for(int i=0;i<K;i++) {
			if(!isSelected[i]) {
				numbers[cnt] = idx[i];
				isSelected[i] = true;
				permutation(cnt+1);
				isSelected[i] = false;
			}
		}
	}
	
	public static void rotate(int [] numbers) {
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				after[i][j]=0;
				middle[i][j] = map[i][j]; 
			}
		}
		for(int d=0;d<K;d++) {
			int x = r[numbers[d]]-1; // (r-s,c-s)  (r,c)  (
			int y = c[numbers[d]]-1;
			int ss = s[numbers[d]];
			int count = 1;
			while(true) {
				if(count > ss) { // 여기 문제
					break;
				}
				after[x][y]=middle[x][y];
				for(int i=y-count;i<y+count;i++) {//+1 ? 
					after[x-count][i+1] = middle[x-count][i];//위
					after[x+count][i] = middle[x+count][i+1];//아래
				}
				for(int i=x-count;i<x+count;i++) {
					after[i][y-count] = middle[i+1][y-count];//왼쪽
					after[i+1][y+count] = middle[i][y+count];//오른쪽
				}
				count++;
			}

			for(int i=x-ss;i<=x+ss;i++) {
				for(int j=y-ss;j<=y+ss;j++) {
					middle[i][j] = after[i][j];
				}
			}
		}

		int min =0;
		for(int i =0;i<N;i++) {
			int sum = 0;
			for(int j=0;j<M;j++) {
				sum += middle[i][j];
			}
			if(i==0) {
				min = sum;
			}
			if(sum<min) {
				min = sum;
			}
		}
		result[f]=min;
	}
	

	public static int fact(int n) {
		if(n<=1) return n;
		else return fact(n-1)*n;

	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new int [N][M];
		middle = new int [N][M];
		after= new int [N][M];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		f=0;
		r = new int[K];
		c = new int[K];
		s = new int[K];
		isSelected = new boolean[K];
		numbers = new int[K];
		idx = new int[K]; //순열 위한 인덱스를 저장한 배열
		result = new int[fact(K)]; // k!
		for(int i=0;i<K;i++) {
			st = new StringTokenizer(br.readLine());
			r[i] =  Integer.parseInt(st.nextToken());
			c[i] =  Integer.parseInt(st.nextToken());
			s[i] =  Integer.parseInt(st.nextToken());
			idx[i] = i;
		}
		permutation(0);
		System.out.println(Arrays.stream(result).min().getAsInt());
		
	}

}
