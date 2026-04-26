import java.util.*;

public class Answer15657 {
  static public void dfs(int start, int depth, int[] sortedNumbers, int totalLength, int targetLength, StringBuilder resultSequences, ArrayList<Integer> sequence){
    if(depth > targetLength){
      var sequenceStrBuilder = new StringBuilder();
      for(int i = 0; i < sequence.size(); i++){
        if(i > 0) sequenceStrBuilder.append(" ");
        sequenceStrBuilder.append(sequence.get(i));
      }
      resultSequences.append(sequenceStrBuilder);
      resultSequences.append("\n");
      return;
    }
    for(int i = start; i < totalLength; i++){
      sequence.add(sortedNumbers[i]);
      dfs(i, depth+1, sortedNumbers, totalLength, targetLength, resultSequences, sequence);
      sequence.remove(sequence.size()-1);
    }
  }

  public static void main(String[] args) {
    var s = new Scanner(System.in);
    int totalLength = s.nextInt();
    int targetLength =  s.nextInt();
    int[] sortedNumbers = new int[totalLength];
    for(int i = 0; i < totalLength; i++){
      sortedNumbers[i] = s.nextInt();
    }
    Arrays.sort(sortedNumbers);

    var resultSequences = new StringBuilder();
    var sequence = new ArrayList<Integer>();

    dfs(0, 1, sortedNumbers, totalLength, targetLength, resultSequences, sequence);
    System.out.println(resultSequences.toString().trim());
  }
}
