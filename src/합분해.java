import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 합분해 {
	
	long D[][];
	int N;
	int K;
	
	public static void main(String[] args) {
		
		합분해 a = new 합분해();
		long div = 1000000000;
		
		
		try {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		a.N = Integer.parseInt(st.nextToken());
		a.K = Integer.parseInt(st.nextToken());
		
		a.D = new long[a.K+1][a.N+1];
		
		for(int i=1 ; i<=a.K ; i++) {
			
			for(int j=0 ; j<=a.N ; j++) {
				
				for(int k=0 ; k<=j ; k++ ) {
					if(i==1) a.D[i][j] = 1;
					else {
						a.D[i][j] = (a.D[i][j]%div + a.D[i-1][j-k]%div)%div;
					}
				}
			}
		}
		
		
		System.out.println(a.D[a.K][a.N]);
		
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
