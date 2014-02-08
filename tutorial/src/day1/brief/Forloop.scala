package day1.brief

/**
 * 1. for loop
 * 2. filter
 * 3. <- operator
 * 4. yield key word
 */
object forLoop extends App {
  val s = for (x <- 1 to 25 if x * x > 50) yield 2 * x
  println(s)
}