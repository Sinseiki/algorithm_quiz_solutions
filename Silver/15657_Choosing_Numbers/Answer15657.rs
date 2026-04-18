fn main(){
  let mut line1 = String::new();
  std::io::stdin().read_line(&mut line1).unwrap();
  let line1_vec:Vec<usize> = line1.split_whitespace().map(|x| x.parse().unwrap()).collect();
  let total_length = line1_vec[0];
  let target_length = line1_vec[1];

  let mut line2 = String::new();
  std::io::stdin().read_line(&mut line2).unwrap();
  let mut sorted_numbers:Vec<usize> = line2.split_whitespace().map(|x| x.parse().unwrap()).collect();
  sorted_numbers.sort();

  let mut result_sequences = String::new();
  let mut sequence:Vec<usize> = Vec::new();

  fn dfs(start:usize, depth:usize, sorted_numbers:&[usize], total_length:usize, target_length:usize, result_sequences:&mut String, sequence:&mut Vec<usize>){
    if depth > target_length {
      result_sequences.push_str(&sequence.iter().map(|x| x.to_string()).collect::<Vec<String>>().join(" "));
      result_sequences.push('\n');
      return;
    }
    for i in start .. total_length {
      sequence.push(sorted_numbers[i]);
      dfs(i, depth + 1, sorted_numbers, total_length, target_length, result_sequences, sequence);
      sequence.pop();
    }
  }

  dfs(0, 1, &sorted_numbers, total_length, target_length, &mut result_sequences, &mut sequence);
  print!("{}", result_sequences);
}