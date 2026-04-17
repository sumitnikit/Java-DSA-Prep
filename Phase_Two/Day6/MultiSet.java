import java.io.*;
import java.util.*;

public class MultiSet {
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
        Map<Integer,Integer> map = new TreeMap<>();
        while(q-->0){
            String s = next();
            if(s.equals("add")){
                int x = nextInt();
                map.put(x, map.getOrDefault(x, 0)+1);
               
            }else if(s.equals("erase")){
                int x = nextInt();
                if(map.containsKey(x)){
                    map.put(x, map.getOrDefault(x, 0)-1);
                    if(map.getOrDefault(x, 0)==0){
                        map.remove(x);
                    }
                }
            }else if(s.equals("eraseall")){
                int x = nextInt();
                map.remove(x);
            }else if(s.equals("find")){
                int x = nextInt();
                if(map.containsKey(x)){
                    sb.append("YES\n");
                }else{
                    sb.append("NO\n");
                }
            }else if(s.equals("count")){
                int x = nextInt();
                sb.append(map.getOrDefault(x, 0)).append("\n");
            }else if(s.equals("print")){
               for(Map.Entry<Integer,Integer> mp : map.entrySet()){
                int x = mp.getValue();
                    while(x>0){
                        sb.append(mp.getKey()).append(" ");
                        x-=1;
                    }
               }
               sb.append("\n");
            }else{
                map.clear();
            }
        }
    }
}
