import java.util.HashMap;
import java.util.Scanner;

public class Answer10816 {
  public static void main(String[] args) {
    var s = new Scanner(System.in);
    s.nextLine();
    var firstList = s.nextLine().split(" ");
    s.nextLine();
    var queryList = s.nextLine().split(" ");

    var frequencyTable = new HashMap<String,Integer>();
    for(var it : firstList) {
      frequencyTable.put(it, frequencyTable.getOrDefault(it, 0) + 1);
    }
    var resultStr = new StringBuilder();
    for(int i = 0; i < queryList.length; i++) {
      if(i > 0) resultStr.append(" ");
      resultStr.append(frequencyTable.getOrDefault(queryList[i], 0));
    }
    System.out.print(resultStr);
  }
}
