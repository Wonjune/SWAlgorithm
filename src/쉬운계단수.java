import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 쉬운계단수 {
	public int N;
	public long[][] D;
	
	public static void main(String[] args) {
		쉬운계단수 a = new 쉬운계단수();
		long result = 0;
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			a.N = Integer.parseInt(br.readLine());
			
			a.D = new long[a.N+1][10];
			
			for(int i = 1 ; i < 10 ; i++) {
				a.D[1][i] = 1;
			}
			
			for(int i = 2 ; i <= a.N ; i++) {
				for(int j = 0 ; j < 10 ; j++) {
					if(j==0) a.D[i][j] = a.D[i-1][j+1]%1000000000;
					else if(j==9) a.D[i][j] = a.D[i-1][j-1]%1000000000;
					else a.D[i][j] = (a.D[i-1][j-1]%1000000000 + a.D[i-1][j+1]%1000000000)%1000000000;
				}
			}
			
			for(int i = 0 ; i < 10 ; i++) {
				result = (result + a.D[a.N][i]%1000000000)%1000000000;
			}
			
			System.out.println(result);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
