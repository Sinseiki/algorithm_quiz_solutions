const [[verticesLength, edgesLength, startVertex], ...rests] = `${require('fs').readFileSync(0)}`.trim().split('\n').map(l=>l.split(' ').map(v=>+v))
const edges = []
for(let i = 0; i < verticesLength; i++) edges.push([])
for(let i = 0; i < edgesLength; i++){
  const it = rests[i]
  edges[it[0] - 1].push(it[1])
  edges[it[1] - 1].push(it[0])
}
const sortedEdges = edges.map(it => it.sort((a,b) => a-b))
const dfsVisited = new Array(verticesLength).fill(false)
const bfsIsFound = [...dfsVisited]


const dfsResult = []

function dfsRecursion(frm){
  dfsResult.push(frm)
  dfsVisited[frm - 1] = true
  for(const it of sortedEdges[frm - 1]){
    if(!dfsVisited[it - 1]){
      dfsRecursion(it)
    }
  }
}
dfsRecursion(startVertex)
console.log(dfsResult.join(' '))


const bfsResult = []
const bfsFound = [startVertex]
bfsIsFound[startVertex - 1] = true
let bfsFoundPointer = 0

function bfsFinder(){
  while(bfsFoundPointer < bfsFound.length){
    for(const it of sortedEdges[bfsFound[bfsFoundPointer] - 1]){
      if(!bfsIsFound[it - 1]){
        bfsFound.push(it)
        bfsIsFound[it - 1] = true
      }
    }
    bfsResult.push(bfsFound[bfsFoundPointer])
    bfsFoundPointer++
  }
}
bfsFinder()
console.log(bfsResult.join(' '))
