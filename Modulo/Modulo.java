package Modulo;

import java.io.*;
import java.util.*;

public class Modulo{
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
        int t = 1;
        while (t-- > 0) solve();
        out.print(sb);
        out.flush();
    }

    static void solve() throws Exception {
        int n =nextInt();
        sb.append(n%5);
    }
    public static int power(int a, int b){
        if(b==0)return 1;
        if(b%2==1) {
            return a*power(a,b-1);
        }else{
            int temp = power(a,b/2);
            return temp*=temp;
        }
        
    }
    public static int power1(int a, int b){
        if(b==0)return 1;
        int temp =power(a,b/2);
        temp*=temp;
        if(b%2==1){
            temp = a*temp;
        }
        return temp;
        /*static long add(long a, long b) { return (a+b) % MOD; }
static long sub(long a, long b) { return (a-b+MOD) % MOD; }
static long mul(long a, long b) { return a%MOD * (b%MOD) % MOD; }
static long div(long a, long b) { return mul(a, modInverse(b, MOD)); }
static long modInverse(long a)  { return power(a, MOD-2, MOD); }
static long power(long b, long e, long m) {
    long r = 1L;
    for (b %= m; e > 0; e >>= 1, b = b*b%m)
        if ((e&1)==1) r = r*b%m;
    return r;
} */
    }
}
