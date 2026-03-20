package Modulo;
import java.io.*;
import java.util.*;

public class power2 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringBuilder sb = new StringBuilder();
    
    static final long MOD = 1_000_000_007L;

    static String next() throws IOException {
        while (st == null || !st.hasMoreTokens())
            st = new StringTokenizer(br.readLine());
        return st.nextToken();
    }
    static int nextInt() throws IOException { return Integer.parseInt(next()); }
    static long nextLong() throws IOException { return Long.parseLong(next()); }
    static double nextDouble() throws IOException { return Double.parseDouble(next()); }
    static String nextLine() throws IOException {
        st = null;
        return br.readLine();
    }

    public static void main(String[] args) throws Exception {
        int t = nextInt();       // change to t = 1 for single test case problems
        while (t-- > 0) solve();
        out.print(sb);
        out.flush();
    }

  static void solve() throws Exception {
        long a = nextLong();
        long b = nextLong();
        long c = nextLong();
        long p = nextLong();
        if(b==0 && c!=0){
            sb.append("1").append("\n");
            return;
        }else if(a==0 ){
            sb.append("0").append("\n");
            return;
        }
        long res = binPow(b,c,p-1);
        long ans = binPow(a,((res%(p))+(p))%(p),p);
        sb.append(((ans%p)+p)%p).append("\n");
    }

    private static long binPow(long base, long power, long mod){
        long result = 1;
        base %=mod;
        while (power>0) {
            if((power&1)==1){
                result =((result%mod)*(base%mod))%mod;
            }
            base = ((base%mod)*(base%mod))%mod;
            power >>=1;
        }
        return result;
    }
}