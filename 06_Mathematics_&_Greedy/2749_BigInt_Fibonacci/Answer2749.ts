const n = Number(BigInt(`${require('fs').readFileSync(0)}`) % BigInt(1500000))
let f1 = 0
let f2 = 1

for(let i = 1; i < n; i++){
  const prev = f1
  f1 = f2
  f2 = (prev + f1) % 1000000
}
console.log(!n ? 0 : f2)