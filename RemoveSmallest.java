import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;
 
public class RemoveSmallest {
 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			int n = sc.nextInt();
			List<Integer> l = new ArrayList<Integer>();
			for (int i = 0; i < n; i++) {
				l.add(sc.nextInt());
			}
			System.out.println(solve(l, l.size()));
		}
	}
 
	private static String solve(List<Integer> l, int size) {
		// TODO Auto-generated method stub
		PriorityQueue<Integer> q = new PriorityQueue<Integer>((a, b) -> {return b - a;});
		q.addAll(l);
		while (q.size() > 1) {
			int x = q.poll();
			int y = q.poll();
			if (Math.abs(x - y) > 1) return "NO";
			q.add(y);
		}
		return "YES";
	}
 
}