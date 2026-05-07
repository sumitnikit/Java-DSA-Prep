package Phase_Two.Day17;

import java.io.*;
import java.util.*;

public class LightEmUp {
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
    static final boolean LOCAL = true;

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
            br = new BufferedReader(new FileReader("../../input.txt"));
        }
        int t = nextInt(); // change to nextInt() for multiple test cases
        while (t-- > 0)
            solve();
        out.print(sb);
        out.flush();
    }

    static void solve() throws Exception {
        int n = nextInt();
        int k = nextInt();
        int[] arr = new int[n];
        boolean hasZero = false;
        for (int i = 0; i < n; i++) {
            arr[i] = nextInt();
            if(arr[i]==0)hasZero=true;
        }
        if(k==0){
            if(hasZero)sb.append("-1\n");
            else sb.append("0\n");
            return;
        }

        int flip =0;
        long ans =0;
        int[] flipsArr = new int[n+1];
        for(int i=0; i<n; i++){
           flip += flipsArr[i];
           if((flip&1+arr[i])==0){
                if(i+k>n){
                    sb.append("-1\n");
                    return;
                }
                flipsArr[i+k]--;
                flip++;
                ans+=flip;
           }
        }
        sb.append(ans).append("\n");

        // long ans =0;

        // long temp=0;
        // for(int i=0; i<n; i++){
        // arr[i]= nextInt();
        // if(arr[i]==0){
        // temp++;
        // }else{
        // ans+=(temp+k-1)/k;
        // temp=0;
        // }
        // }
        // if(temp!=0)ans+=(temp+k-1)/k;
        // sb.append(ans).append("\n");
    }
}
