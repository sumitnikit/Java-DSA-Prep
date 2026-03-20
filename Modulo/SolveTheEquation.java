package Modulo;

import java.io.*;
import java.util.*;

public class SolveTheEquation {
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
        String first = next();
long a  = Long.parseLong(first.replace("(", ""));  // strip (
char o1 = nextChar();                               // reads operator
long b  = nextLong();                               // reads b
char o2 = nextChar();                               // reads operator
String last = next();
long c  = Long.parseLong(last.replace(")", ""));   // strip )
next();                                             // skip "mod"
long modulus = nextLong();                          // reads modulus
       
        if(o1=='*' || o1=='/'){
            b = apply(a,b,o1,modulus);
            sb.append(apply(b, c, o1, modulus)).append("\n");
        }else if(o2=='*' || o2=='/'){
            b = apply(b,c,o2,modulus);
            sb.append(apply(a, b, o2, modulus)).append("\n");
        }else{
            b = apply(a,b,o1,modulus);
            sb.append(apply(b, c, o1, modulus)).append("\n");
        }

        

    }
    public static long apply(long a, long b, char o1, long mod){
        if(o1 =='+') return (a%mod)+(b%mod);
        if(o1 =='-') return (a%mod)-(b%mod);
        if(o1 =='*') return (a%mod)*(b%mod);
        if(o1 =='/') return (a%mod)*(inverse(b,mod)%mod);
        return 0;
    }
    public static long inverse(long base, long mod){
        return binPow(base,mod-2,mod);
    }

    public static long binPow(long base, long power,long mod){
        long result =1;
        while(power>0){
            if((power&1)==1){
                result = (result%mod)*(base*mod)%mod;
            }
            base = (base%mod)*(base%mod)%mod;
            power >>=1;
            
        }
        return result;
    }
}
