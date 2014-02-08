package test

import scala.annotation.tailrec

object week2 {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet

  def factorial(n: Int): Int =
    if (n == 1) 1 else n * factorial(n - 1)       //> factorial: (n: Int)Int

  factorial(3)                                    //> res0: Int = 6

  def factorial2(n: Int): Int = {

    @tailrec
    def loop(acu: Int, n: Int): Int =
      if (n == 0) acu else loop(acu * n, n - 1)
    loop(1, n)
  }                                               //> factorial2: (n: Int)Int

  factorial(3)                                    //> res1: Int = 6

  //Write a product function that calculates the product of the
  //values of a function for the points on a given interval.

  def product1(start: Int, end: Int, interval: Int): Int = {
    def next(start: Int): Int = start + interval
    def loop(start: Int): Int =
      if (start >= end) start else start * loop(next(start))
    loop(start)
  }                                               //> product1: (start: Int, end: Int, interval: Int)Int

  def product2(start: Int, end: Int, interval: Int): Int = {
    def next(start: Int): Int = start + interval
    def loop(next: Int => Int, start: Int): Int = {
      if (start >= end) start else start * loop(next, next(start))
    }
    loop(next, start)
  }                                               //> product2: (start: Int, end: Int, interval: Int)Int

  def product3(start: Int, end: Int, interval: Int): Int = {
    def next(end: Int): Int = end - interval
    @tailrec
    def loop(product: Int, end: Int): Int =
      if (end <= start) product else loop(product * next(end), next(end))
    loop(end, end)
  }                                               //> product3: (start: Int, end: Int, interval: Int)Int

  product1(1, 21, 2)                              //> res2: Int = 864408687
  product3(1, 21, 2)                              //> res3: Int = 864408687
  product2(1, 21, 2)                              //> res4: Int = 864408687
  

  def sum(f: Int => Int)(a: Int, b: Int): Int =
    if (a > b) 0 else f(a) + sum(f)(a + 1, b)     //> sum: (f: Int => Int)(a: Int, b: Int)Int

  sum(x => x * x)(1, 2)                           //> res5: Int = 5

  //rational num

  class Rational(n: Int, d: Int) {
  	require(d > 0, "denominator must be positive")
    def number = n
    def denominator = d
    def this(x: Int) = this(x, 1)
    private val g = {
    	val x = gcd(n, d)
    	if (x > 0) x else -x
    }
    def + (r: Rational): Rational = {
      new Rational(number * r.denominator + denominator * r.number, denominator * r.denominator)
    }
    def neg(): Rational = {
      //n = 0 - n
      new Rational(0-n, d)
    }
    def unary_- : Rational = {
      //n = 0 - n
      new Rational(0-n, d)
    }
    def - (that: Rational): Rational = {
      this + -that
    }
    def < (that: Rational) =
      number * that.denominator < that.number * denominator
    def max(that: Rational) =
      if (this < that) that else this
    private def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)
    override def toString = number/g + "/" + denominator/g
  }

  val r = new Rational(1, 2)                      //> r  : test.week2.Rational = 1/2
  val s = new Rational(3, 4)                      //> s  : test.week2.Rational = 3/4
  r + s                                           //> res6: test.week2.Rational = 5/4
  r - s                                           //> res7: test.week2.Rational = -1/4
	
	new Rational(2)                           //> res8: test.week2.Rational = 2/1
  val x = new Rational(1, 3)                      //> x  : test.week2.Rational = 1/3
  val y = new Rational(5, 7)                      //> y  : test.week2.Rational = 5/7
  val z = new Rational(3, 2)                      //> z  : test.week2.Rational = 3/2
  x - y -z                                        //> res9: test.week2.Rational = -79/42
	//infix
  r + s                                           //> res10: test.week2.Rational = 5/4
  r - s                                           //> res11: test.week2.Rational = -1/4
  x - y - z                                       //> res12: test.week2.Rational = -79/42
  x < y                                           //> res13: Boolean = true
  x max y                                         //> res14: test.week2.Rational = 5/7
}