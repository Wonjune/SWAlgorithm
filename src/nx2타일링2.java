import java.io.BufferedReader;
import java.io.InputStreamReader;

public class nx2타일링2 {
	public int N;
	public long[] D;
	
	public static void main(String[] args) {
		nx2타일링2 a = new nx2타일링2();
		
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			a.N  = Integer.parseInt(br.readLine());
			
			a.D = new long[a.N+1];
			a.D[0] = 1;
			a.D[1] = 1;
			
			for(int i = 2 ; i <= a.N ; i++) {
				a.D[i] = (a.D[i-2] * 2 + a.D[i-1])%10007;
			}
			
			System.out.println(a.D[a.N]%10007);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
