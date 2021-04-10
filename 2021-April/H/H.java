import java.util.*;
import java.io.*;

public class H {
	private static BufferedReader br;
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		solve();
		br.close();
	}

	private static void solve() throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken()), K = Integer.parseInt(st.nextToken());

		int val = 0;
		for (int i = 0; i < N; i++) {
			int x = Integer.parseInt(br.readLine(), 2);
			val ^= x;
		}

		if (N == 1) {
			val ^= ((1 << K) - 1);
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < K; i++) {
			sb.insert(0, val & 1);
			val >>= 1;
		}

		System.out.println(sb);
	}
}
