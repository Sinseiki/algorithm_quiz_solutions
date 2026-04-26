fun main(){
  val (s1, s2) = List(2){readln()}
  val s1LengthPlus1 = s1.length + 1
  val s2LengthPlus1 = s2.length + 1
  val dp = IntArray(s1LengthPlus1 * s2LengthPlus1) { 0 }
  for(i in 0 until s1LengthPlus1 - 1){
    for(j in 0 until s2LengthPlus1 - 1){
      dp[(i + 1) * s2LengthPlus1 + j + 1] =
        if(s1[i] == s2[j]) dp[i * s2LengthPlus1 + j] + 1
        else {
          if(dp[(i + 1) * s2LengthPlus1 + j] > dp[i * s2LengthPlus1 + j + 1])
          dp[(i + 1) * s2LengthPlus1 + j]
          else dp[i * s2LengthPlus1 + j + 1]
        }
    }
  }
  println(dp[s1LengthPlus1 * s2LengthPlus1 - 1])

  val lcs = StringBuilder()
  var i = s1LengthPlus1 - 1
  var j = s2LengthPlus1 - 1
  while(i > 0 && j > 0){
    if(dp[i * s2LengthPlus1 + j] == dp[i * s2LengthPlus1 + j - 1]){
      j--
    } else if(dp[i * s2LengthPlus1 + j] == dp[(i - 1) * s2LengthPlus1 + j]) {
      i--
    } else if(dp[i * s2LengthPlus1 + j] - dp[(i - 1) * s2LengthPlus1 + (j - 1)] == 1
      && s1[i - 1] == s2[j - 1]){
      lcs.append(s2[j - 1])
      i--
      j--
    }
  }
  println(lcs.reverse())
}