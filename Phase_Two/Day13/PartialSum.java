package Phase_Two.Day13;

import java.io.*;
import java.util.*;

public class PartialSum {
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
        int n=nextInt();
        int m = nextInt();
        int q = nextInt();
        long[][] arr =new long[n+2][m+2];
        while(q-->0){
            int x1=nextInt();
            int y1 = nextInt();
            int x2 = nextInt();
            int y2 = nextInt();
            int c = nextInt();
            arr[x1][y1]+=c;
            arr[x2+1][y1]-=c;
            arr[x1][y2+1]-=c;
            arr[x2+1][y2+1]+=c;
        }
        long max =Integer.MIN_VALUE;
        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){
                arr[i][j]+=arr[i][j-1]+arr[i-1][j]-arr[i-1][j-1];
                max = Math.max(max, arr[i][j]);
            }
        }
        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){
                arr[i][j] =(arr[i][j]==max)?1:0; 
            }
        }
        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){
                arr[i][j]+=arr[i][j-1]+arr[i-1][j]-arr[i-1][j-1];
            }
        }
        sb.append(max+" ").append(arr[n][m]).append("\n");
    }
}
