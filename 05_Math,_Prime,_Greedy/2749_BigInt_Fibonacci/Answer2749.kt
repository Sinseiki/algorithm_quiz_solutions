fun main(){
  val n = (readln().toBigInteger() % (1500000).toBigInteger()).toInt()
  var f1 = 0
  var f2 = 1

  for(i in 1 until n){
    val prev = f1
    f1 = f2
    f2 = (prev + f1) % 1000000
  }
  print(if(n == 0) 0 else f2)
}