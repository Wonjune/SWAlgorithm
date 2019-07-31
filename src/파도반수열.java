import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 파도반수열 {
	public int N;
	public int T;
	public long[] D;
	public long[] ans;
	
	public static void main(String[] args) {
		파도반수열 a = new 파도반수열();
		
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			a.T = Integer.parseInt(br.readLine());
			a.ans = new long[a.T];
			
			for(int i=0 ; i<a.T ; i++) {
				a.N = Integer.parseInt(br.readLine());
				
				if(a.N > 5)
					a.D = new long[a.N + 1];
				else
					a.D = new long[6];
				
				a.D[1] = a.D[2] = a.D[3] = 1;
				a.D[4] = a.D[5] =  2;
				
				if(a.N > 5) {
					for(int j=6 ; j<=a.N ; j++) {
						a.D[j] = a.D[j-1] + a.D[j-5];
					}
				}
				
				a.ans[i] = a.D[a.N];
			}
			
			for(int i=0 ; i<a.T ;i++) {
				System.out.println(a.ans[i]);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
