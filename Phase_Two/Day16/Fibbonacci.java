package Phase_Two.Day16;

import java.io.*;
import java.util.*;

public class Fibbonacci {
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
    static final long[] fib = new long[46];

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
            br = new BufferedReader(new FileReader("../../input.txt"));
        }
        pre();
        int t = nextInt();       // change to nextInt() for multiple test cases
        while (t-- > 0) solve();
        out.print(sb);
        out.flush();
    }

    static void solve() throws Exception {
        long k = nextLong();
        int ans=0;
        while(k>0){
            int low = lower(k);
            if(fib[low]==k){
                ans++;
                break;
            }else{
                k-=fib[low-1];
                ans++;
            }
        }
        sb.append(ans).append("\n");

    }
    static int lower(long k){
        int l =0;
        int r = 45;
        while(l<r){
            int mid = (l+r-1)/2;
            if(fib[mid]<k)l=mid+1;
            else r = mid;
        }
        return r;
    }
    static void pre(){
        fib[0]=0;
        fib[1]=1;
        for(int i=2; i<46; i++){
            fib[i] = fib[i-1]+fib[i-2];
        }
    }
}
