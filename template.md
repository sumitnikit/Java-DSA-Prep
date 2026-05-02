import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringBuilder sb = new StringBuilder();

    // ===================== CONSTANTS =====================
    static final long MOD  = 1_000_000_007L;
    static final long MOD2 = 998_244_353L;
    static final int  INF  = (int) 1e9;
    static final long LINF = (long) 1e18;
    static final double EPS = 1e-9;

    // ===================== LOCAL TESTING =====================
    static final boolean LOCAL = false; // change to false before submitting!

    // ===================== INPUT METHODS =====================
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

    // ===================== MODULAR ARITHMETIC =====================
    static long addMod(long a, long b)  { return ((a % MOD) + (b % MOD)) % MOD; }
    static long subMod(long a, long b)  { return ((a % MOD) - (b % MOD) + MOD) % MOD; }
    static long mulMod(long a, long b)  { return ((a % MOD) * (b % MOD)) % MOD; }
    static long divMod(long a, long b)  { return mulMod(a, modInverse(b)); }

    // ===================== BINARY EXPONENTIATION =====================
    // Best method — iterative, O(1) space, no stack overflow risk
    static long binPow(long base, long exp, long mod) {
        long result = 1L;
        base %= mod;
        while (exp > 0) {
            if ((exp & 1) == 1) result = result * base % mod;
            base = base * base % mod;
            exp >>= 1;
        }
        return result;
    }

    // ===================== MODULAR INVERSE =====================
    // Use when MOD is prime (Fermat's Little Theorem)
    static long modInverse(long a) {
        return binPow(a, MOD - 2, MOD);
    }

    // Use when MOD is NOT prime (Extended Euclidean)
    static long[] extGCD(long a, long b) {
        if (b == 0) return new long[]{a, 1, 0};
        long[] r = extGCD(b, a % b);
        return new long[]{r[0], r[2], r[1] - (a / b) * r[2]};
    }
    static long modInverseAny(long a, long mod) {
        long[] r = extGCD(a, mod);
        if (r[0] != 1) return -1;           // inverse doesn't exist
        return (r[1] % mod + mod) % mod;    // always positive
    }

    // ===================== TOWER POWER =====================
    // a^(b^c) % p  where p is prime
    static long towerPow(long a, long b, long c, long p) {
        if (b == 0) return 1 % p;           // a^0 = 1
        if (a == 0 || a % p == 0) return 0; // 0^x = 0
        long exp = binPow(b, c, p - 1);     // exponent mod (p-1) by Fermat
        return binPow(a, exp, p);
    }

    // ===================== FACTORIALS & nCr =====================
    static final int MAXN = 1_000_001;
    static long[] fact    = new long[MAXN];
    static long[] invfact = new long[MAXN];

    // Precompute factorials and inverse factorials — call in main()!
    static void precompute() {
        fact[0] = 1;
        for (int i = 1; i < MAXN; i++)
            fact[i] = fact[i-1] * i % MOD;
        invfact[MAXN-1] = binPow(fact[MAXN-1], MOD-2, MOD);
        for (int i = MAXN-2; i >= 0; i--)
            invfact[i] = invfact[i+1] * (i+1) % MOD;
    }

    // Approach 6 — O(1) per query (needs precompute, n,r <= 10^6)
    static long nCr(int n, int r) {
        if (r < 0 || r > n) return 0;
        return fact[n] * invfact[r] % MOD * invfact[n-r] % MOD;
    }

    // Approach 2 — O(r) per query (works for n up to 10^9, r <= 20)
    static long nCrLarge(long n, long r) {
        if (r > n) return 0;
        long num = 1, den = 1;
        for (long i = 0; i < r; i++) {
            num = num * ((n - i) % MOD) % MOD;
            den = den * ((i + 1) % MOD) % MOD;
        }
        return num * modInverse(den) % MOD;
    }

    // Approach 4 — Pascal's triangle (use when MOD is NOT prime, n <= 1000)
    static long[][] pascal = new long[1001][1001];
    static void buildPascal(long mod) {
        pascal[0][0] = 1 % mod;
        for (int i = 1; i <= 1000; i++) {
            pascal[i][0] = 1 % mod;
            for (int j = 1; j <= i; j++)
                pascal[i][j] = (pascal[i-1][j-1] + pascal[i-1][j]) % mod;
        }
    }

    // nPr — O(r)
    static long nPr(long n, long r) {
        if (r > n) return 0;
        long result = 1;
        for (long i = 0; i < r; i++)
            result = result * ((n - i) % MOD) % MOD;
        return result;
    }

    // ===================== GCD & LCM =====================
    static long gcd(long a, long b) { return b == 0 ? a : gcd(b, a % b); }
    static long lcm(long a, long b) { return a / gcd(a, b) * b; } // divide first!

    // ===================== SIEVE OF ERATOSTHENES =====================
    static boolean[] sieve(int n) {
        boolean[] isComposite = new boolean[n + 1];
        for (int i = 2; (long)i * i <= n; i++)
            if (!isComposite[i])
                for (int j = i * i; j <= n; j += i)
                    isComposite[j] = true;
        return isComposite;
        // isComposite[i] = true  → i is NOT prime
        // isComposite[i] = false → i IS prime
    }

    // ===================== GRID DIRECTIONS =====================
    // 4 directions (up, down, left, right)
    static int[] dx4 = {-1,  0,  0,  1};
    static int[] dy4 = { 0, -1,  1,  0};

    // 8 directions (including diagonals)
    static int[] dx8 = {-1, -1, -1,  0,  0,  1,  1,  1};
    static int[] dy8 = {-1,  0,  1, -1,  1, -1,  0,  1};

    // ===================== APPLY OPERATOR =====================
    static long apply(long a, long b, char op, long mod) {
        if (op == '+') return ((a % mod) + (b % mod)) % mod;
        if (op == '-') return ((a % mod) - (b % mod) + mod) % mod;
        if (op == '*') return ((a % mod) * (b % mod)) % mod;
        if (op == '/') return ((a % mod) * binPow(b, mod-2, mod)) % mod;
        return 0;
    }

    // ===================== MAIN =====================
    public static void main(String[] args) throws Exception {
        if (LOCAL) {
            br = new BufferedReader(new FileReader("input.txt"));
        }
        precompute();                    // precompute factorials
        int t = 1;                       // change to nextInt() for multiple test cases
        while (t-- > 0) solve();
        out.print(sb);
        out.flush();
    }

    // ===================== SOLVE =====================
    static void solve() throws Exception {
        // your code here
        // output      → sb.append(answer).append("\n")
        // two values  → sb.append(a + " " + b).append("\n")
    }

    // 2 ints → long key
long key = ((long)a << 32) | (b & 0xFFFFFFFFL);

// decode back
int a = (int)(key >> 32);
int b = (int)(key);

// 2 longs or triplet → String key  
String key = a + "," + b;
String key = a + "," + b + "," + c;
}