import java.util.Scanner;

public class StringSimilarity {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			int n = sc.nextInt();
			String s = sc.next();
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < n; i++) {
				sb.append(s.charAt(n - 1));
			}
			System.out.println(sb.toString());
		}
	}

}
