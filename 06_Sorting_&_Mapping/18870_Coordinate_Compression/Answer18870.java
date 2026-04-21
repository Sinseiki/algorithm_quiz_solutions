import java.util.*;
import java.util.stream.*;

public class Answer18870 {
  public static void main(String[] args) {
    var s = new Scanner(System.in);
    int n = s.nextInt();
    var numbers = new ArrayList<Integer>();
    for (int i = 0; i < n; i++) {
      numbers.add(s.nextInt());
    }
    var ranks = new HashMap<Integer, Integer>();
    var numberSet = new HashSet<>(numbers);
    var numberSetList = new ArrayList<>(numberSet);
    Collections.sort(numberSetList);
    for(int i = 0; i < numberSetList.size(); i++){
      int it = numberSetList.get(i);
      ranks.put(it, i);
    }
    var result = new StringBuilder();
    for(int it : numbers){
      result.append(ranks.get(it));
      result.append(" ");
    }
    System.out.println(result);
  }
}
