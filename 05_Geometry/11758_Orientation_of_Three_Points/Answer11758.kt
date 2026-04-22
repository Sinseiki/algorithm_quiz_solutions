import java.util.Scanner

fun main(){
  val vals = Array(3){IntArray(2)}
  val s = Scanner(System.`in`)
  for(i in vals.indices){
    for(j in vals[0].indices){
      vals[i][j] = s.nextInt()
    }
  }
  val orientationNum =
    (vals[1][0] - vals[0][0]) * (vals[2][1] - vals[0][1]) - (vals[1][1] -
      vals[0][1]) * (vals[2][0] - vals[0][0])
  print(if(orientationNum > 0) 1 else if (orientationNum < 0) -1 else 0)
}