const [numArr, ...strs] = `${require('fs').readFileSync(0)}`.split('\n')
const [n, m] = numArr.split(' ').map(v=>+v)
const strsSet = new Set(strs.slice(0, n))
let resultInt= 0
for(let i= n; i < n + m; i++) if(strsSet.has(strs[i])) resultInt++
console.log(resultInt)