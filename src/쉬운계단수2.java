import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 쉬운계단수2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			int mod = 1000000000;
			int N = Integer.parseInt(br.readLine());
			
			long d[][] = new long[N+1][10];
			
			for(int i=1 ; i<=N ; i++) {
				for(int j=0 ; j<10 ; j++) {
					if(i == 1) { 
						if(j == 0) d[i][j] = 0;
						else d[i][j] = 1;
					}else {
						if(j == 0) d[i][j] = d[i-1][j+1] % mod;
						else if(j == 9) d[i][j] = d[i-1][j-1] % mod;
						else d[i][j] = (d[i-1][j-1] % mod + d[i-1][j+1] % mod) % mod;
					}
				}
			}
			
			long ans = 0;
			for(int i=0 ; i<10 ; i++) {
				ans = (ans + d[N][i] % mod) % mod; 
			}
			
			System.out.println(ans);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
