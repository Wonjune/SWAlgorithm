import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 가장긴증가하는부분수열 {
	public int N;
	public int A[];
	public int D[];
	
	public static void main(String args[]) {
		가장긴증가하는부분수열 a = new 가장긴증가하는부분수열();
		
		try {
			//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(new File("C://sample_input_가장긴증가하는부분수열.txt"))));
			
			a.N = Integer.parseInt(br.readLine());
			
			a.A = new int[a.N];
			a.D = new int[a.N];
			
			StringTokenizer st = new StringTokenizer(br.readLine() , " ");
			
			for(int i = 0 ; i < a.N ; i++) {
				a.A[i] = Integer.parseInt(st.nextToken());
			}
			
			a.D[0] = 1;
			
			for(int i = 1 ; i < a.N ; i++) {
				a.D[i] = 1;
				for(int j = i-1 ; j >= 0 ; j--) {
					if(a.A[j] <= a.A[i]) a.D[i] = Math.max(a.D[i], a.D[j]+1);
				}
			}
			
			int ans = 0;
			for(int i = 0 ; i < a.N ; i++) {
				ans = Math.max(ans, a.D[i]);
			}
			
			System.out.println(ans);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
