import sun.invoke.empty.Empty
import test.week4.nat.Natural
import test.week4.bool.True
import test.week4.bool.False

object week4 {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet

  List(1, 2, 3)                                   //> res0: List[Int] = List(1, 2, 3)

  //decomposition

  trait Expr {
    def isNumber: Boolean
    def isSum: Boolean
    def numValue: Int
    def leftOp: Expr
    def rightOp: Expr
  }

  class Number(n: Int) extends Expr {
    def isNumber: Boolean = true
    def isSum: Boolean = false
    def numValue: Int = n
    def leftOp: Expr = throw new Error("Number.leftOp")
    def rightOp: Expr = throw new Error("Number.rightOp")
  }

  class Sum(e1: Expr, e2: Expr) extends Expr {
    def isNumber: Boolean = false
    def isSum: Boolean = true
    def numValue: Int = throw new Error("Sum.numValue")
    def leftOp: Expr = e1
    def rightOp: Expr = e2
    def eval(e: Expr): Int = {
      if (e.isNumber) e.numValue
      else if (e.isSum) eval(e.leftOp) + eval(e.rightOp)
      else throw new Error("Unknown expression " + e)
    }
  }
  
  trait Expr2{
    def eval:Int
  }
  class Num2(n: Int) extends Expr2{
  	def eval:Int = n
  }
  class Sum2(e1: Expr2, e2: Expr2) extends Expr2 {
    def eval:Int = e1.eval + e2.eval
  }

}