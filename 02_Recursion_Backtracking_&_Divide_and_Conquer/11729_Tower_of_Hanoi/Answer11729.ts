const n = +require('fs').readFileSync(0)
const resultArr = [`${2 ** n - 1}`]

const recursionFn = (n, from, to) => {
  const auxiliary = 6 - from - to
  if(n === 1) {
    resultArr.push(`${from} ${to}`)
  } else {
    recursionFn(n - 1, from, auxiliary)
    resultArr.push(`${from} ${to}`)
    recursionFn(n - 1, auxiliary, to)
  }
}
recursionFn(n, 1, 3)

console.log(resultArr.join('\n'))