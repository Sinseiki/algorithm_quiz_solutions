fun main(){
  val (totalLength, targetLength) = readln().split(' ').map{it.toInt()}
  val numbers = readln().split(' ').map{it.toInt()}
  val sortedNumbers = numbers.sorted()
  val resultSequences = StringBuilder()
  val sequence = mutableListOf<Int>()
  fun dfs(start:Int, depth:Int){
    if(depth > targetLength){
      resultSequences.append(sequence.joinToString(separator = " "))
      resultSequences.append("\n")
      return
    }
    for(i in start until totalLength){
      sequence.add(sortedNumbers[i])
      dfs(i, depth + 1)
      sequence.removeLast()
    }
  }
  dfs(0, 1)
  println(resultSequences.trim())
}