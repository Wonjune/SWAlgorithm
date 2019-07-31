import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class RGB거리 {
	public ArrayList<Integer[]> i;
	public ArrayList<Integer[]> d;
	public int n;
	public int ans = Integer.MAX_VALUE;
	
	public static void main(String[] args) {
		RGB거리 a = new RGB거리();
		a.i = new ArrayList<Integer[]>();
		a.d = new ArrayList<Integer[]>();
		Integer[] arrI;
		Integer[] arrD;
		StringTokenizer st;
		
		try {
			//입력
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(new File("C://sample_input_RGB거리.txt"))));
			//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			a.n = Integer.parseInt(br.readLine());
			for(int i=0 ; i<a.n ; i++) {
				arrI = new Integer[3];
				arrD = new Integer[3];
				st = new StringTokenizer(br.readLine(), " ");
				for(int j=0 ; j<3 ; j++) {
					arrI[j] = Integer.parseInt(st.nextToken());
					if(i == 0) arrD[j] = arrI[j];
					else {
						if(j == 0) arrD[j] = Math.min(a.d.get(i-1)[1], a.d.get(i-1)[2]) + arrI[j];
						else if(j == 1) arrD[j] = Math.min(a.d.get(i-1)[0], a.d.get(i-1)[2]) + arrI[j];
						else arrD[j] = Math.min(a.d.get(i-1)[0], a.d.get(i-1)[1]) + arrI[j];
					}
				}
				a.i.add(arrI);
				a.d.add(arrD);
			}
			
			//출력
			for(int i=0 ; i<3 ; i++) {
				a.ans = Math.min(a.ans, a.d.get(a.n-1)[i]);
			}
			System.out.println(a.ans);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
}
