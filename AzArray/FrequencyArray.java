/*
Frequency Array
Time Limit : 
1 sec
Memory Limit : 
256000 MB
Description
Given 
2
2 numbers 
N
N, 
M
M and an array 
A
A of 
N
N numbers. For every number from 
1
1 to 
M
M, print how many times this number appears in this array.

Input Format
The first line contains 
T
T, the number of test cases.
For each test case:
The first line contains two space separated integers 
N
N and 
M
M.
The second line contains 
N
N space separated integers each denoting an element of the array 
A
A.

Output Format
Print 
M
M lines, the 
i
t
h
i 
th
  line should contain number of times that the number 
i
i appears in 
A
A.

Constraints
1
≤
T
≤
10
1≤T≤10
1
≤
N
,
M
≤
1
0
5
1≤N,M≤10 
5
 
1
≤
A
[
i
]
≤
M
1≤A[i]≤M

Sample Input 1
1
10 5
1 2 3 4 5 3 2 1 5 3
Sample Output 1
2
2
3
1
2
Note
Numbers from 
1
1 to 
5
5 appear in the array as follows:
1
1 appears 2 times in the array.
2
2 appears 2 times in the array.
3
3 appears 3 times in the array.
4
4 appears once in the array.
5
5 appears 2 times in the array.
*/
package AzArray;

import java.io.*;
import java.util.*;

public class FrequencyArray {
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
        int n = nextInt();
        int m = nextInt();
        int[] arr = new int[n];
        int[] freq = new int[100100];
        for(int i=0; i<n; i++){
            arr[i] =  nextInt();
            freq[arr[i]]++;
        }
        for(int i =0; i<=m; i++){
            sb.append(freq[i]).append("\n");
        }
    }
}