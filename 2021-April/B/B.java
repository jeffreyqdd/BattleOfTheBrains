import java.util.*;
import java.io.*;

public class B {
	private static BufferedReader br;
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		solve();
		br.close();
	}

	private static void solve() throws IOException {
		int N = Integer.parseInt(br.readLine());

		Drone head = new Drone(-1, -1);
		Drone curr = head;
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			curr.next = new Drone(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			curr = curr.next;
		}
	}
}

class Drone {
	Drone next;
	int x, v;
	double crossTime;

	public Drone(int x, int v) {
		next = null;
		this.x = x;
		this.v = v;
	}

	public double getCrossTime() {
		return crossTime;
	}

	public void changeNext(Drone newNext) {

	}
}
