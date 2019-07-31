import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 퇴사 {
	public long[] D;
	public int[] T;
	public int[] P;
	public int N;
	
	public static void main(String[] args) {
		퇴사 a = new 퇴사();
		
		try {
//			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(new File("C://sample_input_퇴사.txt"))));
			StringTokenizer st;
			
			a.N = Integer.parseInt(br.readLine());
			
			a.T = new int[a.N+1];
			a.P = new int[a.N+1];
			a.D = new long[a.N+1];
			
			for(int i = 1 ; i <= a.N ; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				a.T[i] = Integer.parseInt(st.nextToken());
				a.P[i] = Integer.parseInt(st.nextToken());
			}
			
			for(int i=1 ; i<=a.N ; i++) {
				a.D[i] = a.D[i-1];
				for(int j=1 ; j<=i ; j++) {
					if(a.T[i-j] == j+1) {
						a.D[i] = Math.max(a.P[i-j]+a.D[i-j], a.D[i]);
					}
				}
			}
			
			System.out.println(a.D[a.N]);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
