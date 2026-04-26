const [n, ...inputNums] = `${require('fs').readFileSync(0)}`.split('\n').map(v=>+v)
const primes = new Array(10000).fill(1)
primes[0] = 0;
for(let i = 2; i <= 10000/i; i++) {
  if(primes[i - 1]){
    for(let j = i; j <= 10000/i; j++) primes[i * j - 1] = 0
  }
}

const resultStr = []
for(let h = 0 ; h < n ; h++){
  let a = inputNums[h]/2;
  let b = inputNums[h]/2;
  while(true){
    if(primes[a - 1] + primes[b - 1] === 2){
      resultStr.push(`${a} ${b}`);
      break
    }
    a--
    b++
  }
}

console.log(resultStr.join('\n'))