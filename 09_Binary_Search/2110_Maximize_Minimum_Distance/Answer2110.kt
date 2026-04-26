fun main(){
  val lengths = readln().split(" ").map{it.toInt()}
  val pointsLength = lengths[0]
  val elementsLength = lengths[1]
  val intPoints = mutableListOf<Int>()
  repeat(pointsLength){intPoints.add(readln().toInt())}
  intPoints.sort()
  var minDistance = (intPoints[pointsLength - 1] - intPoints[0]) / 2
  var disableMin = intPoints[pointsLength - 1] - intPoints[0] + 1
  var ableMax = 0

  while (true) {
    var placedElCount = 1;
    var prev = intPoints[0];
    for(i in 1 until pointsLength){
      val it = intPoints[i]
      if(prev + minDistance <= it){
        prev = it
        placedElCount++
      }
    }
    if(disableMin - ableMax <= 1){
      print(ableMax)
      break
    }
    if(placedElCount >= elementsLength) ableMax = minDistance
    if(placedElCount < elementsLength) disableMin = minDistance
    minDistance = (ableMax + disableMin) / 2
  }
}