package Phase_Two.Day14;

import java.io.*;
import java.util.*;

public class Practice1 {
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
        int n= nextInt();
        int m = nextInt();
        Map<Long,Integer> map = new HashMap<>();
        while(n-->0){
            int xi = nextInt();
            int u = nextInt();
            map.put(1L*xi*u,map.getOrDefault(1L*xi*u, 0)+1);
        }
        int ans =0;
        while(m-->0){
            int yi = nextInt();
            int v = nextInt();
            if(map.containsKey(1L*yi*v)){
                ans++;
                map.put(1L*yi*v,map.getOrDefault(1L*yi*v, 0)-1);
                if(map.get(1L*yi*v)==0)map.remove(1L*yi*v);
            }
            
        }
        sb.append(ans).append("\n");
    }
}
