- Inspired by: [BOJ 9252](https://www.acmicpc.net/problem/9252) (Gold III)

- Problem type: 2D Dynamic Programming / Backtracking / String

- Goal: find the LCS length of two strings and reconstruct one valid LCS

- Input format:
    - Two uppercase strings given on separate lines

- Output:
    - The LCS length
    - One valid LCS string

<details>
  <summary>- Solution approach:</summary>
  <pre>
  1. Read the two strings and allocate a DP table with one extra row and column.
     The extra padding simplifies boundary conditions.
     (For a detailed explanation of the DP state definition,
      see [problem 9251: LCS length](https://github.com/Sinseiki/algorithm_quiz_solutions/blob/main/01_Dynamic_Programming/9251_LCS_Length/README.md).)

  2. Unlike problem 9251, this problem requires not only the LCS length
   but also one actual LCS string.
   Because of that, we must keep the full DP table for backtracking.

  3. The DP table uses one extra row and one extra column filled with 0.
   This padding represents the empty-prefix case
   and makes boundary handling simpler.

  4. Instead of using a nested 2D array,
   store the whole table in one flattened array.

   If a DP cell is conceptually at row r and column c,
   its index in the flat array is:

   r * s2LengthPlus1 + c

  5. Fill the DP table row by row.

   The loops iterate over the actual string indices:
    - `i` for `s1`
    - `j` for `s2`

   Then the compared result is stored at:

   dp[(i + 1) * s2LengthPlus1 + (j + 1)]

   So:
    - row `i + 1` corresponds to the prefix ending at `s1[i]`
    - column `j + 1` corresponds to the prefix ending at `s2[j]`

  6. Transition rule:

   - If `s1[i] == s2[j]`,
     take the diagonal value and add 1:

     dp[(i + 1, j + 1)] = dp[(i, j)] + 1

   - Otherwise,
     take the larger value between left and upper:

     dp[(i + 1, j + 1)] =
     max(dp[(i + 1, j)], dp[(i, j + 1)])

  7. After the table is fully filled,
   the last cell contains the LCS length.
   Print that value first.

  8. To reconstruct one LCS string,
   start from the bottom-right corner of the DP table.

   Here:
    - `i = s1LengthPlus1 - 1`
    - `j = s2LengthPlus1 - 1`

   At this stage, `i` and `j` are DP coordinates,
   not direct string indices.

  9. During backtracking:
    - If the current value is the same as the left cell, move left
    - Else if the current value is the same as the upper cell, move up
    - Otherwise, the current cell came from the diagonal,
      so the current characters belong to one LCS

  10. In that diagonal case,
   the matched characters are checked as:

   s1[i - 1] == s2[j - 1]

   This is because the DP table is shifted by one row and one column,
   while the strings themselves are 0-indexed.

   Since the trace runs from the end of the strings toward the beginning,
   matched characters are collected in reverse order.
   So each matched character is pushed into the result first,
   and the result is reversed at the end.

  11. Finally, reverse the collected result,
    join it into a string, and print the reconstructed LCS.
    
  The DP table construction takes O(nm) time,
  and backtracking takes O(n + m) in the worst case.
  Space complexity is O(nm),
  because reconstruction requires access to the full table.
  </pre>
</details>