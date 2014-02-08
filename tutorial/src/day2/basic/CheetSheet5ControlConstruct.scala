package day2.basic

object CheetSheet5ControlConstruct extends App {

  //conditional.
  val check = false
  var happy = "happy"
  var sad = "sad"

  if (check) happy else sad

  //conditional sugar.
  if (check) happy
  if (check) happy else ()

  //while loop.
  var x = 4
  while (x < 5) { println(x); x += 1 }

  //do while loop.
  do { println(x); x += 1 } while (x < 5)

  //break. (slides)
  import scala.util.control.Breaks._
  val xs = 1 until 5
  breakable {
    for (x <- xs) {
      if (Math.random < 0.1) break
    }
  }

  //for comprehension: filter/map
  for (x <- xs if x % 2 == 0) yield x * 10
  xs.filter(_ % 2 == 0).map(_ * 10)

  //for comprehension: destructuring bind
  val ys = 5 to 10
  println(xs zip ys)

  for ((x, y) <- xs zip ys) yield x * y
  val m = (xs zip ys) map { case (x, y) => x * y }
  println(m)

  //for comprehension: cross product
  //=> is eqvalent to foreach
  for (x <- xs; y <- ys) yield x * y
  xs flatMap { x => ys map { y => x * y } }

  //for comprehension: imperative-ish
  for (x <- xs; y <- ys) {
    //sprintf-style
    println("%d/%d = %.2f".format(x, y, x.toFloat / y))
  }

  //for comprehension: iterate including the upper bound
  for (i <- 1 to 5) {
    println(i)
  }
  
  for (i <- 1 until 5) {
    println(i)
  }
}