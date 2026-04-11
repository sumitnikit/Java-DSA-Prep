package AzArray;

import java.io.*;
import java.util.*;

public class Replacement {
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
        int t = nextInt();
        while (t-- > 0)
            solve();
        out.print(sb);
        out.flush();
    }

    static void solve() throws Exception {
        int n = nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            int x= nextInt();
            if(x==0){
                arr[i]=0;
            }else if(x>0){
                arr[i]=1;
            }else{
                arr[i]=2;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]+" ");
        }
        sb.append("\n");

    }

}
