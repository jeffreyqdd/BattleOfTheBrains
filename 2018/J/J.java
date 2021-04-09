import java.util.*;
import java.io.*;

public class J {
	private static BufferedReader br;
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));

		for (int i = 1; solve(i); i++);

		br.close();
	}

	private static boolean solve(int caseNum) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());

		if (N == -1) {
			return false;
		}

		int[][] dp = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				dp[i][j] = -1;
			}
		}
		dp[0][0] = 0;

		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < N; j++) {
				int x = s.charAt(j) - '0';
				if (dp[i][j] != -1) {
					if (i + x < N && (dp[i + x][j] == -1 || dp[i][j] + 1 < dp[i + x][j])) {
						dp[i + x][j] = dp[i][j] + 1;
					}

					if (j + x < N && (dp[i][j + x] == -1 || dp[i][j] + 1 < dp[i][j + x])) {
						dp[i][j + x] = dp[i][j] + 1;
					}
				}
			}
		}

		int result = dp[N - 1][N - 1];
		if (result == -1) {
			System.out.println(caseNum + " No Path");
		} else {
			System.out.println(caseNum + " " + result);
		}

		return true;
	}
}
