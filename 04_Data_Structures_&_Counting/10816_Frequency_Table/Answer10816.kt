fun main(){
  readln()
  val firstList = readln().split(" ")
  readln()
  val queryList = readln().split(" ")
  val frequencyTable = HashMap<String,Int>()
  for(it in firstList) {
    frequencyTable[it] = (frequencyTable[it] ?: 0) + 1
  }
  val resultArr = queryList.map{frequencyTable[it] ?: 0}
  print(resultArr.joinToString(" "))
}