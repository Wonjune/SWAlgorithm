import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 타일채우기 {

	public long D[];
	public int N;
	
	public static void main(String[] args) {
		타일채우기 a = new 타일채우기();
		
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			a.N = Integer.parseInt(br.readLine());
			
			a.D = new long[a.N+1];
			
			if(a.N == 0) System.out.println(0);
			else if(a.N%2 == 1) System.out.println(0);
			else {
				a.D[0] = 1;
				a.D[2] = 3;
				for(int i=4 ; i<=a.N ; i=i+2) {
					a.D[i] += a.D[i-2]*3;
					for(int j=4 ; j<=i ; j=j+2) {
						a.D[i] += a.D[i-j]*2;
					}
				}
				
				System.out.println(a.D[a.N]);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
