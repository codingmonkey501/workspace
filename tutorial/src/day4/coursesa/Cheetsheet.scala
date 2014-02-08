package day4.coursesa

object Cheetsheet extends App {

  /**
   * Evaluation Rules
   */
  //Call by value: evaluates the function arguments before calling the function
  //Call by name: evaluates the function first, and then evaluates the arguments if need be
  def example1 = 2 // evaluated when called
  val example2 = 2 // evaluated immediately
  lazy val example3 = 2 // evaluated once when needed

  def square1(x: Double) = {} // call by value
  def square2(x: => Double) = {} // call by name
  def myFct(bindings: Int*) {} // bindings is a sequence of int, containing a varying # of arguments
  //Higher order functions
  //These are functions that take a function as a parameter or return functions.
  // sum() returns a function that takes two integers and returns an integer  
  def sum1(f: Int => Int): (Int, Int) => Int = {
    def sumf(a: Int, b: Int): Int = { a + b }
    sumf
  }
  // same as above. Its type is (Int => Int) => (Int, Int) => Int  
  def sum2(f: Int => Int)(a: Int, b: Int): Int = { a + b }

  // Called like this
  sum1((x: Int) => x * x * x) // Anonymous function, i.e. does not have a name  
  sum1(x => x * x * x) // Same anonymous function with type inferred

  def cube(x: Int) = x * x * x
  sum1(x => x * x * x)(1, 10) // sum of cubes from 1 to 10
  sum1(cube)(1, 10) // same as above      
  //Currying
  //Converting a function with multiple arguments into a function with a single argument that returns another function.

  def f1(a: Int, b: Int): Int = { a + b } // uncurried version (type is (Int, Int) => Int)
  def f2(a: Int)(b: Int): Int = { a + b } // curried version (type is Int => Int => Int)

  //Classes
  class MyClass(x: Int, y: Int) { // Defines a new type MyClass with a constructor  
    require(y > 0, "y must be positive") // precondition, triggering an IllegalArgumentException if not met  
    def this(x: Int) = { this(x, 1) } // auxiliary constructor   
    def nb1 = x // public method computed every time it is called  
    def myMethod(a: Int) = a
    private def test(a: Int): Int = { a } // private method  
    val nb3 = x + y // computed only once  
    override def toString = // overridden method  
      x + ", " + y
  }

  val myObject = new MyClass(1, 2) // creates a new object of type
  //this references the current object, assert(<condition>) issues AssertionError if condition is not met. 
  //See scala.Predef for require, assume and assert.

  /**
   * Operators
   */
  myObject myMethod 1
  //is the same as calling 
  myObject.myMethod(1)

  //Operator (i.e. function) names can be alphanumeric, symbolic (e.g. x1, *, +?%&, vector_++, counter_=)

  //The precedence of an operator is determined by its first character, with the following increasing order of priority:

  //(all letters)
  /**
   *
   * |
   * ^
   * &
   * < >
   * = !
   * :
   * + -
   * / %
   *
   */

  //(all other special characters)
  //The associativity of an operator is determined by its last character: 
  //Right-associative if ending with :, Left-associative otherwise.

  //Note that assignment operators have lowest precedence. 
  //(Read Scala Language Specification 2.9 sections 6.12.3, 6.12.4 for more info)

  /**
   * Class hierarchies
   */
  abstract class TopLevel { // abstract class  
    def method1(x: Int): Int // abstract method  
    def method2(x: Int): Int = { x }
  }

  class Level1 extends TopLevel {
    def method1(x: Int): Int = { x }
    override def method2(x: Int): Int = { x } // TopLevel's method2 needs to be explicitly overridden  
  }

  object MyObject extends TopLevel {
    override def method1(x: Int) = { x }
  } // defines a singleton object. No other instance can be created
  //To create an runnable application in Scala:

  object Hello1 {
    def main(args: Array[String]) = println("Hello world")
  }
  //or

  object Hello2 extends App {
    println("Hello World")
  }

  //Class Organization
  //Classes and objects are organized in packages (package myPackage).

  //They can be referenced through import statements 
  //(import myPackage.MyClass, import myPackage._, import myPackage.{MyClass1, MyClass2}, import myPackage.{MyClass1 => A})

  //They can also be directly referenced in the code with the fully qualified name (new myPackage.MyClass1)

  //All members of packages scala and java.lang as well as all members of the object scala.Predef are automatically imported.

  //Traits are similar to Java interfaces, except they can have non-abstract members:

  trait Planar {}
  class Shape {}
  class Square extends Shape with Planar
  //General object hierarchy:

  //scala.Any //base type of all types. Has methods hashCode and toString that can be overloaded
  //scala.AnyVal //base type of all primitive types. (scala.Double, scala.Float, etc.)
  //scala.AnyRef //base type of all reference types. (alias of java.lang.Object, supertype of java.lang.String, scala.List, any user-defined class)
  //scala.Null //is a subtype of any scala.AnyRef (null is the only instance of type Null), and scala.Nothing is a subtype of any other type without any instance.

  //Type Parameters
  //Similar to C++ templates or Java generics. These can apply to classes, traits or functions.

  class MyClass2[T](arg1: T) {}
  new MyClass2[Int](1)
  new MyClass2(1) // the type is being inferred, i.e. determined based on the value arguments  
  //It is possible to restrict the type being used, e.g.

  def myFct1[T <: TopLevel](arg: T): T = { arg } // T must derive from TopLevel or be TopLevel
  def myFct2[T >: Level1](arg: T): T = { arg } // T must be a supertype of Level1
  def myFct3[T >: Level1 <: TopLevel](arg: T): T = { arg }

  //Variance
  class B {}
  class A extends B {}
  //Given A <: B

  //If C[A] <: C[B], //C is covariant

  //If C[A] >: C[B], //C is contravariant

  //Otherwise C is nonvariant
  class C1[+A] {} // C1 is covariant
  class C2[-A] {} // C2 is contravariant
  class C3[A] {} // C3 is nonvariant

  //For a function, if A2 <: A1 and B1 <: B2, then A1 => B1 <: A2 => B2.

  //Functions must be contravariant in their argument types and covariant in their result types, e.g.

  trait Function1[-T, +U] {
    def apply(x: T): U
  } // Variance check is OK because T is contravariant and U is covariant

  // variance checks fails
  //abstract class Array[+T] {
  //  def update(x: T)
  //} 

  //Find out more about variance in lecture 4.4 and lecture 4.5

  //Pattern Matching
  //Pattern matching is used for decomposing data structures:
  abstract class MyCase
  case class MyCase1(a: Int, b: Int) extends MyCase {}
  case class MyCase2(s: String) extends MyCase {}

  val o = new MyCase1(1, 2)
  o match {
    case MyCase1(a, b) => println("MyClass1")
    //case MyCase2(x) => println("MyClass2")
  }

  //Here are a few example patterns
  val someList = List[Int](1, 2, 3)
  type T = Int
  (someList: List[T]) match {
    case Nil => 1 // empty list
    case x :: Nil => 2 // list with only one element
    case List(x) => 3 // same as above
    case x :: xs => 4 // a list with at least one element. x is bound to the head,
    // xs to the tail. xs could be Nil or some other list.
    case 1 :: 2 :: cs => 5 // lists that starts with 1 and then 2
    //case (x, y) :: ps => 6 // a list where the head element is a pair
    case _ => 7 // default case if none of the above matches
  }

  //The last example shows that every pattern consists of sub-patterns: 
  //it only matches lists with at least one element, where that element is a pair. 
  //x and y are again patterns that could match only specific types.

  //Options
  //Pattern matching can also be used for Option values. Some functions (like Map.get) 
  //return a value of type Option[T] which is either a value of type Some[T] or the value None:

  val myMap = Map("a" -> 42, "b" -> 43)
  def getMapValue1(s: String): String = {
    myMap get s match {
      case Some(nb) => "Value found: " + nb
      case None => "No value found"
    }
  }
  getMapValue1("a") // "Value found: 42"
  getMapValue1("c") // "No value found"

  //Most of the times when you write a pattern match on an option value, 
  //the same expression can be written more concisely using combinator methods of the Option class. 
  //For example, the function getMapValue can be written as follows:

  def getMapValue2(s: String): String =
    myMap.get(s).map("Value found: " + _).getOrElse("No value found")

  //Pattern Matching in Anonymous Functions
  //Pattern matches are also used quite often in anonymous functions:

  val pairs: List[(Char, Int)] = ('a', 2) :: ('b', 3) :: Nil
  val chars: List[Char] = pairs.map(p => p match {
    case (ch, num) => ch
  })
  //Instead of p => p match { case ... }, you can simply write {case ...}, so the above example becomes more concise:

  val chars2: List[Char] = pairs map {
    case (ch, num) => ch
  }

  //Collections
  //Scala defines several collection classes:

  //Base Classes
  Iterable //(collections you can iterate on)
  Seq //(ordered sequences)
  Set
  Map //(lookup data structure)
  //Immutable Collections
  List //(linked list, provides fast sequential access)
  Stream //(same as List, except that the tail is evaluated only on demand)
  Vector //(array-like type, implemented as tree of blocks, provides fast random access)
  Range //(ordered sequence of integers with equal spacing)
  //String //(Java type, implicitly converted to a character sequence, so you can treat every string like a Seq[Char])
  Map //(collection that maps keys to values)
  Set //(collection without duplicate elements)
  //Mutable Collections
  Array //(Scala arrays are native JVM arrays at runtime, therefore they are very performant)
  //Scala also has mutable maps and sets; these should only be used if there are performance issues with immutable types

  //Examples
  val fruitList = List("apples", "oranges", "pears")
  // Alternative syntax for lists
  val fruits = "apples" :: ("oranges" :: ("pears" :: Nil)) // parens optional, :: is right-associative
  fruits.head // "apples"
  fruits.tail // List("oranges", "pears")
  val empty = List()
  val empty2 = Nil

  val nums = Vector("louis", "frank", "hiromi")
  nums(1) // element at index 1, returns "frank", complexity O(log(n))
  nums.updated(2, "helena") // new vector with a different string at index 2, complexity O(log(n))

  val fruitSet = Set("apple", "banana", "pear", "banana")
  fruitSet.size // returns 3: there are no duplicates, only one banana

  val r: Range = 1 until 5 // 1, 2, 3, 4
  val s: Range = 1 to 5 // 1, 2, 3, 4, 5
  1 to 10 by 3 // 1, 4, 7, 10
  6 to 1 by -2 // 6, 4, 2

  val s2 = (1 to 6).toSet
  s2 map (_ + 2) // adds 2 to each element of the set

  val s3 = "Hello World"
  s3 filter (c => c.isUpper) // returns "HW"; strings can be treated as Seq[Char]

  // Operations on sequences
  val xs = List(1, 2, 3)
  val ys = List(1, 2, 3)
  xs.length // number of elements, complexity O(n)
  xs.last // last element (exception if xs is empty), complexity O(n)
  xs.init // all elements of xs but the last (exception if xs is empty), complexity O(n)
  xs take 2 // first n elements of xs
  xs drop 2 // the rest of the collection after taking n elements
  xs(2) // the nth element of xs, complexity O(n)
  xs ++ ys // concatenation, complexity O(n)
  xs.reverse // reverse the order, complexity O(n)
  xs updated (2, 4) // same list than xs, except at index n where it contains x, complexity O(n)
  xs indexOf 2 // the index of the first element equal to x (-1 otherwise)
  xs contains 2 // same as xs indexOf x >= 0

  val p: (Int => Boolean) = { _ > 2 }
  xs filter p // returns a list of the elements that satisfy the predicate p
  xs filterNot p // filter with negated p 
  xs partition p // same as (xs filter p, xs filterNot p)
  xs takeWhile p // the longest prefix consisting of elements that satisfy p
  xs dropWhile p // the remainder of the list after any leading element satisfying p have been removed
  xs span p // same as (xs takeWhile p, xs dropWhile p)

  val op: ((Int, Int) => Int) = { _ + _ }
  List(1, 2, 3) reduceLeft op // (...(x1 op x2) op x3) op ...) op xn
  List(1, 2, 3).foldLeft(1)(op) // (...( z op x1) op x2) op ...) op xn
  List(1, 2, 3) reduceRight op // x1 op (... (x{n-1} op xn) ...)
  List(1, 2, 3).foldRight(2)(op) // x1 op (... (    xn op  z) ...)

  xs exists p // true if there is at least one element for which predicate p is true
  xs forall p // true if p(x) is true for all elements
  xs zip ys // returns a list of pairs which groups elements with same index together
  //xs unzip       // opposite of zip: returns a pair of two lists
  //xs.flatMap f   // applies the function to all elements and concatenates the result
  //xs.sum			// sum of elements of the numeric collection
  //xs.product     // product of elements of the numeric collection
  //xs max         // maximum of collection
  //xs.min         // minimum of collection
  //xs.flatten     // flattens a collection of collection into a single-level collection
  //xs groupBy f   // returns a map which points to a list of elements
  //xs distinct    // sequence of distinct entries (removes duplicates)

  val x1: Int = 1
  x1 +: xs // creates a new collection with leading element x
  xs :+ x1 // creates a new collection with trailing element x

  // Operations on maps
  val myMap2 = Map("I" -> 1, "V" -> 5, "X" -> 10) // create a map
  myMap("I") // => 1  
  myMap("A") // => java.util.NoSuchElementException  
  myMap get "A" // => None 
  myMap get "I" // => Some(1)
  myMap.updated("V", 15) // returns a new map where "V" maps to 15 (entry is updated)
  // if the key ("V" here) does not exist, a new entry is added

  // Operations on Streams
  val xs1 = Stream(1, 2, 3)
  val xs2 = Stream.cons(1, Stream.cons(2, Stream.cons(3, Stream.empty))) // same as above
  (1 to 1000).toStream // => Stream(1, ?)
  x1 #:: xs1 // Same as Stream.cons(x, xs)
  // In the Stream's cons operator, the second parameter (the tail)
  // is defined as a "call by name" parameter.
  // Note that x::xs always produces a List
  //Pairs //(similar for larger Tuples)
  val pair = ("answer", 42) // type: (String, Int)
  val (label, value) = pair // label = "answer", value = 42  
  pair._1 // "answer"  
  pair._2 // 42  

  Ordering
  //There is already a class in the standard library that represents orderings: 
  //scala.math.Ordering[T] which contains comparison functions such as lt() and gt() for standard types. 
  //Types with a single natural ordering should inherit from the trait scala.math.Ordered[T].

  import math.Ordering

  //def msort[T](xs: List[T])(implicit ord: Ordering) = { qsort(xs) }  
  //msort(fruits)(Ordering.String)  
  //msort(fruits)   // the compiler figures out the right ordering  

  /**
   * For-Comprehensions
   */
  //A for-comprehension is syntactic sugar for map, flatMap and filter operations on collections.

  //he general form is for (s) yield e

  //s is a sequence of generators and filters
  //p <- e is a generator
  //if f is a filter
  //If there are several generators (equivalent of a nested loop), the last generator varies faster than the first
  //You can use { s } instead of ( s ) if you want to use multiple lines without requiring semicolons
  //e is an element of the resulting collection
  //Example 1
  // list all combinations of numbers x and y where x is drawn from
  // 1 to M and y is drawn from 1 to N
  val M = 10
  val N = 10
  for (x <- 1 to M; y <- 1 to N)
    yield (x, y)

  //is equivalent to
  //(1 to M) flatMap (x => (1 to N) map (y => (x, y))

  //Translation Rules
  //A for-expression looks like a traditional for loop but works differently internally

  val e1 = 1 to 10
  val e2 = 11 to 20
  val e3 = 21 to 30
  for (x <- e1) yield e2
  //is translated to 
  e1.map(x => e2)

  //def h1(x:Int)={x>1}
  //(x:Int)=>{x>1}
  //val h1:(Int=>Boolean)= x=>{x>1}
  //val h1:(Int=>Boolean)= xx=>xx>1

  for (x <- e1 if x > 1) yield e2 //is translated to 
  for (x <- e1.filter(x => x > 1)) yield e2

  for (x <- e1; y <- e2) yield e3
  //is translated to 
  e1.flatMap(x => for (y <- e2) yield e3)

  //This means you can use a for-comprehension for your own type, as long as you define map, flatMap and filter.

  //For more, see lecture 6.5.

  //Example 2
  val n = 10
  val i = 10
  for {
    i <- 1 until n
    j <- 1 until i
    if (i + j > 10)
  } yield (i, j)
  //is equivalent to

  for (i <- 1 until n; j <- 1 until i if (i + j) > 10)
    yield (i, j)

  //is equivalent to

  (1 until n).flatMap(i => (1 until i).filter(j => (i + j > 10)).map(j => (i, j)))
}