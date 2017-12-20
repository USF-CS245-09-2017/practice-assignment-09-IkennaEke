
public class GraphAdjMatrix implements Graph {
	private int [][] graph;
	private int size;
	public GraphAdjMatrix(int vertices){
		size = vertices;
		graph = new int [vertices][vertices];
	}

	@Override
	public void addEdge(int v1, int v2, int w) {
		graph[v1][v2] = w;
		graph[v2][v1] = w;
		
	}

	@Override
	public int getEdge(int v1, int v2) {
		return graph[v1][v2];
	}

	@Override
	public int createSpanningTree() {
		int parent[] = new int[size];
		int cost[] = new int[size];
		int total = 0;
		boolean [] known = new boolean[size];
		for(int i = 0; i<known.length;i++){
			known[i] = false;
			cost[i]= Integer.MAX_VALUE;
		}
		cost[0] = 0;
		parent[0] = -1;
		
		for(int i = 0; i < size-1; i++) {
			int index = Findmin(known, cost);
			known[index] = true;
			for(int j = 0; j < size; j++) {
				if(graph[index][j] != 0 && known[j] == false && graph[index][j] < cost[j]) {
					parent[j] = index;
					cost[j] = graph[index][j];
				}
			}
		}
		for(int i = 0; i<cost.length;i++){
		total += cost[i];	
		}
		return total;
	}
	
	private int Findmin(boolean[] known, int[] cost) {
		int min = Integer.MAX_VALUE;
		int index = -1;
		for(int i = 0; i < known.length; i++) {
			if(known[i] == false && cost[i] < min) {
				min = cost[i];
				index = i;
			}
		}
		return index;
	}
	
	

}
