import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 구간합구하기 {
	public int N;		//수의 갯수
	public int M;		//수 변경 횟수
	public int K;		//구간의 합을 구하는 횟수
	public ArrayList<Integer> A;		//수 배열
	public ArrayList<Long> S;	//세그먼트트리 배열
	public ArrayList<Long> Ans; //합 배열
	
	public static void main(String[] args) {
		구간합구하기 a = new 구간합구하기();
		
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			a.N = Integer.parseInt(st.nextToken());
			a.M = Integer.parseInt(st.nextToken());
			a.K = Integer.parseInt(st.nextToken());
			
			a.A = new ArrayList<Integer>();
			a.S = new ArrayList<Long>();
			a.Ans = new ArrayList<Long>();
			
			a.A.add(0);
			for(int i=1 ; i<=a.N ; i++) {
				a.A.add(Integer.parseInt(br.readLine()));
			}
			
			int k = 1;
			while(k < a.N) k *= 2;
			
			for(int i=0 ; i<k*2 ; i++) {
				a.S.add((long)0);
			}
			
			a.init(a, 1, 1, a.N);
			
			for(int i=0 ; i<a.M+a.K ; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				if(st.nextToken().equals("1")) {
					// 수바꾸기
					int index = Integer.parseInt(st.nextToken());
					int chg = Integer.parseInt(st.nextToken());
					int diff = a.A.get(index)-chg;
					a.A.set(index, chg);
					a.change(a, 1, index, diff, 1, a.N);
				}else {
					// 합구하기
					int left = Integer.parseInt(st.nextToken());
					int right = Integer.parseInt(st.nextToken());
					a.Ans.add(a.sum(a, 1, 1, a.N, left, right));
				}
			}
			
			for(long val : a.Ans) {
				System.out.println(val);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public long init(구간합구하기 a, int node, int start, int end) {
		if(start == end) {
			a.S.set(node, (long)a.A.get(start));
		}else {
			a.S.set(node, init(a, node*2, start, (start+end)/2) + init(a, node*2+1, (start+end)/2+1, end));
		}
		
		return a.S.get(node);
	}
	
	public void change(구간합구하기 a, int node, int index, int diff, int start, int end) {
		if(index < start || index > end) {
			return;
		}else{
			a.S.set(node, a.S.get(node)-diff);
			if(start != end) {
				change(a, node*2, index, diff, start, (start+end)/2);
				change(a, node*2+1, index, diff, (start+end)/2+1, end);
			}
		}
	}
	
	public long sum(구간합구하기 a, int node, int start, int end, int left, int right) {
		if(end < left || start > right) return 0;
		if(start >= left && end <= right) return a.S.get(node);
		else return sum(a, node*2, start, (start+end)/2, left, right) + sum(a, node*2+1, (start+end)/2+1, end, left, right);
	}
}
