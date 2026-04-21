import java.util.Scanner;

public class Answer11729 {
  public static void recursionFn(int n, int from, int to, StringBuilder resultStr){
    int auxiliary = 6 - from - to;
    if(n == 1){
      var s = "\n" + from + " " + to;
      resultStr.append(s);
    } else {
      recursionFn(n - 1, from, auxiliary, resultStr);
      var s = "\n" + from + " " + to;
      resultStr.append(s);
      recursionFn(n - 1, auxiliary, to, resultStr);
    }
  }

  public static void main(String[] args) {
    var n = new Scanner(System.in).nextInt();
    var resultStr = new StringBuilder();
    resultStr.append(((1 << n) - 1));

    recursionFn(n, 1, 3, resultStr);

    System.out.print(resultStr);
  }
}