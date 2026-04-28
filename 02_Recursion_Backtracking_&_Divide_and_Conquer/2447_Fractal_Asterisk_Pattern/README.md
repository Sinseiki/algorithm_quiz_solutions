- Inspired by: [BOJ 2447](https://www.acmicpc.net/problem/2447) (Gold V)

- Problem type: Divide and Conquer / Fractal Pattern

- Goal: print an `N x N` star pattern where the center block is recursively removed at each scale of 3

- Input format:
    - One integer `N`
    - `N` is a power of 3
  
- Output:
    - The recursive star pattern of size `N`


<details>
  <summary>- Solution approach (String Expansion):</summary>
  <pre>
  1. Read `N` from standard input.
  2. Start from the base pattern of size 3:
    ***
    * *
    ***
  3. Store the current pattern as a list of row strings.
  4. While the current size is smaller than `N`, expand each row
   into the next 3-times larger pattern.
  5. For each row in the current pattern:
    - the `t123` (top and bottom) sections are created by repeating the row 3 times
    - the `t456` (middle) section is created by placing a blank block between
      two copies of the row
  6. Combine the sections in this order:
    - `t123` (top)
    - `t456` (middle)
    - `t123` (bottom)
  7. Replace the current pattern with the newly expanded pattern.
  8. After reaching size `N`, print all rows joined by newline characters.
  - Time complexity is O(N^2), since the total amount of generated output
    is proportional to the final N x N pattern.
  - Space complexity is O(N^2), since the full pattern is stored in memory.
  - This approach is efficient in practice because it expands the pattern
    by copying row strings in blocks instead of checking every coordinate
    across recursive levels.
  </pre>
</details>

<details>
  <summary>- Solution approach (Coordinate Checking):</summary>
  <pre>
  - The coordinate-based approach was derived from the same recursive structure,
  but evaluates each position independently instead of explicitly constructing subproblems.
  1. Read `N` from standard input.
  2. Traverse every coordinate `(y, x)` directly in the `N x N` grid,
     constructing the output line by line to reduce memory usage.
  3. For each row, build a temporary string `line`.
  4. For each coordinate, copy `y` and `x` into temporary variables
   `tmpY` and `tmpX`, then repeatedly divide them by 3.
  5. At each step, check whether the current position falls into
   the center block of a 3 x 3 partition:
  - if `tmpY % 3 == 1` and `tmpX % 3 == 1`,
    that cell belongs to a blank region
  - append a space and stop checking further
  6. This determines whether the coordinate becomes blank at any
   recursive scale by shrinking the coordinates themselves.
   It directly reflects the self-similar structure of the pattern.
  7. If no level places the coordinate in a center block,
   append `*` to the current row.
  8. After completing one row, print the row immediately.
    - Time complexity is O(N^2 log N), since each of the N^2 cells
    may be checked across recursive levels.
    - Space complexity is reduced to O(N), since only one output row
    is constructed at a time.
    - Trade-off: Compared to the string-expansion approach, this method
    is slower due to repeated coordinate checks, but it uses less memory
    and makes the blank-region rule explicit in code.
  </pre>
</details>
