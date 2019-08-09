import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 중앙값 {
	public static int MAX_N = 250000;
	public static int MAX = 65536;
	
	public int tree[];
	public int a[];
	public int n;
	public int k;
	public int res;
	
	public static void main(String[] args) {
		중앙값 c = new 중앙값();
		
		try {
			//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(new File("c://sample_input_중앙값.txt"))));
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			c.n = Integer.parseInt(st.nextToken());
			c.k = Integer.parseInt(st.nextToken());
			
			c.tree = new int[MAX_N * 4];
			c.a = new int[MAX_N];
			
			for(int i=1 ; i<=c.n ; i++) {
				c.a[i] = Integer.parseInt(br.readLine());
			}
			
			for(int i=1 ; i<c.k ; i++) {
				c.update(c.a[i], 1, 1, 1, MAX_N);
			}
			for(int i=c.k ; i<=c.n ; i++) {
				c.update(c.a[i], 1, 1, 1, MAX_N);
				c.update(c.a[i-c.k], -1, 1, 1, MAX_N);
				c.res += c.query((c.k+1)/2, 1, 1, MAX_N);
			}
			
			System.out.println(c.res);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public int update(int pos, int val, int node, int start, int end) {
		if(pos < start || pos > end) return tree[node];
		if(start == end) {
			tree[node] += val;
		}else{
			int mid = (start + end)/2;
			tree[node] = update(pos, val, node*2, start, mid) + update(pos, val, node*2+1, mid+1, end);
		}
		return tree[node];
	}
	
	public int query(int val, int node, int start, int end) {
		if(start == end) return start;
		int mid = (start + end)/2;
		if(tree[node*2] >= val) return query(val, node*2, start, mid);
		return query(val-tree[node*2], node*2+1, mid+1, end);
	}
}
