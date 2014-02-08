package test

object week6 {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  
  /*
  sub class of sequence
  */
  
  //vector
  var nums = Vector(1,2,3,-88)                    //> nums  : scala.collection.immutable.Vector[Int] = Vector(1, 2, 3, -88)
  var people = Vector("Bob", "James", "Peter")    //> people  : scala.collection.immutable.Vector[String] = Vector(Bob, James, Pet
                                                  //| er)
  //array
  val xs = Array(1,2,3,44)                        //> xs  : Array[Int] = Array(1, 2, 3, 44)
  //String
  val s = "Hello World"                           //> s  : String = Hello World
	//List
	val ls = List(1,2,3,4)                    //> ls  : List[Int] = List(1, 2, 3, 4)
	//Range
	val r1:Range = 1 until 5 by 2             //> r1  : Range = Range(1, 3)
	val r2:Range = 5 to 1 by -1               //> r2  : Range = Range(5, 4, 3, 2, 1)
	  
	//operations
	xs map (x=>x*2)                           //> res0: Array[Int] = Array(2, 4, 6, 88)
	s filter (c => c.isUpper)                 //> res1: String = HW
  s exists (c => c.isUpper)                       //> res2: Boolean = true
  s forall (c => c.isUpper)                       //> res3: Boolean = false
  val pairs = ls zip s                            //> pairs  : List[(Int, Char)] = List((1,H), (2,e), (3,l), (4,l))
  pairs.unzip                                     //> res4: (List[Int], List[Char]) = (List(1, 2, 3, 4),List(H, e, l, l))
  s flatMap (c => List('.',c))                    //> res5: String = .H.e.l.l.o. .W.o.r.l.d
  xs.sum                                          //> res6: Int = 50
  xs.product                                      //> res7: Int = 264
  xs.max                                          //> res8: Int = 44
  xs.min                                          //> res9: Int = 1
  
  
  
  // a little bit complex usage
  (1 to 5) flatMap (x => (1 to 10) map (y => (x, y)))
                                                  //> res10: scala.collection.immutable.IndexedSeq[(Int, Int)] = Vector((1,1), (1,
                                                  //| 2), (1,3), (1,4), (1,5), (1,6), (1,7), (1,8), (1,9), (1,10), (2,1), (2,2), (
                                                  //| 2,3), (2,4), (2,5), (2,6), (2,7), (2,8), (2,9), (2,10), (3,1), (3,2), (3,3),
                                                  //|  (3,4), (3,5), (3,6), (3,7), (3,8), (3,9), (3,10), (4,1), (4,2), (4,3), (4,4
                                                  //| ), (4,5), (4,6), (4,7), (4,8), (4,9), (4,10), (5,1), (5,2), (5,3), (5,4), (5
                                                  //| ,5), (5,6), (5,7), (5,8), (5,9), (5,10))
   (nums zip nums).map(xy => xy._1 * xy._2).sum   //> res11: Int = 7758
   
   (nums zip nums).map{case (x,y) => x*y}.sum     //> res12: Int = 7758
   
   def isPrime(n:Int) = (2 until n) forall (x => n%x != 0)
                                                  //> isPrime: (n: Int)Boolean
   isPrime(11)                                    //> res13: Boolean = true
   isPrime(12)                                    //> res14: Boolean = false
   
   
   
   
   
   
   
   
   
   
   //nested sequences
   val n =7                                       //> n  : Int = 7
   var cc = (1 until n) map ( i =>
   		(1 until i) map (j => (i,j)))     //> cc  : scala.collection.immutable.IndexedSeq[scala.collection.immutable.Inde
                                                  //| xedSeq[(Int, Int)]] = Vector(Vector(), Vector((2,1)), Vector((3,1), (3,2)),
                                                  //|  Vector((4,1), (4,2), (4,3)), Vector((5,1), (5,2), (5,3), (5,4)), Vector((6
                                                  //| ,1), (6,2), (6,3), (6,4), (6,5)))
   cc.flatten                                     //> res15: scala.collection.immutable.IndexedSeq[(Int, Int)] = Vector((2,1), (3
                                                  //| ,1), (3,2), (4,1), (4,2), (4,3), (5,1), (5,2), (5,3), (5,4), (6,1), (6,2), 
                                                  //| (6,3), (6,4), (6,5))
   val cc1 = (1 until n) flatMap ( i =>
   		(1 until i) map (j => (i,j)))     //> cc1  : scala.collection.immutable.IndexedSeq[(Int, Int)] = Vector((2,1), (3
                                                  //| ,1), (3,2), (4,1), (4,2), (4,3), (5,1), (5,2), (5,3), (5,4), (6,1), (6,2), 
                                                  //| (6,3), (6,4), (6,5))
   cc1 filter (pair => isPrime(pair._1 + pair._2))//> res16: scala.collection.immutable.IndexedSeq[(Int, Int)] = Vector((2,1), (3
                                                  //| ,2), (4,1), (4,3), (5,2), (6,1), (6,5))
   
   
   //for expression
   for (e <- cc1 if isPrime(e._1 + e._2)) yield e //> res17: scala.collection.immutable.IndexedSeq[(Int, Int)] = Vector((2,1), (3
                                                  //| ,2), (4,1), (4,3), (5,2), (6,1), (6,5))
   
   
   
   for {
   		i <- 1 until n
   		j <- 1 until i
   		if isPrime(i+j)
   } yield (i,j)                                  //> res18: scala.collection.immutable.IndexedSeq[(Int, Int)] = Vector((2,1), (3
                                                  //| ,2), (4,1), (4,3), (5,2), (6,1), (6,5))
   
   
   //scala product
   (for ((x,y) <- xs zip xs) yield x*y).sum       //> res19: Int = 1950
   
   
   
   /**
   
   Scala collection Iterable
   
   */
   
   
   //set
   
   val fruits = Set("Banana", "Apple", "Pear")    //> fruits  : scala.collection.immutable.Set[String] = Set(Banana, Apple, Pear)
                                                  //| 
   val set = (1 to 6).toSet                       //> set  : scala.collection.immutable.Set[Int] = Set(5, 1, 6, 2, 3, 4)
   
   set map (_+2)                                  //> res20: scala.collection.immutable.Set[Int] = Set(5, 6, 7, 3, 8, 4)
   //fruits filter (_.startsWith == "app")
   set.nonEmpty                                   //> res21: Boolean = true
   set map (_/2)                                  //> res22: scala.collection.immutable.Set[Int] = Set(2, 0, 3, 1)
   s contains 5                                   //> res23: Boolean = false
   //map
   
   
   //N-Queens problem
   
   def queens(n:Int) : Set[List[Int]] = {
   		def isSafe(col: Int, queens: List[Int]) ={
   			  val row = queens.length
   			  val queensWithRow = (row - 1 to 0 by -1) zip queens
   			  queensWithRow forall {
   			  	case (r,c) => col!=c && math.abs(col-c) != row-r
   			  }
   		}
   			
   		def placeQueens(k:Int): Set[List[Int]] =
   				if(k==0) Set(List())
   				else
   					for {
   						queens <- placeQueens(k-1)
   						col <- 0 until n
   						if isSafe(col, queens)
   					} yield col :: queens
   		placeQueens(n)
   }                                              //> queens: (n: Int)Set[List[Int]]
   
   def show (queens:List[Int]) ={
   		val lines =
   			for (col <- queens.reverse)
   			yield Vector.fill(queens.length)("* ").updated(col, "X ").mkString
   			"\n" + (lines mkString "\n")
   }                                              //> show: (queens: List[Int])String
   queens(0)                                      //> res24: Set[List[Int]] = Set(List())
   queens(1)                                      //> res25: Set[List[Int]] = Set(List(0))
   queens(4)                                      //> res26: Set[List[Int]] = Set(List(1, 3, 0, 2), List(2, 0, 3, 1))
   queens(4) map show                             //> res27: scala.collection.immutable.Set[String] = Set("
                                                  //| * * X * 
                                                  //| X * * * 
                                                  //| * * * X 
                                                  //| * X * * ", "
                                                  //| * X * * 
                                                  //| * * * X 
                                                  //| X * * * 
                                                  //| * * X * ")
   (queens(8) take 3 map show) mkString "\n"      //> res28: String = "
                                                  //| * * * * * X * * 
                                                  //| * * * X * * * * 
                                                  //| * X * * * * * * 
                                                  //| * * * * * * * X 
                                                  //| * * * * X * * * 
                                                  //| * * * * * * X * 
                                                  //| X * * * * * * * 
                                                  //| * * X * * * * * 
                                                  //| 
                                                  //| * * * * X * * * 
                                                  //| * * * * * * X * 
                                                  //| * X * * * * * * 
                                                  //| * * * X * * * * 
                                                  //| * * * * * * * X 
                                                  //| X * * * * * * * 
                                                  //| * * X * * * * * 
                                                  //| * * * * * X * * 
                                                  //| 
                                                  //| * * * * * X * * 
                                                  //| * * X * * * * * 
                                                  //| * * * * * * X * 
                                                  //| * * * X * * * * 
                                                  //| X * * * * * * * 
                                                  //| * * * * * * * X 
                                                  //| * X * * * * * * 
                                                  //| * * * * X * * * "
}