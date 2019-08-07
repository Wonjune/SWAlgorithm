import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 순열 {
	//1. N의 갯수만큼 세그먼트 트리 생성
	//2. 트리의 리프를 모두 1로 채우고 구간합 계산
	//3. 입력 순열 순서대로 loop
	//3-1. root 노드부터 시작하여 
	//3-2. 입력값(A[i])이 왼쪽 자식노드보다 작으면 왼쪽으로 내려감
	//3-3. 입력값(A[i])이 왼쪽 자식노드보다 크거나 같으면 왼쪽노드값만큼 값을 감하고 오른쪽으로 내려감
	//3-4. leaf에 도달하면 해당 leaf의 위치가 i의 위치가 됨.
	//3-5. 해당 leaf의 값을 0으로 바꾸고 구간합을 재계산.
	
	public int N;
	public int[] A;
	public int[] tree;
	public int[] S;
	
	public static void main(String[] args) {
		순열 a = new 순열();
		
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			a.N = Integer.parseInt(br.readLine());
			
			int NN = 1;
			while(NN < a.N) NN *= 2;
			a.tree = new int[NN*2+1];
			
			a.A = new int[a.N+1];
			a.S = new int[a.N+1];
			
			a.init(a, 1, 1, a.N);
			
			for(int i=1 ; i<= a.N ; i++) {
				a.A[i] = Integer.parseInt(br.readLine());
				int pos = a.find(a, i, a.A[i], 1, 1, a.N);
				a.update(a, pos, 1, 1, a.N);
			}
			
			for(int i : a.S) {
				System.out.println(i);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public int init(순열 a, int node, int start, int end) {
		if(start == end) {
			a.tree[node] = 1;
			return a.tree[node];
		}
		
		a.tree[node] = init(a, node*2, start, (start+end)/2) + init(a, node*2+1, (start+end)/2+1, end);
		return a.tree[node];
	}
	
	public int find(순열 a, int val, int zerocnt, int node, int start, int end) {
		if(start == end) {
			a.tree[node] = 0;
			a.S[node] = val;
			return node;
		}
		
		if(a.tree[node*2] > zerocnt) {
			return find(a, val, zerocnt, node*2, start, (start+end)/2);
		}else {
			return find(a, val, zerocnt-a.tree[node*2], node*2+1, (start+end)/2+1, end);
		}
	}
	
	public void update(순열 a, int pos, int node, int start, int end) {
		if(pos < start || pos > end) return;
		a.tree[node] -= 1;
		if(start != end) {
			update(a, pos, node*2, start, (start+end)/2);
			update(a, pos, node*2+1, (start+end)/2+1, end);
		}
	}
}
