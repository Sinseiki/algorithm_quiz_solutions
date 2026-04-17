fn main(){
  let mut s = String::new();
  std::io::stdin().read_line(&mut s).unwrap();
  let o: Vec<usize> = s.split_whitespace().map(|x| x.parse().unwrap()).collect();
  let m = o[0];
  let n = o[1];
  let mut a: Vec<usize> = vec![1; n];

  let mut i:usize = 2;
  while i <= n / i {
    if a[i - 1] == 1 {
      for j in i ..= n/i { a[i * j - 1] = 0; }
    }
    i += 1;
  }

  for i in (if m > 1 {m - 1} else {1}) .. n {
    if a[i] == 1 {println!("{}", i + 1);}
  }
}