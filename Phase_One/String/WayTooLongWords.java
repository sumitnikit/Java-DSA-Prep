/*Way Too Long Words
Time Limit : 
1 sec
Memory Limit : 
256000 MB
Description
Given a string 
S
S. Print the original string if it's not too long, otherwise, print the special abbreviation.

Note: The string is called too long if its length is strictly more than 
10
10 characters. If the string is too long, then you have to print the string in the following manner:

Print the first character in the string.
Print the number of characters between the first and the last characters.
Print the last character in the string.
For example: "localization" will be "l10n", and "internationalization" will be "i18n".

Input Format
The first line contains an integer 
T
T denoting the number of test cases.
Each of the following 
T
T lines contains a string 
S
S.
It's guaranteed that 
S
S contains only lowercase Latin letters.

Output Format
For each test case, print the resulting string.

Constraints
1
≤
T
≤
100
1≤T≤100
1
≤
∣
S
∣
≤
100
1≤∣S∣≤100

Sample Input 1
4
word
localization
internationalization
pneumonoultramicroscopicsilicovolcanoconiosis
Sample Output 1
word
l10n
i18n
p43s
Sample Input 2
2
codeforces
algozenith
Sample Output 2
codeforces
algozenith
Sample Input 3
5
arijit
biswas
arijitbiswas
biswasarijit
arijitarijitbiswasbiswas
Sample Output 3
arijit
biswas
a10s
b10t
a22s
Note
In the first test case:

"word" is not too long (length 4 ≤ 10), so we print it as is.
"localization" has length 12 > 10, so we abbreviate it to "l10n".
"internationalization" has length 20 > 10, abbreviated as "i18n".
"pneumonoultramicroscopicsilicovolcanoconiosis" has length 45 > 10, abbreviated as "p43s". In the second test case:
"arijit" and "biswas" are not too long, so we print them as is.
"arijitbiswas" has length 12 > 10, abbreviated as "a10s".
"biswasarijit" has length 12 > 10, abbreviated as "b10t".
"arijitarijitbiswasbiswas" has length 24 > 10, abbreviated as "a22s". In the third test case:
Both "codeforces" and "algozenith" are not too long (lengths 10 and 10), so we print them as is. */

package String;

import java.io.*;
import java.util.*;

public class WayTooLongWords {
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
    static int nextInt() throws IOException { return Integer.parseInt(next()); }
    static long nextLong() throws IOException { return Long.parseLong(next()); }
    static double nextDouble() throws IOException { return Double.parseDouble(next()); }
    static String nextLine() throws IOException {
        st = null;
        return br.readLine();
    }

    public static void main(String[] args) throws Exception {
        int t = 1;
        while (t-- > 0) solve();
        out.print(sb);
        out.flush();
    }

    static void solve() throws Exception {
        String s = next();
        if(s.length()>10){
            sb.append(s.charAt(0)).append(s.length()-2).append(s.charAt(s.length()-1)).append("\n");
        }else{
            sb.append("s").append("\n");
        }
    }
}
