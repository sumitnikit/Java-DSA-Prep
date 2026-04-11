import java.io.*;
import java.util.*;

public class ZZZZZZ26March {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringBuilder sb = new StringBuilder();

    // Constants
    static final long MOD  = 1_000_000_007L;
    static final long MOD1  = 1_000_000_000L;
    static final long MOD2 = 998_244_353L;
    static final int  INF  = (int) 1e9;
    static final long LINF = (long) 1e18;
    static final double EPS = 1e-9;
    static final long[] fact = new long[1000100];
    static final long[] invFact = new long[1000100];
    

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
            br = new BufferedReader(new FileReader("input.txt"));
        }
        pre();
        int t = nextInt();       // change to nextInt() for multiple test cases
        while (t-- > 0) solve();
        out.print(sb);
        out.flush();
    }

    static void solve() throws Exception {
        int n = nextInt();
        
        long ans =1;
       for(int i=0; i<=n; i++){
        ans = fact[n]*invFact[i]%MOD;
       // sb.append("ans"+invFact[i]+"   "+invFact[i])
        ans = ans*invFact[n-i]%MOD;
        sb.append(ans).append(" ");
       }
       sb.append("\n");
        

    }
    private static void pre(){
        fact[0]=1;
        for(int i=1; i<=1000000; i++){
            fact[i] = fact[i-1]*i%MOD;
        }
        invFact[1000000] = inv(fact[1000000]);
        for(int i=1000000; i>0; i--){
            invFact[i-1]=i*invFact[i]%MOD;
        }
    }
    private static long inv(long base ){
        return binPow(base,MOD-2);
    }
    private static long binPow(long base , long power){
        long res =1L;
        base %=MOD;
        while(power>0){
            if((power&1)==1){
                res = base*res%MOD;
            }
            base = base *base%MOD;
            power>>=1;
        }
        return res;
    }
}
