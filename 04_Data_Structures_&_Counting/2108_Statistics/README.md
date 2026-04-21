- Inspired by: [BOJ 2108](https://www.acmicpc.net/problem/2108) (Silver II)

- Problem type: Sorting / Frequency counting / Implementation / Statistics

- Goal: compute the arithmetic mean, median, mode, and range of a list of integers

- Input format:
    - The first line contains an odd integer N, the number of values
    - The next N lines each contain one integer

- Output:
    - Arithmetic mean, rounded to the nearest integer
    - Median
    - Mode
        - If there are multiple modes, print the second smallest one
    - Range

<details>
  <summary>- Solution approach:</summary>
  <pre>
  1. Read N and the list of numbers from input.
  2. Sort the numbers in ascending order.
     - This allows the median to be found directly at the middle index.
     - It also makes the range easy to compute using the first and last values.
  3. Count how many times each number appears.
     - Use an object `countsObj` where each key is a number
       and each value is its frequency.
  4. Convert the frequency object into an array `countsArr` of [number, count] pairs.
  5. Sort `countsArr` with the following priority:
     - Higher frequency comes first
     - If frequencies are equal, smaller numbers come first
     This places the most frequent values at the front in ascending numerical order.
  6. The mode is determined from the first two elements of countsArr:
     - If only one value exists, that value is the mode.
     - Otherwise, if the first and second values have the same frequency,
       print the second one.
     - If not, print the first one.
     Since equal-frequency values were sorted in ascending order,
     this correctly gives the second smallest mode when multiple modes exist.
  7. Compute the arithmetic mean by summing all values and dividing by N.
     - Use `Math.round()` to round to the nearest integer.
     - In some languages, rounding a negative half value can produce `-0`,
       so convert `-0` to `0` before printing.
  8. The median is the middle element of the sorted array.
  9. The range is the difference between the largest and smallest values.
  10. Print the mean, median, mode, and range in order.
  </pre>
</details>