- Inspired by: [BOJ 9020](https://www.acmicpc.net/problem/9020) (Silver II)

- Problem type: Math / Number Theory / Sieve of Eratosthenes / Two Pointers (center expansion)

- Goal: for each given even integer greater than 2, find two prime numbers whose sum equals that integer, and among all such pairs, output the pair with the smallest difference.

- Summarize:
    - Each test case gives one even integer
    - For that integer, find two primes whose sum is the target
    - If multiple prime pairs are possible, choose the pair closest to the center
    - Output the smaller prime first, then the larger prime

- Input format:
    - An integer n representing the number of test cases
    - n lines follow, each containing one even integer

- Output:
    - For each test case, print one Goldbach partition as two integers separated by a space
    - The printed pair must have the minimum difference among all valid prime pairs

<details>
  <summary>- Solution approach:</summary>
  <pre>
  1. Read the number of test cases.
  2. Store all target even numbers in an array.
  3. Prepare a prime table up to 10000 in advance.
  4. A naive approach would be:
     - For each test case, start with two values at the center (target / 2 and target / 2).
     - Repeatedly move outward symmetrically to examine candidate pairs whose sum is the target.
     - For each candidate number, test primality by dividing up to its square root.
     This works, but it repeats prime checks many times.
  5. Instead, use the Sieve of Eratosthenes once:
     - Create an integer array `primes` of size 10000, initially filled with 1.
     - Interpret 1 as “prime candidate” and 0 as “not prime”.
     - Set the value for number 1 to 0.
     - For each integer i starting from 2, if it is still marked as prime,
       mark all numbers of the form i × j as non-prime.
  6. For each target number:
     - Start with two values at the center: target / 2 and target / 2.
     - This center-first strategy ensures the smallest-difference pair is checked first.
  7. Repeatedly check whether both current numbers are marked as prime:
     - If they are, this is the correct Goldbach partition.
     - Otherwise, move outward symmetrically by decreasing a by 1
       and increasing b by 1.
  8. Append each result to `resultStr` and print everything at the end.
  </pre>
</details>