fun main(){
  val n = readln().toInt()
  var t = listOf("***","* *","***")
  var i = 3

  while (i < n){
    val t123 = mutableListOf<String>()
    val t456 = mutableListOf<String>()
    for(it in t){
      val t456B = " ".repeat(it.length)
      t123.add(it.repeat(3))
      t456.add(it + t456B + it)
    }

    t = buildList{
      addAll(t123)
      addAll(t456)
      addAll(t123)
    }
    i *= 3
  }

  print(t.joinToString("\n"))
}