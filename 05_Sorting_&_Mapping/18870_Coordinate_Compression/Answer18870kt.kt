fun main(){
  readln()
  val numbers = readln().split(" ").map{it.toInt()}
  val ranks = mutableMapOf<Int, Int>()
  numbers.toSet().toList().sorted().forEachIndexed{i, it -> ranks[it] = i}
  val result:MutableList<String> = mutableListOf()
  numbers.forEach {result.add("${ranks[it]}")}
  println(result.joinToString(" "))
}