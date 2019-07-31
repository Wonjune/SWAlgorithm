import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 동전1 {

	public static void main(String[] args) {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			int n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			
			int[] coin = new int[k+1];
			int[] input = new int[n];
			
			for(int i = 0 ; i < n ; i++) {
				input[i] = Integer.parseInt(br.readLine());
			}
			
			System.out.println(getCase(n, k, input, coin));
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static int getCase(int n, int k, int[] input, int[] coin) {
		int rtn = 0;
		
		for(int i = 0 ; i < input.length ; i++) { // 더할 동전
			for(int j = 1 ; j <= k ; j++) { // 합액
				if(input[i] > j) coin[j] += 0;
				else if(input[i] == j) coin[j] += 1;
				else coin[j] += coin[j - input[i]];
			}
		}
		
		rtn = coin[k];
		
		return rtn;
	}

}
