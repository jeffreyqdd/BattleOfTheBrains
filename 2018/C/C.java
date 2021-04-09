import java.util.*;
import java.io.*;

public class C {
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

		int k = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken());
		long n = Long.parseLong(st.nextToken());

		long ssd = 0;
		while (n > 0) {
			long digit = n % b;
			ssd += digit * digit;
			n /= b;
		}

		System.out.println(k + " " + ssd);
	}
}
