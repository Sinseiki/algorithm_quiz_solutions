import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.roundToInt

fun main(){
  val br = BufferedReader(InputStreamReader(System.`in`))
  val n = br.readLine().toInt()
  val nums = IntArray(n)
  for(i in 0 until n) nums[i] = br.readLine().toInt()
  nums.sort()

  val countsObj = HashMap<Int,Int>()

  for(i in 0 until n){
    val it = nums[i]
    if(countsObj[it] != null){
      countsObj[it] = countsObj[it]!! + 1
    } else {
      countsObj[it] = 1
    }
  }

  val countsArr = mutableListOf<IntArray>()
  for(i in countsObj.keys){
    countsObj[i]?.let{countsArr.add(element = intArrayOf(i, countsObj[i]!!))}
  }
  countsArr.sortWith{a, b ->
    if(a[1] == b[1]){
      a[0] - b[0]
    } else {
      b[1] - a[1]
    }
  }
  val ave = nums.average()
  val roundAve = ave.roundToInt()

  var mode = 0
  if(countsArr.size > 1) {
    mode = if(countsArr[0][1] == countsArr[1][1]) countsArr[1][0] else countsArr[0][0]
  } else mode = countsArr[0][0]

  val resultStr = StringBuilder()
  resultStr.append("${roundAve}\n")
  resultStr.append("${nums[n / 2]}\n")
  resultStr.append("${mode}\n")
  resultStr.append("${nums[n - 1] - nums[0]}")
  print(resultStr)
}