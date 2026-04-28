const n = +`${require('fs').readFileSync(0)}`

let t = [
  '***',
  '* *',
  '***'
]
let i = 3

while (i < n){
  const t123 = []
  const t456 = []
  for(const it of t){
    t123.push(it.repeat(3))
    t456.push(it + ' '.repeat(it.length) + it)
  }

  t = [...t123, ...t456, ...t123]
  i *= 3
}

console.log(t.join('\n'))