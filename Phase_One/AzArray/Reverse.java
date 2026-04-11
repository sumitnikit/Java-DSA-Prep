package AzArray;

import java.io.*;
import java.util.*;

public class Reverse {
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
        int n = nextInt();
        int[] arr = new int[n];

        for(int i=0; i<n; i++){
            arr[i]=nextInt();
        }

        int start=0;
        int end=n-1;

        while(start<=end){
            int temp =arr[start];
            arr[start] =arr[end];
            arr[end] =temp;
            start++;
            end--;
        }
        for(int i=0; i<n; i++){
            sb.append(arr[i]+" ");
        }
        sb.append("\n");

    }
}
