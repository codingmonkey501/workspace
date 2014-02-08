package day3.oop

object ImplicitAccessorMutator extends App {

  val t = new Thermometer
  println(t)
  t.fahrenheit=10
  println(t)
  
  /**
   * 1. implicit getter and setter
   */
  class Thermometer {
    var celsius: Float = _
    def fahrenheit = celsius * 9 / 5 + 32
    def fahrenheit_= (f: Float) {
      celsius = (f - 32) * 5 / 9
    }
    override def toString = fahrenheit + "F/" + celsius + "C"
  }
}