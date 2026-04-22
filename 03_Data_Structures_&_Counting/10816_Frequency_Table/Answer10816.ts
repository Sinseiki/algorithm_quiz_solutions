const [_, firstList, __, queryList] =`${require('fs').readFileSync(0)}`.split('\n')
    .map(l => l.split(' '))
const frequencyTable = {}
for(const it of firstList) {
  frequencyTable[it] = (frequencyTable[it] ?? 0) + 1
}
const resultArr = queryList.map(it=> frequencyTable[it] ?? 0)
console.log(resultArr.join(' '))