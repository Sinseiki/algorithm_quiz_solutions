- Inspired by: [BOJ 1260](https://www.acmicpc.net/problem/1260) (Silver II)

- Problem type: Graph Traversal / DFS / BFS

- Goal: traverse an undirected graph using DFS and BFS from the same starting vertex.

- Summary:
  An undirected graph is given.
  Starting from a given vertex, print the order of visited vertices using DFS first, then BFS.
  When multiple vertices are available to visit, the vertex with the smaller number should be visited first.

- Input format:
    - The first line contains the number of vertices, the number of edges,
      and the starting vertex.
    - Each of the following lines contains two connected vertices.
    - The graph is undirected.
    - Vertex indices are 1-based (from 1 to N).

- Output:
    - Print the DFS traversal order on the first line.
    - Print the BFS traversal order on the second line.


<details>
  <summary>- Solution approach:</summary>
  <pre>
  1. Read the number of vertices, the number of edges, and the starting vertex.
  2. Create an adjacency list for the graph.
     Since the graph is undirected, add each edge in both directions.
  3. Sort each adjacency list in ascending order.
     This is necessary because smaller-numbered vertices must be visited first.
  4. For DFS:
     - Use recursion.
     - When entering a vertex, mark it as visited and append it to the DFS result.
     - Recursively visit each unvisited adjacent vertex in sorted order.
     - The result array itself can be used as a visited check,
       but that requires repeated linear searches.
       Therefore, use a dedicated boolean visited array indexed by vertex number - 1
       for clearer intent and faster lookup.
  5. For BFS:
     - At first, it may seem natural to store vertices by depth:
       depth 0, depth 1, depth 2, and so on.
     - This works conceptually, but it makes the implementation more complicated
       because the code must keep checking which depth still has unprocessed vertices.
     - A simpler way is to use a queue-like array.
     - Store discovered vertices in an array and use a pointer as the queue head.
     - When a vertex is discovered, immediately mark it as true in bfsIsFound
       so it is not added again.
     - Move the pointer forward one by one to process vertices in first-in-first-out order.
  6. Collect the DFS and BFS visit orders separately.
  7. Print both results as space-separated values.
  </pre>
</details>