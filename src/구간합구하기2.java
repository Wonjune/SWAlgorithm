import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 구간합구하기2 {
	public int N;		//수의 갯수
	public int M;		//수 변경 횟수
	public int K;		//구간의 합을 구하는 횟수
	public ArrayList<Integer> A;		//수 배열
	public ArrayList<Long> S;	//세그먼트트리 배열
	public ArrayList<Long> Ans; //합 배열
	public ArrayList<Integer> L; //lazy 배열
	
	public static void main(String[] args) {
		구간합구하기2 a = new 구간합구하기2();
		
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			a.N = Integer.parseInt(st.nextToken());
			a.M = Integer.parseInt(st.nextToken());
			a.K = Integer.parseInt(st.nextToken());
			
			a.A = new ArrayList<Integer>();
			a.L = new ArrayList<Integer>();
			a.S = new ArrayList<Long>();
			a.Ans = new ArrayList<Long>();
			
			a.A.add(0);
			for(int i=1 ; i<=a.N ; i++) {
				a.A.add(Integer.parseInt(br.readLine()));
			}
			
			int NN = 1;
			while(NN < a.N) NN *= 2;
			for(int i=0 ; i<= NN*2 ; i++) {
				a.S.add((long)0);
			}
			
			a.init(1, 1, a.N);
			
			for(int i=1 ; i<=a.M+a.K ; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				if(st.nextToken().equals("1")) {
					//update
					
				}else {
					//sum
				}
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public long init(int node, int start, int end) {
		if(start == end) {
			S.set(node, (long)A.get(start));
		}else {
			int mid = (start/end)/2;
			S.set(node, init(node*2, start, mid) + init(node*2+1, mid+1, end));
		}
		
		return S.get(node);
	}
}
