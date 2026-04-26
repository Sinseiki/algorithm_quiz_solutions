use std::cmp::Reverse;
use std::collections::BinaryHeap;
use std::io::{stdin, Read};

fn main(){
  let mut s = String::new();
  stdin().read_to_string(&mut s).unwrap();
  let inputs:Vec<Vec<usize>> = s.trim().split('\n').map(|x| x.split_whitespace().map(|x| x.parse().unwrap()).collect()).collect();
  let nodes_length = inputs[0][0];
  let edges_length = inputs[0][1];
  let mut edges:Vec<Vec<[usize;2]>> = vec![Vec::new(); nodes_length];
  for i in 1 ..= edges_length {
    let it = &inputs[i];
    edges[it[0] - 1].push([it[1], it[2]]);
    edges[it[1] - 1].push([it[0], it[2]]);
  }

  let v1 = inputs[inputs.len() - 1][0];
  let v2 = inputs[inputs.len() - 1][1];
  let infinity = (i32::MAX >> 2) as usize;

  fn get_shortest_path(mut now_node:usize, to1:&usize, to2:&usize, nodes_length:&usize, infinity:&usize, edges:&[Vec<[usize;2]>]) -> [usize;2] {
    let mut cost_of_nodes:Vec<usize> = vec![*infinity; *nodes_length];
    cost_of_nodes[now_node - 1] = 0;
    let mut candidates = BinaryHeap::new();
    candidates.push(Reverse((0, now_node)));

    while !candidates.is_empty() {
      let Some(Reverse((candidate_min, candidate_node))) = candidates.pop() else {todo!()};

      if candidate_min > cost_of_nodes[candidate_node - 1] {continue};

      now_node = candidate_node;
      cost_of_nodes[now_node - 1] = candidate_min;

      for i in 0 .. edges[now_node - 1].len() {
        let to_node:usize = edges[now_node - 1][i][0];
        let weight = edges[now_node - 1][i][1];
        if cost_of_nodes[now_node - 1] + weight < cost_of_nodes[to_node - 1] {
          cost_of_nodes[to_node - 1] = cost_of_nodes[now_node - 1] + weight;
          candidates.push(Reverse((cost_of_nodes[to_node - 1], to_node)));
        }
      }
    }

    if *to2 > 0 {
      [cost_of_nodes[to1 - 1], cost_of_nodes[to2 - 1]]
    } else {
      [cost_of_nodes[to1 - 1], *infinity]
    }
  }

  let cost1 = get_shortest_path(1, &v1, &v2, &nodes_length, &infinity, &edges);
  let cost_v1 = get_shortest_path(v1, &v2, &nodes_length, &nodes_length, &infinity, &edges);
  let cost_v2 = get_shortest_path(v2, &nodes_length, &0usize, &nodes_length, &infinity, &edges);

  let min_value = std::cmp::min(cost1[0] + cost_v1[0] + cost_v2[0], cost1[1] + cost_v1[0] + cost_v1[1]);

  print!("{}", if infinity <= min_value {-1i64} else {min_value as i64});
}