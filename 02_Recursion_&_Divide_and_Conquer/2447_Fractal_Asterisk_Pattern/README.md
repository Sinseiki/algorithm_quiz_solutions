- Inspired by: [BOJ 2447](https://www.acmicpc.net/problem/2447) (Gold V)

- Problem type: Divide and Conquer / Fractal Pattern

- Goal: print an `N x N` star pattern where the center block is recursively removed at each scale of 3

- Input format:
    - One integer `N`
    - `N` is a power of 3
  
- Output:
    - The recursive star pattern of size `N`
  
<details>
<summary>- Solution approach:</summary>
  <pre>
  1. Read `N` from standard input.
  2. A natural first idea is to construct the pattern recursively:
    ***
    * *
    ***
   and expand it to larger sizes.
   However, this approach repeatedly rebuilds large intermediate strings.
  3. Another idea is to build a 2D grid and progressively carve out
   the blank regions from smaller patterns to larger ones.
   However, this approach requires repeatedly scanning the entire grid
   at each scale, resulting in redundant computations.
  4. Instead, traverse every coordinate `(y, x)` directly in the `N x N` grid,
   constructing the output line by line.
  5. For each row, build a temporary string `line`.
  6. For each coordinate, copy `y` and `x` into temporary variables
   `tmpY` and `tmpX`, then repeatedly divide them by 3.
  7. At each step, check whether the current position falls into
   the center block of a 3 x 3 partition:
    - if `tmpY % 3 == 1` and `tmpX % 3 == 1`,
      that cell belongs to a blank region
    - append a space and stop checking further
  8. This effectively determines whether the coordinate becomes blank
   at any recursive scale, by shrinking the coordinates themselves.
   It directly reflects the self-similar structure of the pattern.
  9. If no level places the coordinate in a center block,
   append `*` to the current row.
  10. After completing one row, print the row immediately.
  - Time complexity is O(N^2 log N), since each of the N^2 cells
  may be checked across recursive levels.
  - Space complexity is reduced to O(N) by constructing and emitting
  each row on demand, instead of keeping the entire N x N buffer.
  </pre>
</details>