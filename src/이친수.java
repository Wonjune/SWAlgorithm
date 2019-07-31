import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class 이친수 {
	public int N;
	public ArrayList<Long[]> D;
	
	public static void main(String[] args) {
		이친수 a = new 이친수();
		
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			a.N = Integer.parseInt(br.readLine());
			Long[] arr;
			a.D = new ArrayList<Long[]>();
			
			for(int i=0 ; i<=a.N ; i++) {
				arr = new Long[2];
				
				if(i==0) {
					arr[0] = (long)0;
					arr[1] = (long)0;
				}else if(i==1) {
					arr[0] = (long)0;
					arr[1] = (long)1;
				}else {
					arr[0] = a.D.get(i-1)[0] + a.D.get(i-1)[1];
					arr[1] = a.D.get(i-1)[0];
				}
			
				a.D.add(arr);
			}
			
			System.out.println(a.D.get(a.N)[0] + a.D.get(a.N)[1]);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
