import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 초콜릿자르기 {
	public int N;
	public int M;
	
	public static void main(String[] args) {
		초콜릿자르기 a = new 초콜릿자르기();
		
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			a.N = Integer.parseInt(st.nextToken());
			a.M = Integer.parseInt(st.nextToken());
			
			int k = a.N - 1;
			
			int ans = a.N * a.M - 1;
			System.out.println(ans);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
}
