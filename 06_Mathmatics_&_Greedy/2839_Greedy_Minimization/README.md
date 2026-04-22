- Inspired by: [BOJ 2839](https://www.acmicpc.net/problem/2839) (Silver IV)

- Problem type: Greedy / Mathematical (Linear Combination)

- Goal: find the minimum number of units to exactly form a given integer N using two fixed unit sizes.

- Summarize:
  - Use the larger unit first to minimize total count
  - Decrease its count step by step
  - Check if the remainder is divisible by the smaller unit
  - Return the first valid result, or -1 if none exists

- Input format:
  - A single integer N

- Output:
  - Minimum number of units, or -1 if impossible

<details>
  <summary>- Solution approach:</summary>
  <pre>
  1. Read the integer N from input.
  2. A brute-force approach would be to try all combinations of 3 and 5,
     but this leads to unnecessary repeated computations.
  3. Observe that using larger units (5) first generally minimizes the total count.
  4. Start from the maximum possible number of 5-unit usages, which is floor(N / 5).
  5. Decrease the count of 5-unit step by step:
     - For each count i, compute the remaining value: rest = N - 5 * i.
     - Check if the remainder can be exactly divided by 3.
  6. If rest % 3 === 0, a valid combination is found:
     - The total count is i + (rest / 3).
     - Print the result and terminate.
  7. If no valid combination exists after exhausting all cases, print -1.
  </pre>
</details>