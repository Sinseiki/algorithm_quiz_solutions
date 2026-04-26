const [lengths, ...points] = `${require('fs').readFileSync(0)}`.trim().split('\n')
const [pointsLength, elementsLength] = lengths.split(' ').map(v=>+v)
const intPoints = points.map(v=>+v)
intPoints.sort((a, b) => a - b)
let minDistance = (intPoints[pointsLength - 1] - intPoints[0]) / 2 | 0
let disableMin = intPoints[pointsLength - 1] - intPoints[0] + 1
let ableMax = 0

while (true) {
  let placedElCount = 1;
  let prev = intPoints[0];
  for(let i = 1; i < pointsLength; i++){
    const it = intPoints[i]
    if(prev + minDistance <= it){
      prev = it
      placedElCount++
    }
  }
  if(disableMin - ableMax <= 1){
    console.log(ableMax)
    break
  }
  if(placedElCount >= elementsLength) ableMax = minDistance
  if(placedElCount < elementsLength) disableMin = minDistance
  minDistance = (ableMax + disableMin) / 2 | 0
}