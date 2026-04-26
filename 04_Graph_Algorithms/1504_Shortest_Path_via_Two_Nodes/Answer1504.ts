const [[nodesLength, edgesLength], ...rests] = `${require('fs').readFileSync(0)}`.split('\n').map(v=>v.split(' ').map(v=>+v))
const edges = Array.from({length:nodesLength}, () => [])
for(let i = 0; i < edgesLength; i++){
  const it = rests[i]
  edges[it[0] - 1].push([it[1], it[2]])
  edges[it[1] - 1].push([it[0], it[2]])
}

const [v1, v2] = rests[edgesLength]

function getShortestPath(nowNode, to1, to2){
  const costOfNodes = new Array(nodesLength).fill(Infinity)
  costOfNodes[nowNode - 1] = 0
  const candidates = [[nowNode, 0]]

  while(candidates.length){
    let minIdx = 0
    const candidatesLength = candidates.length
    for(let i = 0; i < candidatesLength; i++){
      if(candidates[i][1] < candidates[minIdx][1]) minIdx = i
    }
    const [candidateNode, candidateMin] = candidates[minIdx]
    candidates[minIdx] = candidates[candidatesLength - 1]
    candidates.pop()

    if(candidateMin > costOfNodes[candidateNode - 1]) continue

    nowNode = candidateNode
    costOfNodes[nowNode - 1] = candidateMin

    for(let i = 0; i < edges[nowNode - 1].length; i++) {
      const [toNode, weight] = edges[nowNode - 1][i]
      if(costOfNodes[nowNode - 1] + weight < costOfNodes[toNode - 1]){
        costOfNodes[toNode - 1] = costOfNodes[nowNode - 1] + weight
        candidates.push([toNode, costOfNodes[toNode - 1]])
      }
    }
  }

  if(to2 > 0){
    return [costOfNodes[to1 - 1], costOfNodes[to2 - 1]]
  } else {
    return [costOfNodes[to1 - 1]]
  }
}

const cost1 = getShortestPath(1, v1, v2)
const costV1 = getShortestPath(v1, v2, nodesLength)
const costV2 = getShortestPath(v2, nodesLength, 0)

const minValue = Math.min(cost1[0] + costV1[0] + costV2[0], cost1[1] + costV1[0] + costV1[1])

console.log(minValue === Infinity ? -1 : minValue)