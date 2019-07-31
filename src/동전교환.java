import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 동전교환 {
	public int[] 최소동전수;
	public ArrayList<Integer> 동전리스트;
	public int 동전개수;
	public int 교환금액;
	
	public static void main(String[] args) {
		
		int maxInt = Integer.MAX_VALUE;
		
		동전교환 a = new 동전교환();
		
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(new File("C://sample_input_dongjun.txt"))));
			
			a.동전개수 = Integer.parseInt(br.readLine());
			a.동전리스트 = new ArrayList<Integer>();
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			for(int i=0 ; i<a.동전개수 ; i++) {
				a.동전리스트.add(Integer.parseInt(st.nextToken()));
			}
			a.교환금액 = Integer.parseInt(br.readLine());
			a.최소동전수 = new int[a.교환금액+1];
			
			//초기화
			for(int i=1 ; i<a.최소동전수.length ; i++) {
				a.최소동전수[i] = maxInt;
			}
			
			for(int i=1 ; i<a.최소동전수.length ; i++) { // 1원단위로 loop
				System.out.print("금액이 " + i + "원일때 : ");
				for(int 단위 : a.동전리스트) { // 동전별로 loop
					if(단위 <= i) { //동전의 단위가 전체금액보다 작은경우 계산 수행, 동전의 단위가 전체금액보다 큰 경우는 계산 불가
						int 잔돈개수 = a.최소동전수[i-단위] + 1;	 // 전체금액보다 현재 동전만큼 작은 금액일 경우의 최소 동전갯수 + 1(현재동전)을 전체동전의 잔돈개수로 세팅 
						if(i%단위 == 0) 잔돈개수 = Math.min(잔돈개수, i/단위); // 동전으로 전체금액이 나누어 떨어지는 경우 그 개수를 잔돈개수랑 비교해서 작은것을 취한다.
						a.최소동전수[i] = Math.min(잔돈개수, a.최소동전수[i]); // 현재 금액의 기존 최소동전개수와 계산된 잔돈계수를 비교해서 작은것을 취한다.
					}
					System.out.print(단위 + "원짜리 수행 후 최소동전수 : " + a.최소동전수[i] + " ");
				}
				
				System.out.println("금액이 " + i + "원일때 최소 동전의 갯수 : " + a.최소동전수[i]);
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
