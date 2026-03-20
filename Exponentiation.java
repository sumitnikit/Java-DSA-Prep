import java.io.*;
import java.util.*;

public class Exponentiation {
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
    static final boolean LOCAL = false;

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
            br = new BufferedReader(new FileReader("../input.txt"));
        }
        int t = 1; // change to nextInt() for multiple test cases
        while (t-- > 0)
            solve();
        out.print(sb);
        out.flush();
    }

    static void solve() throws Exception {
        // long a = nextInt();
        // long b = nextInt();
        // sb.append(pow(a, b,MOD)).append("\n");
        long n = nextLong();
        long ans = pow(1378,n);
        sb.append((ans)%10);
    }

    // private static long binPow(long base, long power) {
    //     long result= 1;
    //     while(power>1){
    //         if((power%2)==1){
    //             result = result*base;
    //             sb.append(result);
    //         }

    //         base = base*base;
    //         power >>=1;
    //     }
    //     return result;
    // }

    private static long pow(long a, long b) {
    long result =1;
    while(b>0){
    if((b & 1)==1){
    result = result*a%10;
    }
    a=a*a%10;
    b >>= 1;
    }
    return result;
    }
}