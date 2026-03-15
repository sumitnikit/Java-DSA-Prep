package TimeComplexity;

import java.io.*;
import java.util.*;

public class ThreeNo {
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
        int k = nextInt();
        int s = nextInt();
        int count=0;
        int minValueOfz= Math.max(0, s-2*k);
        int maxValueOfz = Math.min(s, k);

        // for(int x=0; x<=k; x++){
        //     for(int y=0; y<=k; y++){
        //         int rem = s-x-y;
        //         if(rem>=0&& rem<=k){
        //             count++;
        //         }
        //     }
        // }
        for(int i =minValueOfz; i<=maxValueOfz; i++){
            int rem = s-i;
            if(rem<=k){
                count+=k+1;
            }else{
                count+= k -(rem -k)+1;
            }
        }
        sb.append(count);

    }

    
}
