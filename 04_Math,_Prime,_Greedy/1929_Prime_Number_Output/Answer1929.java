import java.util.Arrays;
import java.util.Scanner;

public class Answer1929 {
  public static void main(String[] args) {
    var c = new Scanner(System.in);
    int m = c.nextInt();
    int n = c.nextInt();
    var a = new int[n];
    Arrays.fill(a, 1);
    for(int i = 2; i <= n/i; i++){
      if(a[i - 1] == 0) continue;
      for(int j = i; j <= n/i; j++) a[i * j - 1] = 0;
    }
    for(int i = (m > 1 ? m - 1 : 1); i < n; i++){
      if(a[i] > 0) System.out.println(i + 1);
    }
  }
}