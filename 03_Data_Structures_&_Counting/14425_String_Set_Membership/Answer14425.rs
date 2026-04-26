use std::collections::HashSet;
use std::io::stdin;

fn main(){
  let mut s = String::new();
  stdin().read_line(&mut s).unwrap();
  let nums:Vec<usize> = s.trim().split_whitespace().map(|x| x.parse().unwrap()).collect();
  let (n, m) = (nums[0], nums[1]);
  let strs:Vec<String> = (0 .. n).map(|_|{
    let mut s = String::new();
    stdin().read_line(&mut s).unwrap();
    s.trim().to_string()}).collect();
  let strs_set:HashSet<String> = strs.iter().cloned().collect();
  let mut result_int = 0;
  for _ in n .. n + m {
    let mut s = String::new();
    stdin().read_line(&mut s).unwrap();
    if strs_set.contains(s.trim()) {result_int += 1;}
  }
  print!("{}", result_int);
}