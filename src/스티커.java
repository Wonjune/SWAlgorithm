import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 스티커 {
	public int N;
	public long D[][];
	public int T;
	public int A[][];
	public long ans[];
	
	public static void main(String[] args) {
		스티커 a = new 스티커();
		
		StringTokenizer st;
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(new File("C://sample_input_스티커.txt"))));
			//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			a.T = Integer.parseInt(br.readLine());
			a.ans = new long[a.T];
			
			for(int i=0 ; i<a.T ; i++) {
				a.N = Integer.parseInt(br.readLine());
				a.A = new int[2][a.N+1];
				a.D = new long[2][a.N+1];
				
				a.A[0][0] = 0;
				a.A[1][0] = 0;
				a.D[0][0] = 0;
				a.D[1][0] = 0;
				
				
				st = new StringTokenizer(br.readLine(), " ");
				for(int j=1 ; j<=a.N ; j++) {
					a.A[0][j] = Integer.parseInt(st.nextToken());
				}
				
				st = new StringTokenizer(br.readLine(), " ");
				for(int j=1 ; j<=a.N ; j++) {
					a.A[1][j] = Integer.parseInt(st.nextToken());
				}
				
				a.D[0][1] = a.A[0][1];
				a.D[1][1] = a.A[1][1];
				
				
				for(int j=2 ; j<=a.N ; j++) {
//					//윗줄
//					for(int k=1 ; k<j ; k++) {
//						if(k != j-1) a.D[0][j] = Math.max(a.D[0][j], a.D[0][k]);
//						a.D[0][j] = Math.max(a.D[0][j], a.D[1][k]);
//					}
//					a.D[0][j] += a.A[0][j];
//					
//					//아랫줄
//					for(int k=1 ; k<j ; k++) {
//						a.D[1][j] = Math.max(a.D[1][j], a.D[0][k]);
//						if(k != j-1) a.D[1][j] = Math.max(a.D[1][j], a.D[1][k]);
//					}
//					a.D[1][j] += a.A[1][j];
					
					//윗줄
					a.D[0][j] = Math.max(a.D[0][j-2], a.D[1][j-2]);
                    a.D[0][j] = Math.max(a.D[0][j], a.D[1][j-1]);
					a.D[0][j] += a.A[0][j];
					
					//아랫줄
					a.D[1][j] = Math.max(a.D[0][j-2], a.D[1][j-2]);
                    a.D[1][j] = Math.max(a.D[1][j], a.D[0][j-1]);
					a.D[1][j] += a.A[1][j];
				}
				
				
				//최대값 구하기
//				for(int j=1 ; j<=a.N ; j++) {
//					for(int k=0 ; k<2 ; k++) {
//						a.ans[i] = Math.max(a.ans[i], a.D[k][j]);
//					}
//				}
				a.ans[i] = Math.max(a.D[0][a.N], a.D[1][a.N]);
                a.ans[i] = Math.max(a.ans[i], a.D[0][a.N-1]);
                a.ans[i] = Math.max(a.ans[i], a.D[1][a.N-1]);
			}
			
			for(int i=0 ; i<a.T ; i++) {
				System.out.println(a.ans[i]);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
