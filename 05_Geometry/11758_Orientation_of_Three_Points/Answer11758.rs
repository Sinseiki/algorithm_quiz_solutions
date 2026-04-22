use std::io::{stdin, Read};

fn main(){
  let mut s = String::new();
  stdin().read_to_string(&mut s).unwrap();
  let vals:Vec<Vec<i32>> = s.split('\n').map(|x| x.split_whitespace().map(|x| x.parse().unwrap()).collect()).collect();
  let orientation_num = (vals[1][0] - vals[0][0]) * (vals[2][1] - vals[0][1])
      - (vals[1][1] - vals[0][1]) * (vals[2][0] - vals[0][0]);
  print!("{}", if orientation_num > 0 {1} else if(orientation_num < 0) {-1} else {0});
}