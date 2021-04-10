import java.util.*;
import java.io.*;

public class E {
	private static BufferedReader br;
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		solve();
		br.close();
	}

	private static void solve() throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken()), N = Integer.parseInt(st.nextToken());

		int[][] grid = new int[N][M];
		boolean[][] flooded = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				grid[i][j] = Integer.parseInt(st.nextToken());
				flooded[i][j] = true;
			}
		}

		boolean delta = true;

		while (delta) {
			delta = false;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (!flooded[i][j]) {
						continue;
					}

					if (i + 1 < N) {
						if (grid[i + 1][j] < grid[i][j] || (grid[i + 1][j] == grid[i][j] && !flooded[i + 1][j])) {
							flooded[i][j] = false;
							delta = true;
						}

						if (!flooded[i][j] && (flooded[i + 1][j] && grid[i + 1][j] >= grid[i][j])) {
							flooded[i + 1][j] = false;
							delta = true;
						}
					}

					if (i - 1 >= 0) {
						if (grid[i - 1][j] < grid[i][j] || (grid[i - 1][j] == grid[i][j] && !flooded[i - 1][j])) {
							flooded[i][j] = false;
							delta = true;
						}

						if (!flooded[i][j] && (flooded[i - 1][j] && grid[i - 1][j] >= grid[i][j])) {
							flooded[i - 1][j] = false;
							delta = true;
						}
					}

					if (j - 1 >= 0) {
						if (grid[i][j - 1] < grid[i][j] || (grid[i][j - 1] == grid[i][j] && !flooded[i][j - 1])) {
							flooded[i][j] = false;
							delta = true;
						}

						if (!flooded[i][j] && (flooded[i][j - 1] && grid[i][j - 1] >= grid[i][j])) {
							flooded[i][j] = false;
							delta = true;
						}
					}

					if (j + 1 < M) {
						if (grid[i][j + 1] < grid[i][j] || (grid[i][j + 1] == grid[i][j] && !flooded[i][j + 1])) {
							flooded[i][j] = false;
							delta = true;
						}

						if (!flooded[i][j] && (flooded[i][j + 1] && grid[i][j + 1] >= grid[i][j])) {
							flooded[i][j] = false;
							delta = true;
						}
					}
				}
			}
		}

		int floodcells = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (flooded[i][j]) {
					floodcells++;
				}
			}
		}

		System.out.println(floodcells);
	}
}
