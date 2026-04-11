package Array2D;

import java.io.*;
import java.util.*;

public class DifferenceOfDiagonals {
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
        int[][] matrix = new int[n][n];
        int diag1 =0;
        int diag2 =0;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                matrix[i][j] = nextInt();
                if(i==j){
                    diag1+=matrix[i][j];
                }
                if(i+j ==n-1){
                    diag2+=matrix[i][j];
                }
            }
        }
        sb.append(Math.abs(diag1 - diag2)).append("\n");
    }
}
