use std::io::{stdin, Read};
use std::collections::HashMap;

fn main(){
  let mut s = String::new();
  stdin().read_to_string(&mut s).unwrap();
  let inputs: Vec<&str> = s.split('\n').collect();
  let first_list:Vec<&str> = inputs[1].split_whitespace().collect();
  let query_list:Vec<&str> = inputs[3].split_whitespace().collect();

  let mut frequency_table:HashMap<&str, i32> = HashMap::new();
  for it in first_list {
    *frequency_table.entry(it).or_insert(0) += 1;
  }
  let mut result_str = String::new();
  for (i, it) in query_list.iter().enumerate() {
    if i > 0 {result_str.push(' ')}
    result_str.push_str(&frequency_table.get(*it).unwrap_or(&0).to_string());
  }
  print!("{}", result_str);
}