package Array2D;

import java.io.*;
import java.util.*;

public class SearchInMatrix {

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

    static int nextInt() throws IOException {
        return Integer.parseInt(next());
    }

    static long nextLong() throws IOException {
        return Long.parseLong(next());
    }

    static double nextDouble() throws IOException {
        return Double.parseDouble(next());
    }

    static String nextLine() throws IOException {
        st = null;
        return br.readLine();
    }

    public static void main(String[] args) throws Exception {
        int t = 1;
        while (t-- > 0)
            solve();
        out.print(sb);
        out.flush();
    }

    static void solve() throws Exception {
        int n= nextInt();
        int m = nextInt();
        int[][] matrix = new int[n][m];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                matrix[i][j] = nextInt();
            }
        }
        int x =nextInt();
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(x == matrix[i][j]){
                    sb.append("will take number").append("\n");
                    return;
                }
                
            }
        }
        sb.append("will not take number").append("\n");
    }
}
