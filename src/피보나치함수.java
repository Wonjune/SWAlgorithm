import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class 피보나치함수 {
	public ArrayList<Integer[]> D;
	public ArrayList<Integer> I;
	public int T;
	
	public static void main(String[] args) {
		
		피보나치함수 a = new 피보나치함수();
		
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			a.T = Integer.parseInt(br.readLine());
			a.I = new ArrayList<Integer>(a.T+1);
			int maxVal = 0;
			//입력
			for(int i=0 ; i<a.T ; i++) {
				a.I.add(Integer.parseInt(br.readLine()));
				if(a.I.get(i) > maxVal) maxVal = a.I.get(i);
			}
			
			a.D = new ArrayList<Integer[]>(maxVal);
			Integer[] arr;
			
			for(int i=0 ; i<=maxVal; i++) {
				 arr = new Integer[2];
				 if(i == 0) {
					 arr[0] = 1;
					 arr[1] = 0;
					 a.D.add(arr);
				 }else if(i==1) {
					 arr[0] = 0;
					 arr[1] = 1;
					 a.D.add(arr);
				 }else {
					Integer[] a1 = a.D.get(i-1);
					Integer[] a2 = a.D.get(i-2);
					arr[0] = a1[0] + a2[0];
					arr[1] = a1[1] + a2[1];
					a.D.add(arr);
				 }
			}
			
			//출력
			for(int i : a.I) {
				System.out.println(a.D.get(i)[0] + " " + a.D.get(i)[1]);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
