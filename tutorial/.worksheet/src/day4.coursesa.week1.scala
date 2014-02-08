package day4.coursesa

object week1 {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(82); 
  println("Welcome to the Scala worksheet");$skip(365); 

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
  };System.out.println("""sqrt: (x: Double)Double""");$skip(12); val res$0 = 

  sqrt(1);System.out.println("""res0: Double = """ + $show(res$0));$skip(10); val res$1 = 
  sqrt(2);System.out.println("""res1: Double = """ + $show(res$1));$skip(13); val res$2 = 
  sqrt(1e-3);System.out.println("""res2: Double = """ + $show(res$2));$skip(10); val res$3 = 
  sqrt(4);System.out.println("""res3: Double = """ + $show(res$3));$skip(12); val res$4 = 
  sqrt(100);System.out.println("""res4: Double = """ + $show(res$4));$skip(16); val res$5 = 
  sqrt(1.0e-20);System.out.println("""res5: Double = """ + $show(res$5));$skip(15); val res$6 = 
  sqrt(1.0e12);System.out.println("""res6: Double = """ + $show(res$6));$skip(15); val res$7 = 
  sqrt(1.0e60);System.out.println("""res7: Double = """ + $show(res$7))}
}
