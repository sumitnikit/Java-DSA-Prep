package Phase_Two.Day17;

import java.io.*;
import java.util.*;

public class Stocks {
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
        // int n = nextInt();
        // int k = nextInt();
        // int[] arr = new int[n];
        // for(int i=0; i<n; i++){
        // arr[i]=nextInt();
        // }
        // int min =arr[0];
        // int max =arr[0];
        // long ans =0;
        // for(int i=1; i<n; i++){
        // if(arr[i]<arr[i-1]){

        // if(max-min>k){
        // ans+=max-min-k;
        // }
        // min =arr[i];
        // max = arr[i];
        // }
        // else{
        // max = arr[i];
        // }
        // }
        // if(max-min>k){
        // ans+=max-min-k;
        // }
        // sb.append(ans).append("\n");
        int n = nextInt();
        int k = nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = nextInt();
        }

       int ongoingSum=Integer.MIN_VALUE;
       int totalSumTill_i = 0;
       for(int i=0; i<n; i++){
        ongoingSum = Math.max(ongoingSum, totalSumTill_i-arr[i]);
        totalSumTill_i = Math.max(totalSumTill_i, ongoingSum+arr[i]-k);
       }
       sb.append(totalSumTill_i).append("\n");
    }
}
