import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class 일로만들기 {
	public int N;
	public ArrayList<Integer> D;
	
	public static void main(String[] args) {
		일로만들기 a = new 일로만들기();
		
		try {
			//BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(new File("sample_input_일로만들기.txt"))));
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			a.N = Integer.parseInt(br.readLine());
			
			a.D = new ArrayList<Integer>(a.N+1);
			
			//초기화
			for(int i =0 ; i <= a.N ; i++) {
				if(i == 0 || i == 1) {
					a.D.add(0);
				}else {
					a.D.add(Integer.MAX_VALUE);
				}
			}
			
			for(int i=2 ; i<=a.N ; i++) {
				a.D.set(i, a.D.get(i-1)+1);
				if(i%2 == 0) a.D.set(i, Math.min(a.D.get(i), a.D.get(i/2)+1));
				if(i%3 == 0) a.D.set(i, Math.min(a.D.get(i), a.D.get(i/3)+1));
			}
			
			System.out.println(a.D.get(a.N));
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
