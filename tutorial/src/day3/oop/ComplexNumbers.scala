package day3.oop

object ComplexNumbers extends App {
  
  /**
   * 1. access getter without argument
   */
  val c = new Complex(1.2, 3.4)
  println("imaginary part: " + c.im)
  println(c)

  /**
   * 1. constructor
   * 2. getter
   * 3. override toString
   */
  class Complex(real: Double, imaginary: Double) {
    def re() = real
    def im() = imaginary
    override def toString() = "" + re + (if (im < 0) "" else "+") + im + "i"
  }
}