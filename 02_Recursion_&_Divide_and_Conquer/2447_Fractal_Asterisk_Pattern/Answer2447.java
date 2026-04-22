import java.util.Scanner;

public class Answer2447 {
  public static void main(String[] args) {
    int n = new Scanner(System.in).nextInt();

    for(int y = 0; y < n; y++){
      var line = new StringBuilder();
      for(int x = 0; x < n; x++){
        int tmpX = x,
            tmpY = y;
        var tmpS = "*";
        while(tmpX >= 1 && tmpY >= 1){
          if(tmpY  % 3 == 1 && tmpX % 3 == 1){
            tmpS = " ";
            break;
          }
          tmpX /= 3;
          tmpY /= 3;
        }
        line.append(tmpS);
      }
      System.out.println(line);
    }
  }
}
