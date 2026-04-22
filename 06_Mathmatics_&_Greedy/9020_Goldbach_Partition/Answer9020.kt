fun main(){
  val n = readln().toInt()
  val inputNums = IntArray(n)
  for(i in 0 until n) inputNums[i] = readln().toInt()
  val primes = IntArray(10000){1}
  primes[0] = 0
  var i = 2
  while (i <= 10000/i){
    if(primes[i - 1] == 1){
      for(j in i .. 10000/i) primes[i * j - 1] = 0
    }
    i++
  }

  val resultStr = StringBuilder()
  for(h in 0 until n){
    var a = inputNums[h]/2
    var b = inputNums[h]/2
    if(h > 0) resultStr.append("\n")
    while(true){
      if(primes[a - 1] + primes[b - 1] == 2){
        resultStr.append("$a $b")
        break
      }
      a--
      b++
    }
  }

  print(resultStr)
}