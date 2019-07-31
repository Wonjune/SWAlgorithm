import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class 계단오르기 {
	public int N;
	public ArrayList<Integer> S;
	public ArrayList<Integer> D;
	
	public static void main(String[] args) {
		계단오르기 a = new 계단오르기();
		
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			a.N = Integer.parseInt(br.readLine());
			a.S = new ArrayList<Integer>(a.N+1);
			a.D = new ArrayList<Integer>(a.N+1);
			int c1 = 0;
			int c2 = 0;
			
			//입력
			for(int i=0 ; i<=a.N ; i++) {
				if(i==0) a.S.add(0);
				else a.S.add(Integer.parseInt(br.readLine()));
			}
			
			for(int i=0 ; i<=a.N ; i++) {
				if(i==0) a.D.add(0);
				else if(i==1) {
					a.D.add(a.S.get(i));
				}
				else if(i==2) {
					c1 = a.D.get(i-1) + a.S.get(i);
					c2 = a.D.get(i-2) + a.S.get(i);
					if(c1 > c2) {
						a.D.add(c1);
					}else {
						a.D.add(c2);
					}
				}else {
					c1 = a.D.get(i-3) + a.S.get(i-1) + a.S.get(i);
					c2 = a.D.get(i-2) + a.S.get(i);
					
					if(c1 > c2) {
						a.D.add(c1);
					}else {
						a.D.add(c2);
					}
				}
			}
			
			//출력
			System.out.println(a.D.get(a.N));
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
