use std::io::{stdin, Read};

fn main(){
  let mut s = String::new();
  stdin().read_to_string(&mut s).unwrap();
  let inputs:Vec<&str> = s.trim().split("\n").collect();
  let lengths:Vec<usize> = inputs.get(0).unwrap().trim().split(" ").map(|x| x.parse().unwrap()).collect();
  let points_length = lengths[0];
  let elements_length = lengths[1];
  let mut int_points:Vec<i32> = inputs[1..].iter().map(|x| x.parse().unwrap()).collect();
  int_points.sort();
  let mut min_distance = (int_points[points_length - 1] - int_points[0]) / 2;
  let mut disable_min = int_points[points_length - 1] - int_points[0] + 1;
  let mut able_max = 0;

  loop {
    let mut placed_el_count = 1;
    let mut prev = int_points[0];
    for i in 1 .. points_length {
      let it = int_points[i];
      if prev + min_distance <= it {
        prev = it;
        placed_el_count+=1;
      }
    }
    if disable_min - able_max <= 1 {
      print!("{able_max}");
      break
    }
    if placed_el_count >= elements_length {able_max = min_distance};
    if placed_el_count < elements_length {disable_min = min_distance};
    min_distance = (able_max + disable_min) / 2;
  }
}