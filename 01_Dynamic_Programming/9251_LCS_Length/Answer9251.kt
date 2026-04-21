fun main() {
  val(s1, s2) = List(2){readln()}
  val s1Length = s1.length
  val s2Length = s2.length
  val tmpRow = IntArray(s1Length + 1, {0})
  for(y in 1 .. s2Length){
    var diagonalX = 0
    for(x in 1 .. s1Length){
      val upperX = tmpRow[x]
      tmpRow[x] =
        if(s1[x - 1] == s2[y - 1]) diagonalX + 1
        else {
          if(tmpRow[x - 1] > tmpRow[x]) tmpRow[x - 1]
          else tmpRow[x]
        }
      diagonalX = upperX
    }
  }
  print(tmpRow[s1Length])
}
