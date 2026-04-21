import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Answer2108 {
  public static void main(String[] args) throws IOException {
    var br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    var nums = new int[n];
    for (int i = 0; i < n; i++) nums[i] = Integer.parseInt(br.readLine());
    Arrays.sort(nums);

    var countsObj = new HashMap<Integer, Integer>();

    for(int i = 0; i < n; i++){
      int it = nums[i];
      if(countsObj.containsKey(it)){
        countsObj.put(it, countsObj.get(it) + 1);
      } else {
        countsObj.put(it, 1);
      }
    }

    var countsArr = new ArrayList<int[]>();
    for (Integer key : countsObj.keySet()) {
      countsArr.add(new int[]{key, countsObj.get(key)});
    }

    countsArr.sort((a, b) -> {
      if(a[1] == b[1]){
        return a[0] - b[0];
      } else {
        return b[1] - a[1];
      }
    });
    double ave = Arrays.stream(nums).average().orElse(0);
    int roundAve = Math.toIntExact(Math.round(ave));

    int mode = 0;
    if(countsArr.size() > 1){
      mode = countsArr.get(0)[1] == countsArr.get(1)[1] ? countsArr.get(1)[0] : countsArr.get(0)[0];
    } else mode = countsArr.get(0)[0];

    var resultStr = new StringBuilder();
    resultStr.append(roundAve).append("\n")
    .append(nums[n / 2]).append("\n")
    .append(mode).append("\n")
    .append(nums[n-1] - nums[0]);
    System.out.print(resultStr);
  }
}
