fun main(){
  val (n, m) = readln().split(" ").map {it.toInt()}
  val strs = mutableListOf<String>()
  repeat(n){strs.add(readln())};
  val strsSet = strs.toSet()
  var resultInt = 0
  for(i in n until n + m) if(strsSet.contains(readln())) resultInt++
  print(resultInt)
}