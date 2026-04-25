fun main(){
  val (verticesLength, edgesLength, startVertex) = readln().split(" ").map {it.toInt()}
  val edges = mutableListOf<MutableList<Int>>()
  repeat(verticesLength){edges.add(mutableListOf())}
  repeat(edgesLength){
    val it = readln().split(" ").map{it.toInt()}
    edges[it[0] - 1].add(it[1])
    edges[it[1] - 1].add(it[0])
  }
  val sortedEdges = edges.map{it.sorted()}
  val dfsVisited = Array(verticesLength){false}
  val bfsIsFound = dfsVisited.clone()


  val dfsResult = mutableListOf<Int>()

  fun dfsRecursion(frm:Int){
    dfsResult.add(frm)
    dfsVisited[frm - 1] = true
    for(it in sortedEdges[frm - 1]){
      if(!dfsVisited[it - 1]){
        dfsRecursion(it)
      }
    }
  }
  dfsRecursion(startVertex)
  println(dfsResult.joinToString(" "))


  val bfsResult = mutableListOf<Int>()
  val bfsFound = mutableListOf<Int>()
  bfsFound.add(startVertex)
  bfsIsFound[startVertex - 1] = true
  var bfsFoundPointer = 0

  fun bfsFinder(){
    while(bfsFoundPointer < bfsFound.size){
      for(it in sortedEdges[bfsFound[bfsFoundPointer] - 1]){
        if(!bfsIsFound[it - 1]){
          bfsFound.add(it)
          bfsIsFound[it - 1] = true
        }
      }
      bfsResult.add(bfsFound[bfsFoundPointer])
      bfsFoundPointer++
    }
  }
  bfsFinder()
  println(bfsResult.joinToString(" "))

}