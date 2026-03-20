package Modulo;

import java.io.*;
import java.util.*;

public class SolveEq2 {
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
        String aDash = next();
        long a = Long.parseLong(aDash.replace("(", ""));
        char op1 = next().charAt(0);
        long b = nextLong();
        char op2 = next().charAt(0);
        String cDash = next();
        long c = Long.parseLong(cDash.replace(")", ""));
        next();
        long mod = nextLong();

        if(op1=='*' || op1 =='/'){
            b = operations(a, b, mod, op1);
            long ans = operations(b, c, mod, op2);
            sb.append(((ans%mod)+mod)%mod).append("\n");
        }else if(op2 =='*' || op2=='/'){
            b = operations(b, c, mod, op2);
            long ans = operations(a, b, mod, op1);
            sb.append(((ans%mod)+mod)%mod).append("\n");
        }else{
            b = operations(a, b, mod, op1);
            long ans = operations(b, c, mod, op2);
            sb.append(((ans%mod)+mod)%mod).append("\n");
        }
        
    }
    private static long operations(long b, long c, long mod, char op2){
        if(op2 == '+')return add(b,c,mod);
        if(op2 == '-')return sub(b,c,mod);
        if(op2 == '*')return mul(b,c,mod);
        if(op2 == '/')return inv(b,c,mod);
        return 0;
    }

    private static long add(long b, long c, long mod){
        return ((b%mod)+(c%mod))%mod;
    }
    private static long sub(long b, long c, long mod){
        long ans = ((b % mod) - (c % mod)) % mod;
        ans %= mod;
        ans = (ans + mod) % mod;
        return ans;
    }
    private static long mul(long b, long c, long mod){
        return ((b%mod)*(c%mod))%mod;
    }
    private static long inv(long b, long c, long mod){
        return ((b%mod)*(binPow(c,mod-2,mod))%mod)%mod;
    }
    private static long binPow(long base, long power, long mod){
        long result =1;
        base = base%mod;
        while(power>0){
            if((power&1) ==1){
                result = ((result%mod)*(base%mod))%mod;
            }
            base = ((base%mod)*(base%mod))%mod;
                power >>= 1;
            
        }
        return result;
    }
}
