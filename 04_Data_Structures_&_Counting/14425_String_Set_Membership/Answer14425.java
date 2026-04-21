public class Answer14425 {
  public static void main(String[] args) {
    var s = new java.util.Scanner(System.in);
    int n = s.nextInt();
    int m = s.nextInt();
    s.nextLine();
    var strs = new String[n];
    for(int i = 0; i < n; i++) strs[i] = s.nextLine();
    var strsSet = new java.util.HashSet<>(java.util.Arrays.asList(strs));
    int resultInt = 0;
    for(int i = n; i < n + m; i++) if(strsSet.contains(s.nextLine())) resultInt++;
    System.out.print(resultInt);
  }
}