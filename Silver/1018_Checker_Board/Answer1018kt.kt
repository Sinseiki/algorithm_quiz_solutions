import kotlin.math.min

fun main() {
  val patterns = arrayOf("BWBWBWBW","WBWBWBWB")
  var paints = 32
  val (height, width) = readln().split(" ").map{it.toInt()}
  val board = ArrayList<String>()
  while(true) {
    val line = readlnOrNull() ?: break
    board.add(line)
  }
  for(patternType in 0 until 2){
    for(startY in 0 .. height - 8){
      for(startX in 0 .. width - 8){
        var paintCount = 0
        for(y in startY until startY + 8){
          for(x in 0 until 8){
            if(patterns[(y + patternType) % 2][x] != board[y][startX + x]) paintCount++
          }
        }
        paints = min(paints, paintCount)
      }
    }
  }
  println(paints)
}