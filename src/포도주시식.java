import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class 포도주시식 {
	public ArrayList<Long[]> D;
//	public ArrayList<Integer> I;
	public int N;
	public long ans;
	
	public static void main(String[] args) {
		
		포도주시식 a = new 포도주시식();
		Long[] arr;
		Long[] arrBF;
		
		a.D = new ArrayList<Long[]>();
		//a.I = new ArrayList<Integer>();
		
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			//arr[0] : n-2번째 포도주를 먹고 n-1번째 포도주를 먹고 n 번째 포도주를 안먹는 경우
			//arr[1] : n-2번째 포도주를 먹고 n-1번째 포도주를 안먹고 n 번째 포도주를 먹는 경우
			//arr[2] : n-2번째 포도주를 안먹고 n-1번째 포도주를 먹고 n 번째 포도주를 먹는 경우
			//arr[3] : n-2번째 포도주를 안먹고 n-1번째 포도주를 먹고 n 번째 포도주를 안먹는 경우
			//arr[4] : n-2번째 포도주를 먹고 n-1번째 포도주를 안먹고 n 번째 포도주를 안먹는 경우
			//arr[5] : n-2번째 포도주를 안먹고 n-1번째 포도주를 안먹고 n 번째 포도주를 먹는 경우
			//arr[6] :n-2번째 포도주를 안먹고 n-1번째 포도주를 안먹고 n 번째 포도주를 안먹는 경우
			
			a.N = Integer.parseInt(br.readLine());
			
			for(int i=0 ; i<a.N ; i++) {
				int input = Integer.parseInt(br.readLine());
				//a.I.add(input);
				arr = new Long[7];
				if(i==0) {
					arr[0] = (long) 0;
					arr[1] = (long) input;
					arr[2] = (long) input;
					arr[3] = (long) 0;
					arr[4] = (long) 0;
					arr[5] = (long) input;
					arr[6] = (long) 0;
				}else if(i==1) {
					arrBF = a.D.get(i-1);
					arr[0] = a.getMax(arrBF[1], arrBF[2], arrBF[5]);
					arr[1] = (long) input;
					arr[2] = arr[0] + (long) input;
					arr[3] = arr[0];
					arr[4] = (long) 0;
					arr[5] = (long) input;
					arr[6] = (long) 0;
				}else {
					arrBF = a.D.get(i-1);
					arr[0] = arrBF[2];
					arr[1] = Math.max(arrBF[0], arrBF[3]) + (long) input;
					arr[2] = Math.max(arrBF[1], arrBF[5]) + (long) input;
					arr[3] = Math.max(arrBF[1], arrBF[5]);
					arr[4] = Math.max(arrBF[0], arrBF[3]);
					arr[5] = Math.max(arrBF[4], arrBF[6]) + (long) input;
					arr[6] = Math.max(arrBF[4], arrBF[6]);
				}
				
				a.D.add(arr);
			}
			
			arr = a.D.get(a.N-1);
			for(int i=0 ; i<7 ; i++) {
				if(a.ans < arr[i]) a.ans = arr[i];
			}
			
			System.out.println(a.ans);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public long getMax(long a, long b, long c) {
		long tmp = Math.max(a, b);
		tmp = Math.max(tmp, c);
		return tmp;
	}
}
