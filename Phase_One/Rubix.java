import java.io.*;
import java.util.*;

public class Rubix {
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
    static final boolean LOCAL = false;

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
            br = new BufferedReader(new FileReader("input.txt"));
        }
        int t = 1;       // change to nextInt() for multiple test cases
        while (t-- > 0) solve();
        out.print(sb);
        out.flush();
    }

    static void solve() throws Exception {
        int k = nextInt();
        long twok = binPow(2,k,MOD-1);
        
        twok = ((((twok-2)%(MOD-1))+(MOD-1))%(MOD-1));
        long fourP = binPow(4, twok, MOD);
        sb.append(fourP*6%MOD);
    }

    static long binPow(long base, long power,long mod){
        long res =1;
        while(power>0){
            if((power&1)==1){
                res = res*base%(mod);
            }
            base = base*base%(mod);
            power>>=1;
        }
        return res;
    }
}