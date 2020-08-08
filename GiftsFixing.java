import java.util.Scanner;

public class GiftsFixing {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			int n = sc.nextInt();
			
			long A[] = new long[n];
			long minA = Long.MAX_VALUE;
			long maxA = Long.MIN_VALUE;
			for (int i = 0; i < n; i++) {
				A[i] = sc.nextLong();
				minA = Math.min(minA, A[i]);
				maxA = Math.max(maxA, A[i]);
			}
			
			long B[] = new long[n];
			long minB = Long.MAX_VALUE;
			long maxB = Long.MAX_VALUE;
			for (int i = 0; i < n; i++) {
				B[i] = sc.nextLong();
				minB = Math.min(minB, B[i]);
				maxB = Math.max(maxB, B[i]);
			}
			if (minA == maxA && minB == maxB) 
				System.out.println(0);
			else System.out.println(solve(A, B, n, minA, minB));
		}
	}

	private static long solve(long[] A, long[] B, int n, long minA, long minB) {
		// TODO Auto-generated method stub
		int i = 0;
		long moves = 0;
		while (i < n) {
			long d1 = A[i] - minA;
			long d2 = B[i] - minB;
			moves += d1 > d2 ? d1 : d2;
			i++;
		}
		return moves;
	}
}