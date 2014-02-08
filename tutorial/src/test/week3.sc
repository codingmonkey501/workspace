package test

object week3 {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  if(true) 1 else false                           //> res0: AnyVal = 1
  
  var anyVal:AnyVal = 1                           //> anyVal  : AnyVal = 1
  
  var ref:AnyRef = new Object                     //> ref  : AnyRef = java.lang.Object@471cc198
  
  var any1:Any = anyVal                           //> any1  : Any = 1
  var any2:Any = ref                              //> any2  : Any = java.lang.Object@471cc198
  
  var str:String = "String"                       //> str  : String = String
  
  str = null
  
  var n:Null = null                               //> n  : Null = null
  
  any1.hashCode                                   //> res1: Int = 1
  any1.hashCode.toString                          //> res2: String = 1
  any1 equals 1                                   //> res3: Boolean = true
  any1 == 1                                       //> res4: Boolean = true
  
  try {
  	throw new Exception;
  }catch{
  	case e:Exception => println("exception happened")
  }                                               //> exception happened
  
  List(1,2,3)                                     //> res5: List[Int] = List(1, 2, 3)
  
  List(List(true, false), List(3))                //> res6: List[List[AnyVal]] = List(List(true, false), List(3))
  

  trait List[T] {
    def isEmpty: Boolean
    def head: T
    def tail: List[T]
    
  }
  
  class Cons[T](val head: T, val tail: List[T]) extends List[T] {
    def isEmpty = false
    
  }
  
  class Nil[T] extends List[T] {
    def isEmpty = true
    def head = throw new NoSuchElementException("Nil.head")
    def tail = throw new NoSuchElementException("Nil.tail")
    
	}
	def singleton[T](elem: T) = new Cons[T](elem, new Nil[T])
                                                  //> singleton: [T](elem: T)test.week3.Cons[T]
  singleton[Boolean](true)                        //> res7: test.week3.Cons[Boolean] = test.week3$$anonfun$main$1$Cons$1@669b5cdb
                                                  //| 
  singleton(true)                                 //> res8: test.week3.Cons[Boolean] = test.week3$$anonfun$main$1$Cons$1@61ed627d
                                                  //| 
  
  val list= List(1,2,3)                           //> list  : List[Int] = List(1, 2, 3)
  list(0)                                         //> res9: Int = 1
  list(1)                                         //> res10: Int = 2
  list(2)                                         //> res11: Int = 3
  
  try{
  	list(3)
  }catch{
  	case e:IndexOutOfBoundsException => println("out of bound")
  }                                               //> out of bound
                                                  //| res12: AnyVal = ()
  
  val list1 = singleton(1)                        //> list1  : test.week3.Cons[Int] = test.week3$$anonfun$main$1$Cons$1@27dd2ec5
                                                  //| 
  def nth[T](n:Int, list:List[T]):T = {
  	var result:Any = null
  	var i = n
  	import scala.annotation.tailrec
  	@tailrec
  	def loop(list:List[T]):T = {
  		if (i == 0) {
  			try{
  				list.head
  			}catch{
  				case e: NoSuchElementException => throw new IndexOutOfBoundsException
  			}
  		} else {
  			i = i-1
  			loop(list.tail)
  		}
  	}
  	loop(list)
  }                                               //> nth: [T](n: Int, list: test.week3.List[T])T
  
  
  nth(1, list1)                                   //> java.lang.IndexOutOfBoundsException
                                                  //| 	at test.week3$$anonfun$main$1.loop$1(test.week3.scala:78)
                                                  //| 	at test.week3$$anonfun$main$1.nth$1(test.week3.scala:88)
                                                  //| 	at test.week3$$anonfun$main$1.apply$mcV$sp(test.week3.scala:92)
                                                  //| 	at org.scalaide.worksheet.runtime.library.WorksheetSupport$$anonfun$$exe
                                                  //| cute$1.apply$mcV$sp(WorksheetSupport.scala:76)
                                                  //| 	at org.scalaide.worksheet.runtime.library.WorksheetSupport$.redirected(W
                                                  //| orksheetSupport.scala:65)
                                                  //| 	at org.scalaide.worksheet.runtime.library.WorksheetSupport$.$execute(Wor
                                                  //| ksheetSupport.scala:75)
                                                  //| 	at test.week3$.main(test.week3.scala:3)
                                                  //| 	at test.week3.main(test.week3.scala)
}