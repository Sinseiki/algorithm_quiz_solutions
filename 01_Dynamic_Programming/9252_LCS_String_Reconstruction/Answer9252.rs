fn main(){
  let l:Vec<String> = (0 .. 2).map(|_| {
    let mut s = String::new();
    std::io::stdin().read_line(&mut s).unwrap();
    s}).collect();
  let (s1, s2) = (l[0].trim(), l[1].trim());
  let (s1_length_plus1, s2_length_plus1) = (s1.len() + 1, s2.len() + 1);
  let (s1_byte, s2_byte) = (s1.as_bytes(), s2.as_bytes());
  let mut dp = vec![0; s1_length_plus1 * s2_length_plus1];
  for i in 0 .. s1_length_plus1 - 1 {
    for j in 0 .. s2_length_plus1 - 1 {
      dp[(i + 1) * s2_length_plus1 + j + 1] =
          if s1_byte[i] == s2_byte[j] {
            dp[i * s2_length_plus1 + j] + 1
          } else if dp[(i + 1) * s2_length_plus1 + j] > dp[i * s2_length_plus1 + j + 1] {
            dp[(i + 1) * s2_length_plus1 + j]
          } else {dp[i * s2_length_plus1 + j + 1]}
    }
  }
  println!("{}", dp[s1_length_plus1 * s2_length_plus1 - 1]);

  let mut lcs = String::new();
  let mut i = s1_length_plus1 - 1;
  let mut j = s2_length_plus1 - 1;
  while i > 0 && j > 0 {
    if dp[i * s2_length_plus1 + j] == dp[i * s2_length_plus1 + j - 1] {
      j-=1;
    } else if dp[i * s2_length_plus1 + j] == dp[(i - 1) * s2_length_plus1 + j] {
      i-=1;
    } else if dp[i * s2_length_plus1 + j] - dp[(i - 1) * s2_length_plus1 + (j - 1)] == 1
        && s1_byte[i - 1] == s2_byte[j - 1] {
      lcs.push(s2.chars().collect::<Vec<char>>()[j - 1]);
      i-=1;
      j-=1;
    }
  }
  println!("{}", lcs.chars().rev().collect::<String>());
}