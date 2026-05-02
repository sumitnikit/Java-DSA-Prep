package Phase_Two.Day16;

import java.io.*;
import java.util.*;

public class SolvingProblems {
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
        int n = nextInt();
        int[] arr = new int[n];
        long[] arrL = new long[n];
        long[] arrR = new long[n];
        for(int i=0; i<n; i++){
            arr[i] = nextInt();
        }
        arrL[0]=1;
        for(int i=1; i<n; i++){
            if(arr[i-1]>arr[i]){
                arrL[i] = arrL[i-1]+1;
            }else{
                arrL[i] = 1;
            }
        }

        arrR[n-1]=1;
        for(int i=n-2; i>=0; i--){
            if(arr[i]>arr[i+1]){
                arrR[i] = arrR[i+1]+1;
            }else{
                arrR[i] = 1;
            }
        }
        long ans =0;
        for(int i=0; i<n; i++){
            ans += Math.max(arrL[i], arrR[i]);
        }
        sb.append(ans).append("\n");
    }
    
}
