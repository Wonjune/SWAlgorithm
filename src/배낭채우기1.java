import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class 배낭채우기1 {
	
	public int 보석수;
	public int 배낭용량;
	public int[] 최대값어치;
	public ArrayList<보석> 보석리스트;
	public int 정답;
	
	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(new File("C://sample_input.txt"))));
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			배낭채우기1 b = new 배낭채우기1();
			
			b.보석수 = Integer.parseInt(st.nextToken());
			b.배낭용량 = Integer.parseInt(st.nextToken());
			b.최대값어치 = new int[b.배낭용량+1];
			b.보석리스트 = new ArrayList<보석>();
			
			for(int i=1 ; i <= b.보석수 ; i++) {
				st = new StringTokenizer(br.readLine());
				
				보석 a = new 보석(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
				
				b.보석리스트.add(a);
			}
			
			Collections.sort(b.보석리스트);
			
			for(int i=0 ; i<b.보석리스트.size() ; i++) {
				
				보석 jewel = b.보석리스트.get(i);
				
				System.out.println(jewel + " ====> " + jewel.무게 + ", " + jewel.값어치);
				for(int j=1 ; j<=b.배낭용량 ; j++) {
					if(jewel.무게 <= j) {
						b.최대값어치[j] = Math.max(b.최대값어치[j], b.최대값어치[j-jewel.무게]+jewel.값어치);
					}
					System.out.print("최대값어치[" + j + "] : " + b.최대값어치[j] + "   ");
				}
				
				System.out.println("");
			}
			
			for(int i=1 ; i<b.최대값어치.length ; i++) {
				if(b.최대값어치[i] > b.정답) b.정답 = b.최대값어치[i];
			}
			
			System.out.println("정답 : " + b.정답);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}

class 보석 implements Comparable<보석>{
	public int 무게;
	public int 값어치;
	
	public 보석(int 무게, int 값어치) {
		this.무게 = 무게;
		this.값어치 = 값어치;
	}
	
	@Override
	public int compareTo(보석 arg0) {
		if(this.무게 < arg0.무게)
			return -1;
		else
			return 1;
	}
	
	
}
