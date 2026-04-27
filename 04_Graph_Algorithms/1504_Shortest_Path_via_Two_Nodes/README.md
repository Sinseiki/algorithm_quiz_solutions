  - Inspired by: [BOJ 1504](https://www.acmicpc.net/problem/1504) (Gold IV)

  - Problem type: Graph Algorithms / Shortest Path (Dijkstra) / Path Composition

  - Goal: find the minimum distance from node 1 to node N in an undirected weighted graph, while passing through two required nodes v1 and v2.

  - Summarize:
    - The graph is undirected and weighted (positive weights)
    - The path must start at node 1 and end at node N
    - Two specific nodes (v1, v2) must be included in the path
    - The path must still be the overall shortest possible under this constraint
    - Since order is not fixed, consider both:
      - 1 → v1 → v2 → N
      - 1 → v2 → v1 → N
    - Compute shortest distances between key nodes and combine them
    - If any required segment is unreachable, the answer is invalid

  - Input format:
    - Two integers N and E (number of nodes and edges),
      where 2 ≤ N ≤ 800 and 0 ≤ E ≤ 200,000
    - E lines, each containing:
      - a, b, c (bidirectional edge between a and b with cost c)
    - One line with two integers:
      - v1 and v2 (mandatory nodes to pass through)

  - Output:
    - A single integer:
      - the length of the shortest path from 1 to N passing through both v1 and v2
      - if such a path does not exist, output -1


<details>
  <summary>- Solution approach:</summary>
  <pre>
  1. Read nodesLength and edgesLength.
  2. Create an adjacency list:
   edges[from] = list of (toNode, weight).
   Since the graph is undirected, each input edge is stored twice:
    - edges[a - 1].add((b, weight))
    - edges[b - 1].add((a, weight))
  3. Read the two required nodes v1 and v2.
  4. Set infinity to Integer.MAX_VALUE >> 2.
   This value is large enough for this problem's constraints,
   while still leaving room to avoid overflow during addition.
  5. Define getShortestPath(nowNodeVal, to1, to2).
   This function runs Dijkstra's algorithm from nowNodeVal and returns:
    - the shortest cost to to1
    - and, if needed, the shortest cost to to2
  6. Inside getShortestPath:
    - costOfNodes stores the minimum known cost to each node.
    - All values are initialized with infinity.
    - costOfNodes[nowNodeVal - 1] is set to 0.
  7. A path-based approach may seem natural:
    - follow one path from the starting node
    - accumulate edge costs
    - remember which path has passed through v1 and v2
    - compare only paths that satisfy the condition
   This is possible conceptually, but inefficient.
   It treats the problem as a path enumeration problem,
   while Dijkstra treats it as a node-cost update problem.
  8. Another possible attempt is to choose the cheapest edge from the current node first.
   This is also misleading.
   The cheapest edge from the current node is not necessarily part of the globally shortest route.
   The correct criterion is the accumulated cost stored in costOfNodes.
  9. Use candidates to manage the next nodes to process.
   In Kotlin, Java, and Rust versions, a priority queue / heap is used:
    - Kotlin/Java: PriorityQueue
    - Rust: BinaryHeap with Reverse
  10. In the JavaScript version, there is no built-in MinHeap.
    Therefore, instead of using a heap, the implementation can search the current minimum candidate manually.
    After finding the minimum candidate, it can be removed by swapping it with the last element
    and popping the last element.
    This avoids sorting the whole candidate list every time,
    but it is still less standard than a real MinHeap.
  11. While candidates is not empty:
    - poll the candidate with the smallest accumulated cost
    - candidateNode is the node to process
    - candidateMin is the accumulated cost to candidateNode
  12. If candidateMin is larger than costOfNodes[candidateNode - 1],
    skip this candidate.
    This means the candidate is outdated because a cheaper route to the same node
    has already been found.
  13. Set nowNode to candidateNode.
  14. Check every adjacent edge from nowNode:
    - toNode is the next node
    - weight is the edge cost
    Compute:
    newCost = costOfNodes[nowNode - 1] + weight
    If newCost is smaller than costOfNodes[toNode - 1],
    update costOfNodes[toNode - 1] and add a new candidate:
    IntArray(toNode, newCost)
15. The function returns the shortest costs requested by to1 and to2.
    If to2 is 0, only the distance to to1 is needed.
16. Since the route must pass through both v1 and v2,
    only two route orders are possible:
    - 1 -> v1 -> v2 -> nodesLength
    - 1 -> v2 -> v1 -> nodesLength
17. Run getShortestPath three times:
    - cost1  = getShortestPath(1, v1, v2)
    - costV1 = getShortestPath(v1, v2, nodesLength)
    - costV2 = getShortestPath(v2, nodesLength, 0)
18. Combine the segment costs:
    route1 = cost1[0] + costV1[0] + costV2[0]
    route2 = cost1[1] + costV1[0] + costV1[1]
    Here:
    - cost1[0] is 1 -> v1
    - cost1[1] is 1 -> v2
    - costV1[0] is v1 -> v2
    - costV1[1] is v1 -> nodesLength
    - costV2[0] is v2 -> nodesLength
19. Select the smaller route cost as minValue.
20. If minValue is outside the valid range 0 until infinity,
    print -1.
    Otherwise, print minValue.
  </pre>
</details>