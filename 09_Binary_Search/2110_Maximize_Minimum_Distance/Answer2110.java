public class Answer2110 {
  public static void main(String[] args) {
    var s = new java.util.Scanner(System.in);
    String[] lengths = s.nextLine().split(" ");
    int pointsLength = Integer.parseInt(lengths[0]);
    int elementsLength = Integer.parseInt(lengths[1]);
    var intPoints = new java.util.ArrayList<Integer>();
    for(int i = 0; i < pointsLength; i++) intPoints.add(s.nextInt());
    intPoints.sort(Integer::compareTo);
    int minDistance = (intPoints.get(pointsLength - 1) - intPoints.get(0)) / 2;

    int disableMin = intPoints.get(pointsLength - 1) - intPoints.get(0) + 1;
    int ableMax = 0;

    while (true) {
      int placedElCount = 1;
      int prev = intPoints.get(0);
      for(int i = 1; i < pointsLength; i++){
        int it = intPoints.get(i);
        if(prev + minDistance <= it){
          prev = it;
          placedElCount++;
        }
      }
      if(disableMin - ableMax <= 1){
        System.out.print(ableMax);
        break;
      }
      if(placedElCount >= elementsLength) ableMax = minDistance;
      if(placedElCount < elementsLength) disableMin = minDistance;
      minDistance = (ableMax + disableMin) / 2;
    }
  }
}
