import java.util.Scanner;

public class Answer2839 {
  public static void main(String[] args) {
    int n = new Scanner(System.in).nextInt();
    for(int i = n/5; i >=0; i--){
      int rest = n - 5 * i;
      if(rest % 3 == 0){
        System.out.print(i + rest / 3);
        break;
      }
      if(i == 0) System.out.print(-1);
    }
  }
}
