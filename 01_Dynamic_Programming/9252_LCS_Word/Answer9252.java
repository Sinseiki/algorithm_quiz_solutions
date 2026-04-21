import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Answer9152 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String s1 = br.readLine(),
           s2 = br.readLine();
    int s1LengthPlus1 = s1.length() + 1;
    int s2LengthPlus1 = s2.length() + 1;
    var dp = new int[s1LengthPlus1 * s2LengthPlus1];
    for(int i = 0; i < s1LengthPlus1 - 1; i++){
      for(int j = 0; j < s2LengthPlus1 - 1; j++){
        dp[(i + 1) * s2LengthPlus1 + j + 1] =
            s1.charAt(i) == s2.charAt(j) ?
                dp[i * s2LengthPlus1 + j] + 1 :
                (dp[(i + 1) * s2LengthPlus1 + j] > dp[i * s2LengthPlus1 + j + 1] ?
                 dp[(i + 1) * s2LengthPlus1 + j] :
                 dp[i * s2LengthPlus1 + j + 1]);
      }
    }
    System.out.println(dp[s1LengthPlus1 * s2LengthPlus1 - 1]);

    var lcs = new StringBuilder();
    int i = s1LengthPlus1 - 1;
    int j = s2LengthPlus1 - 1;
    while (i > 0 && j > 0){
      if(dp[i * s2LengthPlus1 + j] == dp[i * s2LengthPlus1 + j - 1]){
        j--;
      } else if(dp[i * s2LengthPlus1 + j] == dp[(i - 1) * s2LengthPlus1 + j]) {
        i--;
      } else if(dp[i * s2LengthPlus1 + j] - dp[(i - 1) * s2LengthPlus1 + (j - 1)] == 1
          && s1.charAt(i - 1) == s2.charAt(j - 1)){
        lcs.append(s2.charAt(j - 1));
        i--;
        j--;
      }
    }
    System.out.println(lcs.reverse());
  }
}
