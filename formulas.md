# CP Formulas Cheat Sheet

---

## Permutations & Combinations

```
nPr = n!/(n-r)!
nCr = n!/(r!(n-r)!)
nCr = nC(n-r)                    ← symmetry
nC0 = nCn = 1
nCr + nC(r+1) = (n+1)C(r+1)     ← Pascal's identity
```

---

## Binomial Theorem Identities

```
nC0 + nC1 + ... + nCn     = 2^n
nC0 - nC1 + nC2 - ...     = 0
nC0 + nC2 + nC4 + ...     = 2^(n-1)   ← even terms
nC1 + nC3 + nC5 + ...     = 2^(n-1)   ← odd terms
nC1 + 2*nC2 + 3*nC3 + ... = n*2^(n-1)
```

---

## Permutation Identities

```
nP1 + nP2 + ... + nPn     = floor(e*n!) - 1
nPr = nP(r-1) * (n-r+1)   ← iterative
nPn = n!
```

---

## Stars and Bars

```
x1+x2+...+xk = n (xi >= 0)  →  solutions = C(n+k-1, k-1)
x1+x2+...+xk = n (xi >= 1)  →  solutions = C(n-1,   k-1)
```

---

## Catalan Numbers

```
Cn = C(2n,n)/(n+1)
C0=1, C1=1, C2=2, C3=5, C4=14...

Used for:
→ valid bracket sequences
→ BST count
→ triangulation of polygon
→ mountain ranges
```

---

## Fibonacci

```
F(n) = F(n-1) + F(n-2)
F(0)=0, F(1)=1

Identities:
F(n)^2 + F(n+1)^2   = F(2n+1)
F(m+n)              = F(m)*F(n+1) + F(m-1)*F(n)
GCD(F(m), F(n))     = F(GCD(m,n))
```

---

## Modular Arithmetic

```
(a+b) % m   = ((a%m) + (b%m)) % m
(a-b) % m   = ((a%m) - (b%m) + m) % m
(a*b) % m   = ((a%m) * (b%m)) % m
(a/b) % m   = ((a%m) * inv(b)) % m
inv(a)      = a^(m-2) % m              ← Fermat (m must be prime)
a^(b^c) % m = a^(b^c % (m-1)) % m     ← tower power
```

---

## GCD & LCM

```
GCD(a,b)  = GCD(b, a%b)
LCM(a,b)  = a/GCD(a,b) * b    ← divide first to avoid overflow!
GCD(a,0)  = a
a*b       = GCD(a,b) * LCM(a,b)
```

---

## Inclusion Exclusion

```
|A∪B|     = |A|+|B|-|A∩B|
|A∪B∪C|   = |A|+|B|+|C|
            -|A∩B|-|B∩C|-|A∩C|
            +|A∩B∩C|
```

---

## Pigeonhole Principle

```
n items in k boxes:
→ at least one box has ≥ ceil(n/k) items

Used for:
→ proving existence of duplicates
→ birthday paradox
→ range problems
```

---

## Prime Numbers

```
Sieve of Eratosthenes  → all primes up to n in O(n log log n)
Prime factorization    → O(sqrt(n))
Number of divisors     → if n = p1^a1 * p2^a2...
                       → divisors = (a1+1)(a2+1)...
Sum of divisors        → (p1^(a1+1)-1)/(p1-1) * ...
Euler's totient φ(n)   → n * Π(1 - 1/p) for prime p|n
```

---

## Derangements

```
D(1) = 0
D(2) = 1
D(n) = (n-1) * (D(n-1) + D(n-2))
D(n) = n! * Σ((-1)^k / k!) for k=0 to n
     ≈ n!/e
```

---

## Arithmetic & Geometric Series

```
Arithmetic:
Sum = n*(first + last)/2
Sum = n*(2a + (n-1)d)/2

Geometric:
Sum = a*(r^n - 1)/(r-1)     r≠1
Sum = a/(1-r)                |r|<1 (infinite)

1+2+3+...+n      = n(n+1)/2
1²+2²+...+n²     = n(n+1)(2n+1)/6
1³+2³+...+n³     = (n(n+1)/2)²
```

---

## Bit Manipulation

```
Count set bits      → Integer.bitCount(n)
Check odd           → (n & 1) == 1
Lowest set bit      → n & (-n)
Remove lowest bit   → n & (n-1)
Power of 2 check    → (n & (n-1)) == 0
XOR 1 to n          → n%4==0 ? n : n%4==1 ? 1 : n%4==2 ? n+1 : 0
```

---

## Java Code Templates

```java
// nCr with MOD
static long nCr(long n, long r, long mod) {
    if(r > n) return 0;
    long num = 1, den = 1;
    for(long i = 0; i < r; i++){
        num = num * ((n-i) % mod) % mod;
        den = den * ((i+1) % mod) % mod;
    }
    return num * binPow(den, mod-2, mod) % mod;
}

// GCD
static long gcd(long a, long b){
    return b == 0 ? a : gcd(b, a%b);
}

// LCM
static long lcm(long a, long b){
    return a / gcd(a,b) * b;  // divide first to avoid overflow!
}

// Sieve of Eratosthenes
static boolean[] sieve(int n){
    boolean[] isComposite = new boolean[n+1];
    for(int i = 2; i*i <= n; i++)
        if(!isComposite[i])
            for(int j = i*i; j <= n; j+=i)
                isComposite[j] = true;
    return isComposite;
}

// Binary Exponentiation
static long binPow(long base, long power, long mod){
    long result = 1;
    base %= mod;
    while(power > 0){
        if((power & 1) == 1) result = result * base % mod;
        base = base * base % mod;
        power >>= 1;
    }
    return result;
}

// Modular Inverse (mod must be prime)
static long modInverse(long a, long mod){
    return binPow(a, mod-2, mod);
}

// Extended GCD (mod inverse for non-prime mod)
static long[] extGCD(long a, long b){
    if(b == 0) return new long[]{a, 1, 0};
    long[] r = extGCD(b, a%b);
    return new long[]{r[0], r[2], r[1]-(a/b)*r[2]};
}

// nPr iterative
static long nPr(long n, long r, long mod){
    long result = 1;
    for(long i = 0; i < r; i++)
        result = result * ((n-i) % mod) % mod;
    return result;
}

// Sum of nP1+nP2+...+nPn
static long sumPermutations(long n, long mod){
    long sum = 0, perm = 1;
    for(long r = 1; r <= n; r++){
        perm = perm * (n-r+1) % mod;
        sum = (sum + perm) % mod;
    }
    return sum;
}

// Catalan number
static long catalan(long n, long mod){
    return nCr(2*n, n, mod) * modInverse(n+1, mod) % mod;
}

// Euler's Totient
static long phi(long n){
    long result = n;
    for(long i = 2; i*i <= n; i++){
        if(n % i == 0){
            while(n % i == 0) n /= i;
            result -= result/i;
        }
    }
    if(n > 1) result -= result/n;
    return result;
}
```

---

## Modular Operations Template

```java
static long MOD = 1_000_000_007L;
static long add(long a, long b) { return ((a%MOD)+(b%MOD))%MOD; }
static long sub(long a, long b) { return ((a%MOD)-(b%MOD)+MOD)%MOD; }
static long mul(long a, long b) { return ((a%MOD)*(b%MOD))%MOD; }
static long div(long a, long b) { return mul(a, modInverse(b, MOD)); }
```

---

## Tower Power Template

```java
// a^(b^c) % p   where p is prime
static long towerPow(long a, long b, long c, long p){
    if(b == 0) return 1 % p;               // a^0 = 1
    if(a == 0 || a % p == 0) return 0;     // 0^x = 0
    long exp = binPow(b, c, p-1);          // exponent mod (p-1)
    return binPow(a, exp, p);
}
```

---

## Quick Reference

```
2^n          = sum of all nCr
e * n! - 1   = sum of all nPr
n(n+1)/2     = sum 1 to n
n(n+1)(2n+1)/6 = sum of squares
(n(n+1)/2)^2   = sum of cubes
C(n+k-1,k-1)   = stars and bars (zeros allowed)
C(n-1,k-1)     = stars and bars (ones minimum)
```
