use std::io::{stdin, Read};
use std::fmt::Write;

fn main(){
  let mut s = String::new();
  stdin().read_to_string(&mut s).unwrap();
  let inputs_arr:Vec<usize> = s.split_whitespace().map(|x| x.parse().unwrap()).collect();
  let n:usize = inputs_arr[0];

  let mut primes = [1u8; 10000];
  primes[0] = 0;
  let mut i = 2;
  while i <= 10000/i {
    if primes[i - 1] == 1 {
      for j in i ..= 10000/i {primes[i * j - 1] = 0;}
    }
    i+=1;
  }

  let mut result_str = String::new();
  for h in 0 .. n {
    let mut a:usize = inputs_arr[h + 1]/2;
    let mut b:usize = inputs_arr[h + 1]/2;
    if h > 0 {result_str.push('\n')}
    loop {
      if primes[a - 1] + primes[b - 1] == 2 {
        write!(result_str, "{} {}", a, b).unwrap();
        break;
      }
      a-=1;
      b+=1;
    }
  }

  print!("{}", result_str);
}