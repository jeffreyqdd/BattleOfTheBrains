import java.util.*;
import java.io.*;

public class A {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] vals = br.readLine().toCharArray();
		int N = vals.length;

        Map<Character, List<Integer>> indexes = new HashMap<Character, List<Integer>>();
        for (int i = 0; i < N; i++) {
            if (!indexes.containsKey(vals[i])) {
                indexes.put(vals[i], new ArrayList<Integer>());
            }

            indexes.get(vals[i]).add(i);
        }

        long ans = 0;
        int[][] qrs = new int[N - 1][2];
        for (int i = 0; i < N - 1; i++) {
            int rightBoundIndex = Collections.binarySearch(indexes.get(vals[i]), i) + 1;
            int rightBound;
            if (rightBoundIndex >= indexes.get(vals[i]).size()) {
                rightBound = N;
            } else {
                rightBound = indexes.get(vals[i]).get(rightBoundIndex);
            }

            qrs[i][0] = i + 1;
            qrs[i][1] = rightBound - 1;
        }

        Arrays.sort(qrs, Comparator.comparingInt(x -> x[1]));

        int q = 0;
        int[] fen = new int[N + 1];
        int[] lastIndex = new int[Character.MAX_VALUE];
        Arrays.fill(lastIndex, -1);
        long answer = 0;

        for (int i = 0; i < N && q < qrs.length; i++) {
            if (lastIndex[vals[i]] >= 0) {
                for (int ind = lastIndex[vals[i]] + 1; ind <= N; ind += ind & -ind) {
                    fen[ind]--;
                }
            }

            lastIndex[vals[i]] = i;
            for (int ind = i + 1; ind <= N; ind += ind & -ind) {
                fen[ind]++;
            }

            while (q < qrs.length && qrs[q][1] == i) {
                for (int ind = qrs[q][1] + 1; ind > 0; ind -= ind & -ind) {
                    ans += fen[ind];
                }

                for (int ind = qrs[q][0]; ind > 0; ind -= ind & -ind) {
                    ans -= fen[ind];
                }

                q++;
            }
        }

        System.out.println(ans);

        br.close();
    }
}
