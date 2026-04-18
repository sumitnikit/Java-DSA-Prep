package Phase_Two.Day8;

import java.io.*;
import java.util.*;

public class STLApplications {
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
            br = new BufferedReader(new FileReader("../../input.txt"));
        }
        int t = 1;       // change to nextInt() for multiple test cases
        while (t-- > 0) solve();
        out.print(sb);
        out.flush();
    }

    static void solve() throws Exception{
        int n = nextInt();int q = nextInt();
        int[] arr = new int[n];
        long[] brr = new long[n];
        for(int i =0; i<n; i++){
            arr[i]=nextInt();
        }
        Arrays.sort(arr);
        brr[0] = arr[0];
        for(int i =1; i<n; i++){
            brr[i]=arr[i]+brr[i-1];
        }

        while(q-->0){
            int x = nextInt();
            int idx = Arrays.binarySearch(brr, x);
            if(idx>=0){
                while(idx<n && brr[idx]==x)idx++;
                sb.append(idx).append("\n");
            }else{
                sb.append(-idx-1).append("\n");
            }
        }
        
        }
}
