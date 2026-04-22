const [n, ...nums]=`${require('fs').readFileSync(0)}`.trim().split('\n').map(v=>+v)
nums.sort((a, b)=> a - b)

const countsObj = nums.reduce((obj, num)=>{
  obj[num] ? obj[num]++ :obj[num] = 1
  return obj
},{})

const countsArr= []
for(let i in countsObj){
  countsArr.push([i, countsObj[i]])
}
countsArr.sort((a, b) => {
  if(a[1] === b[1]){
    return a[0] - b[0]
  } else {
    return b[1] - a[1]
  }
})
const ave = nums.reduce((d, e) => d + e, 0) / n
const roundAve = Math.round(ave)

let mode = 0
if(countsArr.length > 1){
  mode = countsArr[0][1] === countsArr[1][1] ? countsArr[1][0] : countsArr[0][0]
} else mode = countsArr[0][0]

console.log(
`${Object.is(-0, roundAve) ? 0 : roundAve}
${nums[n / 2 | 0]}
${mode}
${nums[n - 1] - nums[0]}`)