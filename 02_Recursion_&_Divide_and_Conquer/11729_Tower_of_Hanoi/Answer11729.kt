fun main(){
  val n = readln().toInt()
  val resultStr = StringBuilder()
  resultStr.append((1 shl n) - 1).toString()

  fun recursionFn(n:Int, from:Int, to:Int){
    val auxiliary = 6 - from - to
    if(n == 1){
      resultStr.append("\n${from} $to")
    } else {
      recursionFn(n - 1, from, auxiliary)
      resultStr.append("\n${from} $to")
      recursionFn(n - 1, auxiliary, to)
    }
  }
  recursionFn(n, 1, 3)
  print(resultStr)
}