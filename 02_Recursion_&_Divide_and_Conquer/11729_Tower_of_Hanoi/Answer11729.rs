use std::fmt::Write;

fn main(){
  let mut s = String::new();
  std::io::stdin().read_line(&mut s).unwrap();
  let n:u8 = s.trim().parse().unwrap();
  let mut result_str = ((1u32 << n) - 1).to_string();

  fn recursion_fn(n:u8, from:u8, to:u8, result_str:&mut String){
    let auxiliary = 6 - from - to;
    if n == 1 {
      write!(result_str, "\n{} {}", from, to).unwrap();
    } else {
      recursion_fn(n - 1, from, auxiliary, result_str);
      write!(result_str, "\n{} {}", from, to).unwrap();
      recursion_fn(n - 1, auxiliary, to, result_str);
    }
  }
  recursion_fn(n, 1, 3, &mut result_str);
  print!("{result_str}")
}