- Inspired by: [BOJ 1018](https://www.acmicpc.net/problem/1018) (Silver III)

- Problem type: Brute-force / Implementation

- Goal:
  Find the minimum number of repaint operations required.

- Summary:
  Given a board of 'W' and 'B' cells, determine the minimum repaint operations needed to convert any 8×8 section into a valid checkerboard.

- Input format:
  - The first line contains two integers representing the board dimensions.
  - The following lines describe the board.

- Output:
  - The minimum number of repaint operations.

---
<details>
  <summary>- Solution approach:</summary>
  <pre>
  1. Read the board dimensions and the board rows from input.
  2. Store the two checkerboard row patterns in advance:
   - one row starting with 'W',
   - and the other starting with 'B'.
  3. Use `patternType` to switch between the two possible checkerboard types
    instead of constructing separate 8×8 boards.
  4. Iterate over every possible top-left position of an 8×8 section.
  5. For each section, compare the original board directly
    against the expected pattern without slicing or copying the section
    into a new board.
  6. Use `(y + patternType) % 2` to choose which checkerboard row pattern should be matched at the current row.
  7. Count how many cells differ inside the current 8×8 section.
  8. After finishing one section, update the minimum repaint count immediately.
  9. Print the smallest repaint count found.
  </pre>
</details>