import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 오르막수 {
	public int N;
	public long D[][];
	public int mod;
	
	public static void main(String[] args) {
		오르막수 a = new 오르막수();
		a.mod = 10007;
		long ans = 0;
		
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			a.N = Integer.parseInt(br.readLine());
			
			a.D = new long[a.N+1][10];
			
			for(int i=0 ; i<10 ; i++) {
				//if(i == 0) a.D[1][i] = 0;
				//else 
					a.D[1][i] = 1;
			}
			
			for(int i=2 ; i<=a.N ; i++) {
				for(int j=0 ; j<10 ; j++) {
					for(int k=0 ; k<=j ; k++) {
						a.D[i][j] = (a.D[i][j]%a.mod + a.D[i-1][k]%a.mod)%a.mod; 
					}
				}
			}
			
			for(int i=0 ; i<10 ; i++) {
				ans = (ans%a.mod + a.D[a.N][i]%a.mod)%a.mod;
			}
			
			System.out.println(ans);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
