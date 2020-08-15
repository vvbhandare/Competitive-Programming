import java.util.Scanner;
 
public class BadTriangle {
 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			int n = sc.nextInt();
			int[] arr = new int[n];
			for (int i = 0; i < arr.length; i++) {
				arr[i] = sc.nextInt();
			}
			solve(arr, n);
		}
	}
 
	private static void solve(int[] arr, int n) {
		// TODO Auto-generated method stub
		if (arr[0] + arr[1] > arr[n - 1]) System.out.println(-1);
		else System.out.println(1 + " " + 2+ " " + n);
	}
 
}