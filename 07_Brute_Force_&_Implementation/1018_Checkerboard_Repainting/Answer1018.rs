fn main(){
  let patterns = ["BWBWBWBW", "WBWBWBWB"];
  let mut paints = 32;
  let mut s = String::new();
  std::io::stdin().read_line(&mut s).unwrap();
  let o: Vec<usize> = s.split_whitespace().map(|x| x.parse().unwrap()).collect();
  let height = o[0];
  let width = o[1];
  let mut board : Vec<String> = Vec::new();
  loop {
    let mut line = String::new();
    if std::io::stdin().read_line(&mut line).unwrap() == 0 { break; }
    board.push(line);
  }
  for pattern_type in 0 .. 2 {
    for start_y in 0 ..= height - 8 {
      for start_x in 0 ..= width - 8 {
        let mut paint_count = 0;
        for y in start_y .. start_y + 8 {
          for x in 0usize..8usize {
            if patterns[(y + pattern_type) % 2][x .. x + 1] != board[y][start_x + x .. start_x + x + 1] {
              paint_count += 1;
            }
          }
        }
        paints = std::cmp::min(paints, paint_count);
      }
    }
  }
  print!("{paints}")
}