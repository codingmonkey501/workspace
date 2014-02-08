package day2.basic

object CheetSheet2 extends App {

  /**
   * functions
   */

  //functions -- without = it’s a Unit-returning procedure; causes havoc
  def f(x: Int) = { x * x }

  //syntax error: need types for every arg.
  //BAD def f(x) = println(x)

  //type alias
  type R = Double
  //call-by-value
  def f(x: R) = { x * x }
  //call-by-name (lazy parameters)
  def f(x: => R) = { lazy val cache = x }

  //lazy parameter
  def f(p: => Int, eval: Boolean) = if (eval) println(p)
  f(3, true)
  f(3 / 0, false)
  //f(3 / 0, true)

  //anonymous function
  (x: R) => x * x

  val v1 = (1 to 5).map(_ * 2)

  //anonymous function: underscore is positionally matched arg.
  val v2 = (1 to 5).reduceLeft(_ + _)

  //anonymous function: to use an arg twice, have to name it.
  val v3 = (1 to 5).map(x => x * x)

  //anonymous function: bound infix method. Use 2*_ for sanity’s sake instead.
  val v4 = (1 to 5).map(2*)
  //BAD (1 to 5).map(*2)	

  //anonymous function: block style returns last expression.
  //(1 to 5).map{ val x= _*2;println(x);x }

  //anonymous functions: pipeline style. (or parens too).
  val v6 = (1 to 5) filter { _ % 2 == 0 } map { _ * 2 }

  //anonymous functions: to pass in multiple blocks, need outer parens.
  def compose(g: R => R, h: R => R) = (x: R) => g(h(x))
  val v = compose({ _ * 2 }, { _ - 1 })
  println(v(3))

  //currying, obvious syntax.
  val zscore1 = (mean: R, sd: R) => (x: R) => (x - mean) / sd
  val normer1 = zscore1(7, 0.4)
  println(normer1(3))

  //currying, obvious syntax
  def zscore2(mean: R, sd: R) = (x: R) => (x - mean) / sd
  val normer2 = zscore2(7, 0.4)
  println(normer2(3))
  
  //currying, sugar syntax. but then:
  //need trailing underscore to get the partial, only for the sugar version.
  def zscore3(mean: R, sd: R)(x: R) = (x - mean) / sd
  val normer3 = zscore3(7, 0.4)_
  println(normer3(3))
  
  //generic type1
  def f[T](x: T) = x //> f: [T](x: T)T
  val g = f[Double](6.1)
  println(g)
  
  //generic type2
  val list = List(2, 3, 1)
  def mapmake1[T](g: T => T)(seq: List[T]) = seq.map(g)
  println(mapmake1[Int](_*2)(list.map{_*2}))
  
  //generic type3
  def mapmake2[T](g: T => T, seq: List[T]) = seq.map(g)
  println(mapmake2[Int](_*2, list))
  

  //infix sugar.
  5. + (3); 5 + 3
  (1 to 5) map (_*2)
  
  //varargs.
  def sum(args: Int*) = args.reduceLeft(_+_)	
  println(sum(1,2,3))
}