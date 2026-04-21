const numbers=`${require('fs').readFileSync(0)}`.split('\n')[1].split(' ').map(v=>+v)
const ranks = {}
Array.from(new Set(numbers)).sort((a, b)=> a - b).forEach((it, i) => ranks[it] = i)
const result= []
for(const it of numbers) result.push(`${ranks[it]}`)
console.log(result.join(' '))