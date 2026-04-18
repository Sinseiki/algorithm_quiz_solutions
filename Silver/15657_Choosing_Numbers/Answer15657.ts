const [[totalLength, targetLength], numbers] = `${require('fs').readFileSync(0)}`.split('\n').map(it => it.split(' ').map(v => +v))
const sortedNumbers = numbers.sort((a, b) => a - b)
const resultSequences = []
const sequence = []
const dfs = (start, depth) => {
  if(depth > targetLength) {
    resultSequences.push(sequence.join(' '))
    return
  }
  for(let i = start; i < totalLength; i++) {
    sequence.push(sortedNumbers[i])
    dfs(i, depth + 1)
    sequence.pop()
  }
}
dfs(0, 1)
console.log(resultSequences.join('\n'));