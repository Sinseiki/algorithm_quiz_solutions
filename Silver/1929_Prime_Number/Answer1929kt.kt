fun main(){
  val (m,n) = readln().split(' ').map{it.toInt()}
  val a = MutableList<Int>(n, {1})
  var i = 2
  while(i <= n/i){
    if(a[i - 1] == 1){
      for(j in i .. n/i) a[i * j - 1] = 0
    }
    i++
  }
  for(i in (if(m > 1) m - 1 else 1)..< n){
    if(a[i] > 0) println(i + 1)
  }
}