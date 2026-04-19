const patterns = ['WBWBWBWB','BWBWBWBW']
let paints = 32
const [line1, ...board] = `${require('fs').readFileSync(0)}`.split('\n')
const [height, width] = line1.split(' ')
for(let patternType = 0; patternType < 2; patternType++) {
  for(let startY = 0; startY <= +height - 8; startY++) {
    for(let startX = 0; startX <= +width - 8; startX++) {
      let paintCount = 0
      for(let y = startY; y < startY + 8; y++) {
        for(let x = 0; x < 8; x++) {
          if(patterns[(y + patternType) % 2][x] !== board[y][startX + x]) paintCount++
        }
      }
      paints = Math.min(paints, paintCount)
    }
  }
}
console.log(paints)