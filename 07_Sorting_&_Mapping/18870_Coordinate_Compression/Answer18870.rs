use std::io::stdin;
use std::collections::HashMap;
use std::collections::HashSet;

fn main(){
  stdin().read_line(&mut String::new()).unwrap();
  let mut s = String::new();
  stdin().read_line(&mut s).unwrap();
  let numbers:Vec<i32> = s.split_whitespace().map(|x| x.parse().unwrap()).collect();
  let mut ranks:HashMap<i32, usize> = HashMap::new();
  let number_set:HashSet<i32> = numbers.iter().cloned().collect();
  let mut number_set_list: Vec<i32> = number_set.into_iter().collect();
  number_set_list.sort();
  for i in 0 .. number_set_list.len() {
    let it = &number_set_list[i];
    ranks.insert(*it, i);
  }
  let mut result = String::new();
  for it in &numbers {
    result.push_str(&ranks[it].to_string());
    result.push(' ');
  }
  print!("{}", result);
}