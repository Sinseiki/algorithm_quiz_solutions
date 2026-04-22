public class Answer9020 {
  public static void main(String[] args) {
    var s = new java.util.Scanner(System.in);
    int n = Integer.parseInt(s.nextLine().trim());
    var inputNums = new int[n];
    for (int i = 0; i < n; i++) inputNums[i] = Integer.parseInt(s.nextLine().trim());
    var primes = new int[10000];
    java.util.Arrays.fill(primes, 1);
    primes[0] = 0;
    int i = 2;
    while (i <= 10000/i){
      if(primes[i - 1] == 1){
        for(int j = i; j <= 10000/i; j++) primes[i * j - 1] = 0;
      }
      i++;
    }

    var resultStr = new StringBuilder();
    for(int h = 0; h < n; h++){
      int a = inputNums[h]/2;
      int b = inputNums[h]/2;
      if(h > 0) resultStr.append("\n");
      while(true){
        if(primes[a - 1] + primes[b - 1] == 2){
          resultStr.append(a).append(" ").append(b);
          break;
        }
        a--;
        b++;
      }
    }

    System.out.print(resultStr);
  }
}
