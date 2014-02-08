package day3.oop

object CaseClassPattern2 extends App {
  
  /**
   * 1. output expression
   */
  val exp: Tree = Sum(Sum(Var("x"), Var("x")), Sum(Const(7), Var("y")))
  println("Expression: " + exp)
  
  /**
   * 2. "type" key word is type alias representing a Function type
   */
  type Environment = String => Int
  val env: Environment = { case "x" => 5 case "y" => 7 }
  
  println("Evaluation with x=5, y=7: " + eval(exp, env))
  def eval(t: Tree, env: Environment): Int = t match {
    case Sum(l, r) => eval(l, env) + eval(r, env)
    case Var(n) => env(n)
    case Const(v) => v
  }
  
  /**
   * 3. print expression
   * 4. _ key words means any or default
   */
  println("Derivative relative to x:\n " + derive(exp, "x"))
  println("Derivative relative to y:\n " + derive(exp, "y"))

  def derive(t: Tree, v: String): Tree = t match {
    case Sum(l, r) => Sum(derive(l, v), derive(r, v))
    case Var(n) if (v == n) => Const(1)
    case _ => Const(0)
  }

  abstract class Tree
  case class Sum(l: Tree, r: Tree) extends Tree
  case class Var(n: String) extends Tree
  case class Const(v: Int) extends Tree
}