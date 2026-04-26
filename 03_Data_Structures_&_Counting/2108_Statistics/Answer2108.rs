use std::io::{stdin, Read};
use std::collections::HashMap;
use std::fmt::Write;

fn main(){
  let mut s = String::new();
  stdin().read_to_string(&mut s).unwrap();
  let inputs:Vec<i32>= s.split_whitespace().map(|x| x.parse().unwrap()).collect();
  let n:usize = inputs[0] as usize;
  let mut nums:Vec<i32> = inputs[1..].to_vec();
  nums.sort();

  let mut counts_obj:HashMap<i32, i32> = HashMap::new();

  for it in &nums {
    if counts_obj.contains_key(&it) {
      *counts_obj.get_mut(&it).unwrap() += 1;
    } else {
      counts_obj.insert(*it, 1);
    }
  }

  let mut counts_arr:Vec<[i32; 2]> = Vec::new();
  for (key, value) in &counts_obj {
    counts_arr.push([*key, *value]);
  }
  counts_arr.sort_by(|a, b| {
    if a[1] == b[1] {
      a[0].cmp(&b[0])
    } else {
      b[1].cmp(&a[1])
    }
  });
  let sum:i32 = nums.iter().sum();
  let ave:f64 = sum as f64 / n as f64;
  let round_ave = ave.round() as i32;

  let mode;
  if counts_arr.len() > 1 {
    mode = if counts_arr[0][1] == counts_arr[1][1] {counts_arr[1][0]} else {counts_arr[0][0]}
  } else {mode = counts_arr[0][0];}

  let mut result_str = String::new();
  write!(result_str,"{}\n{}\n{}\n{}", round_ave, nums[n/2], mode, nums[n-1] - nums[0]).unwrap();
  print!("{}", result_str);
}