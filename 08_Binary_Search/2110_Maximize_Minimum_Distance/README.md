- Inspired by: [BOJ 2110](https://www.acmicpc.net/problem/2110) (Gold IV)

- Problem type: Binary Search / Greedy / Sorting

- Goal: maximize the minimum distance between selected positions.

- Summary:
  Several available positions are given on a one-dimensional line.
  A fixed number of devices must be placed on these positions.
  Each position can contain at most one device.
  The objective is to place all devices so that the shortest distance between any two neighboring devices is as large as possible.

- Input format:
    - The first line contains the number of positions and the number of devices.
    - Each of the following lines contains one available position.

- Output:
    - Print the largest possible value of the minimum distance between neighboring devices.
<details>
  <summary>- Solution approach:</summary>
  <pre>
  1. Read the number of available positions and the number of elements to place.
    Then read all positions and sort them in ascending order.
  2. A first intuitive approach could be to choose ideal evenly spaced points
    between the minimum and maximum positions,
    then find the nearest available position around each ideal point.
    However, this is unreliable because elements can only be placed
    on the given positions, and the positions may be distributed very unevenly.
  3. Another possible approach is to calculate many distance combinations
    between positions and search among them.
    This is also inefficient because the number of possible pairwise distances
    can become too large when the number of positions is large.
  4. Instead, reinterpret the problem as a decision problem:
    for a given distance d, check whether it is possible
    to place the required number of elements
    so that every neighboring placed element is at least
   distance d apart.
  5. For this feasibility check, use a greedy scan:
    - Place the first element at the smallest position.
    - Move from left to right through the sorted positions.
    - Whenever the current position is at least d
      away from the previously selected position,
      place another element there.
    - Count how many elements can be placed.
  6. If at least the required number of elements can be placed,
    distance d is possible, so try a larger distance.
    If fewer elements can be placed, distance d is impossible,
    so try a smaller distance.
  7. Because the feasibility result is monotonic:
    - If distance d is possible, every smaller distance is also possible.
    - If distance d is impossible, every larger distance is also impossible.
      Use binary search over the distance range.
  8. Maintain two boundaries:
    - ableMax: the largest distance confirmed to be possible.
    - disableMin: the smallest distance boundary known to be impossible.
    Repeatedly test the middle distance between them.
  9. Stop when the two boundaries become adjacent.
     At that point, ableMax is the largest possible minimum distance.
  10. Output ableMax.
  </pre>
</details>