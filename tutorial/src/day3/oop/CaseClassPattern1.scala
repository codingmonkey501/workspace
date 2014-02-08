package day3.oop

object CaseClassPattern extends App {

  /**
   * 1. class passed as function (lambda calculus)
   */
  var exp = Fun("x", Fun("y", App(Var("x"), Var("y"))))
  println(exp)
  
  /**
   * 2. getter setter for params in constructor
   */
  val x = Var("term name")
  Console.println(x.name)

  /**
   * 3. "hash code / equals" is inside 
   */
  val x1 = Var("x")
  val x2 = Var("x")
  val y1 = Var("y")
  println("" + x1 + " == " + x2 + " => " + (x1 == x2))
  println("" + x1 + " == " + y1 + " => " + (x1 == y1))
  
  
  abstract class Term
  case class Var(name: String) extends Term
  case class Fun(arg: String, body: Term) extends Term
  case class App(f: Term, v: Term) extends Term
  
  /**
   * 4. case class and term match with no return
   */
  val id = Fun("x", Var("x"))
  val t = Fun("x", Fun("y", App(Var("x"), Var("y"))))
  printTerm(t)
  
  def printTerm(term: Term) {
    term match {
      case Var(n) =>
        print(n)
      case Fun(x, b) =>
        print("^" + x + ".")
        printTerm(b)
      case App(f, v) =>
        Console.print("(")
        printTerm(f)
        print(" ")
        printTerm(v)
        print(")")
    }
  }
  
  /**
   * 5. term match with returns
   */
  println
  println(isIdentityFun(id))
  println(isIdentityFun(t))
  
  
  def isIdentityFun(term: Term): Boolean = term match {
    case Fun(x, Var(y)) if x == y => true
    case _ => false
  }
  
}