
public class 군인숨기기 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		long[] soldier = {0, 1L, 4L, 5L};
		
		int n = 3;
		
		System.out.println(getResult(n, soldier));
		
	}
	
	public static long getResult(int n, long[] soldier) {
		long rst = 0;
		long[] c = new long[n+1];
		
		c[0] = 1L;
		
		for(int i = 1 ; i <= n ; i++) {
			if(i == 1) {
				c[i] =  soldier[i];
				continue;
			}
			
			for(long j = 1L ; j <= c[i-1] ; j++) {
				c[i] += soldier[i] - j + (long)1;
				if(c[i] < 0) {
					System.out.println(c[i] + " " + soldier[i]);
					break;
				}
			}
		}
		
		rst = c[n];
		
		return rst;
	}

}
