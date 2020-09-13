import java.util.Scanner;

public class Vacation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int days = sc.nextInt();
		int[][] activities = new int[days][3];
		for (int i = 0; i < days; i++) 
			 for (int j = 0; j < 3; j++) 
				 activities[i][j] = sc.nextInt();
		
		System.out.println(solve(activities, days));
	}

	private static int solve(int[][] activities, int days) {
		// TODO Auto-generated method stub
		int[][] dp = new int[days][3];
		
		dp[0][0] = activities[0][0];
		dp[0][1] = activities[0][1];
		dp[0][2] = activities[0][2];
		
		for (int day = 1; day < days; day++) {
			dp[day][0] = activities[day][0] + Math.max(dp[day - 1][1], dp[day - 1][2]);
			dp[day][1] = activities[day][1] + Math.max(dp[day - 1][0], dp[day - 1][2]);
			dp[day][2] = activities[day][2] + Math.max(dp[day - 1][0], dp[day - 1][1]);
		}
		
		return Math.max(dp[days - 1][0], Math.max(dp[days - 1][1], dp[days - 1][2]));
	}

}
