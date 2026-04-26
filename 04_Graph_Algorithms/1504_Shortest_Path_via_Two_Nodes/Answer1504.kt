import java.util.PriorityQueue

fun main(){
  val (nodesLength, edgesLength) = readln().split(' ').map{it.toInt()}
  val edges:MutableList<MutableList<IntArray>> = MutableList(nodesLength){mutableListOf()}
  for(i in 0 until edgesLength){
    val it = readln().split(' ').map{it.toInt()}
    edges[it[0] - 1].add(intArrayOf(it[1], it[2]))
    edges[it[1] - 1].add(intArrayOf(it[0], it[2]))
  }

  val (v1, v2) = readln().split(' ').map{it.toInt()}
  val infinity = Int.MAX_VALUE shr 2

  fun getShortestPath(nowNodeVal:Int, to1:Int, to2:Int):IntArray{
    var nowNode = nowNodeVal
    val costOfNodes = IntArray(nodesLength){infinity}
    costOfNodes[nowNode - 1] = 0
    val candidates = PriorityQueue<IntArray>(compareBy{it[1]})
    candidates.add(intArrayOf(nowNode, 0))

    while(!candidates.isEmpty()) {
      val (candidateNode, candidateMin) = candidates.poll()

      if(candidateMin > costOfNodes[candidateNode - 1]) continue

      nowNode = candidateNode
      costOfNodes[nowNode - 1] = candidateMin

      for(i in edges[nowNode - 1].indices) {
        val (toNode, weight) = edges[nowNode - 1][i]
        if(costOfNodes[nowNode - 1] + weight < costOfNodes[toNode - 1]){
          costOfNodes[toNode - 1] = costOfNodes[nowNode - 1] + weight
          candidates.add(intArrayOf(toNode, costOfNodes[toNode - 1]))
        }
      }
    }

    return if(to2 > 0){
      intArrayOf(costOfNodes[to1 - 1], costOfNodes[to2 - 1])
    } else {
      intArrayOf(costOfNodes[to1 - 1])
    }
  }

  val cost1 = getShortestPath(1, v1, v2)
  val costV1 = getShortestPath(v1, v2, nodesLength)
  val costV2 = getShortestPath(v2, nodesLength, 0)

  val minValue = intArrayOf(cost1[0] + costV1[0] + costV2[0], cost1[1] + costV1[0] + costV1[1]).min()

  print(if(minValue !in 0 until infinity) -1 else minValue)
}