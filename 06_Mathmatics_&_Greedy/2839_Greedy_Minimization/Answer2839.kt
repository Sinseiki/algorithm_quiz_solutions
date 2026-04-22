fun main(){
  val n = readln().toInt()

  for(i in n/5 downTo 0){
    val rest = n - 5 * i
    if(rest % 3 == 0){
      print(i + rest / 3)
      break
    }
    if(i == 0) print(-1)
  }
}