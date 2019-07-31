import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class 일이삼더하기 {
	public int T;
	public int Input[];
	public ArrayList<Integer> D;
	
	public static void main(String[] args) {
		일이삼더하기 a = new 일이삼더하기();
		
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int maxVal = 0;
			
			a.T = Integer.parseInt(br.readLine());
			
			a.Input = new int[a.T];
			
			//입력
			for(int i=0 ; i<a.T ; i++) {
				a.Input[i] = Integer.parseInt(br.readLine());
				if(a.Input[i] > maxVal) maxVal = a.Input[i];
			}
			
			a.D = new ArrayList<Integer>(maxVal+1);
			
			for(int i=0 ; i<=maxVal ; i++) {
				if(i==0) { a.D.add(1);
				}else {
					int tmp = a.D.get(i-1);
					if(i>=2) tmp += a.D.get(i-2);
					if(i>=3) tmp += a.D.get(i-3);
					a.D.add(tmp);
				}
			}
			
			//출력
		    for(int i : a.Input) {
		    	System.out.println(a.D.get(i));
		    }
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
