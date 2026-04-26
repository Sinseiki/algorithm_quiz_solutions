import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Answer9251 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String s1 = br.readLine(),
           s2 = br.readLine();
    int s1Length = s1.length(),
        s2Length = s2.length(),
        tmpRow[] = new int[s1Length + 1];
    for(int y = 1; y <= s2Length; y++) {
      int diagonalX = 0;
      for(int x = 1; x <= s1Length; x++) {
        int upperX = tmpRow[x];
        tmpRow[x] = s1.charAt(x - 1) == s2.charAt(y - 1) ?
            diagonalX + 1 :
            tmpRow[x - 1] > tmpRow[x] ? tmpRow[x - 1] : tmpRow[x];
        diagonalX = upperX;
      }
    }
    System.out.print(tmpRow[s1Length]);
  }
}
