package NumberTheory;

import java.io.*;
import java.util.*;

public class SegmentedSieve {
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
        long l = nextLong();
        long r = nextLong();
        int limit = (int)Math.sqrt(r);
        List<Integer> list = new ArrayList<>();
        List<Boolean> list1 = new ArrayList<>(Collections.nCopies(limit+1,true));
        for(int i=2; 1L*i*i<=r;i++){
            if(list1.get(i)){
                list.add(i);
                for(long j =1L*i*i; j<=limit;j+=i){
                    list1.set((int)j,false);
                }
            }
        }
        List<Boolean> list2 = new ArrayList<>(Collections.nCopies((int)(r-l+1),true));
        if(l==1)list2.set(0,false);

        for(long li:list){
            long cur_mul = ((l+li-1)/li)*li;
            cur_mul=Math.max(li*li,cur_mul);

            while(cur_mul<=r){
                list2.set((int)(cur_mul-l),false);
                cur_mul+=li;
            }
        }
        int count =0;
        for(long i=l; i<=r; i++){
            if(list2.get((int)(i-l))){
                count++;
                
            }
        }
        sb.append(count).append("\n");
        for(long i=l; i<=r; i++){
            if(list2.get((int)(i-l))){
                sb.append(i).append(" ");
                
            }
        }
    }
}
