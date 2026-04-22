import java.util.ArrayList;
import java.util.Scanner;

public class Answer1018 {
  public static void main(String[] args) {
    final String[] patterns = {"BWBWBWBW","WBWBWBWB"};
    int paints = 32;
    final Scanner s = new Scanner(System.in);
    final String[] o = s.nextLine().split(" ");
    final int height = Integer.parseInt(o[0]);
    final int width = Integer.parseInt(o[1]);
    final ArrayList<String> board = new ArrayList<>();
    while(s.hasNext()) board.add(s.nextLine());
    for(int patternType = 0; patternType < 2; patternType++){
      for(int startY = 0; startY <= height - 8; startY++){
        for(int startX = 0; startX <= width - 8; startX++){
          int paintCount = 0;
          for(int y = startY; y < startY + 8; y++){
            for(int x = 0; x < 8; x++){
              if(patterns[(y + patternType) % 2].charAt(x)!= board.get(y).charAt(startX + x)) paintCount++;
            }
          }
          paints = Math.min(paints, paintCount);
        }
      }
    }
    System.out.println(paints);
  }
}