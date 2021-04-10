import java.util.*;
import java.io.*;

public class J {
	private static BufferedReader br;
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		solve();
		br.close();
	}

	private static void solve() throws IOException {
		String line = br.readLine();
		StringBuilder sb = new StringBuilder("AWHO");
		boolean h = true;

		while (sb.length() <= line.length()) {
			if (h) {
				sb.append('H');
			} else {
				sb.append('O');
			}

			h = !h;
		}

		System.out.println(sb.toString());
	}
}
