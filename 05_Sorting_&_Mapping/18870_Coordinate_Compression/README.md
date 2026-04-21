- Inspired by: [BOJ 18870](https://www.acmicpc.net/problem/18870) (Silver II)

- Problem type:
  Coordinate Compression / Sorting

- Goal:
  Replace each value with its relative rank among distinct values.

- Summary:
  A list of integers is given.
  Each value should be mapped to its rank when the distinct values are sorted.
  The rank of a value is defined as the number of distinct values smaller than it.

- Input format:
    - The first line contains the number of elements.
    - The second line contains the list of integers.

- Output:
    - Print the transformed values after applying coordinate compression.


<details>
  <summary>- Solution approach:</summary>
  <pre>
  1. Read the number of elements and the list of integers from input.
  2. Extract the distinct values (e.g., using a set-like structure).
   Since such structures do not preserve order,
   convert the values into a sortable collection and sort them.
  3. Assign a rank to each distinct value based on its position in the sorted list (i.e., the number of distinct values smaller than it).
  4. Use a mapping structure (e.g., a map or dictionary) to store the value-to-rank mapping.
  5. Iterate through the original list, look up each value in the mapping,
    and collect the corresponding ranks in order.
  6. Output the resulting sequence as space-separated values.
  </pre>
</details>
