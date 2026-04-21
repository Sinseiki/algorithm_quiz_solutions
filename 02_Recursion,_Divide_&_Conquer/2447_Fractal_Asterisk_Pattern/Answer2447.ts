const n = +`${require('fs').readFileSync(0)}`

for(let y = 0; y < n; y++){
  let line = ''
  for(let x = 0; x < n; x++){
    let tmpX = x
    let tmpY = y
    let tmpS = '*'
    while(tmpX >= 1 && tmpY >= 1){
      if(tmpY  % 3 === 1 && tmpX % 3 === 1){
        tmpS = ' '
        break;
      }
      tmpX = tmpX / 3 | 0
      tmpY = tmpY / 3 | 0
    }
    line += tmpS
  }
  console.log(line)
}