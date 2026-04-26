const n = +require('fs').readFileSync(0)

for(let i = n/5|0; i >=0; i--){
  const rest = n - 5 * i
  if(rest % 3 === 0){
    console.log(i + rest / 3)
    break
  }
  if(i === 0) console.log(-1)
}