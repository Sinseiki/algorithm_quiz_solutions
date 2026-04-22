fn main(){
  let mut s = String::new();
  std::io::stdin().read_line(&mut s).unwrap();
  let n = s.trim().parse::<i32>().unwrap();
  
  for y in 0 .. n {
    let mut line = String::new();
    for x in 0 .. n {
      let mut tmp_x = x;
      let mut tmp_y = y;
      let mut tmp_s = "*";
      while tmp_x >= 1 && tmp_y >= 1 {
        if tmp_y  % 3 == 1 && tmp_x % 3 == 1 {
          tmp_s = " ";
          break;
        }
        tmp_x /= 3;
        tmp_y /= 3;
      }
      line.push_str(tmp_s);
    }
    println!("{line}");
  }
}
