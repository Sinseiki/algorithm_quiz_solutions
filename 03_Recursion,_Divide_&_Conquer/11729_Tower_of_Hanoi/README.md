- Inspired by: [BOJ 11729](https://www.acmicpc.net/problem/11729) (Gold IV)

- Problem type: Recursion / Divide and Conquer / Backtracking-style Output Construction

- Goal:
  Print the minimum number of moves required to solve the Tower of Hanoi,
  and output the exact sequence of moves.

- Summary:
  Given n disks stacked on rod 1 in decreasing size order,
  move the entire stack to rod 3 while following the Tower of Hanoi rules.
  Only one disk may be moved at a time, and a larger disk may never be placed on a smaller one.

- Input format:
    - The first line contains an integer n up to 20.

- Output:
    - The first line prints the minimum number of moves.
    - From the second line onward, print each move as two integers A and B,
      meaning move the top disk from rod A to rod B.

---
<details>
  <summary>- Solution approach:</summary>
  <pre>
  1. Read n from input.
  2. The minimum number of moves required for the Tower of Hanoi is given by the formula 2^n - 1,
   since solving the problem involves moving n-1 disks twice plus one move of the largest disk,
   which leads to the recurrence T(n) = 2T(n-1) + 1.
   Store this value as the first output line.
  3. Although it is possible to simulate the rods using arrays, it is unnecessary.
     We only need to print the sequence of moves, not maintain the actual state.
  4. Use a recursive function that receives:
   - the number of disks to move
   - the source rod
   - the destination rod
  5. Since the rods are numbered 1, 2, and 3,
    the remaining auxiliary rod can be computed as:
   - auxiliary = 6 - from - to
    because 1 + 2 + 3 = 6.
  6. Base case:
   - If n === 1, the only move is directly from the source rod to the destination rod.
   - Record that move in the result.
  7. Recursive case:
   - First move n - 1 disks from the source rod to the auxiliary rod.
   - Then move the largest remaining disk from the source rod to the destination rod.
   - Finally move the n - 1 disks from the auxiliary rod to the destination rod.
     ( For a visual demonstration of the movement process, see [this](https://sinseiki.github.io/tower-of-hanoi-autoplay/hanoi_pause.html). )
  8. Store every move as a string in the result instead of printing immediately.
    This avoids repeated console output overhead and allows all lines to be printed at once.
  9. After the recursion finishes, print the complete result.
  10. This works because the recursive structure exactly matches the only optimal way
    to move the largest disk:
   - all smaller disks must be moved away first,
   - then the largest disk moves once,
   - then the smaller disks are rebuilt on top of it.
  </pre>
</details>

- Visual reference (self-implemented):
  This visualization demonstrates how the recursive solution translates into
  step-by-step disk movements using timed DOM updates.
  https://sinseiki.github.io/tower-of-hanoi-autoplay/hanoi_pause.html