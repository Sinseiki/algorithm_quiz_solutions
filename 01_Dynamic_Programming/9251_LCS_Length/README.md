- Inspired by: [BOJ 9251](https://www.acmicpc.net/problem/9251) (Gold IV)

- Problem type: Dynamic Programming (2D state, 1D optimization) / String

- Goal: find the length of the longest subsequence that appears in both strings in the same relative order

- Input format:
    - Two uppercase strings, given on separate lines

- Output:
    - The length of the longest common subsequence

<details>
  <summary>- Solution approach:</summary>
  <pre>
  1. Read two strings from standard input.
  2. First, define what each DP state represents.
   Let dp[i][j] be the length of the longest common subsequence between:
    - the first i characters of the first string
    - the first j characters of the second string
   This means every cell represents a comparison between two prefixes.
  3. Example (BDCABA vs ABCBDAB):
   The DP table is constructed as follows:
  ...∅ A B C B D A B 
   ∅ 0 0 0 0 0 0 0 0
    B 0 0 1 1 1 1 1 1
    D 0 0 1 1 1 2 2 2
    C 0 0 1 2 2 2 2 2
    A 0 1 1 2 2 2 3 3
    B 0 1 2 2 3 3 3 4
    A 0 1 2 2 3 3 4 4
   Each row corresponds to a prefix of the first string,
   and each column corresponds to a prefix of the second string.
  4. Transition rule:
   - If the current characters match:
      dp[i][j] = dp[i-1][j-1] + 1
      (extend the subsequence from the diagonal)
   - If they do not match:
      dp[i][j] = max(dp[i-1][j], dp[i][j-1])
      (carry forward the best result from top or left)
   This rule works because:
    - Matching characters increase the subsequence length
    - Non-matching characters cannot contribute, so we reuse previous best results
   5. A full 2D DP table allows reconstruction of the actual LCS sequence like this 
      (https://github.com/Sinseiki/algorithm_quiz_solutions/blob/main/01_Dynamic_Programming/9252_LCS_Word/README.md).
    However, since this problem only requires the length,
    we do not need to store the entire table.
    Instead, we can keep only the current row,
    reducing the space complexity from O(nm) to O(n).
    We observe that: each row only depends on:
    - the previous row (dp[i-1][j])
    - the current row's left value (dp[i][j-1])
    - the previous diagonal (dp[i-1][j-1])
  6. Therefore, we can compress the DP table into a single row.
    Create a one-dimensional array `tmpRow` of size (s1Length + 1),
    initialized with 0.
  7. Iterate over the second string as the outer loop,
    and the first string as the inner loop.
  8. During iteration, track three values:
    - `tmpRow[x]` before update → dp[i-1][j] (upper)
    - `tmpRow[x-1]` → dp[i][j-1] (left)
    - `diagonalX` → dp[i-1][j-1] (diagonal)
  9. Update rule (same logic as 2D DP):
    - If characters match:
      tmpRow[x] = diagonalX + 1
    - Otherwise:
      tmpRow[x] = max(tmpRow[x], tmpRow[x-1])
  10. After updating, store the previous upper value into `diagonalX`
    so it can be used in the next iteration.
  11. After all iterations,
    `tmpRow[s1Length]` contains the final LCS length.
  - This approach preserves the original DP logic,
  while reducing space complexity from O(nm) to O(n).
  The time complexity remains O(nm).
  </pre>
</details>