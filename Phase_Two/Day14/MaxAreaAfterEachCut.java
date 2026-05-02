package Phase_Two.Day14;

import java.io.*;
import java.util.*;

public class MaxAreaAfterEachCut {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringBuilder sb = new StringBuilder();

    // Constants
    static final long MOD  = 1_000_000_007L;
    static final long MOD2 = 998_244_353L;
    static final int  INF  = (int) 1e9;
    static final long LINF = (long) 1e18;
    static final double EPS = 1e-9;

    // Local testing — change to false before submitting!
    static final boolean LOCAL = true;

    static String next() throws IOException {
        while (st == null || !st.hasMoreTokens())
            st = new StringTokenizer(br.readLine());
        return st.nextToken();
    }
    static int nextInt() throws IOException { return Integer.parseInt(next()); }
    static long nextLong() throws IOException { return Long.parseLong(next()); }
    static double nextDouble() throws IOException { return Double.parseDouble(next()); }
    static char nextChar() throws IOException { return next().charAt(0); }
    static String nextLine() throws IOException {
        st = null;
        return br.readLine();
    }

    public static void main(String[] args) throws Exception {
        if (LOCAL) {
            br = new BufferedReader(new FileReader("../input.txt"));
        }
        int t = 1;       // change to nextInt() for multiple test cases
        while (t-- > 0) solve();
        out.print(sb);
        out.flush();
    }

    static void solve() throws Exception {
        int h =nextInt();
        int w = nextInt();
        int n = nextInt();
        TreeSet<Integer> set1 = new TreeSet<>();
        TreeSet<Integer> set2 = new TreeSet<>();
        TreeMap<Integer,Integer> map1 = new TreeMap<>();
        TreeMap<Integer,Integer> map2 = new TreeMap<>();
        map1.put(h, 1);
        map1.put(w, 1);
        set1.add(0);
        set1.add(h);
        set2.add(0);
        set2.add(w);
        while (n-->0) {
            char c = next().charAt(0);
            int x = nextInt();
            if(c=='H'){
                set1.add(x);
                map1.remove(set1.higher(x)-set1.lower(x));
                map1.put(x-set1.lower(x), 1);
                map1.put(set1.higher(x)-x, 1);
            }else{
                set2.add(x);
                map2.remove(set2.higher(x)-set2.lower(x));
                map2.put(x-set2.lower(x), 1);
                map2.put(set2.higher(x)-x, 1);
            }
            sb.append(1L*map1.lastKey()*map2.lastKey()).append(" ");
        }
    }
}
