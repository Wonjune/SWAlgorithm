import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class nx2타일링 {
	public ArrayList<Long> D;
	public int N;
	
	public static void main(String[] args) {
		nx2타일링 a = new nx2타일링();
		
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			a.N = Integer.parseInt(br.readLine());
			
			a.D = new ArrayList<Long>();

			for(int i=0 ; i<=a.N ; i++) {
				
				if(i == 0 || i == 1) {
					a.D.add((long) 1);
				}else {
					a.D.add(a.D.get(i-1) + a.D.get(i-2));
				}
			}
			
			System.out.println(a.D.get(a.N)%10007);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
