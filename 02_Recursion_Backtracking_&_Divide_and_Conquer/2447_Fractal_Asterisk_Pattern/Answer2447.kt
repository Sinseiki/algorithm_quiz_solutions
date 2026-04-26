fun main(){
  val n = readln().toInt()

  for(y in 0 until n){
    var line = ""
    for(x in 0 until n) {
      var tmpX = x
      var tmpY = y
      var tmpS = '*'
      while (tmpX >= 1 && tmpY >= 1) {
        if (tmpY % 3 == 1 && tmpX % 3 == 1) {
          tmpS = ' '
          break
        }
        tmpX /= 3
        tmpY /= 3
      }
      line += tmpS
    }
    println(line)
  }
}