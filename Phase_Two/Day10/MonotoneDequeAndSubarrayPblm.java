package Phase_Two.Day10;

import java.io.*;
import java.util.*;

public class MonotoneDequeAndSubarrayPblm {
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
        int n = nextInt();
        int k = nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = nextInt();
        }
        // Deq dq = new Deq();
        // for (int i = 0; i < n; i++) {
        //     dq.insert(arr[i]);
        //     if (i >= k-1){
        //         sb.append(dq.printMax()).append(" ");
        //         dq.remove(arr[i-k+1]);
        //     }
                

        // }
        // sb.append("\n");
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0)+1);
            if(i>=k-1){
                sb.append(map.lastKey()).append(" ");
                map.put(arr[i-k+1], map.getOrDefault(arr[i-k+1], 0)-1);
                if(map.get(arr[i-k+1])==0)map.remove(arr[i-k+1]);
            }
        }sb.append("\n");
    }

    static class Deq {
        Deque<Integer> dq = new ArrayDeque<>();

        void insert(int x) {
            while (!dq.isEmpty()&&dq.peekLast() < x) {
                dq.pollLast();
            }
            dq.addLast(x);
        }

        public int printMax() {
           return dq.peekFirst();
        }

        void remove(int x) {
            if(dq.peekFirst()==x){
                dq.pollFirst();
            }
        }
        
    }
}
