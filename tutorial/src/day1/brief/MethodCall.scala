package day1.brief

import scala.math.cbrt
import scala.math.log

/**
 * 1. function call
 * 2. type conversion
 * 3. math package
 * 4. import package
 * 5. function call without parameters
 * 6. val vs. var
 * 7. implicit type conversion
 */
object methodCall extends App{
  println(mathFunction(1));
  println(intRoot23(2));

  def mathFunction(num: Int): Int = {
    var numSquare: Int = num * num
    return (math.cbrt(numSquare) + math.log(numSquare)).asInstanceOf[Int]
  }

  import math._
  def intRoot23(num: Int) = {
    val numSquare = num * num
    (cbrt(numSquare) + log(numSquare)).toInt
  }
}