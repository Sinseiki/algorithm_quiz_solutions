use std::io::{stdin, Read};
use std::fmt::Write;

fn main(){
  let mut s = String::new();
  stdin().read_to_string(&mut s).unwrap();
  let inputs:Vec<&str> = s.trim().split('\n').collect();
  let lengths:Vec<usize> = inputs[0].split_whitespace().map(|x| x.parse::<usize>().unwrap()).collect();
  let (vertices_length, edges_length, start_vertex) = (lengths[0], lengths[1], lengths[2]);
  let mut edges = vec![Vec::new(); vertices_length];
  for i in 1 ..= edges_length {
    let it:Vec<usize> = inputs[i].split_whitespace().map(|x| x.parse().unwrap()).collect();
    edges[it[0] - 1].push(it[1]);
    edges[it[1] - 1].push(it[0]);
  }
  for it in &mut edges {it.sort();}

  let sorted_edges:Vec<Vec<usize>> = edges;
  let mut dfs_visited:Vec<bool> = vec![false; vertices_length];
  let mut bfs_is_found = dfs_visited.clone();


  let mut dfs_result = String::new();

  fn dfs_recursion(frm:usize, sorted_edges:&Vec<Vec<usize>>, dfs_result:&mut String, dfs_visited:&mut Vec<bool>) {
    write!(dfs_result, "{} ", frm).unwrap();
    dfs_visited[frm - 1] = true;
    for it in &sorted_edges[frm - 1] {
      if !dfs_visited[it - 1] {
        dfs_recursion(*it, sorted_edges, dfs_result, dfs_visited)
      }
    }
  }
  dfs_recursion(start_vertex, &sorted_edges, &mut dfs_result, &mut dfs_visited);
  println!("{}", dfs_result.trim());


  let mut bfs_result = String::new();
  let mut bfs_found:Vec<usize> = Vec::new();
  bfs_found.push(start_vertex);
  bfs_is_found[start_vertex - 1] = true;
  let bfs_found_pointer = 0;

  fn bfs_finder(mut bfs_found_pointer:usize, bfs_found:&mut Vec<usize>, sorted_edges:Vec<Vec<usize>>, bfs_is_found:&mut [bool], bfs_result:&mut String) {
    while bfs_found_pointer < bfs_found.len() {
      for it in &sorted_edges[bfs_found[bfs_found_pointer] - 1] {
        if !bfs_is_found[it - 1] {
          bfs_found.push(*it);
          bfs_is_found[it - 1] = true;
        }
      }
      write!(bfs_result, "{} ", bfs_found[bfs_found_pointer]).unwrap();
      bfs_found_pointer+=1;
    }
  }
  bfs_finder(bfs_found_pointer, &mut bfs_found, sorted_edges, &mut bfs_is_found, &mut bfs_result);
  println!("{}", bfs_result.trim());
}
