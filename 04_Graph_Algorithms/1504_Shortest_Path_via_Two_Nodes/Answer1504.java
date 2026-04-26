import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.stream.Stream;

public class Answer1504 {
  public static int[] getShortestPath(int nowNode, int to1, int to2, int nodesLength, int infinity, ArrayList<ArrayList<int[]>> edges){
    var costOfNodes = new int[nodesLength];
    Arrays.fill(costOfNodes, infinity);
    costOfNodes[nowNode - 1] = 0;
    var candidates = new PriorityQueue<int[]>(Comparator.comparingInt(a -> a[1]));
    var addItem = new int[]{nowNode, 0};
    candidates.add(addItem);

    while(!candidates.isEmpty()){
      var minCandidate = candidates.poll();
      int candidateNode = minCandidate[0],
          candidateMin = minCandidate[1];

      if(candidateMin > costOfNodes[candidateNode - 1]) continue;

      nowNode = candidateNode;
      costOfNodes[nowNode - 1] = candidateMin;

      for(int i = 0; i < edges.get(nowNode - 1).size(); i++) {
        int toNode = edges.get(nowNode - 1).get(i)[0];
        int weight = edges.get(nowNode - 1).get(i)[1];
        if(costOfNodes[nowNode - 1] + weight < costOfNodes[toNode - 1]){
          costOfNodes[toNode - 1] = costOfNodes[nowNode - 1] + weight;
          candidates.add(new int[]{toNode, costOfNodes[toNode - 1]});
        }
      }
    }

    if(to2 > 0){
      return new int[]{costOfNodes[to1 - 1], costOfNodes[to2 - 1]};
    } else {
      return new int[]{costOfNodes[to1 - 1]};
    }
  }

  public static void main(String[] args) {
    var s = new java.util.Scanner(System.in);
    var lengths = Stream.of(s.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    int nodesLength = lengths[0];
    int edgesLength = lengths[1];
    var edges = new ArrayList<ArrayList<int[]>>(nodesLength);
    for(int i = 0; i < nodesLength; i++) edges.add(new ArrayList<>());
    for(int i = 0; i < edgesLength; i++){
      var it = Stream.of(s.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
      edges.get(it[0] - 1).add(new int[]{it[1], it[2]});
      edges.get(it[1] - 1).add(new int[]{it[0], it[2]});
    }

    var viaNodes = Stream.of(s.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    int v1 = viaNodes[0];
    int v2 = viaNodes[1];
    int infinity = Integer.MAX_VALUE >> 2;

    var cost1 = getShortestPath(1, v1, v2, nodesLength, infinity, edges);
    var costV1 = getShortestPath(v1, v2, nodesLength, nodesLength, infinity, edges);
    var costV2 = getShortestPath(v2, nodesLength, 0, nodesLength, infinity, edges);

    int minValue = Math.min(cost1[0] + costV1[0] + costV2[0], cost1[1] + costV1[0] + costV1[1]);

    System.out.print(0 <= minValue && minValue < infinity ? minValue : -1);
  }
}
