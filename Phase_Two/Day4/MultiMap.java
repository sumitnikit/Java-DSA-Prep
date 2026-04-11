package Phase_Two.Day4;

import java.io.*;
import java.util.*;

public class MultiMap {
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
        int t = nextInt();       // change to nextInt() for multiple test cases
        while (t-- > 0) solve();
        out.print(sb);
        out.flush();
    }

    static void solve() throws Exception {
        int q=nextInt();
        Map<String,List<Integer>> map = new HashMap<>();
        while(q-->0){
            String s = next();
            if(s.equals("add")){
                String x =next();
                int y=nextInt();
                map.computeIfAbsent(x, t -> new ArrayList<>()).add(y);
            }else if(s.equals("erase")){
                String x =next();
                List<Integer> li = map.getOrDefault(x,null);
                if(li!=null && !li.isEmpty()){
                    li.remove(0);
                    if(li.isEmpty())map.remove(x);
                }
            }else if(s.equals("eraseall")){
                String x =next();
                map.remove(x);
            }else{
                String x =next();
                List<Integer> li = map.getOrDefault(x,null);
                if(li==null && li.isEmpty() )sb.append(0).append("\n");
                else sb.append(li.get(0)).append("\n");
            }
        }
    }
}
