# Java-DSA-Prep
DSA in Java


import java.io.*;
import java.util.*;

public class Main {

    // ----------- Fast I/O -----------
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int nextInt() throws IOException {
        return Integer.parseInt(next());
    }

    static long nextLong() throws IOException {
        return Long.parseLong(next());
    }

    static String next() throws IOException {
        while (st == null || !st.hasMoreElements()) {
            st = new StringTokenizer(br.readLine());
        }
        return st.nextToken();
    }

    // ----------- Debugging -----------
    static void debug(Object... args) {
        for (Object obj : args) {
            System.out.print(obj + " ");
        }
        System.out.println();
    }

    static void printArray(int[] arr) {
        System.out.println(Arrays.toString(arr));
    }

    static void printList(List<?> list) {
        System.out.println(list);
    }

    static void printMap(Map<?, ?> map) {
        for (var e : map.entrySet()) {
            System.out.println(e.getKey() + " -> " + e.getValue());
        }
    }

    // ----------- Math Utils -----------
    static long binpow(long b, long p, long mod) {
        long ans = 1;
        b %= mod;
        while (p > 0) {
            if ((p & 1) == 1) ans = (ans * b) % mod;
            b = (b * b) % mod;
            p >>= 1;
        }
        return ans;
    }

    // ----------- Pair Class -----------
    static class Pair {
        int first, second;

        Pair(int f, int s) {
            first = f;
            second = s;
        }

        public String toString() {
            return "(" + first + ", " + second + ")";
        }
    }

    // ----------- Main -----------
    public static void main(String[] args) throws Exception {

        // Example input
        int n = nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = nextInt();
        }

        // Example usage
        printArray(arr);

        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        printList(list);

        debug("Value of n:", n);

        System.out.println(binpow(2, 10, 1000000007));
    }
}