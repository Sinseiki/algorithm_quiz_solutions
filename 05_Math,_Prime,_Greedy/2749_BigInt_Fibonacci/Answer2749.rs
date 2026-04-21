fn main(){
  let mut s = String::new();
  std::io::stdin().read_line(&mut s).unwrap();
  let b:u64 = s.trim().parse().unwrap();
  let n = b % 1500000;
  let mut f1 = 0;
  let mut f2 = 1;

  for _ in 1 .. n {
    let prev = f1;
    f1 = f2;
    f2 = (prev + f1) % 1000000;
  }
  print!("{}", if n==0 {0} else {f2});
}