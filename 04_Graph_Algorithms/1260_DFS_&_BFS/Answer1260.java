import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Answer1260 {
  public static void dfsRecursion(int frm, int[][] sortedEdges, ArrayList<Integer> dfsResult, boolean[] dfsVisited){
    dfsResult.add(frm);
    dfsVisited[frm - 1] = true;
    for(var it : sortedEdges[frm - 1]){
      if(!dfsVisited[it - 1]){
        dfsRecursion(it, sortedEdges, dfsResult, dfsVisited);
      }
    }
  }


  public static void bfsFinder(int bfsFoundPointer, ArrayList<Integer> bfsFound, int[][] sortedEdges, boolean[] bfsIsFound, ArrayList<Integer> bfsResult){
    while(bfsFoundPointer < bfsFound.size()){
      for(var it : sortedEdges[bfsFound.get(bfsFoundPointer) - 1]){
        if(!bfsIsFound[it - 1]){
          bfsFound.add(it);
          bfsIsFound[it - 1] = true;
        }
      }
      bfsResult.add(bfsFound.get(bfsFoundPointer));
      bfsFoundPointer++;
    }
  }


  public static void main(String[] args) {
    var s = new java.util.Scanner(System.in);
    var header = Arrays.stream(s.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    int verticesLength = header[0],
        edgesLength = header[1],
        startVertex = header[2];
    var edges = new ArrayList<ArrayList<Integer>>();
    for (int i = 0; i < verticesLength; i++) edges.add(new ArrayList<>());
    for (int i = 0; i < edgesLength; i++) {
      var it = Arrays.stream(s.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
      edges.get(it[0] - 1).add(it[1]);
      edges.get(it[1] - 1).add(it[0]);
    }
    var sortedEdges = edges.stream().map(it -> it.stream().sorted().mapToInt(Integer::intValue).toArray()).toArray(int[][]::new);
    var dfsVisited = new boolean[verticesLength];
    Arrays.fill(dfsVisited, false);
    var bfsIsFound = dfsVisited.clone();


    var dfsResult = new ArrayList<Integer>();

    Answer1260.dfsRecursion(startVertex, sortedEdges, dfsResult, dfsVisited);
    System.out.println(dfsResult.stream().map(String::valueOf).collect(Collectors.joining(" ")));


    var bfsResult = new ArrayList<Integer>();
    var bfsFound = new ArrayList<Integer>();
    bfsFound.add(startVertex);
    bfsIsFound[startVertex - 1] = true;
    int bfsFoundPointer = 0;

    Answer1260.bfsFinder(bfsFoundPointer, bfsFound, sortedEdges, bfsIsFound, bfsResult);
    System.out.println(bfsResult.stream().map(String::valueOf).collect(Collectors.joining(" ")));
  }
}