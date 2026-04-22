- Inspired by: [BOJ 11758](https://www.acmicpc.net/problem/11758) (Gold V)

- Problem type: Geometry / CCW / Orientation Test

- Goal: given three distinct points on a 2D plane,
  determine whether moving from the first point to the second 
  and then to the third forms a counterclockwise turn, a clockwise turn, or a straight line.

- Summarize:
    - Read three 2D points in order
    - Interpret them as an ordered path: P1 → P2 → P3
    - Determine the orientation of this turn on the plane
    - If the turn is counterclockwise, output 1
    - If the turn is clockwise, output -1
    - If the three points are collinear, output 0

- Input format:
    - The first line contains two integers x1 and y1
    - The second line contains two integers x2 and y2
    - The third line contains two integers x3 and y3
    - Each pair represents the coordinates of one point
    - All coordinates are integers in the range -10000 to 10000
    - The three points are all different

- Output:
    - Print one integer
    - Print 1 if the ordered points make a counterclockwise turn
    - Print -1 if they make a clockwise turn
    - Print 0 if they lie on a single straight line

<details> 
  <summary>- Solution approach:</summary>
  <pre> 
  1. Read three 2D points P1, P2, P3 from input.
  2. The goal is to determine the orientation of the sequence:
   P1 → P2 → P3
  - Counterclockwise (CCW)
  - Clockwise (CW)
  - Collinear
  3. Initial idea:
  - Compare slopes:
    (y3 - y1) / (x3 - x1) and (y2 - y1) / (x2 - x1)
  - This seems intuitive but introduces problems:
    - Division by zero when x2 = x1 or x3 = x1
    - Sign ambiguity when multiplying inequalities
    - Requires multiple conditional branches
  4. Attempted workaround:
  - Remove division by cross-multiplication
  - Consider handling cases like dx = 0 separately
  - This approach works but becomes increasingly complex
    due to case distinctions and sign handling
  5. Key observation:
  - Instead of comparing slopes (angles), we only need
    the relative rotation direction between two vectors
  6. Reformulation:
  - Translate the coordinate system so that P1 becomes the origin
  - Define two vectors:
    A = P1 → P2 = (x2 - x1, y2 - y1)
    B = P1 → P3 = (x3 - x1, y3 - y1)
  7. Compute the value:
   orientation = (x2 - x1)*(y3 - y1) - (y2 - y1)*(x3 - x1)
  - This can be understood as:
    - The signed area of the parallelogram formed by A and B
    - Or equivalently, a determinant-like expression
    - The sign directly encodes rotation direction
  8. Interpretation:
  - If orientation > 0 → CCW (left turn)
  - If orientation < 0 → CW (right turn)
  - If orientation = 0 → collinear
  9. This formulation avoids:
  - Division entirely
  - Special cases for vertical or horizontal lines
  - Complex branching logic
  10. Output the result based on the sign of orientation.
  </pre> 
</details>