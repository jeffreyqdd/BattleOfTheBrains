import java.util.*;
import java.io.*;

public class F {
	private static BufferedReader br;
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));

		int numCases = Integer.parseInt(br.readLine());
		for (int i = 0; i < numCases; i++) {
			solve();
		}

		br.close();
	}

	private static void solve() throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());

		int caseNum = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
		String starter = st.nextToken();

		String winner;
		if (N % (M + 1) == 0) {
			winner = (starter.equals("A") ? "B" : "A");
		} else {
			winner = starter;
		}

		System.out.println(caseNum + " " + winner);
	}
}
