const [m,n] = `${require('fs').readFileSync(0)}`.split(' ').map(v=>+v)
const a = new Array(n).fill(1)
for(let i = 2; i <= n/i; i++) {
  if(!a[i - 1]) continue
  for(let j = i; j <= n/i; j++) a[i * j - 1] = 0
}
for(let i = (m - 1 || 1); i < n; i++) {
  if(a[i]) console.log(i + 1)
}