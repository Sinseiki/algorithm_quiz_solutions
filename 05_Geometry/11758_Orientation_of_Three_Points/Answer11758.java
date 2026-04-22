public class Answer11758 {
  public static void main(String[] args) {
    var vals =  new int[3][2];
    var s = new java.util.Scanner(System.in);
    for(var i = 0; i < vals.length; i++) {
      for(var j = 0; j < vals[0].length; j++) {
        vals[i][j] = s.nextInt();
      }
    }
    int orientationNum = (vals[1][0] - vals[0][0]) * (vals[2][1] - vals[0][1])
        - (vals[1][1] - vals[0][1]) * (vals[2][0] - vals[0][0]);
    System.out.println(orientationNum > 0 ? 1 : orientationNum < 0 ? -1 : 0);
  }
}
