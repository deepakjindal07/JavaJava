package basics_large;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

public class DijkstraAlgorithm {

	private int[] dist;
	private Set<Integer> settled;
	private PriorityQueue<GraphNode> pq;
	private int V;
	private List<List<GraphNode>> adj;

	public DijkstraAlgorithm(int V) {
		this.V = V;
		dist = new int[V];
		settled = new HashSet<>();
		pq = new PriorityQueue<>(V, new NodeComparator());
	}

	public void dijkstra(List<List<GraphNode>> adj, int src) {
		this.adj = adj;

		Arrays.fill(dist, Integer.MAX_VALUE);
		pq.add(new GraphNode(src, 0));
		dist[src] = 0;

		while (settled.size() != V) {
			if (pq.isEmpty()) {
				return;
			}

			int u = pq.remove().node;

			if (settled.contains(u)) {
				continue;
			}

			settled.add(u);
			exploreNeighbors(u);
		}
	}

	private void exploreNeighbors(int u) {
		for (GraphNode v : adj.get(u)) {
			if (!settled.contains(v.node)) {
				int edgeDistance = v.cost;
				int newDistance = dist[u] + edgeDistance;

				if (newDistance < dist[v.node]) {
					dist[v.node] = newDistance;
					pq.add(new GraphNode(v.node, dist[v.node]));
				}
			}
		}
	}

	public static void main(String args[]) {
		int V = 5;
		int source = 0;

		List<List<GraphNode>> adj = new ArrayList<>();

		for (int i = 0; i < V; i++) {
			adj.add(new ArrayList<>());
		}

		adj.get(0).add(new GraphNode(1, 9));
		adj.get(0).add(new GraphNode(2, 6));
		adj.get(0).add(new GraphNode(3, 5));
		adj.get(0).add(new GraphNode(4, 3));

		adj.get(2).add(new GraphNode(1, 2));
		adj.get(2).add(new GraphNode(3, 4));

		DijkstraAlgorithm dijkstra = new DijkstraAlgorithm(V);
		dijkstra.dijkstra(adj, source);

		System.out.println("Shortest paths from node " + source + ":");
		for (int i = 0; i < dijkstra.dist.length; i++) {
			System.out.println(source + " to " + i + " is " + dijkstra.dist[i]);
		}
	}
}

class GraphNode {
	public int node;
	public int cost;

	public GraphNode(int node, int cost) {
		this.node = node;
		this.cost = cost;
	}
}

class NodeComparator implements Comparator<GraphNode> {
	@Override
	public int compare(GraphNode node1, GraphNode node2) {
		return Integer.compare(node1.cost, node2.cost);
	}
}
