import java.math.BigInteger;
import java.util.Scanner;

public class Answer2749 {
  public static void main(String[] args) {
    var s = new Scanner(System.in);
    BigInteger b = s.nextBigInteger(),
        p = new BigInteger("1500000");
    int n = b.mod(p).intValue(),
        f1 = 0,
        f2 = 1;

    for(int i = 1; i < n; i++){
      int prev = f1;
      f1 = f2;
      f2 = (prev + f1) % 1000000;
    }
    int res = n == 0 ? 0 : f2;
    System.out.print(res);
  }
}
