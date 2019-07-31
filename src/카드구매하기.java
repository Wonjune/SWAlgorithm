import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 카드구매하기 {
	public long[] D;
	public int N;
	public ArrayList<Integer> A;
	
	public static void main(String[] args) {
		
		카드구매하기 a = new 카드구매하기();
		
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			a.N = Integer.parseInt(br.readLine());
			a.A = new ArrayList<Integer>(a.N+1);
			a.D = new long[a.N+1];
			
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int i = 0 ; i <= a.N ; i++) {
				if(i==0) a.A.add(0);
				else a.A.add(Integer.parseInt(st.nextToken()));
			}
			
			for(int i = 1 ; i <= a.N ; i++) {
				if(i == 1) a.D[i] = a.A.get(i);
				else {
					for(int j = i ; j >= 1 ; j--) {
						a.D[i] = Math.max(a.D[i], a.D[i-j] + a.A.get(j));
					}
				}
			}
			
			System.out.println(a.D[a.N]);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
