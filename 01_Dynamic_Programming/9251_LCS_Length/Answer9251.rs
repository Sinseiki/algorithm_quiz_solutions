fn main(){
  let l:Vec<String>=(0 ..2).map(|_|{
    let mut s=String::new();
    std::io::stdin().read_line(&mut s).unwrap();
  s}).collect();
  let (s1, s2) = (&l[0].trim(), &l[1].trim());
  let (s1_length, s2_length) = (s1.len(), s2.len());
  let mut tmp_row = vec![0; s1_length + 1];
  for y in 1 ..= s2_length {
    let mut diagonal_x = 0;
    for x in 1 ..= s1_length {
      let upper_x = tmp_row[x];
      tmp_row[x] = if s1.as_bytes()[x - 1] == s2.as_bytes()[y - 1]{
        diagonal_x + 1
      } else if tmp_row[x - 1] > tmp_row[x] {tmp_row[x - 1]} else {tmp_row[x]};
      diagonal_x = upper_x;
    }
  }
  print!("{}", tmp_row[s1_length])
}
