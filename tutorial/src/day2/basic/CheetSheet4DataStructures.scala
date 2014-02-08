package day2.basic

object CheetSheet4DataStructures extends App {
  
  //tuple literal. (Tuple3)
  (1, 2, 3)

  //destructuring bind: tuple unpacking via pattern matching.
  var (x, y, z) = (1, 2, 3)

  //hidden error: each assigned to the entire tuple.
  //BAD var x,y,z = (1,2,3)	

  //list (immutable).
  var xs = List(1, 2, 3)
  //paren indexing. (slides)
  xs(2)

  //cons.
  val l = 1 :: List(2, 3)
  print(l)

  1 to 5

  1 until 6

  //range sugar.
  1 to 10 by 2

  //(empty parens)	sole member of the Unit type (like C/Java void).
  ()

}