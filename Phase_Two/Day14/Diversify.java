package Phase_Two.Day14;

import java.io.*;
import java.util.*;

public class Diversify {
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
        int n = nextInt();
        int k = nextInt();
        Map<Integer,Integer> map = new HashMap<>();
        
        int cur_sum =n;
        // TreeSet<int[]> set = new TreeSet<>((a,b)->a[0]!=b[0]?a[0]-b[0]:a[1]-b[1]);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[0]!=b[0]?a[0]-b[0]:a[1]-b[1]);
        while (n-->0) {
            int x = nextInt();
            map.put(x, map.getOrDefault(x, 0)+1);
        }
        int ans =0;
        for(Map.Entry<Integer,Integer> mp : map.entrySet()){
            pq.add(new int[]{mp.getValue(),mp.getKey()});
            ans += (cur_sum-mp.getValue())*mp.getValue();
            cur_sum-=mp.getValue();
        }
        while(k-->0&&!pq.isEmpty()){
            if(!pq.isEmpty()){
                ans+=pq.peek()[0]-1;
                if(pq.peek()[0]-1<=1){
                    pq.poll();
                }else{
                    pq.add(new int[]{pq.peek()[0]-1,pq.peek()[1]});
                    pq.poll();
                }
                
            }
        }
        // for(Map.Entry<Integer,Integer> mp : map.entrySet()){
        //     set.add(new int[]{mp.getValue(),mp.getKey()});
        //     ans += (cur_sum-mp.getValue())*mp.getValue();
        //     cur_sum-=mp.getValue();
        // }
        // while(k-->0&&!set.isEmpty()){
        //     if(!set.isEmpty()){
        //         ans+=set.last()[0]-1;
        //         if(set.last()[0]-1<=1){
        //             set.remove(set.last());
        //         }else{
        //             set.add(new int[]{set.last()[0]-1,set.last()[1]});
        //             set.remove(set.last());
        //         }
                
        //     }
        // }
        // Map<Integer,Integer> map = new HashMap<>();
        // int cur_sum =n;
        // TreeSet<Integer> set = new TreeSet<>();
        // while (n-->0) {
        //     int x = nextInt();
        //     map.put(x, map.getOrDefault(x, 0)+1);
        // }
        // long ans =0;
        
        // for(Map.Entry<Integer,Integer> mp : map.entrySet()){
        //     set.add(mp.getValue());
        //     ans += (cur_sum-mp.getValue())*mp.getValue();
        //     cur_sum-=mp.getValue();
            
        // }
        // while(k-->0&&!set.isEmpty()){
        //     sb.append(set.size());
        //     if(!set.isEmpty()){
        //         ans+=set.last()-1;
                
        //         if(set.last()-1<=1){
        //             set.remove(set.last());
        //         }else{
        //             set.add(set.last()-1);
        //             set.remove(set.last());
        //         }
                
        //     }
        // }
        sb.append(ans).append("\n");
    }
}
