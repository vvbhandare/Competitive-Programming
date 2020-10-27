import java.util.Scanner;
import java.util.Stack;

public class ReverseBinaryStrings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			int n = sc.nextInt();
			String s = sc.next();
			Stack<Character> st1 = new Stack<>();
			Stack<Character> st2 = new Stack<>();
			int count = 0;
			for (char c : s.toCharArray()) {
				if (st1.isEmpty() || c != st1.peek()) {
					st1.push(c);
				} else if (!st2.isEmpty() && c != st2.peek()) {
					st1.push(st2.pop());
					st1.push(c);
//					count++;
//					count--;
				} else {
					st2.push(c);
					count++;
				}
			}
//			System.out.println(st1);
//			System.out.println(st2);
			System.out.println(count);
		}
	}

}