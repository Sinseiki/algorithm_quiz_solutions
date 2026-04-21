- Inspired by: [BOJ 2749](https://www.acmicpc.net/problem/2749) (Gold II)

- Problem type: Math / Dynamic Programming / Pisano Period

- Goal:
  Compute the n-th Fibonacci number modulo 1,000,000.

- Summary:
  Given a very large n, find the n-th Fibonacci number modulo 1,000,000.
  Since n can be as large as 10^18, the sequence must be reduced using the Pisano period.

- Input format:
  - The first line contains a natural number n.

- Output:
  - The value of F(n) modulo 1,000,000.

---
<details>
  <summary>- Solution approach:</summary>
  <pre>
  1. Read n from input as BigInt, since the input size can exceed the safe integer range of JavaScript Number.
  2. Use the Pisano period for modulo 1,000,000, which is 1,500,000.
  3. Reduce n by computing n % 1,500,000, because Fibonacci numbers modulo 1,000,000 repeat with that period.
  4. Initialize two variables to represent consecutive Fibonacci values:
   - f1 = F(0)
   - f2 = F(1)
  5. Iterate from 1 up to n - 1, updating the pair step by step.
  6. At each step, compute the next Fibonacci value with modulo 1,000,000 applied immediately
    so the numbers never grow too large.
  7. This works because
    (a + b) % m = ((a % m) + (b % m)) % m,
    so taking the modulo during the recurrence preserves the correct final remainder.
  8. Handle n = 0 separately, since the loop structure assumes F(1) is already prepared.
  9. Print the resulting Fibonacci value modulo 1,000,000.
  </pre>
</details>