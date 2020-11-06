import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class GraphWithoutLongDirectedPaths {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		GraphWithoutLongDirectedPaths o = new GraphWithoutLongDirectedPaths();
		Graph g = o.new Graph(n, m);
		List<Edge> edges = new ArrayList<>();
		for (int i = 0; i < m; i++) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			g.addEdge(u, v);
			edges.add(o.new Edge(u, v));
		}
		g.bipartite(edges);
	}
	
	public class Edge {

		int src, dest;
		
		public Edge(int u, int v) {
			// TODO Auto-generated constructor stub
			src = u;
			dest = v;
		}
	}
	
	public class Graph {

		int E, V;
		List<Integer> adj[];
		
		public Graph(int v, int e) {
			// TODO Auto-generated constructor stub
			V = v + 1;
			E = e;
			adj = new LinkedList[V];
			for (int i = 0; i < V; i++) {
				adj[i] = new LinkedList<>();
			}
		}
		
		public void addEdge(int u, int v) {
			adj[u].add(v);
			adj[v].add(u);
		}
		
		int color[];
		public void bipartite(List<Edge> edges) {
			color = new int[V];
			Arrays.fill(color, -1);
			for (int i = 1; i < V; i++) {
				if (color[i] == -1) {
					color[i] = 1;
					if (!dfs(i)) {
						System.out.println("NO");
						return;
					}
				}
			}
			System.out.println("YES");
			for (int i = 0; i < E; i++) {
				System.out.print(color[edges.get(i).src]);
			}
		}

		private boolean dfs(int u) {
			// TODO Auto-generated method stub
			for (int v : adj[u]) {
				if (color[u] == color[v]) {
					return false;
				} else if (color[v] == -1) {
					color[v] = color[u] ^ 1;
					if (!dfs(v)) {
						return false;
					}
				}
			}
			return true;
		}
	}

}
