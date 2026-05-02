package Phase_Two.Day14;

import java.io.*;
import java.util.*;

public class Median {
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
        int t = 1; // change to nextInt() for multiple test cases
        while (t-- > 0)
            solve();
        out.print(sb);
        out.flush();
    }

    static void solve() throws Exception {
        Design d = new Design();
        d.insert(5);
        d.insert(1);
        d.insert(4);
        d.insert(2);
        d.insert(3);
        d.remove(1);
        d.remove(2);
        d.insert(6);
        sb.append(d.tmp1.size() +" "+ d.tmp2.size()+" ");
        sb.append(d.median());
    }

    static class Design {
        int cnt = 0;
        long sum = 0;
        long sumsq = 0;
        Map<Integer, Integer> map = new HashMap<>();
        TreeSet<int[]> set = new TreeSet<>((a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);
        TreeMap<Integer, Integer> tmp1 = new TreeMap<>();
        TreeMap<Integer, Integer> tmp2 = new TreeMap<>();

        void insert(int x) {
            sum += x;
            sumsq += (1L * x * x);
            int freq = map.getOrDefault(x, 0);
            if (freq > 0)
                set.remove(new int[] { freq, x });

            map.put(x, freq + 1);
            set.add(new int[] { map.getOrDefault(x, 0), x });

            if ((cnt & 1) == 1) {
                if (!tmp1.isEmpty() && tmp1.lastKey() < x) {
                    tmp2.put(x, tmp2.getOrDefault(x, 0) + 1);

                } else {
                    tmp2.put(tmp1.lastKey(), tmp2.getOrDefault(tmp1.lastKey(), 0) + 1);
                    tmp1.put(tmp1.lastKey(), tmp1.getOrDefault(tmp1.lastKey(), 0) - 1);
                    if (tmp1.get(tmp1.lastKey()) == 0)
                        tmp1.remove(tmp1.lastKey());
                    tmp1.put(x, tmp1.getOrDefault(x, 0) + 1);
                }
            } else {
                if (!tmp2.isEmpty() && tmp2.firstKey() < x) {
                    tmp1.put(tmp2.firstKey(), tmp1.getOrDefault(tmp2.firstKey(), 0) + 1);
                    tmp2.put(tmp2.firstKey(), tmp2.getOrDefault(tmp2.firstKey(), 0) - 1);
                    if (tmp2.get(tmp2.firstKey()) == 0)
                        tmp2.remove(tmp2.firstKey());
                    tmp2.put(x, tmp2.getOrDefault(x, 0) + 1);
                } else {
                    tmp1.put(x, tmp1.getOrDefault(x, 0) + 1);
                }
            }
            cnt++;

        }

        void remove(int x) {
            if (!map.containsKey(x))
                return;
            sum -= x;
            sumsq -= (1L * x * x);
            int freq = map.getOrDefault(x, 0);
            set.remove(new int[] { map.get(x), x });
            if (freq == 1) {
                map.remove(x);
            } else {
                map.put(x, map.getOrDefault(x, 0) - 1);
                set.add(new int[] { map.getOrDefault(x, 0), x });
            }

            if ((cnt & 1) == 1) {
                if (!tmp1.isEmpty() && tmp1.containsKey(x)) {
                    tmp1.put(x, tmp1.getOrDefault(x, 0) - 1);
                    if (tmp1.get(x) == 0)
                        tmp1.remove(x);

                } else if (!tmp2.isEmpty() && tmp2.containsKey(x)) {
                    tmp2.put(x, tmp2.getOrDefault(x, 0) - 1);
                    if (tmp2.get(x) == 0)
                        tmp2.remove(x);
                    tmp2.put(tmp1.lastKey(), tmp2.getOrDefault(tmp1.lastKey(), 0) + 1);
                    tmp1.put(tmp1.lastKey(), tmp1.getOrDefault(tmp1.lastKey(), 0) - 1);
                    if (tmp1.get(tmp1.lastKey()) == 0)
                        tmp1.remove(tmp1.lastKey());
                }
            } else {
                if (!tmp1.isEmpty() && tmp1.containsKey(x)) {
                    tmp1.put(x, tmp1.getOrDefault(x, 0) - 1);
                    if (tmp1.get(x) == 0)
                        tmp1.remove(x);
                    tmp1.put(tmp2.firstKey(), tmp1.getOrDefault(tmp2.firstKey(), 0) + 1);
                    tmp2.put(tmp2.firstKey(), tmp2.getOrDefault(tmp2.firstKey(), 0) - 1);
                    if (tmp2.get(tmp2.firstKey()) == 0)
                        tmp2.remove(tmp2.firstKey());

                } else if (!tmp2.isEmpty() && tmp2.containsKey(x)) {
                    tmp2.put(x, tmp2.getOrDefault(x, 0) - 1);
                    if (tmp2.get(x) == 0)
                        tmp2.remove(x);
                }
            }

            cnt--;

        }

        double mean() {
            return sum / (double) cnt;
        }

        double variance() {
            return sumsq / (double) cnt - (mean() * mean());
        }

        int mode() {
            return set.last()[1];
        }

        double median() {

            if ((cnt & 1) != 1)
                return (tmp1.lastKey() + tmp2.firstKey()) / 2.0;
            else
                return tmp1.lastKey();
        }
    }

}
