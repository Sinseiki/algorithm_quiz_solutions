- Inspired by: [BOJ 14425] (Silver IV)

- Goal: given a reference collection of strings and a list of candidate strings, determine how many of the candidates are present in the reference collection.

- Summarize:
  - Maintain a collection of unique strings as the reference dataset
  - Receive a separate list of strings to verify
  - Check each candidate string for membership in the reference dataset
  - Count how many candidates are found in the dataset
  - Output the total count

- Input format:
  - Two integers N and M
  - N lines, each containing a string (reference dataset)
  - M lines, each containing a string (candidates)

- Output:
  - A single integer representing how many candidate strings exist in the reference dataset

<details> 
  <summary>- Solution approach:</summary>
  <pre> 
  1. Read two integers N and M. 
  2. Read the next N strings and store them in a collection.
  3. Convert this collection into a hash-based set.
   - This allows average O(1) time complexity for membership checks.
  4. A naive approach would compare each of the M query strings against all N stored strings,
   resulting in O(N × M) time complexity. This is inefficient for large inputs.
  5. Instead of storing the M query strings, process them one by one:
   - For each query string:
     - Read the string from input
     - Check whether it exists in the set
     - If it exists, increment a counter
   6. After processing all M query strings, output the final count.
  </pre> 
</details>