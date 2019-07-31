import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 연속합 {
	
	public int N;
	public ArrayList<Long> D;
	
	public static void main(String[] args) {
		연속합 a = new 연속합();
		int input;
		Long tmp = (long)0;
		
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(new File("C://sample_input_연속합.txt"))));
			//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			a.N = Integer.parseInt(br.readLine());
			a.D = new ArrayList<Long>(a.N);
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			for(int i =0 ; i < a.N ; i++) {
				input = Integer.parseInt(st.nextToken());
				if(i == 0) {
					a.D.add((long) input);
				}else {
					a.D.add(Math.max(a.D.get(i-1) + input, (long) input));
				}
			}
			tmp = (long) 0;
			for(int i = 0 ; i < a.N ; i++) {
				if(a.D.get(i) > tmp) tmp = a.D.get(i); 
			}
			
			System.out.println(tmp);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
