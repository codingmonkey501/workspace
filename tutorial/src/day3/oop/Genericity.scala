package day3.oop

object Genericity extends App {
  
  val cell = new Reference[Int]
  cell.set(13)
  println("Reference contains the half of " + (cell.get * 2))
  
  /**
   * 1. generic type
   */
  class Reference[T] {
    private var contents: T = _
    def set(value: T) { contents = value }
    def get: T = contents
  }
}