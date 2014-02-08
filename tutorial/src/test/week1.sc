package day4.coursesa

object week1 {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet

  def sqrt(x: Double) = {
    def abs(x: Double) = if (x < 0) -x else x
    def sqrtRecusive(guess: Double): Double =
      if (isGoodEnough(guess)) guess
      else sqrtRecusive(improve(guess))
    def isGoodEnough(guess: Double) =
      abs(guess * guess - x) / x < 1e-10
    def improve(guess: Double) =
      (guess + x / guess) / 2
    sqrtRecusive(1.0)
  }                                               //> sqrt: (x: Double)Double

  sqrt(1)                                         //> res0: Double = 1.0
  sqrt(2)                                         //> res1: Double = 1.4142135623746899
  sqrt(1e-3)                                      //> res2: Double = 0.03162277660168433
  sqrt(4)                                         //> res3: Double = 2.000000000000002
  sqrt(100)                                       //> res4: Double = 10.000000000139897
  sqrt(1.0e-20)                                   //> res5: Double = 1.000000000002308E-10
  sqrt(1.0e12)                                    //> res6: Double = 1000000.0000000054
  sqrt(1.0e60)                                    //> res7: Double = 1.0E30
}