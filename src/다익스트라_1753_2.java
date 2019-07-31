import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class 다익스트라_1753_2 {
	
	class Pair{
		public int node;
		public int weight;
		
		public Pair( int weight, int node) {
			this.node = node;
			this.weight = weight;
		}
	}
	
	public int V;
	public int E;
	
	public static void main(String[] args){
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            int input = Integer.parseInt(br.readLine());

            for(int i = input ; i >= 0 ; i--){
            	System.out.print(i + " ");
            }
        }catch(Exception e){
        }
    }
	
	public ArrayList<Integer> dijkstra(int start, int vertex){
		ArrayList<Integer> distance = new ArrayList<Integer>(V);
		distance.set(start, 0);
		
		PriorityQueue<Pair> pq = new PriorityQueue<Pair>(); //Cost, Vertex
		pq.add(new Pair(0, start));
		
		while(!pq.isEmpty()) {
			Pair pair = pq.poll();
			int cost = pair.weight;
			int curVertex = pair.node;
		}
		
		return distance;
	}
}
