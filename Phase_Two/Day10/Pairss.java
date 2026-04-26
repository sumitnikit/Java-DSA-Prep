package Phase_Two.Day10;

import java.io.*;
import java.security.Key;
import java.util.*;

public class Pairss {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringBuilder sb = new StringBuilder();

    // Constants
    static final long MOD = 1_000_000_007L;
    static final long MOD2 = 998_244_353L;
    static final int INF = (int) 1e9;
    static final long LINF = (long) 1e18;
    static final double EPS = 1e-9;

    // Local testing — change to false before submitting!
    static final boolean LOCAL = true;

    static String next() throws IOException {
        while (st == null || !st.hasMoreTokens())
            st = new StringTokenizer(br.readLine());
        return st.nextToken();
    }

    static int nextInt() throws IOException {
        return Integer.parseInt(next());
    }

    static long nextLong() throws IOException {
        return Long.parseLong(next());
    }

    static double nextDouble() throws IOException {
        return Double.parseDouble(next());
    }

    static char nextChar() throws IOException {
        return next().charAt(0);
    }

    static String nextLine() throws IOException {
        st = null;
        return br.readLine();
    }

    public static void main(String[] args) throws Exception {
        if (LOCAL) {
            br = new BufferedReader(new FileReader("../../input.txt"));
        }
        int t = nextInt(); // change to nextInt() for multiple test cases
        while (t-- > 0)
            solve();
        out.print(sb);
        out.flush();
    }

    static void solve() throws Exception {
        int n = nextInt();
        int x = nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = nextInt();
        }
        long count = 0;
        // TreeMap<Integer, Integer> map = new TreeMap<>();
        // for (int i = 0; i < n; i++) {
        //     Integer idx = map.higherKey(x - arr[i]);
        //     if (idx != null) {
        //         for (Map.Entry<Integer, Integer> mp : map.entrySet()) {
        //             if (mp.getKey() == idx) {
        //                 break;
        //             }
        //             count += mp.getValue();
        //         }
        //     } else {
        //         for (Map.Entry<Integer, Integer> mp : map.entrySet()) {

        //             count += mp.getValue();

        //         }
        //     }
        //     map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        // }
        // sb.append(2 * count).append("\n");
        Arrays.sort(arr);
        int i=0;int j=n-1;
        while(i<j)
    }
}