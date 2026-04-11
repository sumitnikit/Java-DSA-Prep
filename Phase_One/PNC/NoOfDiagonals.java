package PNC;
import java.io.*;
import java.util.*;

public class NoOfDiagonals {
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
        int t = nextInt();       // change to nextInt() for multiple test cases
        while (t-- > 0) solve();
        out.print(sb);
        out.flush();
    }

    static void solve() throws Exception {
        long n = nextLong();
        long ans = ((n*(n-1))/2)%MOD;
        long ans1 = n*(n-1)%MOD;
        ans1 = ans1*(n-2)%MOD;
        ans1 = ans1*(n-3)%MOD;
        ans1 = ans1 *binPow(24, MOD-2)%MOD;
        long finaal = (ans + ans1+1)%MOD;
        sb.append((((finaal-n)%MOD)+MOD)%MOD).append("\n");
       
    }
    static long binPow(long base, long power){
        long res =1;
        base%=MOD;
        while(power>0){
            if((power&1)==1){
                res=res*base%MOD;

            }
            base = base*base%MOD;
            power>>=1;
        }
        return res;
    }
}
