fn main(){
  let mut s = String::new();
  std::io::stdin().read_line(&mut s).unwrap();
  let n:usize = s.trim().parse().unwrap();
  let mut t:Vec<String> = [
    String::from("***"),
    String::from("* *"),
    String::from("***")].to_vec();
  let mut i = 3;

  while i < n {
    let mut t123:Vec<String> = Vec::new();
    let mut t456:Vec<String> = Vec::new();
    for it in &t {
      t123.push(it.repeat(3));
      t456.push(format!("{}{}{}", it, " ".repeat(it.len()), it));
    }

    t.clear();
    t.extend(t123.iter().cloned());
    t.extend(t456);
    t.extend(t123);
    i *= 3;
  }
  print!("{}", t.join("\n"));
}