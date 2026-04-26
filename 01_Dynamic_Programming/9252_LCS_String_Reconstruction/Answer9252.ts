const [s1, s2] = `${require('fs').readFileSync(0)}`.split(`
`)
const [s1LengthPlus1, s2LengthPlus1] = [s1.length + 1, s2.length + 1]
const dp = Array(s1LengthPlus1 * s2LengthPlus1).fill(0)
for(let i = 0; i < s1LengthPlus1 - 1; i++){
  for(let j = 0; j < s2LengthPlus1 - 1; j++){
    dp[(i + 1) * s2LengthPlus1 + j + 1] =
        s1[i] === s2[j] ?
            dp[i * s2LengthPlus1 + j] + 1 :
            (dp[(i + 1) * s2LengthPlus1 + j] > dp[i * s2LengthPlus1 + j + 1] ?
                dp[(i + 1) * s2LengthPlus1 + j] :
                dp[i * s2LengthPlus1 + j + 1])
  }
}
console.log(dp[s1LengthPlus1 * s2LengthPlus1 - 1])

const lcs = []

let i = s1LengthPlus1 - 1
let j = s2LengthPlus1 - 1
while (i > 0 && j > 0){
  if(dp[i * s2LengthPlus1 + j] === dp[i * s2LengthPlus1 + j - 1]){
    j--
  } else if(dp[i * s2LengthPlus1 + j] === dp[(i - 1) * s2LengthPlus1 + j]) {
    i--
  } else if(dp[i * s2LengthPlus1 + j] - dp[(i - 1) * s2LengthPlus1 + (j - 1)] === 1
      && s1[i - 1] === s2[j - 1]){
    lcs.push(s2[j - 1]);
    i--
    j--
  }
}

console.log(lcs.reverse().join(''))