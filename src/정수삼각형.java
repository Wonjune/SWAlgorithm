import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 정수삼각형 {
	public int N;
	public ArrayList<Integer[]> A;
	public ArrayList<Integer[]> D;
	public int Ans;
	
	public static void main(String[] args) {
		정수삼각형 a = new 정수삼각형();
		Integer[] arrA;
		Integer[] arrD;
		
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			//BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(new File("C://sample_input_정수삼각형.txt"))));
			StringTokenizer st;
			
			a.N = Integer.parseInt(br.readLine());
			
			//초기화
			a.A = new ArrayList<Integer[]>(a.N);
			a.D = new ArrayList<Integer[]>(a.N);
			
			for(int i=0 ; i<a.N ; i++) {
				st = new StringTokenizer(br.readLine());
				arrA = new Integer[i+1];
				arrD = new Integer[i+1];
				for(int j=0 ; j<=i ; j++) {
					arrA[j] = Integer.parseInt(st.nextToken());
					
					if(i==0) arrD[j] = arrA[j];
					else {
						if(j == 0) arrD[j] = a.D.get(i-1)[j] + arrA[j]; // 맨 왼쪽 끝
						else if(j == i) arrD[j] = a.D.get(i-1)[j-1] + arrA[j]; // 맨 오른쪽 끝
						else arrD[j] = Math.max(a.D.get(i-1)[j-1], a.D.get(i-1)[j]) + arrA[j]; // 중간
					}
				}
				a.A.add(arrA);
				a.D.add(arrD);
			}
			
			
			for(int i=0 ; i<a.N ; i++) {
				a.Ans = Math.max(a.Ans, a.D.get(a.N-1)[i]);
			}
			
			System.out.println(a.Ans);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
