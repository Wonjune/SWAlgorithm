import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 제곱수의합 {
	public long D[];
	public int N;
	
	public static void main(String[] args) {
		제곱수의합 a = new 제곱수의합();
		
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			a.N = Integer.parseInt(br.readLine());
			
			a.D = new long[a.N+1];
			
			for(int i=1 ; i<=a.N ; i++) {
				for(int j=1 ; j<=i ; j++) {
					int power = (int) Math.pow(j, 2);
					if(power > i) break;
					if(a.D[i] == 0) { 
						a.D[i] = i;
					}else {
						a.D[i] = Math.min(a.D[i], a.D[i-power]+1);
					}
				}
			}
			
			System.out.println(a.D[a.N]);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
