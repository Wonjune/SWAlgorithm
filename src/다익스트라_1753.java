import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class 다익스트라_1753 {
	
	// 노드의 갯수
	public int V;
	
	// 간선의 갯수
	public int E;
	
	// 출발지 노드
	public int S;
	
	// 현재 커서위치
	public int U;
	
	// 간선배열
	public ArrayList<int[]> lines;
	
	//출발지에서 노드까지의 거리
	public int dist[];
	
	//방문하지 않은 노드
	public Set<Integer> unvisited;
	
	//방문한 노드
	public ArrayList<Integer> visited;
	
	//방문한 노드 리스트의 마지막 위치
	public int visitedMaxPos;
	
	//최대값
	public final int INFINITE = Integer.MAX_VALUE; 
	
	public static void main(String[] args) {
		//입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		다익스트라_1753 cla = new 다익스트라_1753();
		
		try {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			cla.V = Integer.parseInt(st.nextToken());
			cla.E = Integer.parseInt(st.nextToken());
				
			st = new StringTokenizer(br.readLine());
			cla.S = Integer.parseInt(st.nextToken());
			
			cla.lines = new ArrayList<int[]>();
			int[] line;
			
			for(int i = 0 ; i < cla.E ; i++) {
				line = new int[3];
				
				st = new StringTokenizer(br.readLine());
				line[0] = Integer.parseInt(st.nextToken());
				line[1] = Integer.parseInt(st.nextToken());
				line[2] = Integer.parseInt(st.nextToken());
				
				cla.lines.add(line);
			}
			
			//초기화
			cla.init();
			
			//U의 이웃노드(X)를 순회하면서 dist[U] + (U와 X간의 거리) 와 dist[X] 중에 작은 값을 dist[X]에 할당
			//X를 방문한 노드 리스트로 옮김
			//방문한 노드들 중에 dist 값이 가장 작은 노드를 선택하고 U로 설정
			//방문하지 않은 노드가 없을때까지 반복		
			while(!cla.unvisited.isEmpty()) {
				
				// 최초에는 출발지로 커서 설정
				if(cla.U == 0) cla.U = cla.S;
				else {
					if(cla.visited.size() == 0) break;
//					cla.U = cla.getNext();
					cla.U = cla.visited.remove(0);
				}
				
				for (int[] i : cla.lines) {
					if(i[0] == cla.U) {
						if(cla.dist[cla.U] + i[2] < cla.dist[i[1]]) {
							cla.dist[i[1]] = cla.dist[cla.U] + i[2];
							cla.unvisited.remove(i[1]);
							
							cla.addVisited(i[1]);
						}
					}
				}
				
			}
			
			
			for(int i=1 ; i <= cla.V ; i++) {
				if(cla.dist[i] == cla.INFINITE) System.out.println("INF");
				else System.out.println(cla.dist[i]);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void init() {
		unvisited = new HashSet<Integer>(V+1);
		visited = new ArrayList<Integer>();
		dist = new int[V+1];
		
		//출발지로의 거리는 0, 그외 노드들은 infinite 값으로 설정
		//방문하지 않은 노드 리스트에 전체등록(시작노드는 방문/미방문 리스트에서 제외함)
		for(int i=1 ; i<=V ; i++) {
			if(i == S) {
				dist[i]= 0;
			}else {
				dist[i] = INFINITE;
				unvisited.add(i);
			}
		}
		
		//방문한 노드 리스트의 초기사이즈 설정
		visitedMaxPos = 0;
	}
	
	//우선순위큐에 담기
	public void addVisited(int node) {
		
//		visitedMaxPos++;
//		
//		int pos = visitedMaxPos;
//		
//		while(visited.get(pos)[1] < visited.get(pos/2)[1]) {
//			swap(pos/2, pos);
//			pos = pos/2;
//		}
		
		visited.add(node);
	}
	
	//다음 커서가 이동할 위치 리턴
	public int getNext() {
//		int ret[] = visited.get(1);
//		
//		//우선순위큐의 마지막노드를 루트로 넣고 재정렬
//		int[] temp = visited.remove(visitedMaxPos);
//		visitedMaxPos--;
//		
//		visited.set(1, temp);
//		
//		int pos = 1;
//		
//		while(pos * 2 <= visitedMaxPos && visited.get(pos)[1] > visited.get(pos * 2)[1]) {
//			if(pos * 2 + 1 <= visitedMaxPos && visited.get(pos)[1] > visited.get(pos * 2 + 1)[1]) {
//				if(visited.get(pos * 2 + 1)[1] <  visited.get(pos * 2)[1]) {
//					swap(pos, pos * 2 + 1);
//				}else {
//					swap(pos, pos * 2);
//				}
//			}else {
//				swap(pos, pos * 2);
//			}
//		}
//		
//		return ret[0];
		
		return visited.remove(0);
	}
	
//	public void swap(int a, int b) {
//		int[] temp = visited.get(a);
//		visited.set(a, visited.get(b));
//		visited.set(b, temp);
//	}
}
