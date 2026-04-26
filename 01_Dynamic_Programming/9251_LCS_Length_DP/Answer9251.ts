const [s1, s2] = `${require('fs').readFileSync(0)}`.split(`
`)
const s1Length = s1.length
const s2Length = s2.length
let tmpRow = new Array(s1Length + 1).fill(0)
for(let y = 1; y <= s2Length; y++){
  let diagonalX = 0
  for(let x = 1; x <= s1Length; x++){
    const upperX = tmpRow[x]
    tmpRow[x] = s1[x - 1] === s2[y - 1] ?
        diagonalX + 1 :
        tmpRow[x - 1] > tmpRow[x] ? tmpRow[x - 1] : tmpRow[x]
    diagonalX = upperX
  }
}

console.log(tmpRow[s1Length])