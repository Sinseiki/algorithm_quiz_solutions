m, n = map(int, input().split(' '))
a = [1] * n
i = 2
while i <= n/i:
  if a[i - 1] == 1:
    for j in range(i, int(n/i) + 1): a[i * j - 1] = 0
  i += 1
for i in range(([1, m - 1][m > 1]), n):
  if a[i] > 0: print(i + 1)