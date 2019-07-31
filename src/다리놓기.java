import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 다리놓기 {
	public int T;
	public int N;
	public int M;
	public long[][] D;
	public long[] ans;
	
	public static void main(String[] args) {
		다리놓기 a = new 다리놓기();
		
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer st;
			
			a.T = Integer.parseInt(br.readLine());
			a.ans = new long[a.T];
			
			for(int i=0 ; i<a.T ; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				
				a.N = Integer.parseInt(st.nextToken());
				a.M = Integer.parseInt(st.nextToken());
				
				//N의 첫번째 라인에서 출발하는 다리가 정해지면 N의 두번째 이하 다리들의 조합의 경우의 수가 정해짐. 따라서...
				//D[N][M] = D[N-1][M-1] + D[N-1][M-2] + ... + D[N-1][1]
				//단, N == M  이면 1이고, N > M 이면 0
				
				a.D = new long[a.N+1][a.M+1];
				   
				a.D[a.N][a.M] = a.foo( a.N, a.M);
				
				a.ans[i] = a.D[a.N][a.M];
			}
			
			for(int i=0 ; i<a.T ; i++) {
				System.out.println(a.ans[i]);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public long foo(int n, int m) {
		if(n == 1) return m;
		if(n == m) return 1;
		if(n > m) return 0;
		if(D[n][m] > 0) return D[n][m];
		long ans = 0;
		for(int i=m-1 ; i>=1 ; i--) {
			ans += foo(n-1, i);
		}
		D[n][m] = ans;
		return D[n][m];
	}
}
