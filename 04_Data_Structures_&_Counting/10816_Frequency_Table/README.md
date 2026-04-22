- Inspired by: [BOJ 10816](https://www.acmicpc.net/problem/10816) (Silver IV)

- Problem type: Data Structures / Hash Map (Frequency Counting)

- Goal: given a list of integers and a separate list of query values, determine how many times each query value appears in the original list, in the same order as the query list.

- Summarize:
  - Treat the first list as the data source
  - Treat the second list as queries
  - Count the frequency of each value in the first list
  - For each query value, return its frequency from the first list
  - Output results in the order of the query list

- Input format:
  - An integer N
  - A line containing N integers
  - An integer M
  - A line containing M integers

- Output:
  - For each query integer, print how many times it appears in the first list

<details>
  <summary>- Solution approach:</summary>
  <pre>
  1. Read the number of integers in the first list.
  2. Read the first list of integers.
  3. Read the number of query values.
  4. Read the query list.
  5. A brute-force approach would be to scan the entire first list
     for every query value and count matches one by one.
     However, this would take O(N × M), which is too slow for large inputs.
  6. Instead, build a frequency table while traversing the first list:
     - For each integer, increase its stored count by 1.
  7. Then process the query list in order:
     - For each query value, check its count in the frequency table.
     - If it exists, output that count.
     - Otherwise, output 0.
  8. Print all results in the original query order, separated by spaces.
  </pre>
</details>