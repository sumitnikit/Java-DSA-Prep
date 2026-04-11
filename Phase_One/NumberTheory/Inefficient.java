import java.io.*;
import java.util.*;

public class Inefficient {
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
        long l = nextLong();
        long r = nextLong();
        long m = nextLong();
        
        long tillR = sumFromOne(r,m);
       
        long tillL = sumFromOne(l-1, m);
        long ans=0;
        ans = (((tillR - tillL)%MOD)+MOD)%MOD;
        
        sb.append((ans)%MOD).append("\n");
    }
    static long sumFromOne(long r, long m){
        long count =r/m;
        long rem =(r%m);
        long res1 =0;
        long res2 =0;
        res1 = ((m%MOD)*((m-1)%MOD))%MOD;
        res1 = res1*binPow(2, MOD-2)%MOD;
        res1 = res1*count%MOD;
        res2 =((rem%MOD)*((rem+1)%MOD))%MOD;
        res2= res2*binPow(2, MOD-2)%MOD;
        return (res1+res2)%MOD;

        static long sumFromOne(long r, long m){
           
        
            long inv2 = (MOD + 1) / 2;
        
           
            long res1 = (m % MOD) * ((m - 1) % MOD) % MOD;
            res1 = res1 * inv2 % MOD;
        
            // multiply by number of cycles
            res1 = res1 * (count % MOD) % MOD;
        
            // remainder sum
            long res2 = (rem % MOD) * ((rem + 1) % MOD) % MOD;
            res2 = res2 * inv2 % MOD;
        
            return (res1 + res2) % MOD;
        }
    }
    static long binPow(long base, long power){
        long res =1;
        while(power>0){
            if((power&1)==1){
                res = res*base%MOD;
            }
            base =  base*base%MOD;
            power>>=1;
        }
        return res;
    }
}
