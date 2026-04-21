fn main(){
  let mut s = String::new();
  std::io::stdin().read_line(&mut s).unwrap();
  let n = s.trim().parse::<i32>().unwrap();

  for i in (0 ..= n/5).rev() {
    let rest = n - 5 * i;
    if rest % 3 == 0 {
      print!("{}", i + rest / 3);
      break
    }
    if i == 0 {print!("{}", -1);}
  }
}