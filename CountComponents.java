import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;
import java.util.Scanner;

class CountComponents {
    public static void main(String args[] ) throws Exception {
		Scanner sc = new Scanner(System.in);	
		int n = sc.nextInt();
		int e = sc.nextInt();
		Graph g = new Graph(n + 1);
		for (int i = 0; i < e; i++) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			g.addEdge(u, v);
		}
		g.findConnectedComponents();
    }
}

class Graph {
	
	private int V;
	private LinkedList<Integer>[] adj;
	private boolean[] visited;
	
	public Graph(int v) {
		// TODO Auto-generated constructor stub
		V = v;
		adj = new LinkedList[v];
		for (int i = 0; i < v; i++) adj[i] = new LinkedList<Integer>();
		visited = new boolean[v];
		Arrays.fill(visited, false);
	}
	
	public void addEdge(int u, int v) {
		adj[u].add(v);
		adj[v].add(u);
	}
	
	public void dfs(int u, Set<Integer> vertices) {
		visited[u] = true;
		vertices.add(u);
		// System.out.print(u + " ");
		Iterator<Integer> it = adj[u].iterator();
		while (it.hasNext()) {
			int v = (int) it.next();
			if (!visited[v]) dfs(v, vertices);
		}
	}
	
	public void findConnectedComponents() {
		int res = 0;
		Set<Integer> vertices = new HashSet<Integer>();
		for (int i = 1; i < V; i++) {
			vertices.clear();
			if (!visited[i]) dfs(i, vertices);
			// System.out.println();
			res += vertices.size() > 0 ? 1 : 0;
		}
		System.out.println(res);
	}
}

