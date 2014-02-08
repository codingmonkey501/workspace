package day2.basic

object CheetSheet6PatternMatching extends App {

  val xs = 1 to 7
  val ys = 8 to 14
  //use case in function args for pattern matching.
  (xs zip ys) map { case (x, y) => x * y }
  //BAD (xs zip ys) map( (x,y) => x*y )	

  
  //“v42” is interpreted as a name matching any Int value, and “42” is printed.
  //BAD
  val v42 = 42
  Some(3) match {
    case Some(v42) => println("42")
    case _ => println("Not 42")
  }

  //“`v43`” with backticks is interpreted as the existing val v43, and “Not 43” is printed.
  val v43 = 43
  Some(3) match {
    case Some(`v43`) => println("43")
    case _ => println("Not 43")
  }

  //UppercaseVal is treated as an existing val, rather than a new pattern variable, because it starts with an uppercase letter. Thus, the value contained within UppercaseVal is checked against 3, and “Not 42” is printed.
  val UppercaseVal = 42
  Some(3) match {
    case Some(UppercaseVal) => println("42")
    case _ => println("Not 42")
  }

}