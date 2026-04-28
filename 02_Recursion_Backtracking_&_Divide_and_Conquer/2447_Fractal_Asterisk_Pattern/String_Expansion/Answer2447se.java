import java.util.ArrayList;

public class Answer2447se {
  public static void main(String[] args) {
    int n = new java.util.Scanner(System.in).nextInt();
    var t = new ArrayList<String>();
    t.add("***");
    t.add("* *");
    t.add("***");

    int i = 3;

    while (i < n){
      var t123 = new ArrayList<String>();
      var t456 = new ArrayList<String>();
      for(var it : t){
        t123.add(it.repeat(3));
        t456.add(it + " ".repeat(it.length()) + it);
      }

      t.clear();
      t.addAll(t123);
      t.addAll(t456);
      t.addAll(t123);
      i *= 3;
    }

    System.out.print(String.join("\n", t));
  }
}
