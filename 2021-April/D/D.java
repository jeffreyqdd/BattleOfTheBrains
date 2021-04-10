import java.util.*;
import java.io.*;

public class D {
	public static int L, W;

	private static BufferedReader br;
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));

		while (solve());

		br.close();
	}

	private static boolean solve() throws IOException {
		String firstLine = br.readLine();
		if (firstLine == null || firstLine.length() < 3) {
			return false;
		}

		StringTokenizer st = new StringTokenizer(firstLine);
		int N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());

		TreeSet<Circle> t = new TreeSet<Circle>(Comparator.comparing(Circle::getStart).thenComparing(Circle::getR));
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			t.add(new Circle(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}

		int numUsed = 1;
		Circle curr = t.first();
		while (curr.getEnd() < L) {
			Circle next = t.floor(new Circle(curr.getEnd(), curr.getEnd()));

			if (next == null || next == curr) {
				System.out.println(-1);
				return true;
			}
			curr = next;
			numUsed++;
		}

		System.out.println(numUsed);
		return true;
	}
}

class Circle {
	double start, end;
	int r;

	public Circle(double start, double end) {
		this.start = start;
		this.end = end;
		this.r = 9999;
	}

	public Circle(int x, int r) {
		this.r = r;
		double delta = Math.sqrt(Math.pow((double) (r), 2) - Math.pow(D.W / 2.0, 2));
		start = x - delta;
		end = x + delta;
	}

	public int getR() {
		return -r;
	}

	public double getStart() {
		return start;
	}

	public double getEnd() {
		return end;
	}

	public String toString() {
		return String.format("[%.2f, %.2f]", start, end);
	}
}
