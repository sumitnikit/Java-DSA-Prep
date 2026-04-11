package ZInterestingIdeas;

import java.io.*;
import java.util.*;

public class StringScore {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringBuilder sb = new StringBuilder();

    static String next() throws IOException {
        while (st == null || !st.hasMoreTokens())
            st = new StringTokenizer(br.readLine());
        return st.nextToken();
    }
    static int nextInt() throws IOException { return Integer.parseInt(next()); }

    public static void main(String[] args) throws Exception {
        solve();
        out.print(sb);
        out.flush();
    }

    static void solve() throws Exception {
        int n = nextInt();
        String s = next();
        int score = 0;
        StringBuilder str = new StringBuilder(s);

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            if (c == 'V') {
                score += 5;
            } else if (c == 'W') {
                score += 2;
            } else if (c == 'X') {
                if (i == str.length() - 1) continue; // ignore if last
                str.deleteCharAt(i + 1);
            } else if (c == 'Y') {
                if (i == str.length() - 1) continue; // ignore if last
                char next = str.charAt(i + 1);
                str.deleteCharAt(i + 1);
                str.append(next);
            } else if (c == 'Z') {
                if (i >= str.length() - 1) continue; // ignore if last
                char next = str.charAt(i + 1);
                if (next == 'V') {
                    score /= 5;
                    str.deleteCharAt(i + 1);
                } else if (next == 'W') {
                    score /= 2;
                    str.deleteCharAt(i + 1);
                }
            }
        }
        sb.append(score);
    }
}