import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Text_1240 {
	public static byte[][] arr;
	public static int m;
	public static int n;
	public static int caseNum;
	
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		try {
			caseNum = Integer.parseInt(br.readLine());
			
			for(int c=0 ; c<caseNum ; c++) {
				st = new StringTokenizer(br.readLine(), " ");
				m = Integer.parseInt(st.nextToken());
				n =  Integer.parseInt(st.nextToken());
				
				arr = new byte[m][n];
				for(int a=0 ; a<m ; a++) {
					
				}
				
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
