import java.util.Scanner;

public class MultipleOf9 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		solve(s, s.length());
	}

	private static void solve(String s, int len) {
		// TODO Auto-generated method stub
		long sum = 0;
		for(int i = 0; i < len; i++) {
			sum += s.charAt(i) - '0';
		}
		if (sum % 9 == 0) 
			System.out.println("Yes");
		else 
			System.out.println("No");
	}

}
