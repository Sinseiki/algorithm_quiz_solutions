const vals = `${require('fs').readFileSync(0)}`.split('\n').map(l => l.split(' ').map(v => +v))
const orientationNum = (vals[1][0] - vals[0][0]) * (vals[2][1] - vals[0][1])
    - (vals[1][1] - vals[0][1]) * (vals[2][0] - vals[0][0])
console.log(orientationNum > 0 ? 1 : orientationNum < 0 ? -1 : 0)