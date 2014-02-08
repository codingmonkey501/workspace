package day2.basic

object CheetSheet7OOP extends App {
  type R = Int

  //same
  class C(x: R)
  class D(private val x: R)

  //constructor params - private
  var c = new C(4)

  //constructor params - public
  class E(val x: R)
  var e = new E(4)
  e.x

  //constructor is class body
  class F(var x: R, var y: R) {
    assert(x > 0, "positive please")

    //declare a public member
    var z = x
    //declare a private member
    private var secret = 1
    
    //declare a gettable but not settable member
    val readonly = 5

    //alternative constructor
    def this(x: R) = this(x, 6)
    def this() = this(6, 7)
  }

  //anonymous class
  new {
    val x: Int = 1
  }

  //define an abstract class. (non-createable)
  abstract class G {}

  //define an inherited class.
  class H extends G {}

  class I(var x: R)

  //inheritance and constructor params. (wishlist: automatically pass-up params by default)
  class J(x: R) extends D(x)

  //traits.
  trait T {}
  class K extends T {}
  class L extends G with T {}

  //interfaces-with-implementation. no constructor params. mixin-able.
  trait T1; trait T2
  class M extends T1 with T2

  //multiple traits.
  class N extends G with T1 with T2

  //must declare method overrides.
  //class P extends G { override def f = ...}

  //create object.
  new java.io.File("f")
  List(1, 2, 3)
  //BAD new List[Int] //type error: abstract type

  //instead, convention: callable factory shadowing the type

  //class literal.
  val clazz = classOf[String]
  println(clazz)

  var x: String = "abc"
  //type check (runtime)
  x.isInstanceOf[String]

  //type cast (runtime)
  x.asInstanceOf[String]

  //ascription (compile time)
  x: String

}